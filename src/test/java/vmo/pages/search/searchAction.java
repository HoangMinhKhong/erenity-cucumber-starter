package vmo.pages.search;

import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Steps;

public class searchAction extends UIInteractionSteps {

    public void enterText(String textSearch){
        $(searchElements.SEARCH_TEXTBOX).sendKeys(textSearch);
    }

    public void clickSearch(){
        $(searchElements.BUTTON_SEARCH).click();
    }

}
