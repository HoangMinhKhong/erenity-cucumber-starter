package vmo.pages.taskmanagement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import vmo.helper.ElementHelper;
import vmo.pages.login.LoginElements;

import static org.assertj.core.api.Assertions.assertThat;

public class taskVerify extends UIInteractionSteps {
    ElementHelper elementHelper = new ElementHelper();

    public void verifyTextBoxSearchDisplay() {
        assertThat($(LoginElements.ACCOUT_TEXTBOX).isDisplayed()).isTrue();
        assertThat($(LoginElements.PASSWORD_TEXTBOX).isDisplayed()).isTrue();
    }

    public void verifyHomePage() {
        assertThat($(LoginElements.LOGOUT).isDisplayed()).isTrue();
    }

    public void searchResultShouldContain(String searchKey){
        By result = elementHelper.getElementBy(searchKey, $(taskElements.SEARCH_RESULT));
        assertThat($(result).getText()).isEqualTo(searchKey);
    }

    public void editFormShouldBeDisplay() {
        assertThat($(taskElements.EDIT_FORM).isDisplayed()).isTrue();
    }

    public void selectedValueShouldBeCorrect(String name) {
        By selected = elementHelper.getElementBy(name, $(taskElements.SELECTED_VALUE));
        assertThat($(selected).getText()).isEqualTo(name);
    }

    public void messageSuccessShouldBeDisplay() {
        assertThat($(taskElements.MSG_SUCCESS).isDisplayed()).isTrue();
    }

    public void messageSuccessShouldContain(String msg) {
        assertThat($(taskElements.MSG_SUCCESS).getText()).isEqualTo(msg);
    }
}
