package qa.test;

import org.testng.annotations.Test;

import baseTest.BaseTest;
import pageEvents.HomePagEvents;
import pageEvents.LoginPageEvents;
import utils.ElementFetch;

public class TestCases extends BaseTest{
	ElementFetch elementFetch = new ElementFetch();
	HomePagEvents homePage = new  HomePagEvents();
	LoginPageEvents loginPage = new LoginPageEvents();
	
	@Test
	public void sampleMethodForVerifingTitle() {
      homePage.LogInbutton();
      loginPage.verifyLoginPageTitle();
	}
	
	@Test
	public void sampleSecondMethodForVerifingTitle() {
      homePage.LogInbutton();
      loginPage.verifyLoginPageTitle();
	}
}
