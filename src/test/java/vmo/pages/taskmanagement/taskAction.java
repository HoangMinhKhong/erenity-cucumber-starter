package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.ElementHelper;

import java.time.Duration;

public class TaskAction extends UIInteractionSteps {
    ElementHelper elementHelper = new ElementHelper();

    public void clickOnTaskManagement() {
        elementHelper.delayInSeconds(1);
        $(TaskElements.TASK_MANAGEMENT).withTimeoutOf(Duration.ofSeconds(10)).click();
    }

    public void clickOnButtonAdd() {
        $(TaskElements.BUTTON_ADD).click();
    }

    public void clickChooseMeeting() {
        elementHelper.delayInSeconds(1);
        $(TaskElements.MEETING_SEARCH).click();
        $(TaskElements.MEETING_MYEC).click();
    }

    public void enterTaskName(String taskName) {
        elementHelper.clearText($(TaskElements.TASK_NAME));
        $(TaskElements.TASK_NAME).sendKeys(taskName + elementHelper.randomString(5));
    }

    public void clickChoosePriority() {
        $(TaskElements.DDL_PRIORITY).click();
        $(TaskElements.PRIORITY_NORMAL).click();
    }

    public void removeOldDate(WebElementFacade webElementFacade) {
        elementHelper.delayInSeconds(1);
        Actions actions = new Actions(getDriver());
        WebElement webElement = webElementFacade.getElement();
        actions.moveToElement(webElement).perform();
        webElement.click();
    }

    public void removeOldDateAndChooseNewDate() {
        elementHelper.delayInSeconds(1);
        removeOldDate($(TaskElements.IC_DELETE_DATE));
        elementHelper.delayInSeconds(2);
        $(TaskElements.DUE_DATA).click();
        $(TaskElements.TODAY).click();
    }

    public void chooseNewDate() {
        elementHelper.delayInSeconds(1);
        $(TaskElements.DUE_DATA).click();
        elementHelper.delayInSeconds(1);
        $(TaskElements.TODAY).click();
    }

    public void clickChoosePIC() {
        $(TaskElements.PIC).click();
        elementHelper.delayInSeconds(1);
        $(TaskElements.PIC_USER).click();
    }

    public void searchTask(String searchKey) {
        elementHelper.delayInSeconds(15);
//        waitFor(ExpectedConditions.visibilityOf($(TaskElements.TXT_SEARCH)));
        WebElement element = $(TaskElements.TXT_SEARCH).getElement();
        if (element.isEnabled()) {
            $(TaskElements.TXT_SEARCH).sendKeys(searchKey);
            elementHelper.delayInSeconds(1);
            $(TaskElements.BTN_SEARCH).click();
        }
    }

    public void clickEditButton(String name) {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.EDIT_BTN(name))));
        $(TaskElements.EDIT_BTN(name)).click();
    }

    public void clickDeleteButton(String name) {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.DELETE_BTN(name))));
        $(TaskElements.DELETE_BTN(name)).click();
    }

    public void selectRandomMeeting() {
        elementHelper.selectRandomValue($(TaskElements.DDL_MEETING));
    }

    public void inputTaskName(String taskName) {
        $(TaskElements.TXT_TASK_NAME).sendKeys(taskName);
    }

    public void selectPriority(String label) {
        $(TaskElements.DDL_PRIORITY).click();

        elementHelper.selectByLabel($(TaskElements.DDL_PRIORITY), label);
    }

    public void selectRandomReporter() {
        $(TaskElements.DDL_REPORTER).click();
        $(TaskElements.REPORTER).click();
    }

    public void selectPIC() {
        elementHelper.delayInSeconds(2);
        $(TaskElements.DDL_PIC).click();
        $(TaskElements.REPORTER).click();
    }

    public void inputNote(String note) {
        elementHelper.clearText($(TaskElements.TXA_NOTE));
        $(TaskElements.TXA_NOTE).sendKeys(note + elementHelper.randomString(10));
    }

    public void clickCancel() {
        elementHelper.checkElementPresent($(TaskElements.BTN_CANCEL));
        $(TaskElements.BTN_CANCEL).click();
    }

    public void submitEdit() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.BTN_SAVE)));
        $(TaskElements.BTN_SAVE).click();
    }

    public void clickConfirmDelete() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.BTN_CONFIRM)));
        $(TaskElements.BTN_CONFIRM).click();
    }
}
