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

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.activation.DataSource;

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
    }
}
