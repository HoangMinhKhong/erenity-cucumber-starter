package starter.common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import starter.log.LogHelper;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.function.Function;

public class WebKeywords {
    private static final Logger log = LogHelper.getLogger();
    private static final String USER_DIR = "user.dir";
    private final int defaultTimeout = 5;
    private static WebDriver driver;
    private String browser;

    public WebKeywords() {

    }

    public By findBy(Object locator) {
        if (locator instanceof By) {
            return (By) locator;
        } else if (locator instanceof String) {
            return By.xpath(locator.toString());
        }
        return null;
    }

    public WebElement getElement(Object locator, int... time) {
        final By by = findBy(locator);
        WebElement webElement;
        int timeOut = time.length > 0 ? time[0] : defaultTimeout;
        int pollingTime = (int) (((float) timeOut / 10) * 1000);
        driver = new ChromeDriver();
        try {
            log.debug("Finding element...");
            Wait<WebDriver> wait =
                    new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeOut))
                            .pollingEvery(Duration.ofMillis(pollingTime)).ignoring(NoSuchElementException.class);
            webElement = wait.until(new Function<WebDriver, WebElement>() {
                public WebElement apply(WebDriver webDriver) {
                    return webDriver.findElement(by);
                }
            });
            if (webElement != null) {
                log.info("Find element success");
                return webElement;
            }
        } catch (Exception e) {
            log.error("Element not found.");
        }
        return null;
    }

    public void clearText(Object locator) {
        WebElement webElement = getElement(locator);
        driver = new ChromeDriver();
        Actions actions = new Actions(driver);
        try {
            if (webElement.isEnabled()) {
                actions.moveToElement(webElement).perform();
                log.debug("Clearing text...");
                webElement.clear();
                log.info("Already clear text.");
            } else {
                log.error("Unable to clear text.");
            }
        } catch (ElementNotInteractableException e) {
            log.error("Unable to clear text because element cannot interact!");
        }
    }

    public void setText(Object locator, String value) {
        WebElement webElement = getElement(locator);
        log.debug("Checking text...");
        if (value == null) {
            log.error("Text is null.");
        }
        driver = new ChromeDriver();
        try {
            Actions actions = new Actions(driver);
            log.debug("Clear text...");
            webElement.clear();
            if (webElement.isEnabled()) {
                log.debug("Set text to field...");
                actions.moveToElement(webElement).perform();
                webElement.sendKeys(value);
                log.info("Finished set text");
            } else {
                log.error("Cannot set text to element");
            }
        } catch (Exception e) {
            log.error("Cannot set text to element");
        }
    }

    public void click(Object locator) {
        WebElement webElement = getElement(locator);
        driver = new ChromeDriver();
        try {
            if (webElement.isEnabled()) {
                log.debug("Click element...");
                webElement.click();
                log.info("Already click to element.");
            } else {
                log.error("Unable to click to element");
            }
        } catch (ElementNotInteractableException e) {
            log.error("Cannot interact with element");
        }
    }

    public void clickByJS(Object locator) {
        WebElement webElement = getElement(locator);
        driver = new ChromeDriver();
        try {
            if (webElement.isEnabled()) {
                log.debug("Click element...");
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
                log.info("Already click to element.");
            } else {
                log.error("Unable to click to element");
            }
        } catch (ElementNotInteractableException e) {
            log.error("Cannot interact with element");
        }
    }

    public void scrollInToView(Object locator) {
        WebElement webElement = getElement(locator);
        driver = new ChromeDriver();
        try {
            log.debug("Scroll to element...");
            int yOffSetOfElement = webElement.getLocation().getY();
            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, " + yOffSetOfElement + ")");
            log.info("Finished scroll to element.");
        } catch (Exception e) {
            log.error("Cannot scroll to element.");
        }
    }

    public String getText(Object locator) {
        driver = new ChromeDriver();
        WebElement webElement = getElement(locator);
        String text = "";
        try {
            log.debug("Get text...");
            text = webElement.getText();
            log.info("Finished get text");
        } catch (Exception e) {
            log.error("Cannot get text");
        }
        return text;
    }

    public void closeCurrentBrowser() {
        driver = new ChromeDriver();
        try {
            log.debug("Closing current browser...");
            driver.close();
            log.info("Already closed current browser.");
        } catch (Exception e) {
            log.error("Cannot close current browser!");
        }
    }

    public void closeAllBrowser() {
        driver = new ChromeDriver();
        try {
            log.debug("Closing all browser...");
            driver.quit();
            log.info("Already closed all browser.");
        } catch (Exception e) {
            log.error("Cannot close all browser.");
        }
    }

    public void switchToIFrame(Object locator){
        driver = new ChromeDriver();
        WebElement webElement = getElement(locator);
        try {
            log.debug("Switch to iframe...");
            driver.switchTo().frame(webElement);
            log.info("Already switched to iframe");
        }catch (NoSuchFrameException e){
            log.error("Cannot switch to iframe.");
        }
    }
}
