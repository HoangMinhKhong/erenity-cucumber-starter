package vmo.openurl;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class NavigateTo {
    WikipediaHomePage wikipediaHomePage;
    @Step("Open home page")
    public void open_home_page(){
        wikipediaHomePage.open() ;
    }
}
