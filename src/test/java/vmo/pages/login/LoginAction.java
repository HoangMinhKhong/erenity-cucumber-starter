package vmo.pages.login;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;

public class LoginAction extends UIInteractionSteps {

    public void sendAccountAndPassWord(String account, String password){
        $(LoginElements.ACCOUT_TEXTBOX).sendKeys(account);
        $(LoginElements.PASSWORD_TEXTBOX).sendKeys(password);
    }

    public void clickButtonLogin(){
        $(LoginElements.BUTTON_LOGIN).click();
    }

    @Step("Enter credential")
    public void enterCredential(String username, String pwd){
        $(LoginElements.IP_USERNAME).sendKeys(username);
        $(LoginElements.IP_PASSWORD).sendKeys(pwd);
    }

    @Step("Click sign in button")
    public void clickSignIn(){
        $(LoginElements.BTN_SIGN_IN).click();
    }

}
