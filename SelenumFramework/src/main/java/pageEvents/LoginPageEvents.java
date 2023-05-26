package pageEvents;

import org.testng.Assert;

import baseTest.BaseTest;
import pageObjects.LoginPageElements;
import utils.ElementFetch;

public class LoginPageEvents {

	ElementFetch elementFetch = new ElementFetch();
	public String verifyLoginPageTitle()
	{ 
		Assert.assertTrue(BaseTest.driver.getTitle().contains("Swag Labs"), "Actual Title : "+BaseTest.driver.getTitle());
		return BaseTest.driver.getTitle();
	}
	
	public void signIn()
	{ 
		elementFetch.getWebElement("XPATH", LoginPageElements.usernameTextBoxId).sendKeys("standard_user");
		elementFetch.getWebElement("XPATH", LoginPageElements.passwordTextBoxId).sendKeys("secret_sauce");
		elementFetch.getWebElement("XPATH", LoginPageElements.loginButtonXPath).click();
	}

}
