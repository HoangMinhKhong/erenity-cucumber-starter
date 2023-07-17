package vmo.pages.common;

import org.openqa.selenium.By;

public class CommonElements {
    public static By IP_SEARCH = By.xpath("//input[@class='ant-input']");
    public static By TBL_ACTIVITY_LOG = By.xpath("//table[@class='p-datatable-table']");

    public static By BTN_ACTIONS(String button) {
        return By.xpath("//button//span[text()='" + button + "']");
    }
}
