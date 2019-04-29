package pageobjects;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import superhelper.Base;

public class FlightsSearchPage extends Base {
	private WebDriver driver;

	@FindBy(id = "ToTag")
	private WebElement toLoc;

	@FindBy(id = "FromTag")
	private WebElement fromLoc;

	@FindBy(id = "OneWay")
	private WebElement oneWay;

	@FindBy(id = "SearchBtn")
	private WebElement searchBtn;

	@FindBy(linkText = "Hotels")
	private WebElement hotelLink;

	@FindBy(linkText = "Your trips")
	private WebElement yourtrips;

	@FindBy(id = "SignIn")
	private WebElement signIn;

	/**
	 * Initializes data member "driver" of {@link FlightsSearchPage} page object and
	 * all its locators.
	 */
	public FlightsSearchPage() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * Selects One Way checkbox on Flights Search Page.
	 */
	public void selectOneWay() {
		waitFor(5000);
		oneWay.click();
	}

	/**
	 * Clicks on Your Trips user menu.
	 */
	public void clickYourTrips() {
		yourtrips.click();
	}

	/**
	 * Clicks on Sign In button in Your Trips user menu. This method needs Your
	 * Trips menu to be open, beforehand.
	 */
	public void signIn() {
		signIn.click();
	}

	/**
	 * Clicks on Hotels link for navigating to Hotels Search Page.
	 * 
	 * @return a {@link HotelsSearchPage} object.
	 */
	public HotelsSearchPage clickHotelsLink() {
		hotelLink.click();
		return new HotelsSearchPage();
	}

	/**
	 * Sets the origin of a user's flight.
	 * 
	 * @param loc takes a String object containing the origin
	 */
	public void setOrigin(String loc) {
		fromLoc.clear();
		fromLoc.sendKeys(loc);
		waitFor(5000);
		// select the first item from the destination auto complete list
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));

		originOptions.get(0).click();
	}

	/**
	 * Sets the destination for a user.
	 * 
	 * @param loc takes a String object containing the destination
	 */
	public void setDestination(String loc) {
		toLoc.clear();
		toLoc.sendKeys(loc);
		waitFor(5000);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
	}

	/**
	 * Sets the departure location for a user.
	 * 
	 * @param date takes a {@link LocalDate} object containing the departure location
	 */
	public boolean clickDate(LocalDate date) {
		if (selectDate(date)) {
			return true;
		}
		System.out.println("Date not selected");
		return false;
	}

	/**
	 * Click on Search Button and perform search on Flight Search Page.
	 * 
	 * @return a {@link FlightResults} object
	 */
	public FlightsResults clickSearchButton() {
		searchBtn.click();
		return new FlightsResults();
	}

}
