package vmo.pages.asset;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import vmo.helper.ElementHelper;
import vmo.pages.common.CommonElements;

public class AssetVerify extends UIInteractionSteps {
    private ElementHelper helper = new ElementHelper();
    @Step("Message should be {0}")
    public void messageShouldBe(String actual){
        String expected = helper.getText($(AssetElements.TOAST_MESSAGE));
        helper.validateMessage(expected, actual);
    }

    public void activityLogShouldBeDisplay(DataTable table){
        String searchKey = helper.getSession("name");
        helper.inputText($(CommonElements.IP_SEARCH), searchKey);
        helper.validateDataInTableShortVersion(table, $(CommonElements.TBL_ACTIVITY_LOG));
    }
}
