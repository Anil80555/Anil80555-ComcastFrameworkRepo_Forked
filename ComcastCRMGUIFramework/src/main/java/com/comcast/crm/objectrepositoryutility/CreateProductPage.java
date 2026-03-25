package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {
	
	public WebDriver driver;
	public CreateProductPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);

}
	
}

