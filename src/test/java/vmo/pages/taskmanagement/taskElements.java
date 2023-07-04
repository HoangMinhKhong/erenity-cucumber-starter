package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import vmo.helper.ElementHelper;

public class taskElements extends PageObject{
    ElementHelper helper = new ElementHelper();
    public static By ACCOUT_TEXTBOX = By.xpath("//input[@name='accountName']");
    public static By PASSWORD_TEXTBOX = By.xpath("//input[@name='password']");
    public static By BUTTON_LOGIN = By.xpath("//button[@type='submit']");
    public static By LOGOUT = By.xpath("//div[text()='Log out']");

    //common
    public static By TXT_SEARCH = By.xpath("//input[@placeholder='Search by PIC, Reporter, Meeting']");
    public static By BTN_SEARCH = By.xpath("//button//span[@class='anticon anticon-search']");
    public static By SEARCH_RESULT = By.xpath("//tbody[@class='ant-table-tbody']//td//div[text()='${name}']");

    //edit locators
    public static String EDIT_BTN = "//div[text()='${name}']//ancestor::tr[@data-row-key]//button[1]";
    public static By EDIT_FORM = By.xpath("//div[@class='ant-modal-content']");
    public static By DDL_MEETING = By.xpath("//div[@name='meeting']");
    public static By TXT_TASK_NAME = By.xpath("//input[@name='taskName' and @label='Task name']");
    public static By DDL_PRIORITY = By.xpath("//div[@name='priority']");
    public static String SELECTED_VALUE = "//div[@name='priority']//span[@class='ant-select-selection-item' and @title='${name}']";
    public static By DTP_DUE_DATE = By.xpath("//div[@class='ant-picker-input']");
    public static By DDL_PIC = By.xpath("//div[@name='pic']");
    public static By DDL_REPORTER = By.xpath("//div[@name='reporter']");
    public static By DDL_STATUS = By.xpath("//div[@name='status']");
    public static By TXA_NOTE = By.xpath("//textarea[@name='note']");
    public static By BTN_CANCEL = By.xpath("//button[@type='button']//div[text()='Cancel']");
    public static By BTN_SAVE = By.xpath("//button[@type='submit']");
    public static By MSG_SUCCESS = By.xpath("//div[@class='ant-message-notice-content']//span[last()]");
}
