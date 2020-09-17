package step_definitions;

import io.cucumber.java.en.When;

public class FacilitiesSteps extends BaseSteps {

    public FacilitiesSteps() {}

    @When("^I apply a (.*?) Facilities filter$")
    public void iApplyASpaAndWellnessCentreFilter(String facility) throws Exception {
        getFacilitiesPage().filterFacilities(facility);
    }

    @When("^I apply a filter for Spa and wellness centre$")
    public void iApplyAFilterForSpaAndWellnessCentre() throws Exception {
        getFacilitiesPage().filterSpaAndWellnessCentre();
    }

}
