package DataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductInfoAmazon {
	
	@Test(dataProvider = "getData")
	public void getProductInfo(String BrandName , String productName) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(BrandName, Keys.ENTER);
		
	String x= "//span[text()='"+productName+"']/ancestor::div[@class='puisg-col-inner']/descendant::span[@class='a-price']";

		
	System.out.println(driver.findElement(By.xpath(x)).getText());
	
	driver.quit();
	
	}
	
	
	@DataProvider
	public Object[][] getData() throws Throwable{
		
		ExcelUtility eLib= new ExcelUtility();
		int rCount = eLib.getRowCount("product");
		Object[][] objA = new Object[rCount][2];
		
		for(int i=0; i<rCount; i++) {
			
			objA[i][0] = eLib.getDataFromExcel("product", i+1, 0);
			objA[i][1] = eLib.getDataFromExcel("product", i+1, 1);
			
			
			 
		}
		return objA;
		
	}

}
