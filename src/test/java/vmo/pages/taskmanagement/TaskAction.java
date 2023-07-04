package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.time.Duration;

public class TaskAction extends UIInteractionSteps {

    public void clickOnTaskManagement(){
        $(TaskElements.TASK_MANAGEMENT).withTimeoutOf(Duration.ofSeconds(10)).click();
    }

    public void clickOnButtonAdd(){
        $(TaskElements.BUTTON_ADD).click();
    }

    public void clickChooseMeeting(){
        $(TaskElements.MEETING_SEARCH).click();
        $(TaskElements.MEETING_MYEC).click();
    }

    public void enterTaskName(){

    }
}
