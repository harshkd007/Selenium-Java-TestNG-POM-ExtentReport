package pageEvents;

import org.testng.Assert;

import baseTest.BaseTest;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch elementFetch = new ElementFetch();
	public String verifyLoginPageTitle()
	{ 
		Assert.assertTrue(BaseTest.driver.getTitle().equals("Cogmento CRM"));
		return BaseTest.driver.getTitle();
	}
	
	public void signIn()
	{ 
		elementFetch.getWebElement("XPATH", LoginPageElements.emailTextBoxId).sendKeys("kdharsh@gmail.com");
		elementFetch.getWebElement("XPATH", LoginPageElements.passwordTextBoxId).sendKeys("Asdf@1234");
		elementFetch.getWebElement("XPATH", LoginPageElements.loginButtonXPath).click();
	}

}
