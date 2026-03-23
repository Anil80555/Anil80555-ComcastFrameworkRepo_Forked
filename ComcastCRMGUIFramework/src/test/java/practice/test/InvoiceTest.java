package practice.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
//@Listeners(com.comcast.crm.listenerutility.ListenerImpClass.class)
public class InvoiceTest extends BaseClass {
	
	@Test
	public void createInvoiceTest() {
	  System.out.println("execute createInvoiceTest");
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		Assert.assertEquals(actTitle, "login");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
	}

	@Test
	public void createInoviceWithContactTest() {
	  System.out.println("execute createInoviceWithContactTest");
		System.out.println("Step-1");
		System.out.println("Step-2");
		System.out.println("Step-3");
		System.out.println("Step-4");
		
	}
	
}
