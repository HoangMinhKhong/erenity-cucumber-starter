package vmo.pages.homepage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import vmo.helper.ElementHelper;
import vmo.helper.LogHelper;
import vmo.pages.taskmanagement.TaskElements;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageVerify extends UIInteractions {
    private static final Logger LOGGER = LogHelper.getLogger();
    ElementHelper helper = new ElementHelper();
    public void userStayAtHomePage() {
        LOGGER.debug("Verifying user is in homepage");
        waitFor(ExpectedConditions.visibilityOf($(HomePageElements.LBL_APP_HEADER)));
        Serenity.reportThat("User stay at home page",
                () -> assertThat($(HomePageElements.LBL_APP_HEADER).getText()).isEqualTo(("Asset Health 11")));
        String header = helper.getTextJS(HomePageElements.LBL_APP_HEADER);
        Serenity.recordReportData().withTitle("Header").andContents("header: " + header);
        Serenity.recordReportData().asEvidence().withTitle("Header2").andContents("header2: " + header);
        LOGGER.info("User is in homepage");
    }
}
