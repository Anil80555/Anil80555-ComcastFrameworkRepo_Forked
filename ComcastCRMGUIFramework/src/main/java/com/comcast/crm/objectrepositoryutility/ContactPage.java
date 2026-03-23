package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	public WebDriver driver;
		public ContactPage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
			
		}
		
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	
	
	@FindBy(id="dtlview_Last Name")
	private WebElement lastNameVerify;
	
	public WebElement getLastNameVerify() {
		return lastNameVerify;
	}

	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createIcon;
	
	public WebElement getCreateIcon() {
		return createIcon;
	}

	public WebElement getHeaderMsg() {
		// TODO Auto-generated method stub
		return headerMsg;
	}




}
