package vmo.hooks;

import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;
import vmo.openurl.NavigateTo;
import vmo.pages.login.LoginAction;

public class Login {
    private static boolean beforeFeature = false;

    @Steps
    NavigateTo navigateTo;
    LoginAction loginAction;

    @Before(order = 0, value = "@login")
    public void openBrowser() {
        if (!beforeFeature) {
            navigateTo.openBrowser();
            beforeFeature = true;
        }
    }

    @Before(order = 1, value = "@taskManagement")
    public void loginSuccess() {
        if (!beforeFeature) {
            navigateTo.openBrowser();
            loginAction.sendAccountAndPassWord("superuser", "password");
            loginAction.clickButtonLogin();
            beforeFeature = true;
        }
    }
}