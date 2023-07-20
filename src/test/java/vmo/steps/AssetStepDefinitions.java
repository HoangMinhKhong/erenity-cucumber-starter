package vmo.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import vmo.pages.asset.AssetActions;
import vmo.pages.asset.AssetVerify;
import vmo.pages.common.CommonActions;

public class AssetStepDefinitions {
    @Steps
    AssetActions assetActions;
    AssetVerify assetVerify;
    LeftMenuStepDefinition leftMenuStepDefinition;

    @And("User right click on a asset")
    public void userRightClick() {
        assetActions.openAssetListActions();
    }

    @And("User click on asset")
    public void clickOnAsset(){
        assetActions.clickOnAsset("Asset_name");
    }

    @Then("User select {string}")
    public void addAssetPopupAppear(String act) {
        assetActions.selectAct(act);
    }

    @And("User input data to add asset")
    public void userInputDataToAddAsset() {
        assetActions.inputData();
    }

    @When("User click Add")
    public void userClickAdd() {
        assetActions.clickAdd();
    }

    @Then("Success message should be {string}")
    public void successMessageShouldBe(String message) {
        assetVerify.messageShouldBe(message);
    }

    @And("User go to Activity Log screen")
    public void userGoToActivityLogScreen() {
        leftMenuStepDefinition.goToActivityLog();
    }

    @Then("User can see new log with correct data")
    public void userCanSeeNewLogWithCorrectData(DataTable dataTable) {
        assetVerify.activityLogShouldBeDisplay(dataTable);
    }

    @And("User delete newly created data")
    public void delete(){
        assetActions.delete();
    }

    @And("User add resource {string}")
    public void userAddResource(String resource) {
        assetActions.addResource(resource);
    }

    @And("User Add entity {string}")
    public void userAddEntity(String identity) {
        assetActions.addIdentity(identity);
    }

    @When("User click save")
    public void userClickSave() {
        assetActions.clickSave();
    }

    @Then("Parent name is asset which is selected")
    public void parentNameShouldBeCorrect(){
        assetVerify.parentFieldValueShouldBeCorrect();
    }
}
