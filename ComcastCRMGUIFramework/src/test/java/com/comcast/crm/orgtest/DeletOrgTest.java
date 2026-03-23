package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class DeletOrgTest {

	public static void main(String[] args) throws Throwable {
		// Step1: Reading Data from property file
		FileUtility fLib = new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib= new WebDriverUtility();

		String browser = fLib.getDataFromProperties("browser");
		String Url = fLib.getDataFromProperties("Url");
		String username = fLib.getDataFromProperties("username");
		String password = fLib.getDataFromProperties("password");

		// generate the random number

		String orgName = eLib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNum();
		String add = eLib.getDataFromExcel("Org", 1, 3) + jLib.getRandomNum();

		WebDriver driver = null;

		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equals("chrome")) {
			driver = new ChromeDriver();
		} else {
			System.out.println("there is no firefox browser");
		}

		// Step1 : Login to application
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get(Url);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(Url, username, password);

		// Step2 : Navigate to Organization Module

		HomePage hp = new HomePage(driver);
        hp.getOrgLink().click();
		
		// Step3 : click on create Organization button

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrganization().click();
		
		// Step4 : enter all the details & create new Organization
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createNewOrg(orgName, add );

		// Step5 : Verify header msg e;d result
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if(actOrgName.contains(orgName)) {
			System.out.println(orgName + " This name is verified ==> Pass");
		}
		else { System.out.println(orgName + " This name is not verified ==> Fail");}
		
		Thread.sleep(2000);
		//goBack to Org page
        hp.getOrgLink().click();

		//Search for Organization page
        op.getSearchEdt().sendKeys(orgName);
        wLib.select(op.getSearchDD(),"Organization Name");
        op.getSearchBtn1().click();
        
		//in Dynamic webTable select & delete org 
		
        driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();

		//Step6: Logout
		//hp.logOut();
		
		// System.out.println("Its working");

		Thread.sleep(1000);
		driver.quit();

	}

}
	


