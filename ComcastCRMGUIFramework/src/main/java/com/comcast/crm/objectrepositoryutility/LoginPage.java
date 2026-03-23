package com.comcast.crm.objectrepositoryutility;

/**
 * 
 * @author Lokesh
 * contains loginpage element & business lib like login()
 * 
 */
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {     //Rule 1 create a separate java class
	                         //Rule 2 object creation 
	//Rule3 : Object Initialization into constructor
	
	 WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginbtn;
	
	
		 //Rule 4 : object encapsulation

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPassword() {
		return passwordEdt;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	

/**
 * login to application based on username, password, url arguments
 * @param Url
 * @param userName
 * @param password
 */
	
//Rule5 : provide action
	
	public void loginToApp(String Url, String userName, String password) {
		waitForPageToLoad(driver);
		driver.manage().window().maximize();
		driver.get(Url);
		usernameEdt.sendKeys(userName);
		passwordEdt.sendKeys(password);
		loginbtn.click();
	}
	
}
