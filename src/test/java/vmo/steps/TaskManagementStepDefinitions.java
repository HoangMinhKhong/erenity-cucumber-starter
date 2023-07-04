package vmo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import vmo.pages.taskmanagement.TaskAction;
import vmo.pages.taskmanagement.TaskVerify;

public class TaskManagementStepDefinitions extends UIInteractionSteps {
    @Steps
    TaskAction taskAction;
    TaskVerify taskVerify;

    @Given("Click on Task Management")
    public void clickOnTaskManagement() {
        taskAction.clickOnTaskManagement();
    }

    @When("Click on button add")
    public void clickOnButtonAdd(){
        taskAction.clickOnButtonAdd();
    }

    @And("Click choose meeting")
    public void clickChooseMeeting(){
        taskAction.clickChooseMeeting();
    }

    @And("Enter task name is {string}")
    public void enterTaskName(String taskName){
        taskAction.enterTaskName(taskName);
    }

    @And("Click choose priority")
    public void clickChoosePriority(){
        taskAction.clickChoosePriority();
    }

    @And("Click choose due date")
    public void clickChooseDueDate(){
        taskAction.clickChooseDueDate();
    }

    //Edit task management steps
    @Given("User search (.*?) to edit")
    public void userSearchSearchKeyToEdit(String search) {
        taskAction.searchTask(search);
    }

    @When("Click on edit button by search key (.*?)")
    public void clickOnEditButton(String search) {
        taskAction.clickEditButton(search);
    }

    @And("Edit information of task with priority (.*?)")
    public void editInformationOfTask(String priority) {
        taskAction.selectPriority(priority);
        taskVerify.selectedValueShouldBeCorrect(priority);
    }

    @And("User click save button")
    public void userClickSaveButton() {
        taskAction.submitEdit();
    }

    @Then("System shows success message (.*?)")
    public void systemShowsSuccessMessage(String message) {
        taskVerify.messageSuccessShouldBeDisplay();
        taskVerify.messageSuccessShouldContain(message);
    }

    @Then("Task details screen should be display")
    public void taskDetailsScreenShouldBeDisplay() {
        taskVerify.editFormShouldBeDisplay();
    }

    @Then("Search result should be contain (.*?)")
    public void searchResultShouldBeContainSearchKey(String search) {
        taskVerify.searchResultShouldContain(search);
    }
}
