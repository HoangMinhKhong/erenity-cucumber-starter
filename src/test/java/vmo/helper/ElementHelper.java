package vmo.helper;


import net.serenitybdd.core.steps.UIInteractionSteps;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ElementHelper extends UIInteractionSteps {

    public static By getElementBy(String name, String tempXpath) {
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
        System.out.println("Element is:"+element);

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

    public int getSizeOfListElement(By element){
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

   public boolean checkElementPresent(By e){
        Boolean present;
        List<WebElement> elementList= getDriver().findElements(e);
        if(elementList.size()>=1){
            present = true;
        }
        else
            present = false;
        return  present;
   }
}
