package vmo.pages.taskmanagement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.ElementHelper;
import vmo.pages.login.LoginElements;

import static org.assertj.core.api.Assertions.assertThat;


public class TaskVerify extends UIInteractionSteps {
    ElementHelper elementHelper = new ElementHelper();

    public void verifyTextBoxSearchDisplay() {
        assertThat($(LoginElements.ACCOUT_TEXTBOX).isDisplayed()).isTrue();
        assertThat($(LoginElements.PASSWORD_TEXTBOX).isDisplayed()).isTrue();
    }

    public void verifyHomePage() {
        assertThat($(LoginElements.LOGOUT).isDisplayed()).isTrue();
    }

    public void searchResultShouldContain(String searchKey) {
        assertThat($(TaskElements.SEARCH_RESULT(searchKey)).getText()).isEqualTo(searchKey);
    }

    public void editFormShouldBeDisplay() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.EDIT_FORM)));
        assertThat($(TaskElements.EDIT_FORM).isDisplayed()).isTrue();
    }

    public void deleteTaskShouldBeDisplay() {
        waitFor(ExpectedConditions.visibilityOf($(TaskElements.DELETE_TASK_POPUP)));
        assertThat($(TaskElements.DELETE_TASK_POPUP).isDisplayed()).isTrue();
    }

    public void selectedValueShouldBeCorrect(String name) {
        assertThat($(TaskElements.SELECTED_VALUE(name)).getText()).isEqualTo(name);
    }

    public void messageSuccessShouldBeDisplay() {
        assertThat($(TaskElements.MSG_SUCCESS).isDisplayed());
    }

    public void messageSuccessShouldContain(String msg) {
        assertThat($(TaskElements.MSG_SUCCESS).getAttribute("innerHTML")).isEqualTo(msg);
    }
}
