package vmo.pages.asset;

import org.openqa.selenium.By;

public class AssetElements {
    //Add Asset
    public static By DIALOG = By.xpath("//div[@role='dialog' and contains(@class,'p-dialog p-component')]");
    static By FIRST_ASSET = By.xpath("((//div[@role='tree'])[last()]//span[@class='ant-tree-title'])[2]");
    static By POPUP_ASSET_ACTION = By.xpath("//div[contains(@class,'p-contextmenu-enter-done')]");
    static By PARENT = By.xpath("//input[@placeholder='Parent']");
    static By DIALOG_SELECT_SOURCE = By.xpath("//div[@class='p-dialog p-component custom-dialog p-dialog-enter-done']");
    static By SOURCE_NO_PARENT = By.xpath("//span[@title='No Parent Asset']");
    static By IP_NAME = By.xpath("//input[@placeholder='Name']");
    static By TOAST_MESSAGE = By.xpath("//div[@class='ahi-toast-message__content']");
    static By POPUP_ADD_IDENTITY = By.xpath("//div[@class='base-drawer-title' and text()='Add Identity']");
    static By DDL_IDENTITY_TYPE = By.xpath("//label[text()='Identity Type']//following-sibling::span//input");
    static By DDL_IDENTITY = By.xpath("//label[text()='Identity']//following-sibling::span//input");
    static By IDENTITY_SEARCH_RESULT = By.xpath("//div[@class='ant-select-item-option-content']");
    static By BTN_ADD_IDENTITY = By.xpath("//button[@class='p-button p-component base-button save-type']");
    static By BTN_CANCEL_IDENTITY = By.xpath("//button[@class='p-button p-component base-button p-button-outlined cancel-type']");

    static By SPAN_RESOURCE(String sourceName) {
        return By.xpath("//span[text()='Resource']//following-sibling::span[text()='" + sourceName + "']");
    }

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
