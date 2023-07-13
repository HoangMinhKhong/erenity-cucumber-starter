package vmo.pages.leftmenu;

import org.openqa.selenium.By;

public class LeftMenuElements {
    static By AHI_MAIN = By.xpath("//div[@class='sc-dLMFU gzGUJr']");
    static By QC_CHECK = By.xpath("(//div[@class='sc-dLMFU eKursX'])[1]");
    static By SOPHIA_NEW_PROJECT = By.xpath("(//div[@class='sc-dLMFU eKursX'])[2]");
    static By SOPHIA_RETRIEVE = By.xpath("//div[@class='sc-dLMFU kffGpp']");
    static By NEW_PROJECT_22 = By.xpath("//div[@class='sc-dLMFU cwnGL']");

    static By MENU(String menu) {
        return By.xpath("//span[text()='" + menu + "']");
    }

    static By SUB_MENU(String submenu) {
        return By.xpath("//li[@role='menuitem']//span[text()='" + submenu + "']");
    }

    static By LBL_HEADER = By.xpath("//span[@class='sc-dhKdcB hsmrjA header-logo-title']");
}
