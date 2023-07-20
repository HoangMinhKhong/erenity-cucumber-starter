package vmo.pages.asset;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.AggregatedAsserts;
import vmo.helper.ElementHelper;
import vmo.pages.common.CommonActions;
import vmo.pages.common.CommonElements;

import static org.assertj.core.api.Assertions.assertThat;

public class AssetVerify extends UIInteractionSteps {
    ElementHelper helper;
    AggregatedAsserts asserts;
    CommonActions actions;

    @Step("Message should be {0}")
    public void messageShouldBe(String actual) {
        String expected = helper.getText($(AssetElements.TOAST_MESSAGE));
        helper.validateMessage(expected, actual);
    }

    public void activityLogShouldBeDisplay(DataTable table) {
        String searchKey = helper.getSession("Asset_name");
        actions.search(searchKey);
        Boolean notPresent = ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated($(CommonElements.TR_NO_DATA))).apply(getDriver());
        asserts.assertTrue("Verify search found", Boolean.TRUE.equals(notPresent));
        helper.validateDataInTableShortVersion(table, $(CommonElements.TBL_ACTIVITY_LOG));
    }

    public void resourceShouldBeDisplay(String resource) {
        Serenity.reportThat("Add resource success!",
                () -> assertThat($(AssetElements.SPAN_RESOURCE(resource)).isDisplayed()).isTrue());
    }

    public void parentFieldValueShouldBeCorrect() {
        String asset = helper.getSession("Asset_name");
        Serenity.reportThat("Parent name is asset which is selected by user!",
                () -> assertThat($(AssetElements.PARENT).getAttribute("value").equalsIgnoreCase(asset)).isTrue());
    }
}
