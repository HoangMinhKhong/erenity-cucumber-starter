package vmo.pages.login;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginElements extends PageObject{
    public static By ACCOUT_TEXTBOX = By.xpath("//input[@name='accountName']");
    public static By PASSWORD_TEXTBOX = By.xpath("//input[@name='password']");
    public static By BUTTON_LOGIN = By.xpath("//button[@type='submit']");
    public static By LOGOUT = By.xpath("//div[text()='Log out']");
}
