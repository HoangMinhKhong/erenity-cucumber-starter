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
    public void clickOnButtonAdd() {
        taskAction.clickOnButtonAdd();
    }

    @And("Click choose meeting")
    public void clickChooseMeeting() {
        taskAction.clickChooseMeeting();
    }

    @And("Enter task name is {string}")
    public void enterTaskName(String taskName) {
        taskAction.enterTaskName(taskName);
    }

    @And("Click choose priority")
    public void clickChoosePriority() {
        taskAction.clickChoosePriority();
    }

    @And("Click choose due date")
    public void clickChooseDueDate() {
        taskAction.chooseNewDate();
    }

    @And("Click choose pic")
    public void clickChoosePic() {
        taskAction.clickChoosePIC();
        taskVerify.picShouldBeCorrect("pic");
    }


    //Edit task management steps
    @When("User search {} to edit/delete")
    public void userSearchSearchKeyToEdit(String search) {
        taskAction.searchTask(search);
    }

    @And("Click on edit button by search key {string}")
    public void clickOnEditButton(String search) {
        taskAction.clickEditButton(search);
    }

    @When("Click on delete button by search key {string}")
    public void clickOnDeleteButton(String search) {
        taskAction.clickDeleteButton(search);
    }

    @When("Edit information of task")
    public void editInformationOfTask() {
        taskAction.enterTaskName("Automation demo");
//        taskAction.selectPriority(priority);
//        taskVerify.selectedValueShouldBeCorrect(priority);
        taskAction.removeOldDateAndChooseNewDate();
        taskAction.selectPIC();
        taskVerify.picShouldBeCorrect("pic");
//        taskAction.selectRandomReporter();
        taskAction.inputNote("This is message for demo automation. Thank you!");
    }

    @And("User click save button")
    public void userClickSaveButton() {
        taskAction.submitEdit();
    }

    @Then("System shows success message should be {string}")
    public void systemShowsSuccessMessage(String message) {
        taskVerify.messageSuccessShouldBeDisplay();
        taskVerify.messageSuccessShouldContain(message);
    }

    @Then("Task details screen should be display")
    public void taskDetailsScreenShouldBeDisplay() {
        taskVerify.editFormShouldBeDisplay();
    }

    @Then("Delete task popup should be display")
    public void deleteTaskShouldBeDisplay() {
        taskVerify.deleteTaskShouldBeDisplay();
    }

    @And("Search result should be contain {string}")
    public void searchResultShouldBeContainSearchKey(String search) {
        taskVerify.searchResultShouldContain(search);
    }

    @When("User click confirm delete task")
    public void userClickConfirmDeleteTask() {
        taskAction.clickConfirmDelete();

    }

    @Then("System shows success message")
    public void systemShowsSuccessMessage() {
        taskVerify.messageSuccessShouldBeDisplay();
    }

    @Then("Verify that edit data success")
    public void verifyThatEditDataSuccess() {
        taskVerify.verifyEditSuccess("taskNameEdit");
    }

    @Then("Verify that delete data success")
    public void verifyThatDeleteDataSuccess() {
        taskVerify.verifyDeleteSuccess("delete");
    }
}
