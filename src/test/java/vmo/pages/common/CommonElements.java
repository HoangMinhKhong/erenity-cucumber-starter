package vmo.pages.common;

import org.openqa.selenium.By;

public class CommonElements {
    static By IP_SEARCH = By.xpath("//input[@class='ant-input']");
    static By BTN_REFRESH = By.xpath("//button//span[text()='Refresh']");
    static By BTN_FILTER = By.xpath("//button//span[text()='Filter']");
    static By BTN_ADD = By.xpath("//button//span[text()='Add']");

    public By BTN_ACTIONS(String button) {
        return By.xpath("//button//span[text()='" + button + "']");
    }
}
