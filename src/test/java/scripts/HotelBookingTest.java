package scripts;

import org.testng.annotations.Test;

import pageobjects.FlightsSearchPage;
import pageobjects.HotelsSearchPage;
import superhelper.Base;

public class HotelBookingTest extends Base {
	@Test
	public void shouldBeAbleToSearchForHotels() {
		loadURL("https://www.cleartrip.com/");
		FlightsSearchPage flightsSearchPage = new FlightsSearchPage();
		HotelsSearchPage hotelsSearchPage = flightsSearchPage.clickHotelsLink();
		hotelsSearchPage.setLocality("Indiranagar, Bangalore");
		hotelsSearchPage.selectTravellers("1 room, 2 adults");
	}
}
