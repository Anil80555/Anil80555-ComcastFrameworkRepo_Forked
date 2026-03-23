package com.comcast.crm.orgtest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.listenerutility.ListenerImpClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationsPage;

@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class CreateOrganizationWithORG_Industry_PhoneNumberTest extends BaseClass {
	
	
	@Test(groups={"smokeTest","regressionTest"})
	public void createOrgTest() throws Throwable {
		
		UtilityClassObject.getTest().log(Status.INFO,"read Data from excel");
 
		String orgName = eLib.getDataFromExcel("Org", 1, 2) + jLib.getRandomNum();
		String add = eLib.getDataFromExcel("Org", 1, 3) + jLib.getRandomNum();

		// Click on Org Link
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to org page"); 
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create button
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to create org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgPlusIcon().click();

		// enter all details
		UtilityClassObject.getTest().log(Status.INFO,"org page");
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createNewOrg(orgName, add);
		
		UtilityClassObject.getTest().log(Status.INFO,"org page");

		// Verify header msg
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);
		String actOrgName = oip.getHeaderMsg().getText();
		if (actOrgName.contains(orgName)) {
			System.out.println(orgName + " This name is verified ==> Pass");
		} else {
			System.out.println(orgName + " This name is not verified ==> Fail");
		}

		
	}

	@Test(groups="regressionTest")
	public void createOrgWithIndustriesAndTypeTest() throws Throwable {

		String orgName = eLib.getDataFromExcel("Org", 4, 2) + jLib.getRandomNum();
		String add = eLib.getDataFromExcel("Org", 4, 3) + jLib.getRandomNum();
		String industry = eLib.getDataFromExcel("Org", 4, 4);
		String type = eLib.getDataFromExcel("Org", 4, 5);

		// Click on Org Link
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgPlusIcon().click();

		// enter all details
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.CreateNewOrgWithIndustry(orgName, add, industry, type);

		// Verify header msg

		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustries.contains(industry)) {
			System.out.println(industry + " is created==> Pass");
		} else {
			System.out.println(industry + " is not created==> Fail");
		}

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + " is created==> Pass");
		} else {
			System.out.println(type + " is not created==> Fail");
		}

	}
	
	@Test(groups="regressionTest")
	public void CreateOrganizationWithPhoneNumberTest() throws Throwable {
		
		String orgName= eLib.getDataFromExcel("Org", 7, 2)+ jLib.getRandomNum();
		String add= eLib.getDataFromExcel("Org", 7, 3)+ jLib.getRandomNum();
		String phoneNum= eLib.getDataFromExcel("Org", 7, 4)+ jLib.getRandomNum();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create button
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgPlusIcon().click();
		
		CreatingNewOrganizationPage createOrg = new CreatingNewOrganizationPage(driver);
		createOrg.createNewOrgWithPhoneNumber(orgName, add, phoneNum);
		
		//Verify phone number
		String actPhoneNum =driver.findElement(By.xpath("//td[@id='mouseArea_Phone']/span[contains(text(),'"+phoneNum+"')]")).getText();

		//String actPhoneNum =driver.findElement(By.id("dtlview_Phone")).getText();
		System.out.println(actPhoneNum);
		if(actPhoneNum.contains(phoneNum)) {
			System.out.println(phoneNum + " is created==> Pass");
		}
		else { System.out.println(phoneNum + " is not created==> Fail");}
		
	}
}
