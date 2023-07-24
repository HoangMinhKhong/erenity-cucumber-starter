package vmo.openurl;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.webdriver.CloseBrowser;
import org.openqa.selenium.WebDriver;

public class NavigateTo {

    MyECHomePage myECHomePage;
    @Step("Open browser")
    public void openBrowser() {
        myECHomePage.open();
    }

//    public void openBrowser(String url) {
//        myECHomePage.openUrl(url);
//    }

    @Step("Close browser")
    public void closeBrowser(){
        myECHomePage.getDriver().close();
    }
}
