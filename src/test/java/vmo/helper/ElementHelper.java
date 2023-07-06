package vmo.helper;


import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Console;
import java.util.*;

public class ElementHelper extends UIInteractionSteps {
    private static final Logger LOGGER = LoggerFactory.getLogger(ElementHelper.class);

    public By getElementBy(String name, String tempXpath) {
        String actualXpath = tempXpath.replace("${name}", name);
        return By.xpath(actualXpath);
    }

    public boolean element_is_exist(By element) {
        return getDriver().findElements(element).size() > 0 && $(element).isVisible();
    }

    public boolean verify_more_element_than_one(By element) {
        return getDriver().findElements(element).size() > 1;
    }

    public List<WebElement> getListElement(By element) {
        return getDriver().findElements(element);
    }

    public WebElement get_last_element_of_list(By element) {
        List<WebElement> list_element = getDriver().findElements(element);
        System.out.println("list size: " + list_element.size());
        return $(list_element.get(list_element.size() - 1));
    }

    //Get list of value from list of element
    public List<String> getValueListByElement(By element, String attribute) {
        List<String> valueList = new ArrayList<>();
        List<WebElement> listElement = getDriver().findElements(element);
        System.out.println("Size of element:" + listElement.size());
        System.out.println("Element is:" + element);

        for (WebElement e : listElement) {
            String value;
            if (attribute.equals("textContent")) {
                value = e.getText();

            } else {
                value = e.getAttribute(attribute);
            }
            valueList.add(value);
        }
        System.out.println("Size of list:" + valueList.size());
        System.out.println("List:" + valueList);
        return valueList;
    }

    public int getSizeOfListElement(By element) {
        List<WebElement> listElement = getDriver().findElements(element);
        return listElement.size();
    }

    public Map get_map_from_list_of_element(By element, String attribute) {
        Map map = new HashMap();

        List<WebElement> elements = getDriver().findElements(element);
        for (WebElement e : elements) {
            String key1 = e.getText();
            String key2 = e.getAttribute(attribute);
            map.put(key1, key2);
        }
        return map;
    }

    public boolean checkElementPresent(By e) {
        Boolean present;
        List<WebElement> elementList = getDriver().findElements(e);
        if (elementList.size() >= 1) {
            present = true;
        } else
            present = false;
        return present;
    }

    public void selectRandomValue(By element) {
        Select dropdown = new Select(getDriver().findElement(element));
        List<WebElement> options = dropdown.getOptions();
        int randomIndex = new Random().nextInt(options.size());
        dropdown.selectByIndex(randomIndex);
    }

    public void selectByLabel(WebElementFacade element, String label) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(label);
    }

    public void delayInSeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clearText(WebElementFacade webElementFacade) {
        webElementFacade.sendKeys(Keys.CONTROL + "a");
        webElementFacade.sendKeys(Keys.DELETE);
    }

    public String randomString(int length) {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characters.length());
            char randomChar = characters.charAt(index);
            stringBuilder.append(randomChar);
        }
        return stringBuilder.toString();
    }


    public String getSession(String session) {
        String value = Serenity.sessionVariableCalled(session);
        LOGGER.info("Value session is : " + value);
        return value;
    }

    public void clickByJS(WebElement webElement){
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", webElement);
    }

}

