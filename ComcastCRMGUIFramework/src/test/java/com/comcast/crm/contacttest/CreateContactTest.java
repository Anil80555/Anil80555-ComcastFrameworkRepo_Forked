package com.comcast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

public class CreateContactTest extends BaseClass {

	@Test(groups="smokeTest")
	public void creatContactTest() throws Throwable {

		String lastName = eLib.getDataFromExcel("Contact", 1, 2) + jLib.getRandomNum();

		// Navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.ClickOnContact();

		// Click on add Icon
		ContactPage cp = new ContactPage(driver);
		cp.getCreateIcon().click();

		// enter all details & create new contact

		CreatingNewContactPage contatc = new CreatingNewContactPage(driver);
		contatc.createContact(lastName);

		hp.saveBtnCreate();

		// Verify LastName

    	String actualHeader = cp.getHeaderMsg().getText();
//    	boolean status = actualHeader.contains(lastName);
//    	Assert.assertEquals(status, true);
    	
		if (actualHeader.equals(lastName)) {
			System.out.println(lastName + "Info is verified ==> Pass");
		}

		else {
			System.out.println(lastName + "Info is not verified ==> Fail");
		}

		String actLastName = cp.getLastNameVerify().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertNotEquals(actLastName, lastName);
		soft.assertAll();
//		if (actLastName.equals(lastName)) {
//			System.out.println(lastName + "Info is verified ==> Pass");
//		}
//
//		else {
//			System.out.println(lastName + "Info is not verified ==> Fail");
//		}
	}

	@Test(groups="regressionTest")
	public void createContactWithSupportDateTest() throws Throwable {

		String lastName = eLib.getDataFromExcel("Contact", 1, 2) + jLib.getRandomNum();

		// Navigate to Contact Module
		HomePage hp = new HomePage(driver);
		hp.ClickOnContact();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateIcon().click();

		// enter all details & create new contact

		String StartDate = jLib.getSystemDateYYYYMMDD();
		String endDate = jLib.getRequiredDateYYYYDDMM(30);
		
		CreatingNewContactPage contatc = new CreatingNewContactPage(driver);
		contatc.createContactWithSupportDate(lastName, StartDate, endDate);

		// Verify contact start date and end date result

		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(StartDate)) {

			System.out.println(StartDate + " is created==> Pass");
		} else {
			System.out.println(StartDate + " is not created==> Fail");
		}
		
		String actLastDate= driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actLastDate.equals(endDate)) {

			System.out.println(endDate + " is created==> Pass");
		} else {
			System.out.println(endDate + " is not created==> Fail");
		}
	}

/*	@Test
	public void createContactWithOrgTest() throws Throwable {
		
		//Reading TestScript data from excel file
		String orgName = eLib.getDataFromExcel("Org", 1, 2);
		String contactLastName = eLib.getDataFromExcel("Contact", 1, 2);
		
		//step2 : navigate to organization Page
		HomePage hp =new HomePage(driver);
		hp.getOrgLink();
		
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrganization().click();
		

	}*/
}
