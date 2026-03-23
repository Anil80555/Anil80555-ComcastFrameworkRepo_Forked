package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.JavaUtility;

public class CreatingNewContactPage {

	JavaUtility jU =new JavaUtility();
			
	 WebDriver driver;
		public CreatingNewContactPage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
			
		}
	@FindBy(name="lastname")
	private WebElement creatNewContact;
	
	@FindBy(name="support_start_date")
	private WebElement startDate;
	
	@FindBy(name="support_end_date")
	private WebElement endDate;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement saveBtn;

	public WebElement getCreatNewContact() {
		return creatNewContact;
	}
	
	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}
	
	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	public void createContact(String lastname) {
		creatNewContact.sendKeys(lastname);
	}
	
	public void createContactWithSupportDate(String lastname, String sDate, String lDate) {
	 
		creatNewContact.sendKeys(lastname);
		startDate.clear();
		startDate.sendKeys(sDate);
		endDate.clear();
		endDate.sendKeys(lDate);
		
	    saveBtn.click();
	}
	
}
