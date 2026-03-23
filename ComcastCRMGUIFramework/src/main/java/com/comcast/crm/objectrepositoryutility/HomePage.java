package com.comcast.crm.objectrepositoryutility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver= driver ;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactLnk;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement orgSaveBtn;

	@FindBy(linkText="Campaigns")
	private WebElement campaignLnk;
	
	@FindBy(linkText="More")
	private WebElement moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOut;
	
	@FindBy(xpath="(//input[@type='submit'])[1]")
	private WebElement contactSaveBtn;
	


//	public WebElement getCampaignLnk() {
//		return campaignLnk;
//	}


	public WebElement getOrgSaveBtn() {
		return orgSaveBtn;
	}

	public WebElement getContactSaveBtn() {
		return contactSaveBtn;
	}

	public void saveBtnCreate() {
		contactSaveBtn.click();
		
	}


	public WebElement getMoreLink() {
		return moreLink;
	}



	public WebElement getOrgLink() {
		return orgLink;
	}


	public WebElement getContactLnk() {
		return contactLnk;
	}


	public void ClickOnContact() {
		contactLnk.click();
	}

	public void navToCampaigPage() {
		Actions act = new Actions(driver);
		act.moveToElement(moreLink).perform();
		campaignLnk.click();
		
	}



	public WebElement getAdminImg() {
		return adminImg;
	}



	public WebElement getSignOut() {
		return signOut;
	}
	
	public void logOut() throws Throwable {
	   Thread.sleep(2000);
		Actions action = new Actions(driver);
		
		action.click(adminImg).perform();
		
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOf(signOut));
		signOut.click();
		}
}
