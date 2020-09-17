package step_definitions;

import io.cucumber.java.en.And;

public class FunThingsToDoSteps extends BaseSteps {

    public FunThingsToDoSteps() {}

    @And("^I apply a filter for Sauna$")
    public void iApplyAFilterForSauna() throws Exception {
        getFunThingsToDoPage().applySaunaFilter();
    }
}
