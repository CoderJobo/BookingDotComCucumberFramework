package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;

public class SearchResultSteps extends BaseSteps {

    public SearchResultSteps() {}

    @Then("^I see my search results$")
    public boolean verifySearchResults() {
        return getSearchResultPage().verifyIfSearchResultDisplayed();
    }

    @Then("^the hotel (.*?) should be listed$")
    public void theHotelNameShouldBeListed(String hotelListed) {
        Assert.assertEquals(true, getSearchResultPage().verifyIfHotelIsListed(hotelListed));
    }

    @Then("^the hotel (.*?) should not be listed$")
    public void theHotelNameShouldNotBeListed(String hotelNotListed) {
        Assert.assertEquals(false, getSearchResultPage().verifyIfHotelIsListed(hotelNotListed));
    }

}
