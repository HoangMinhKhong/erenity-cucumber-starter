package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;

import java.time.Duration;

public class TaskAction extends UIInteractionSteps {

    public void clickOnTaskManagement(){
        withTimeoutOf(Duration.ofSeconds(30))
                .find(TaskElements.TASK_MANAGEMENT)
                .isDisplayed();
        $(TaskElements.TASK_MANAGEMENT).click();
    }

    public void clickOnButtonAdd(){
//        $(TaskElements.BUTTON_ADD).click();
    }

}
