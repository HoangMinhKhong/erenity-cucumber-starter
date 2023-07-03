package vmo.pages.search;

import net.serenitybdd.core.steps.UIInteractionSteps;
import static org.assertj.core.api.Assertions.assertThat;

public class searchVerify extends UIInteractionSteps {
    public void verifyTextBoxSearchDisplay(){
        assertThat($(searchElements.SEARCH_TEXTBOX).isDisplayed()).isTrue();
    }
}
