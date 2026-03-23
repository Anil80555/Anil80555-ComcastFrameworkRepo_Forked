package com.comcast.crm.baseTest;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;


public class BaseClass {

	
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public JavaUtility jLib = new JavaUtility();
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	
	
	@BeforeSuite(groups={"smokeTest", "regressionTest"})
	public void configBSuit() throws SQLException {
		System.out.println("====connect to DB, report====");
		dbLib.getDbConnection();
			
	}
	
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest", "regressionTest"})
	public void configBC() throws Throwable {
		System.out.println("===Launch Browser===");
		String BROWSER = fLib.getDataFromProperties("browser");
		
		
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {System.out.println("browser not found"); }
		sdriver= driver;
		
		UtilityClassObject.setdriver(driver);
	}
	
	@BeforeMethod(groups={"smokeTest", "regressionTest"})
	public void configBM() throws Throwable {
		System.out.println("==Login==");
		String url = fLib.getDataFromProperties("Url");
		String userName = fLib.getDataFromProperties("username");
		String password = fLib.getDataFromProperties("password");
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(url, userName, password);
		
	}
	
	@AfterMethod(groups={"smokeTest", "regressionTest"} , alwaysRun = true)
	public void configAM() throws Throwable {
		System.out.println("==Logout=");
		HomePage hp = new HomePage(driver);
		hp.logOut();
		
	}
	
	@AfterClass(groups={"smokeTest", "regressionTest"}, alwaysRun = true)
	public void configAC() {
		System.out.println("===Close Browser===");
		driver.quit();
	}
	
	@AfterSuite(groups={"smokeTest", "regressionTest"}, alwaysRun = true)
	public void configAS() throws Throwable {
		System.out.println("====close DB ,Report Backup====");
		dbLib.closeConnectio();
		
		
	}
}
