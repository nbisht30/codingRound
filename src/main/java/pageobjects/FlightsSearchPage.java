package pageobjects;

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

	public FlightsSearchPage() {
		this.driver = Base.driver;
		PageFactory.initElements(driver, this);
	}

	public void selectOneWay() {
		waitFor(2000);
		oneWay.click();
	}

	public void clickYourTrips() {
		yourtrips.click();
	}

	public void signIn() {
		signIn.click();
	}

	public HotelsSearchPage clickHotelsLink() {
		waitFor(2000);
		hotelLink.click();
		return new HotelsSearchPage();
	}

	public void setSource(String loc) {
		fromLoc.clear();
		fromLoc.sendKeys(loc);
		// wait for the auto complete options to appear for the origin

		waitFor(7000);
		// select the first item from the destination auto complete list
		List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
		originOptions.get(0).click();
	}

	public void setDestination(String loc) {
		toLoc.clear();
		toLoc.sendKeys(loc);

		// wait for the auto complete options to appear for the destination

		waitFor(7000);
		// select the first item from the destination auto complete list
		List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
		destinationOptions.get(0).click();
	}

	public void clickDate() {
		driver.findElement(By.xpath("//*[@id=\"ui-datepicker-div\"]/div[2]/table/tbody/tr[1]/td[3]/a")).click();
	}

	public FlightsResults clickSearchButton() {
		// all fields filled in. Now click on search
		searchBtn.click();
		return new FlightsResults();
	}

}
