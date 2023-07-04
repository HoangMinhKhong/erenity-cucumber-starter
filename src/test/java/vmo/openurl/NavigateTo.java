package vmo.openurl;

import net.thucydides.core.annotations.Step;

public class NavigateTo {
    MyECHomePage myECHomePage;
    @Step("Open browser")
    public void openBrowser(){
        myECHomePage.open();
    }

    @Step("Close browser")
    public void closeBrowser(){
        myECHomePage.getDriver().close();
    }
}
