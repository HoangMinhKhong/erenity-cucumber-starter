package vmo.pages.taskmanagement;

import net.serenitybdd.core.steps.UIInteractionSteps;
import vmo.pages.login.LoginElements;

public class taskAction extends UIInteractionSteps {

    public void sendAccountAndPassWord(String account, String password){
        $(LoginElements.ACCOUT_TEXTBOX).sendKeys(account);
        $(LoginElements.PASSWORD_TEXTBOX).sendKeys(password);
    }

    public void clickButtonLogin(){
        $(LoginElements.BUTTON_LOGIN).click();
    }

}
