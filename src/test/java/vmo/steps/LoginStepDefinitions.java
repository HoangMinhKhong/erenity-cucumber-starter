package vmo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import vmo.pages.login.LoginAction;
import vmo.pages.login.LoginVerify;

public class LoginStepDefinitions extends UIInteractionSteps {
    @Steps
    LoginAction loginAction;
    LoginVerify loginVerify;

    @Given("Verify account text box and password text box")
    public void researchingThings() {
        loginVerify.verifyTextBoxSearchDisplay();
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
