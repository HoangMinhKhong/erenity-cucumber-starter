package vmo.pages.taskmanagement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import vmo.helper.ElementHelper;
import vmo.pages.login.LoginElements;

public class taskAction extends UIInteractionSteps {
    ElementHelper elementHelper = new ElementHelper();

    public void sendAccountAndPassWord(String account, String password) {
        $(LoginElements.ACCOUT_TEXTBOX).sendKeys(account);
        $(LoginElements.PASSWORD_TEXTBOX).sendKeys(password);
    }

    public void clickButtonLogin() {
        $(LoginElements.BUTTON_LOGIN).click();
    }

    public void searchTask(String searchKey){
        elementHelper.checkElementPresent($(taskElements.TXT_SEARCH));
        elementHelper.checkElementPresent($(taskElements.BTN_SEARCH));
        $(taskElements.TXT_SEARCH).sendKeys(searchKey);
        $(taskElements.BTN_SEARCH).click();
    }

    public void clickEditButton(String name) {
        elementHelper.checkElementPresent($(taskElements.EDIT_BTN));
        By editBtn = elementHelper.getElementBy(name, taskElements.EDIT_BTN);
        $(editBtn).click();
    }

    public void selectRandomMeeting() {
        elementHelper.selectRandomValue($(taskElements.DDL_MEETING));
    }

    public void inputTaskName(String taskName) {
        $(taskElements.TXT_TASK_NAME).sendKeys(taskName);
    }

    public void selectPriority(String label) {
        elementHelper.selectByLabel($(taskElements.DDL_PRIORITY), label);
    }

    public void selectRandomReporter() {
        elementHelper.selectRandomValue($(taskElements.DDL_REPORTER));
    }

    public void selectRandomPIC(){
        elementHelper.selectRandomValue($(taskElements.DDL_PIC));
    }

    public void inputNote(String note){
        $(taskElements.TXA_NOTE).sendKeys(note);
    }

    public void clickCancel(){
        elementHelper.checkElementPresent($(taskElements.BTN_CANCEL));
        $(taskElements.BTN_CANCEL).click();
    }

    public void submitEdit(){
        elementHelper.checkElementPresent($(taskElements.BTN_SAVE));
        $(taskElements.BTN_SAVE).click();
    }
}
