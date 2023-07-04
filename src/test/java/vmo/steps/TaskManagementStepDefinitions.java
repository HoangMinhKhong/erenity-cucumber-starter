package vmo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import vmo.pages.login.LoginAction;
import vmo.pages.login.LoginVerify;
import vmo.pages.taskmanagement.taskAction;
import vmo.pages.taskmanagement.taskVerify;

public class TaskManagementStepDefinitions extends UIInteractionSteps {
    @Steps
    LoginAction loginAction;
    LoginVerify loginVerify;
    taskAction taskAct;
    taskVerify taskVer;

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
    public void verifyHomePage() {
        loginVerify.verifyHomePage();
    }

    //Edit task management steps
    @Given("User search (.*?) to edit")
    public void userSearchSearchKeyToEdit(String search) {
        taskAct.searchTask(search);
    }

    @When("Click on edit button by search key (.*?)")
    public void clickOnEditButton(String search) {
        taskAct.clickEditButton(search);
    }

    @And("Edit information of task with priority (.*?)")
    public void editInformationOfTask(String priority) {
        taskAct.selectPriority(priority);
        taskVer.selectedValueShouldBeCorrect(priority);
    }

    @And("User click save button")
    public void userClickSaveButton() {
        taskAct.submitEdit();
    }

    @Then("System shows success message (.*?)")
    public void systemShowsSuccessMessage(String message) {
        taskVer.messageSuccessShouldBeDisplay();
        taskVer.messageSuccessShouldContain(message);
    }

    @Then("Task details screen should be display")
    public void taskDetailsScreenShouldBeDisplay() {
        taskVer.editFormShouldBeDisplay();
    }

    @Then("Search result should be contain (.*?)")
    public void searchResultShouldBeContainSearchKey(String search) {
        taskVer.searchResultShouldContain(search);
    }
}
