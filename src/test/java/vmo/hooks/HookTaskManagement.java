package vmo.hooks;


import io.cucumber.java.Before;
import net.thucydides.core.annotations.Steps;
import vmo.openurl.NavigateTo;

public class HookTaskManagement {
    private static boolean beforeGroup = false;
    private static boolean beforeFeature = false;

    @Steps
    NavigateTo navigateTo;
    @Steps
    Login login;
    @Before(order = 0, value = "@taskManagement")
    public void login(){
        if (!beforeFeature) {
            navigateTo.openBrowser();
            login.loginSuccess();
            beforeFeature = true;
        }
    }

}
