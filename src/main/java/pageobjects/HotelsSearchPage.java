package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import superhelper.Base;

public class HotelsSearchPage {

	private WebDriver driver;

	@FindBy(id = "Tags")
	private WebElement localityTextBox;

	@FindBy(id = "SearchHotelsButton")
	private WebElement searchButton;

	@FindBy(id = "travellersOnhome")
	private WebElement travellerSelection;

	@FindBy(linkText = "Your trips")
	private WebElement yourtrips;

	@FindBy(id = "SignIn")
	private WebElement signIn;

	public HotelsSearchPage() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	public void setLocality(String locality) {
		localityTextBox.sendKeys(locality);
	}

	public void selectTravellers(String travellers) {
		new Select(travellerSelection).selectByVisibleText(travellers);
	}

	public HotelsResults performHotelSearch() {
		searchButton.click();
		return new HotelsResults();
	}

	public void clickYourTrips() {
		yourtrips.click();
	}

	public void signIn() {
		signIn.click();
	}

}
