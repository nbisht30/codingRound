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

	public SignInPage() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	public void submitPage() {
		signInButton.click();
	}

	public void validateError() {
		String errors1 = errorMsg.getText();
		Assert.assertTrue(errors1.contains("There were errors in your submission"));
	}
}
