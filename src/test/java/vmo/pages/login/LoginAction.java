package vmo.pages.login;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginAction extends UIInteractionSteps {

    public void sendAccountAndPassWord(String account, String password){
        $(LoginElements.ACCOUT_TEXTBOX).sendKeys(account);
        $(LoginElements.PASSWORD_TEXTBOX).sendKeys(password);
    }

    public void clickButtonLogin(){
        $(LoginElements.BUTTON_LOGIN).click();
    }

}
