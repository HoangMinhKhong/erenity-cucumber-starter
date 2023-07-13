package vmo.pages.login;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginVerify extends UIInteractionSteps {
    public void verifyTextBoxSearchDisplay() {
        assertThat($(LoginElements.ACCOUT_TEXTBOX).isDisplayed()).isTrue();
        assertThat($(LoginElements.PASSWORD_TEXTBOX).isDisplayed()).isTrue();
    }

    public void verifyHomePage() {
        Serenity.reportThat("User login success and stay at homepage",
                () -> assertThat($(LoginElements.LOGOUT).isDisplayed()).isTrue());
    }

    public void userStayAtLoginPage() {
        Serenity.reportThat("User stay at login page",
                () -> assertThat($(LoginElements.LOGO).isDisplayed()).isTrue());
    }
}
