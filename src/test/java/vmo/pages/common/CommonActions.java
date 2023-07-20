package vmo.pages.common;

import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.Keys;
import vmo.helper.ElementHelper;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonActions extends UIInteractionSteps {
    ElementHelper helper;

    public void search(String searchKey) {
        helper.inputText($(CommonElements.IP_SEARCH), searchKey);
        $(CommonElements.IP_SEARCH).type(Keys.ENTER);
        assertThat($(CommonElements.SEARCH_RESULT).getText().trim()).isEqualTo(searchKey);
    }
}
