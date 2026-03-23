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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreateOrganizationWithIndustriesTest {

	public static void main(String[] args) throws Throwable {
		//Step1: Reading Data from property file
		
		FileUtility fLib =new FileUtility();
		ExcelUtility eLib = new ExcelUtility();
		JavaUtility jLib = new JavaUtility();
		
		//Read Data From property file
				String browser = fLib.getDataFromProperties("browser");
				String Url = fLib.getDataFromProperties("Url");
				String username = fLib.getDataFromProperties("username");
				String password = fLib.getDataFromProperties("password");
			
				//Read Data From Excel
				String orgName = eLib.getDataFromExcel("Org", 4, 2) + jLib.getRandomNum();
				String add = eLib.getDataFromExcel("Org", 4, 3) + jLib.getRandomNum();
				String industry = eLib.getDataFromExcel("Org", 4, 4);
				String type = eLib.getDataFromExcel("Org", 4, 5);
				
				
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
				Thread.sleep(2000);
				WebElement wbSelect = driver.findElement(By.name("industry"));
				Select sel1 = new Select(wbSelect);
				
				sel1.selectByVisibleText(industry);
				
				WebElement wbSelect1 = driver.findElement(By.name("accounttype"));
				Select sel2 = new Select(wbSelect1);
				sel2.selectByVisibleText(type);
				
				driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
				Thread.sleep(4000);
				// verify the industries and type info
				
				String actIndustries =driver.findElement(By.id("dtlview_Industry")).getText();
				if(actIndustries.contains(industry)) {
					System.out.println(industry + " is created==> Pass");
				}
				else { System.out.println(industry + " is not created==> Fail");}
				
				String actType =driver.findElement(By.id("dtlview_Type")).getText();
				if(actType.equals(type)) {
					System.out.println(type + " is created==> Pass");
				}
				else { System.out.println(type + " is not created==> Fail");}
				
				//System.out.println("Its working");
				
				driver.quit();
		

	}

}
