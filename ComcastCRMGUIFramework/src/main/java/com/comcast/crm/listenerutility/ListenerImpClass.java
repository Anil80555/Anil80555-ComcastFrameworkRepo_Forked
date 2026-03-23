package com.comcast.crm.listenerutility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpClass implements ITestListener, ISuiteListener {
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	@Override
	public void onStart(ISuite suite) {

		System.out.println("report configuration");
		//spark report config
		String time = new Date().toString().replace(" ","_").replace(":","_");

				spark = new ExtentSparkReporter("./AdvanceReport/report_"+time+".html");
				spark.config().setDocumentTitle("crm testsuit results");
				spark.config().setReportName("CRM Report");
				spark.config().setTheme(Theme.DARK);
				
				//add env information & create test
				report = new ExtentReports();
				report.attachReporter(spark);
				report.setSystemInfo("OS", "windows-10");
				report.setSystemInfo("BROWSER", "Chrome-100");		

			
	}

	@Override
	public void onFinish(ISuite suite) {

		System.out.println("Report Backup");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {

		System.out.println("======" + result.getMethod().getMethodName()+ "====Start===="); 
		test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName()+ "======Starts=======");
	    
		
		

	}
	
	@Override
	public void onTestSuccess(ITestResult result) {

		System.out.println("======" + result.getMethod().getMethodName()+ "====End====");
		test.log(Status.INFO, result.getMethod().getMethodName()+ "======Completed=======");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {

		
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ","_").replace(":","_");
		test.addScreenCaptureFromBase64String(filePath, testName + " "+time);

		
		test.log(Status.INFO, result.getMethod().getMethodName()+ "======Fail=======");

		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		//test.log(Status.INFO, result.getMethod().getMethodName()+ "======Skipped=======");

	}

} 
