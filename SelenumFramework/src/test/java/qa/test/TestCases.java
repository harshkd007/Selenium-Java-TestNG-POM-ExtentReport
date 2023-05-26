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
	public void sampleMethodForVerifingTitle() throws InterruptedException {
		Thread.sleep(4000);
		loginPage.verifyLoginPageTitle();
		logger.info("Verified the login page title");
	}

	@Test
	public void verifyTheLogInFunctioality() throws InterruptedException {
		Thread.sleep(4000);
		loginPage.signIn();
		logger.info("Successfully signed in");
	}
}
