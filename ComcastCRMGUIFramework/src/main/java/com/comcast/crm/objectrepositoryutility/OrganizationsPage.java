package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	public WebDriver driver;
	public OrganizationsPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement organizations;
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement orgPlusIcon;
	
	public WebElement getOrgPlusIcon() {
		return orgPlusIcon;
	}
	@FindBy(name="search_text")
	private WebElement searchEdt;

	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement searchBtn1;
	
	public WebElement getSearchBtn1() {
		return searchBtn1;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}


	public WebElement getOrganization() {
		return organizations;
	}
	

	
	
}
