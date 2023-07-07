package vmo.pages.taskmanagement;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.ElementHelper;

import java.time.Duration;
import java.util.List;

public class TaskAction extends UIInteractionSteps {
    ElementHelper elementHelper = new ElementHelper();

    @Step
    public void clickOnTaskManagement() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.TASK_MANAGEMENT)));
        $(TaskElements.TASK_MANAGEMENT).withTimeoutOf(Duration.ofSeconds(10)).click();
    }

    @Step
    public void clickOnButtonAdd() {
        $(TaskElements.BUTTON_ADD).click();
    }

    @Step
    public void clickChooseMeeting() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.MEETING_SEARCH)));
        $(TaskElements.MEETING_SEARCH).click();
        $(TaskElements.MEETING_MYEC).click();
    }

    @Step
    public void enterTaskName(String taskName) {
        elementHelper.clearText($(TaskElements.TASK_NAME));
        String rd = taskName + elementHelper.randomString(5);
        Serenity.setSessionVariable("taskNameEdit").to(rd);
        $(TaskElements.TASK_NAME).sendKeys(rd);
    }

    @Step
    public void clickChoosePriority() {
        $(TaskElements.DDL_PRIORITY).click();
        $(TaskElements.PRIORITY_NORMAL).click();
    }

    @Step
    public void removeOldDate(WebElementFacade webElementFacade) {
        Actions actions = new Actions(getDriver());
        WebElement webElement = webElementFacade.getElement();
        actions.moveToElement(webElement).perform();
        webElement.click();
    }

    @Step
    public void removeOldDateAndChooseNewDate() {
        removeOldDate($(TaskElements.IC_DELETE_DATE));
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.DUE_DATA)));
        $(TaskElements.DUE_DATA).click();
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.TODAY)));
        $(TaskElements.TODAY).click();
    }

    @Step
    public void chooseNewDate() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.DUE_DATA)));
        $(TaskElements.DUE_DATA).click();
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.TODAY)));
        $(TaskElements.TODAY).click();
    }

    @Step
    public void clickChoosePIC() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.PIC)));
        $(TaskElements.PIC).click();
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.LIST_PIC_ADD)));
        //get list
        List<WebElement> value = elementHelper.getListElement(TaskElements.LIST_PIC_ADD);
        String pic = value.get(0).getText().trim();
        Serenity.setSessionVariable("pic").to(pic);
        elementHelper.clickByJS(value.get(0));
    }

    @Step
    public void searchTask(String searchKey) {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.TXT_SEARCH)));
        WebElement element = $(TaskElements.TXT_SEARCH).getElement();
        if (element.isEnabled()) {
            elementHelper.clearText($(TaskElements.TXT_SEARCH));
            $(TaskElements.TXT_SEARCH).sendKeys(searchKey);
            waitFor(ExpectedConditions.visibilityOf($(TaskElements.BTN_SEARCH)));
            $(TaskElements.BTN_SEARCH).click();
        }
    }

    @Step
    public void clickEditButton(String name) {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.EDIT_BTN(name))));
        $(TaskElements.EDIT_BTN(name)).click();
    }

    @Step
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

    @Step
    public void selectPIC() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.DDL_PIC)));
        $(TaskElements.DDL_PIC).click();
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.PIC_LIST)));
        //get list
        List<WebElement> list = elementHelper.getListElement(TaskElements.PIC_LIST);
        String pic = list.get(1).getText().trim();
        Serenity.setSessionVariable("pic").to(pic);
        list.get(1).click();
    }

    @Step
    public void inputNote(String note) {
        elementHelper.clearText($(TaskElements.TXA_NOTE));
        $(TaskElements.TXA_NOTE).sendKeys(note + elementHelper.randomString(10));
    }

    public void clickCancel() {
        elementHelper.checkElementPresent($(TaskElements.BTN_CANCEL));
        $(TaskElements.BTN_CANCEL).click();
    }

    @Step
    public void submitEdit() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.BTN_SAVE)));
        $(TaskElements.BTN_SAVE).click();
    }

    @Step
    public void clickConfirmDelete() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.BTN_CONFIRM)));
        $(TaskElements.BTN_CONFIRM).click();
    }
}
