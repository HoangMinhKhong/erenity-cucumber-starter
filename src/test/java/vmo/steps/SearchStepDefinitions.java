package vmo.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import vmo.pages.search.searchAction;
import vmo.pages.search.searchVerify;

public class SearchStepDefinitions extends UIInteractionSteps {
    @Steps
    searchAction searchAction;
    searchVerify searchVerify;

    @Given("Sergey is researching things on the internet")
    public void researchingThings() {
        searchVerify.verifyTextBoxSearchDisplay();
    }

    @When("he looks up {string}")
    public void searchesFor(String term) {
        searchAction.enterText(term);
        searchAction.clickSearch();
    }

    @Then("he should see information about {string}")
    public void should_see_information_about(String term) {
//        actor.attemptsTo(
//                Ensure.that(WikipediaArticle.HEADING).hasText(term)
//        );
    }
}
