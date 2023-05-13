package utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import baseTest.BaseTest;

public class ElementFetch {

	public WebElement getWebElement(String identifierType, String identifierValue)
	{
		switch (identifierType)
		{
		case "XPATH": return BaseTest.driver.findElement(By.xpath(identifierValue));
		case "ID": return BaseTest.driver.findElement(By.id(identifierValue));
		case "CSS": return BaseTest.driver.findElement(By.cssSelector(identifierValue));
		case "NAME": return BaseTest.driver.findElement(By.name(identifierValue));
		case "CLASSNAME": return BaseTest.driver.findElement(By.className(identifierValue));
		case "LINKTEXT": return BaseTest.driver.findElement(By.linkText(identifierValue));
		default: return null;
		}
	}

	public List<WebElement> getWebElements(String identifierType, String identifierValue)
	{
		switch (identifierType)
		{
		case "XPATH": return BaseTest.driver.findElements(By.xpath(identifierValue));
		case "ID": return BaseTest.driver.findElements(By.id(identifierValue));
		case "CSS": return BaseTest.driver.findElements(By.cssSelector(identifierValue));
		case "NAME": return BaseTest.driver.findElements(By.name(identifierValue));
		case "CLASSNAME": return BaseTest.driver.findElements(By.className(identifierValue));
		case "LINKTEXT": return BaseTest.driver.findElements(By.linkText(identifierValue));
		default: return null;
		}
	}
}
