package pageEvents;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import baseTest.BaseTest;
import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch elementFetch = new ElementFetch();
	public void verifyLoginPageTitle()
	{ 
		Assert.assertTrue(BaseTest.driver.getTitle().equals("Cogmento CRM"));
	}

}
