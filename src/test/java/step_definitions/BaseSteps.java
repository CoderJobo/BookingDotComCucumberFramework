package step_definitions;

import org.openqa.selenium.WebDriver;
import pages.*;

public class BaseSteps {

    private static WebDriver driver = null;

    public BaseSteps() {}

    public static void setDriver(WebDriver driver){
        BaseSteps.driver = driver;
    }

    public HomePage getHomePage() {
        return new HomePage(driver);
    }

    public SearchResultPage getSearchResultPage() {
        return new SearchResultPage(driver);
    }

    public StarRatingPage getFilterStarRating() {
        return new StarRatingPage(driver);
    }

    public FacilitiesPage getFacilitiesPage() {
        return new FacilitiesPage(driver);
    }

    public FunThingsToDoPage getFunThingsToDoPage() {
        return new FunThingsToDoPage(driver);
    }

}
