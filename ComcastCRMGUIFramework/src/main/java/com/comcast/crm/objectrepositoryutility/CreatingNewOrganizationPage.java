package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class CreatingNewOrganizationPage {
	
	
	public CreatingNewOrganizationPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="accountname")
	private WebElement orgName1;
	
	@FindBy(name="ship_street")
	private WebElement shipAdd;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	WebElement savebtn;
	
	@FindBy(name="industry")
	private WebElement industryDD;
	
	@FindBy(name="accounttype")
	private WebElement typeDD;
	
	@FindBy(name="phone")
	private WebElement phoneNum;

	public WebElement getTypeDD() {
		return typeDD;
	}

	public WebElement getSavebtn() {
		return savebtn;
	}

	public WebElement getOrgName() {
		return orgName1;
	}

	public WebElement getShipAdd() {
		return shipAdd;
	}
	
	
	
	public WebElement getIndustryDD() {
		return industryDD;
	}

	public void newOrg(String orgName, String add) {
		orgName1.sendKeys(orgName);
		shipAdd.sendKeys(add);
		savebtn.click();
		
	}
	
	public void CreateNewOrgWithIndustry(String orgName, String add, String industry, String type) {
		
		orgName1.sendKeys(orgName);
		shipAdd.sendKeys(add);
		WebDriverUtility wLib = new WebDriverUtility();
		wLib.select(industryDD, industry);
		wLib.select(typeDD, type);
		savebtn.click();
	}
	
	public void createNewOrg(String orgName, String add) {
		
		orgName1.sendKeys(orgName);
		shipAdd.sendKeys(add);
		WebDriverUtility wLib = new WebDriverUtility();
		savebtn.click();
	
	}
	
	public void createNewOrgWithPhoneNumber(String orgName, String add, String phoneNumber) {
		orgName1.sendKeys(orgName);
		shipAdd.sendKeys(add);
		phoneNum.sendKeys(phoneNumber);
		savebtn.click();
	}
}
