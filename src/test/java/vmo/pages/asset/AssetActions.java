package vmo.pages.asset;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.ElementHelper;
import vmo.pages.common.CommonActions;
import vmo.pages.common.CommonElements;

import static org.assertj.core.api.Assertions.assertThat;

public class AssetActions extends UIInteractionSteps {
    ElementHelper helper;
    CommonActions actions;

    @Step("Open list actions of asset")
    public void openAssetListActions() {
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.FIRST_ASSET)));
        helper.rightClick(AssetElements.FIRST_ASSET);
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.POPUP_ASSET_ACTION)));
    }

    @Step("Click action {0}")
    public void selectAct(String act) {
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.BTN_CUSTOM_ASSET(act))));
        helper.click($(AssetElements.BTN_CUSTOM_ASSET(act)));
//        waitFor(ExpectedConditions.visibilityOf($(AssetElements.DIALOG_ADD_ASSET)));
    }

    @Step
    public void inputData() {
        helper.click($(AssetElements.PARENT));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.DIALOG_SELECT_SOURCE)));
        helper.clickByJS(AssetElements.SOURCE_NO_PARENT);
        helper.click(AssetElements.BTN_CONFIRM_SELECT_SOURCE("OK"));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.IP_NAME)));
        String name = helper.randomString(9);
        helper.inputText(AssetElements.IP_NAME, name);
        Serenity.setSessionVariable("Asset_name").to(name);
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.BTN_ADD_ASSET("Add"))));
    }

    @Step
    public void clickAdd() {
        helper.click(AssetElements.BTN_ADD_ASSET("Add"));
        Serenity.reportThat("Success message has displayed",
                () -> assertThat($(AssetElements.TOAST_MESSAGE).isDisplayed()).isTrue());
    }

    public void delete() {
        openAssetListActions();
        selectAct("Delete Asset");
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.DIALOG)));
        helper.click($(AssetElements.BTN_CONFIRM_SELECT_SOURCE("Yes")));
    }

    public void addResource(String sourceName){
        openAssetListActions();
        selectAct("Access Control");
        waitFor(ExpectedConditions.visibilityOf($(CommonElements.BTN_ACTIONS("Add Resource"))));
        helper.click($(CommonElements.BTN_ACTIONS("Add Resource")));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.DIALOG_SELECT_SOURCE)));
        actions.search(sourceName);
        helper.clickByJS(CommonElements.SEARCH_RESULT);
        helper.click(AssetElements.BTN_CONFIRM_SELECT_SOURCE("OK"));
    }

    public void addIdentity(String identity){
        helper.click($(CommonElements.BTN_ACTIONS("Add Identity")));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.POPUP_ADD_IDENTITY)));
        helper.click($(AssetElements.DDL_IDENTITY));
        helper.inputText($(AssetElements.DDL_IDENTITY), identity);
        assertThat($(AssetElements.IDENTITY_SEARCH_RESULT).getText().trim().equalsIgnoreCase(identity)).isTrue();
        helper.click($(AssetElements.IDENTITY_SEARCH_RESULT));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.BTN_ADD_IDENTITY)));
        helper.click($(AssetElements.BTN_ADD_IDENTITY));
    }

    public void clickSave(){
        helper.click($(AssetElements.BTN_CONFIRM_SELECT_SOURCE("Save")));
        Serenity.reportThat("Success message has displayed",
                () -> assertThat($(AssetElements.TOAST_MESSAGE).isDisplayed()).isTrue());
    }

    public void clickOnAsset(String session){
        String searchKey = helper.getSession(session);
        actions.search(searchKey);
        helper.click($(AssetElements.FIRST_ASSET));
    }
}
