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

	/**
	 * Initializes data member "driver" of {@link HotelsSearchPage} page object and
	 * all its locators.
	 */
	public HotelsSearchPage() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Sets locality on Hotels Search Page.
	 */
	public void setLocality(String locality) {
		localityTextBox.sendKeys(locality);
	}

	/**
	 * Selects the number of rooms and adults combination.
	 */
	public void selectTravellers(String travellers) {
		new Select(travellerSelection).selectByVisibleText(travellers);
	}

	/**
	 * Performs hotel search by clicking on Search Button on Hotels Search page.
	 * 
	 * @return a HotelsResults object
	 */
	public HotelsResults performHotelSearch() {
		searchButton.click();
		return new HotelsResults();
	}

	/**
	 * Clicks on Your Trips section.
	 */
	public void clickYourTrips() {
		yourtrips.click();
	}

	/**
	 * Clicks on Sign In button in Your Trips section.
	 */
	public void signIn() {
		signIn.click();
	}

}
