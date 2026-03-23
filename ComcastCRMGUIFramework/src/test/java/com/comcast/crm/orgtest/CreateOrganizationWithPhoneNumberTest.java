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

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreateOrganizationWithPhoneNumberTest {

	public static void main(String[] args) throws Throwable {
		//Step1: Reading Data from property file
		
		FileUtility fLib =new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		JavaUtility jLib = new JavaUtility();
				
				String browser = fLib.getDataFromProperties("browser");
				String Url = fLib.getDataFromProperties("Url");
				String username = fLib.getDataFromProperties("username");
				String password = fLib.getDataFromProperties("password");
				
			
				//Read Data From Excel
				String orgName= eLib.getDataFromExcel("Org", 7, 2)+ jLib.getRandomNum();
				String add= eLib.getDataFromExcel("Org", 7, 3)+ jLib.getRandomNum();
				String phoneNum= eLib.getDataFromExcel("Org", 7, 4)+ jLib.getRandomNum();
				
				WebDriver driver= null;
				
				if(browser.equals("firefox")) {
					driver = new FirefoxDriver();
				}
				else if(browser.equals("chrome")) {
				driver = new ChromeDriver();
				}
				else {
					System.out.println("there is no firefox browser");
				}
						
				//Login to application
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				driver.get(Url);
				
				driver.findElement(By.name("user_name")).sendKeys(username);
				driver.findElement(By.name("user_password")).sendKeys(password);
				driver.findElement(By.id("submitButton")).click();
				
				//Navigate to Organization Module
				driver.findElement(By.linkText("Organizations")).click();
				
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				
				//enter all details & create new Organization
				
				driver.findElement(By.name("accountname")).sendKeys(orgName);
				driver.findElement(By.name("ship_street")).sendKeys(add);
				driver.findElement(By.id("otherphone")).sendKeys(phoneNum);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				Thread.sleep(4000);
				
				//Verify orgname info expected result
				
				String actPhoneNum =driver.findElement(By.id("dtlview_Other Phone")).getText();
				if(actPhoneNum.equals(phoneNum)) {
					System.out.println(phoneNum + " is created==> Pass");
				}
				else { System.out.println(phoneNum + " is not created==> Fail");}
				
				//System.out.println("Its working");
				
				driver.quit();
		

	}

}
