package vmo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import vmo.pages.login.LoginAction;
import vmo.pages.login.LoginVerify;

public class TaskManagementStepDefinitions extends UIInteractionSteps {
    @Steps
    LoginAction loginAction;
    LoginVerify loginVerify;

    @Given("Click on Task Management")
    public void researchingThings() {

    }

    @When("Enter account is {string} and password is {string}")
    public void enterAccountAndPassword(String account, String password) {
        loginAction.sendAccountAndPassWord(account, password);
    }

    @And("Click button login")
    public void clickButtonLogin() {
        loginAction.clickButtonLogin();
    }

    @Then("Verify home page")
    public void verifyHomePage(){
        loginVerify.verifyHomePage();
    }
}
