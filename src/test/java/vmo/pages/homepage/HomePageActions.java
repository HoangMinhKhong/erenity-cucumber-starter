package vmo.pages.homepage;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.steps.UIInteractions;
import net.thucydides.core.annotations.Step;

import static org.assertj.core.api.Assertions.assertThat;

public class HomePageActions extends UIInteractions {
    @Step("Open asset {0}")
    public void openAsset(String asset) {
        switch (asset) {
            case "Data Insight":
            case "Identity":
            case "Data Management":
                $(HomePageElements.asset(asset)).click();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + asset);
        }
    }
}
