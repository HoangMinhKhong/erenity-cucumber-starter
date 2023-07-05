package vmo.hooks;


import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.environment.SystemEnvironmentVariables;
import net.thucydides.core.util.EnvironmentVariables;
import vmo.openurl.NavigateTo;

public class HookTaskManagement {
    private static boolean beforeGroup = false;
    private static boolean beforeFeature = false;

    @Steps
    NavigateTo navigateTo;
    @Steps
    Login login;

    @Before()
    public void login() {
        if (!beforeFeature) {
            navigateTo.openBrowser();
            login.loginSuccess();
            beforeFeature = true;
        }
//        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
//        String url =  EnvironmentSpecificConfiguration.from(variables)
//                .getProperty("webdriver.base.url");
//        navigateTo.openBrowser(url);
//        login.loginSuccess();
    }

//    @After
//    public void afterScenario() {
//        navigateTo.closeBrowser();
//    }
}
