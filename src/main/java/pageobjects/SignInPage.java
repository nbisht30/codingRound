package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import superhelper.Base;

public class SignInPage {
	private WebDriver driver;

	@FindBy(id = "signInButton")
	private WebElement signInButton;

	@FindBy(id = "errors1")
	private WebElement errorMsg;

	/**
	 * Initializes data member "driver" of {@link SignInPage} page object and all
	 * its locators.
	 */
	public SignInPage() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Submits the page by clicking on Sign In Button.
	 */
	public void submitPage() {
		signInButton.click();
	}

	/**
	 * Validates the error message in case of an incorrect submission.
	 */
	public void validateError() {
		String errors1 = errorMsg.getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}
}
