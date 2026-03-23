package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactWithOrgTest {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		WebDriverUtility wLib = new WebDriverUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		
		String browser = fLib.getDataFromProperties("browser");
		String Url = fLib.getDataFromProperties("Url");
		String username = fLib.getDataFromProperties("username");
		String password = fLib.getDataFromProperties("password");

		
		String orgName = eLib.getDataFromExcel("Org", 1, 2);
		eLib.getDataFromExcel("Contact", 1, 2);
		
		WebDriver driver = null;
		
		
		HomePage hp = new HomePage(driver);
		hp.ClickOnContact();
		
				
		//Login to application
		wLib.waitForPageToLoad(driver);
		driver.get(Url);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(Url, username, password);
		
		HomePage hp1 = new HomePage(driver);
		hp1.getOrgLink().click();
		
		//Navigate to Organization Module
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrganization().click();
		
		
		//enter all details & create new Organization
		
		String orgName1 = eLib.getDataFromExcel("Org", 1, 2);
		
		
		hp.getOrgSaveBtn().click();
		Thread.sleep(4000);
		//Verify header expected result
		String headerInfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName1)) {
			
			System.out.println(orgName + " is created==> Pass");
		}
		else { System.out.println(orgName + " is not created==> Fail");}
		
		//Verify orgname info expected result
		
		String actOrgName =driver.findElement(By.id("dtlview_Organization Name")).getText();
		if(actOrgName.equals(orgName)) {
			System.out.println(orgName + " is created==> Pass");
		}
		else { System.out.println(orgName + " is not created==> Fail");}
		
		
		//Navigate to contact module
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//click on create organization button
		String lastName = eLib.getDataFromExcel("Contact", 1, 2);
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		
	    wLib.switchToTabOnURL(driver, "module=Accounts");
		
		driver.findElement(By.id("search_txt")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch back to parent window
		wLib.switchToTabOnURL(driver, "module=Contacts");
		
		
		driver.findElement(By.xpath("//img[@tile='save[Alt+S]']")).click();
		
		//verify header phone number info expected result
		 headerInfo =driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerInfo.contains(orgName)) {
			
			System.out.println(orgName + " is created==> Pass");
		}
		else { System.out.println(orgName + " is not created==> Fail");}
		
		//Verify orgname info expected result
		
		String actOrgName1 =driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if(actOrgName1.equals(orgName)) {
			System.out.println(orgName + " is created==> Pass");
		}
		else { System.out.println(orgName + " is not created==> Fail");}
		
		//System.out.println("Its working");
		
		driver.quit();


	}

}
