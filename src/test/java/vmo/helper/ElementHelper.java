package vmo.helper;


import io.cucumber.datatable.DataTable;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;

import java.text.MessageFormat;
import java.util.*;

public class ElementHelper extends UIInteractionSteps {
    private static final Logger logger = LogHelper.getLogger();
    private AggregatedAsserts asserts = new AggregatedAsserts();

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
        logger.info("Value session is : " + value);
        return value;
    }

    public void click(By locator) {
        try {
            logger.debug("Click on element...");
            WebElement webElement = getDriver().findElement(locator);
            webElement.click();
            logger.info("User has User has already clicked on element");
        } catch (Exception e) {
            logger.error(MessageFormat.format("User cannot click on element because {0}", e.getMessage()));
        }
    }

    public void clickByJS(WebElement webElement) {
        try {
            logger.debug(MessageFormat.format("Click on web element {0}", webElement));
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", webElement);
            logger.info("User has already click on element");
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot click element because {0}", e.getMessage()));
        }
    }

    public void clickByJS(By locator) {
        try {
            logger.debug(MessageFormat.format("Click on web element {0}", locator));
            highlightElement(locator);
            WebElement webElement = getDriver().findElement(locator);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", webElement);
            logger.info("User has already click on element");
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot click element because {0}", e.getMessage()));
        }
    }

    public void switchToNewOpenBrowser() {
        try {
            for (String winHandle : getDriver().getWindowHandles()) {
                logger.debug(MessageFormat.format("Switching to browser {0}", winHandle));
                getDriver().switchTo().window(winHandle);
                logger.info(MessageFormat.format("Switched to browser {0}", winHandle));
            }
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot switch to browser because {0}", e.getMessage()));
        }
    }

    public String getTextJS(By element) {
        String text = "";
        try {
            logger.debug("Get text from element");
            highlightElement(element);
            WebElement webElement = getDriver().findElement(element);
            highlightElement(element);
            text = (String) ((JavascriptExecutor) getDriver()).executeScript("return arguments[0].innerText;", webElement);
            logger.info("User has already get text from element");
            return text;
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot get text because of {0}", e.getMessage()));
        }
        return null;
    }

    public String getText(By element) {
        String text = "";
        try {
            logger.debug("Get text from element");
            highlightElement(element);
            WebElement webElement = getDriver().findElement(element);
            highlightElement(element);
            text = webElement.getText();
            logger.info("User has already get text from element");
            return text;
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot get text because of {0}", e.getMessage()));
        }
        return null;
    }

    public void highlightElement(By locator) {
        try {
            WebElement webElement = getDriver().findElement(locator);
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.border='4px solid red'", webElement);
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot highlight element because {0}", e.getMessage()));
        }
    }

    public void rightClick(By locator) {
        try {
            highlightElement(locator);
            logger.debug("Right click on element...");
            Actions actions = new Actions(getDriver());
            WebElement webElement = getDriver().findElement(locator);
            actions.contextClick(webElement).perform();
            logger.info("User has already right lick on element");
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot perform right click on element because {0}", e.getMessage()));
        }
    }

    public void doubleClick(By locator) {
        try {
            highlightElement(locator);
            logger.debug("Double click on element...");
            Actions actions = new Actions(getDriver());
            WebElement webElement = getDriver().findElement(locator);
            actions.doubleClick(webElement).perform();
            logger.info("User has already double lick on element");
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot perform double click on element because {0}", e.getMessage()));
        }
    }

    public void validateDataInTable(DataTable dataTable, By locator) {
        WebElement htmlTableElement = getDriver().findElement(locator);//get the table WebElement
        List<WebElement> rowElements = htmlTableElement.findElements(By.xpath(".//tr")); //get all row WebElements from the table
        rowElements.remove(0); // remove "header" row from list row WebElements

        List<List<String>> dataTableRows = dataTable.asLists(); //outer List<> is rows, inner List<> is cells
        for (List<String> row : dataTableRows) { //loop through every row in the DataTable input
            int rowIndex = dataTableRows.indexOf(row);
            WebElement rows = rowElements.get(rowIndex); //get the row WebElement based on the index of the current row in the DataTable
            List<WebElement> cells = rows.findElements(By.xpath(".//td"));//get all cells from the row WebElement

            for (String expectedCell : row) {
                int cellIndex = row.indexOf(expectedCell);
                String actualTextOfCell = cells.get(cellIndex).getText();

                 /*
                System.out.println for demonstration purposes
                 */
                System.out.println("DataTable row " + rowIndex + ", cell " + cellIndex + ": " + expectedCell);
                System.out.println("Actual value on the page: " + actualTextOfCell);

                Assert.assertEquals("Expected value of cell should match actual value of cell",
                        expectedCell, actualTextOfCell);
            }
        }
    }

    //verify all column exclude EntityID
    public void validateDataInTableShortVersion(DataTable dataTable, By locator) {
        WebElement htmlTableElement = getDriver().findElement(locator);//get the table WebElement
        List<WebElement> rowElements = htmlTableElement.findElements(By.xpath(".//tr")); //get all row WebElements from the table
        rowElements.remove(0); // remove "header" row from list row WebElements

        List<List<String>> dataTableRows = dataTable.asLists(); //outer List<> is rows, inner List<> is cells
        for (List<String> row : dataTableRows) { //loop through every row in the DataTable input
            int rowIndex = dataTableRows.indexOf(row);
            WebElement rows = rowElements.get(rowIndex); //get the row WebElement based on the index of the current row in the DataTable
            List<WebElement> cells = rows.findElements(By.xpath(".//td"));//get all cells from the row WebElement
            cells.remove(2);//remove column EntityID
            cells.remove(6);//remove column Created At

            for (String expectedCell : row) {
                int cellIndex = row.indexOf(expectedCell);
                String actualTextOfCell = cells.get(cellIndex).getText();

                 /*
                System.out.println for demonstration purposes
                 */
                System.out.println("DataTable row " + rowIndex + ", cell " + cellIndex + ": " + expectedCell);
                System.out.println("Actual value on the page: " + actualTextOfCell);

                asserts.assertEquals("Expected value of cell should match actual value of cell",
                        expectedCell, actualTextOfCell);
            }
        }
    }

    public void inputText(By locator, String text) {
        try {
            logger.debug("Check text is empty...");
            if (!text.isEmpty()) {
                logger.debug("Input text to element...");
                highlightElement(locator);
                WebElement webElement = getDriver().findElement(locator);
                webElement.sendKeys(text);
                logger.info("User has already input to element");
            } else {
                logger.error("Text is empty, please check your input");
            }
        } catch (Exception e) {
            logger.error(MessageFormat.format("Cannot input text to element because {0}", e.getMessage()));
        }
    }

    public void validateMessage(String expected, String actual) {
        logger.debug("Checking message display...");
        asserts.assertEquals("Assert that expected string equals actual string", expected, actual);
    }
}

