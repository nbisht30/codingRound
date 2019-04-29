package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import superhelper.Base;

public class FlightsResults extends Base {
	private WebDriver driver;

	By searchSummary = By.className("searchSummary");

	/**
	 * Initializes data member "driver" of {@link FlightsResults} page object and
	 * all its locators.
	 */
	public FlightsResults() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Checks that Search Summary is displaying on Flights Results page.
	 */
	public void isSummaryPresent() {
		waitFor(5000);
		Assert.assertTrue(isElementPresent(searchSummary));
	}
}
