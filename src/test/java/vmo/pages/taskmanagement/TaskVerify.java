package vmo.pages.taskmanagement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import vmo.pages.login.LoginElements;

import static org.assertj.core.api.Assertions.assertThat;

public class TaskVerify extends UIInteractionSteps {
    public void verifyTextBoxSearchDisplay(){
        assertThat($(LoginElements.ACCOUT_TEXTBOX).isDisplayed()).isTrue();
        assertThat($(LoginElements.PASSWORD_TEXTBOX).isDisplayed()).isTrue();
    }

    public void verifyHomePage(){
        assertThat($(LoginElements.LOGOUT).isDisplayed()).isTrue();
    }
}
