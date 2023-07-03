package vmo.pages.search;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class searchElements extends PageObject{
    public static By SEARCH_TEXTBOX = By.xpath("//input[@id='searchInput']");
    public static By BUTTON_SEARCH = By.xpath("//i[text()='Search']");
}
