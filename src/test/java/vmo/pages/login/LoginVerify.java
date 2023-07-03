package vmo.pages.login;

import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.assertj.core.api.Assertions.assertThat;

public class LoginVerify extends UIInteractionSteps {
    public void verifyTextBoxSearchDisplay(){
        assertThat($(LoginElements.ACCOUT_TEXTBOX).isDisplayed()).isTrue();
        assertThat($(LoginElements.PASSWORD_TEXTBOX).isDisplayed()).isTrue();
    }

    public void verifyHomePage(){
        assertThat($(LoginElements.LOGOUT).isDisplayed()).isTrue();
    }
}
