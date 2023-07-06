package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import vmo.helper.ElementHelper;

public class TaskElements extends PageObject{
    static ElementHelper elementHelper = new ElementHelper();
    public static By TASK_MANAGEMENT = By.xpath("//div/a[text()='Task Management']");
    public static By BUTTON_ADD = By.xpath("//button/span[text()='Add']");
    public static By MEETING_SEARCH = By.xpath("//div[@name='meeting']//input[@type='search']");
    public static By MEETING_MYEC = By.xpath("//div[@name='MyEC']");
    public static By TASK_NAME = By.xpath("//input[@name='taskName']");
    public static By PRIORITY = By.xpath("//*[@id='rc_select_1']");
    public static By PRIORITY_NORMAL = By.xpath("//div[@label='Normal']");
    public static By DUE_DATA = By.xpath("//div[@class='ant-picker-input']");
    public static By TODAY = By.xpath("//div[@class='ant-picker-footer']//a");
    public static By PIC = By.xpath("//div[@name='pic']");
    public static By PIC_USER = By.xpath("//div[@class='ant-select-item-option-content' and contains(text(), 'user 7')]");
    public static By LIST_PIC_ADD = By.xpath("//div[@id='rc_select_4_list']//ancestor::div//div[@class='rc-virtual-list-holder-inner']//div[@label]");
    public static By SELECTED_PIC = By.xpath("//div[@name='pic']//span[@class='ant-select-selection-item']");
    public static By PIC_LIST = By.xpath("//div[contains(@class,'ant-select-dropdown-placement-bottomLeft')]//div[@class='rc-virtual-list-holder-inner']//div[@label]");

    //common
    public static By TXT_SEARCH = By.xpath("//input[@placeholder='Search by PIC, Reporter, Meeting']");
    public static By BTN_SEARCH = By.xpath("//button//span[@class='anticon anticon-search']");

    public static String SEARCH_RESULT = "(//tbody[@class='ant-table-tbody']//td//div[text()='${name}'])[1]";
    public static By SEARCH_RESULT(String search){
        return elementHelper.getElementBy(search, SEARCH_RESULT);
    }

//    public static String ACTION_BTN = "//div[text()='${name}']//ancestor::tr[@data-row-key]//button['${name}']";
//    public static By ACTION_BTN(String value, String position){
//        By first = elementHelper.getElementBy(value, ACTION_BTN);
//        return elementHelper.getElementBy(position, first.toString());
//    }
    //edit locators
    public static String EDIT_BTN = "//div[text()='${name}']//ancestor::tr[@data-row-key]//button[1]";
    public static By EDIT_BTN(String search){
        String EDIT_BTN = "//div[text()='${name}']//ancestor::tr[@data-row-key]//button[1]";
        return elementHelper.getElementBy(search, EDIT_BTN);
    }
    public static By DELETE_TASK_POPUP = By.xpath("//div[@class='modal-confirm__title']");
    public static By DELETE_BTN(String search){
        String DELETE_BTN = "//div[text()='${name}']//ancestor::tr[@data-row-key]//button[2]";
        return elementHelper.getElementBy(search, DELETE_BTN);
    }
    public static By BTN_CONFIRM = By.xpath("//div[@class='ant-space-item']//button//span[text()='Confirm']");
    public static By EDIT_FORM = By.xpath("//div[@class='ant-modal-content']");
    public static By DDL_MEETING = By.xpath("//div[@name='meeting']");
    public static By TXT_TASK_NAME = By.xpath("//input[@name='taskName' and @label='Task name']");
    public static By DDL_PRIORITY = By.xpath("//div[@name='priority']");
    public static String SELECTED_VALUE = "//div[@name='priority']//span[@class='ant-select-selection-item' and @title='${name}']";
    public static By SELECTED_VALUE(String value){
        String SELECTED_VALUE = "//div[@name='priority']//span[@class='ant-select-selection-item' and @title='${name}']";
        return elementHelper.getElementBy(value, SELECTED_VALUE);
    }
    public static By DTP_DUE_DATE = By.xpath("//div[@class='ant-picker-input']");
    public static By IC_DELETE_DATE = By.xpath("//span[@class='anticon anticon-close-circle']");
    public static By DDL_PIC = By.xpath("//div[@name='pic']");
    public static By DDL_REPORTER = By.xpath("//div[@name='reporter']");
    public static By REPORTER = By.xpath("//div[@class='ant-select-item-option-content' and contains(text(), 'user 20')]");
    public static By USER = By.xpath("//div[text()=' user 10 ']");
    public static By DDL_STATUS = By.xpath("//div[@name='status']");
    public static By TXA_NOTE = By.xpath("//textarea[@name='note']");
    public static By BTN_CANCEL = By.xpath("//button[@type='button']//div[text()='Cancel']");
    public static By BTN_SAVE = By.xpath("//button[@type='submit']");
    public static By MSG_SUCCESS = By.xpath("//div[@class='ant-message-notice-content']//span[last()]");

    //delete
    public static By TASK_NAME_SEARCH = By.xpath("(//tbody[@class='ant-table-tbody']//div[@class='underline'])[1]");

}
