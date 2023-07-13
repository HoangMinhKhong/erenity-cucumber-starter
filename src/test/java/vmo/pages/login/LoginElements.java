package vmo.pages.login;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class LoginElements{
    public static By ACCOUT_TEXTBOX = By.xpath("//input[@name='accountName']");
    public static By PASSWORD_TEXTBOX = By.xpath("//input[@name='password']");
    public static By BUTTON_LOGIN = By.xpath("//button[@type='submit']");
    public static By LOGOUT = By.xpath("//div[text()='Log out']");
    //yokogawa
    static By IP_USERNAME = By.id("user_email");
    static By IP_PASSWORD = By.id("Password");
    static By BTN_SIGN_IN = By.xpath("//input[@value='Sign in']");
    static By LOGO = By.xpath("//div[@class='tenant']");
    static By CHK_REMEMBER = By.id("remember_me");
    static By LNK_FORGOT_PASSWORD = By.xpath("//div[@class='col-6 mb-3 text-end']//a");

}
