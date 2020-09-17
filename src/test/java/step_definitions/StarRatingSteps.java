package step_definitions;

import io.cucumber.java.en.When;

public class StarRatingSteps extends BaseSteps {

    public StarRatingSteps() {}

    @When("^I apply a (.*?) Star Rating filter$")
    public void iApplyAThreeStarRatingFilter(int stars) throws Exception {
        getFilterStarRating().filterByStars(stars);
        Thread.sleep(10000);
    }
}
