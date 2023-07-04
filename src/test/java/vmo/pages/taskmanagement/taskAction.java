package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import vmo.helper.ElementHelper;

import java.time.Duration;

public class TaskAction extends UIInteractionSteps {
    ElementHelper elementHelper = new ElementHelper();

    public void clickOnTaskManagement() {
        $(TaskElements.TASK_MANAGEMENT).withTimeoutOf(Duration.ofSeconds(10)).click();
    }

    public void clickOnButtonAdd() {
        $(TaskElements.BUTTON_ADD).click();
    }

    public void clickChooseMeeting() {
        $(TaskElements.MEETING_SEARCH).click();
        $(TaskElements.MEETING_MYEC).click();
    }

    public void enterTaskName(String taskName) {
        $(TaskElements.TASK_NAME).click();
        $(TaskElements.TASK_NAME).sendKeys(taskName);
    }

    public void clickChoosePriority() {
        $(TaskElements.PRIORITY).click();
        $(TaskElements.PRIORITY_NORMAL).click();
    }

    public void clickChooseDueDate() {
        $(TaskElements.DUE_DATA).click();
        $(TaskElements.TODAY).click();
    }

    public void clickChoosePIC() {
        $(TaskElements.PIC).click();
        $(TaskElements.PIC_USER).click();
    }

    public void searchTask(String searchKey) {
        elementHelper.checkElementPresent($(TaskElements.TXT_SEARCH));
        elementHelper.checkElementPresent($(TaskElements.BTN_SEARCH));
        $(TaskElements.TXT_SEARCH).sendKeys(searchKey);
        $(TaskElements.BTN_SEARCH).click();
    }

    public void clickEditButton(String name) {
        elementHelper.checkElementPresent($(TaskElements.EDIT_BTN));
        By editBtn = elementHelper.getElementBy(name, TaskElements.EDIT_BTN);
        $(editBtn).click();
    }

    public void selectRandomMeeting() {
        elementHelper.selectRandomValue($(TaskElements.DDL_MEETING));
    }

    public void inputTaskName(String taskName) {
        $(TaskElements.TXT_TASK_NAME).sendKeys(taskName);
    }

    public void selectPriority(String label) {
        elementHelper.selectByLabel($(TaskElements.DDL_PRIORITY), label);
    }

    public void selectRandomReporter() {
        elementHelper.selectRandomValue($(TaskElements.DDL_REPORTER));
    }

    public void selectRandomPIC() {
        elementHelper.selectRandomValue($(TaskElements.DDL_PIC));
    }

    public void inputNote(String note) {
        $(TaskElements.TXA_NOTE).sendKeys(note);
    }

    public void clickCancel() {
        elementHelper.checkElementPresent($(TaskElements.BTN_CANCEL));
        $(TaskElements.BTN_CANCEL).click();
    }

    public void submitEdit() {
        elementHelper.checkElementPresent($(TaskElements.BTN_SAVE));
        $(TaskElements.BTN_SAVE).click();
    }
}
