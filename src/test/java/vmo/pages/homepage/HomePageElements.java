package vmo.pages.homepage;

import org.openqa.selenium.By;

public class HomePageElements {
    static By LBL_APP_HEADER = By.xpath("//div[@class='logo ']//div");
    static By asset(String asset) {
        return By.xpath("//div[text()='" + asset + "']");
    }
    static By LBL_PROJECT_HEADER = By.xpath("//span[@class='sc-dhKdcB hsmrjA header-logo-title']");

//    static final Target test = Target.the("test").located(By.xpath("asda"));
}
