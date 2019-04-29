package superhelper;

import java.time.LocalDate;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;

import com.sun.javafx.PlatformUtil;

public class Base {
	public static WebDriver driver;

	/**
	 * This is a test setup methods which runs before any other test method. It sets
	 * "webdriver.chrome.driver" to location of chromedriver.exe It initializes up
	 * Chrome Driver for further test execution. It disables notification alerts for
	 * Chrome and maximizes the browser's window.
	 */
	@BeforeTest
	public void setup() {
		setDriverPath();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	/**
	 * Loads any URL.
	 * 
	 * @param url takes the url which has to be opened
	 */
	public static void loadURL(String url) {
		driver.navigate().to(url);
		waitFor(3000);
	}

	/**
	 * Selects any given date on any Date Pickers in the application.
	 * 
	 * @param date takes a {@link LocalDate} object which contains the date to be
	 *              selected
	 * @return true if able to click that date and false if the date was invalid
	 */
	public static boolean selectDate(LocalDate date) {
		LocalDate now = LocalDate.now();
		if (date.isBefore(now)) {
			return false;
		}
		String dateStr = String.valueOf(date.getDayOfMonth());
		String month = date.getMonth().toString().toLowerCase();
		month = month.substring(0, 1).toUpperCase() + month.substring(1);
		String year = String.valueOf(date.getYear());
		// get to the year
		while (!isElementPresent(By.xpath("//span[@class=\"ui-datepicker-year\" and text()=\"" + year + "\"]"))) {
			if (!isElementPresent(By.cssSelector("a.nextMonth.disabled"))) {
				driver.findElement(By.cssSelector("a.nextMonth ")).click();
			} else {
				return false; // wrong year
			}
		}
		// get to the month
		while (!isElementPresent(By.xpath("//span[@class=\"ui-datepicker-month\" and text()=\"" + month + "\"]"))) {
			if (!isElementPresent(By.cssSelector("a.nextMonth.disabled"))) {
				driver.findElement(By.cssSelector("a.nextMonth ")).click();
			} else {
				return false; // wrong month
			}
		}
		// select the date if both month and year are valid
		driver.findElement(By.xpath("//span[text()=\"" + month + "\"]//ancestor::div[contains(@class,\"monthBlock\")]"
				+ "//td[not(contains(@class,\"disabled\"))]/a[text()=\"" + dateStr + "\"]")).click();
		return true;
	}

	/**
	 * To halt the program execution for given number of milliseconds.
	 * 
	 * @param durationInMilliSeconds the number of milliseconds to halt for
	 */
	public static void waitFor(int durationInMilliSeconds) {
		try {
			Thread.sleep(durationInMilliSeconds);
		} catch (InterruptedException e) {
			e.printStackTrace(); // To change body of catch statement use File | Settings | File Templates.
		}
	}


	/**
	 * Checks if a element is present in the HTML of a page.
	 * 
	 * @param by takes By object formed with that element's locator
	 */
	public static boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	/**
	 * Sets the driver path depending on the platform.
	 */
	public static void setDriverPath() {
		if (PlatformUtil.isMac()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver");
		}
		if (PlatformUtil.isWindows()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		}
		if (PlatformUtil.isLinux()) {
			System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
		}
	}

	/**
	 * Closes all browser windows after tests have executed.
	 */
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
}
