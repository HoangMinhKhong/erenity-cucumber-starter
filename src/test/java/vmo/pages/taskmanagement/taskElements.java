package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TaskElements extends PageObject{
    public static By TASK_MANAGEMENT = By.xpath("//div/a[text()='Task Management']");
    public static By BUTTON_ADD = By.xpath("//button/span[text()='Add']");
    public static By MEETING_SEARCH = By.xpath("//span[text()='Search']");
    public static By MEETING_MYEC = By.xpath("//div[text()='MyEC']");
    public static By TASK_NAME = By.xpath("//input[@name='taskName']");
    public static By PRIORITY = By.xpath("//*[@id='rc_select_1']");
    public static By PRIORITY_NORMAL = By.xpath("//*[@id='rc_select_1']");
    public static By DUE_DATA = By.xpath("//div[@class='ant-picker-input']");
    public static By TODAY = By.xpath("//div[@class='ant-picker-footer']//a");
    public static By PIC = By.xpath("//div[@name='pic']");
    public static By PIC_USER = By.xpath("//div[text()=' user 15 ']");

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
