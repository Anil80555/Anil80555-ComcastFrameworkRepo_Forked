package com.comcast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
	}
 
	public void waitForElementPresent(WebDriver driver, WebElement element) {
	     WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(20));
	     wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabOnURL(WebDriver driver, String partialUrl) {
		
		Set<String>set1 =driver.getWindowHandles();
		Iterator<String> it1 = set1.iterator();
		
		while(it1.hasNext()) {
		  String window1 = it1.next();
		   driver.switchTo().window(window1);
		   String actUrl = driver.getCurrentUrl();
		   if(actUrl.contains("module=Contacts")) {
			   break;
		   }
		}
	}
	
   public void switchToTabOnTitle(WebDriver driver, String partialTitle) {
		
		Set<String>set =driver.getWindowHandles();
		Iterator<String> it1 = set.iterator();
		
		while(it1.hasNext()) {
		  String window1 = it1.next();
		   driver.switchTo().window(window1);
		   String actUrl = driver.getTitle();
		   if(actUrl.contains("module=Contacts")) {
			   break;
		   }
		}
	}
   public void switchToFrame(WebDriver driver,int index) {
	   driver.switchTo().frame(index);
	
}
   
   public void switchToFrame(WebDriver driver,String name) {
	   driver.switchTo().frame(name);

}
   
   public void switchToFrame(WebDriver driver,WebElement element) {
	   driver.switchTo().frame(element);
}
   
   public void switchToAlertAndAccept(WebDriver driver) {
	   driver.switchTo().alert().accept();
   }
   
   public void switchToAlertAndCancel(WebDriver driver) {
	   driver.switchTo().alert().dismiss();
   }
   
   public void select(WebElement element, String text) {
	   Select sel = new Select(element);
	   sel.selectByVisibleText(text);
   }
   
   
   public void select1(WebElement element, String index) {
	   Select sel = new Select(element);
	   sel.selectByIndex(0);
   }
   
   public void mouseMoveOnElement(WebDriver driver, WebElement element) {
	   Actions act = new Actions(driver);
       act.moveToElement(element).perform();
   }
   public void doubleClick(WebDriver driver, WebElement element) {
	   Actions act = new Actions(driver);
       act.doubleClick(element).perform();
   }
   
}