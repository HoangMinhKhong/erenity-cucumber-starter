package vmo.pages.leftmenu;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import vmo.helper.ElementHelper;
import vmo.pages.common.CommonElements;

import java.util.List;

public class LeftMenuActions extends UIInteractionSteps {
    ElementHelper helper;
    @Step("Open project {0}")
    public void openProject(String project) {
        helper.switchToNewOpenBrowser();
        switch (project) {
            case "AHI Main":
                $(LeftMenuElements.AHI_MAIN).click();
                break;
            case "QC check1":
                $(LeftMenuElements.QC_CHECK).click();
                break;
            case "Sophia new project":
                $(LeftMenuElements.SOPHIA_NEW_PROJECT).click();
                break;
            case "Sophia retrieve":
                $(LeftMenuElements.SOPHIA_RETRIEVE).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + project);
        }
    }

    @Step("Navigate to screen")
    public void navigateToScreen(DataTable dataTable){
        List<List<String>> menu = dataTable.asLists(String.class);
        for (List<String> data: menu){
            WebElement webElement = $(LeftMenuElements.MENU(data.get(0))).getElement();
            helper.clickByJS(webElement);
            waitFor(ExpectedConditions.visibilityOf($(CommonElements.IP_SEARCH)));
        }
    }

    @Step("Navigate to Activity Log screen")
    public void navigateToActivityLogScreen(){
        waitFor(ExpectedConditions.visibilityOf($(LeftMenuElements.MENU_ACTIVITY_LOG)));
        $(LeftMenuElements.MENU_ACTIVITY_LOG).click();
        waitFor(ExpectedConditions.visibilityOf($(LeftMenuElements.SUBMENU_ACTIVITY_LOG)));
        $(LeftMenuElements.SUBMENU_ACTIVITY_LOG).click();
        waitFor(ExpectedConditions.visibilityOf($(CommonElements.IP_SEARCH)));
    }
}
