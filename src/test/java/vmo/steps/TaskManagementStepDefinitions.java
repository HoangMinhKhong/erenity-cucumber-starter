package vmo.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;
import vmo.pages.login.LoginAction;
import vmo.pages.login.LoginVerify;
import vmo.pages.taskmanagement.TaskAction;
import vmo.pages.taskmanagement.TaskElements;
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
}
