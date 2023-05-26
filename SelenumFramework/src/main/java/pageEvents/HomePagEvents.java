package pageEvents;

import pageObjects.HomePageElements;
import utils.ElementFetch;

public class HomePagEvents {
	ElementFetch elementFetch = new ElementFetch();
	public void LogInbutton()
	{
		elementFetch.getWebElement("XPATH", HomePageElements.logInButtonXpath).click();
	}

	public void RegisterForFree()
	{
		elementFetch.getWebElement("XPATH", HomePageElements.logInButtonXpath).click();
	}
}
