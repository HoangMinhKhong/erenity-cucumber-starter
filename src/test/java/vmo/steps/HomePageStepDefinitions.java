package vmo.steps;

import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import vmo.pages.homepage.HomePageActions;
import vmo.pages.homepage.HomePageVerify;

public class HomePageStepDefinitions {
    @Steps
    HomePageActions homePageActions;
    HomePageVerify homePageVerify;
    @Given("Click on asset {}")
    public void clickOnAsset(String asset){
        homePageVerify.userStayAtHomePage();
        homePageActions.openAsset(asset);
    }
}
