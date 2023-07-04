package vmo.pages.taskmanagement;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class TaskElements extends PageObject{
    public static By TASK_MANAGEMENT = By.xpath("//div/a[text()='Task Management']");
    public static By BUTTON_ADD = By.xpath("//button/span[text()='Add']");
    public static By MEETING_SEARCH = By.xpath("//div[@name='meeting']/div/span/input");
    public static By MEETING_MYEC = By.xpath(" //div[@name='hehe']//div[text()='hehe']");
    public static By TASK_NAME = By.xpath("//input[@name='taskName']");
    public static By PRIORITY = By.xpath(" //div[@name='priority']");
    public static By PRIORITY_NORMAL = By.xpath("//div[@label='Normal']");
    public static By DUE_DATA = By.xpath("//div[@class='ant-picker-input']");
    public static By TODAY = By.xpath("//div[@class='ant-picker-footer']//a");
    public static By PIC = By.xpath("//div[@name='pic']");
    public static By PIC_USER = By.xpath("//div[text()=' user 15 ']");

}
