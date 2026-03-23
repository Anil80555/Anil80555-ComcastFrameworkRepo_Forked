package practice.test;
/**
 * test class for contact module
 * @author Lokesh
 * 
 */

import org.testng.annotations.Test;

import com.comcast.crm.baseTest.BaseClass;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class SearchContactTest extends BaseClass {
	
	@Test
	public void searchContactTest() {
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp("Url", "username", "pwd");
	}

}
