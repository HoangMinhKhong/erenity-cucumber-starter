package vmo.pages.asset;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.ElementHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class AssetActions extends UIInteractionSteps {
    ElementHelper helper;

    @Step("Create asset")
    public void createAsset() {
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.FIRST_ASSET)));
        helper.rightClick(AssetElements.FIRST_ASSET);
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.BTN_CUSTOM_ASSET("Add New"))));
        helper.click($(AssetElements.BTN_CUSTOM_ASSET("Add new")));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.DIALOG_ADD_ASSET)));
        helper.click($(AssetElements.IP_NAME));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.DIALOG_SELECT_SOURCE)));
        helper.clickByJS(AssetElements.SOURCE_NO_PARENT);
        helper.click(AssetElements.BTN_CONFIRM_SELECT_SOURCE("OK"));
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.IP_NAME)));
        String name = helper.randomString(9);
        helper.inputText(AssetElements.IP_NAME, name);
        Serenity.setSessionVariable("Asset_name").to(name);
        waitFor(ExpectedConditions.visibilityOf($(AssetElements.BTN_ADD_ASSET("Add"))));
        helper.click(AssetElements.BTN_ADD_ASSET("Add"));
        Serenity.reportThat("Success message has displayed",
                () -> assertThat($(AssetElements.TOAST_MESSAGE).isDisplayed()).isTrue());
    }
}
