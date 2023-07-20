package vmo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import vmo.pages.leftmenu.LeftMenuActions;

public class LeftMenuStepDefinition {
    @Steps
    LeftMenuActions leftMenuActions;

    @Given("^User click on project (.*)$")
    public void clickOnAsset(String project){
        leftMenuActions.openProject(project);
    }

    @When("User follow path to access screen")
    public void accessPage(DataTable dataTable){
        leftMenuActions.navigateToScreen(dataTable);
    }

    @And("User access Activity Log screen")
    public void goToActivityLog(){
        leftMenuActions.navigateToActivityLogScreen();
    }

}
