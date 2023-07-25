package vmo.pages.login;

import vmo.helper.ElementHelper;

import static vmo.pages.login.LoginElements.*;

public class LoginAction extends ElementHelper {

    public void sendAccountAndPassWord(String account, String password){
        sendKeyToElement(ACCOUT_TEXTBOX,account);
        sendKeyToElement(PASSWORD_TEXTBOX,password);
    }

    public void clickButtonLogin(){
        clickToElement(BUTTON_LOGIN);
    }

}
