//package com.comcast.crm.contacttest;
//
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.time.Duration;
//import java.util.Properties;
//import java.util.Random;
//
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import com.comcast.crm.generic.webdriverutility.JavaUtility;
//import com.comcast.crm.objectrepositoryutility.ContactPage;
//import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
//import com.comcast.crm.objectrepositoryutility.HomePage;
//import com.comcast.crm.objectrepositoryutility.LoginPage;
//
//public class CreateContactWithSupportDateTest {
//
//	public static void main(String[] args) throws Throwable {
//		// TODO Auto-generated method stub
//
//		String lastName = eLib.getDataFromExcel("Contact", 1, 2) + jLib.getRandomNum();
//
//		// Navigate to Contact Module
//		HomePage hp = new HomePage(driver);
//		hp.ClickOnContact();
//
//		ContactPage cp = new ContactPage(driver);
//		cp.getCreateIcon().click();
//
//		// enter all details & create new contact
//
//		CreatingNewContactPage contatc = new CreatingNewContactPage(driver);
//		contatc.createContact(lastName);
//
//		hp.saveBtnCreate();
//
//		String endDate = jLib.getSystemDateYYYYMMDD();
//		String StartDate = jLib.getRequiredDateYYYYDDMM(30);
//		contatc.requiredDate(30);
//
//		// Verify contact start date and end date result
//
//		String actLastName = driver.findElement(By.id("Support Start Date")).getText();
//		if (actLastName.equals(StartDate)) {
//
//			System.out.println(StartDate + " is created==> Pass");
//		} else {
//			System.out.println(StartDate + " is not created==> Fail");
//		}
//
//		// System.out.println("Its working");
//
//	}
//
//}
