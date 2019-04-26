package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import superhelper.Base;

public class FlightsResults extends Base {
	private WebDriver driver;

	@FindBy(className = "searchSummary")
	private WebElement searchSummary;

	public FlightsResults() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	public void isSummaryPresent() {
		waitFor(5000);
		Assert.assertTrue(isElementPresent(searchSummary));
	}
}
