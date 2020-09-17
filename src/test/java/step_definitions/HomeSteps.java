package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps extends BaseSteps {

    public HomeSteps() {}

    @Given("^I am navigated to Booking.com$")
    public void navigateToBookingDotCom() {
        getHomePage().launchApp();
        Assert.assertTrue(getHomePage().verifyIfNavigatedToBookingDotCom());
    }

    @When("^I enter the location (.*?)$")
    public void iEnterTheLocation(String location) {
        getHomePage().enterLocationFromDropdown(location);
    }

    @When("^I click Search$")
    public void iClickSearch() {
        getHomePage().clickSearch();
    }

    @When("^I enter my guest room details (.*?) (.*?) (.*?)$")
    public void iEnterMyGuestRoomDetailsNumAdultsNumChildrenNumRooms(String numAdults, String numChildren, String numRooms) {
        getHomePage().enterGuestRoomDetails(numAdults, numChildren, numRooms);
    }

    @When("I enter my dates")
    public void iEnterMyDates() {
        getHomePage().enterDates();
    }

    @When("^I accept cookie preferences$")
    public void iAcceptCookiePreferences() throws Exception {
        getHomePage().acceptCookiePreferences();
    }
}
