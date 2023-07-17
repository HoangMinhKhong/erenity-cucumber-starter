package vmo.pages.asset;

import org.openqa.selenium.By;

public class AssetElements {
    static By FIRST_ASSET = By.xpath("((//div[@role='tree'])[last()]//span[@class='ant-tree-title'])[2]");

    //Add Asset
    static By DIALOG_ADD_ASSET = By.xpath("//div[@class='p-dialog p-component add-asset-dialog p-dialog-enter-done']");
    static By PARENT = By.xpath("//input[@placeholder='Parent']");
    static By DIALOG_SELECT_SOURCE = By.xpath("//div[@class='p-dialog p-component custom-dialog p-dialog-enter-done']");
    static By SOURCE_NO_PARENT = By.xpath("//span[@title='No Parent Asset']");
    static By IP_NAME = By.xpath("//input[@placeholder='Name']");
    static By TOAST_MESSAGE = By.xpath("//div[@class='ahi-toast-message__content']");

    static By BTN_CUSTOM_ASSET(String button) {
        return By.xpath("//button[@class='p-button p-component custom-btn-asset' and text()='" + button + "']");
    }

    static By BTN_CONFIRM_SELECT_SOURCE(String button) {
        return By.xpath("//span[@class='p-button-label p-c' and text()='" + button + "']");
    }

    static By BTN_ADD_ASSET(String button) {
        return By.xpath("//div[@class='sc-gFqAkR cFSnbs']//button[text()='" + button + "']");
    }
}
