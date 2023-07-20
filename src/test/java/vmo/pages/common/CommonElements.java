package vmo.pages.common;

import org.openqa.selenium.By;

public class CommonElements {
    public static By IP_SEARCH = By.xpath("//input[@class='ant-input']");
    public static By SEARCH_RESULT = By.xpath("//span[@class='tree-search-match-item']");
    public static By TBL_ACTIVITY_LOG = By.xpath("//table[@class='p-datatable-table']");
    public static By TR_NO_DATA = By.xpath("//tr[@class='p-datatable-emptymessage']");

    public static By BTN_ACTIONS(String button) {
        return By.xpath("//button//span[text()='" + button + "']");
    }
}
