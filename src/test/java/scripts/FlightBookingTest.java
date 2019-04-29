package scripts;

import java.time.LocalDate;
import java.time.Month;

import org.testng.annotations.Test;

import pageobjects.FlightsResults;
import pageobjects.FlightsSearchPage;
import superhelper.Base;

public class FlightBookingTest extends Base {
	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		loadURL("https://www.cleartrip.com/");
		FlightsSearchPage flightSearch = new FlightsSearchPage();
		flightSearch.selectOneWay();
		flightSearch.setOrigin("Bangalore");
		flightSearch.setDestination("Delhi");
		LocalDate jnyDate = LocalDate.of(2023, Month.MARCH, 30);
		flightSearch.clickDate(jnyDate);
		FlightsResults resultsPage = flightSearch.clickSearchButton();
		resultsPage.isSummaryPresent();
	}
}
