package scripts;

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
		flightSearch.setSource("Bangalore");
		flightSearch.setDestination("Delhi");
		flightSearch.clickDate();
		FlightsResults resultsPage = flightSearch.clickSearchButton();
		resultsPage.isSummaryPresent();
	}
}
