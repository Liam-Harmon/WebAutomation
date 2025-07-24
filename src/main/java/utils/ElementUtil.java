package utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ElementUtil {

    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public ElementUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // You can externalize this timeout
    }

    // Click element
    public void doClick(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Send keys to element
    public void doSendKeysCharByChar(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            try {
                Thread.sleep(100); // small delay between keystrokes to mimic user typing
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // restore interrupt status
            }
        }
    }

    // Send Char

    // Get text
    public String doGetText(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
    }

    // Check if element is displayed
    public boolean isElementDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    // Wait for element to be visible
    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for element to be clickable
    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Get attribute value
    public String getAttribute(By locator, String attribute) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getAttribute(attribute);
    }

    // Add Delay
    public void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore the interrupt flag
            e.printStackTrace();
        }
    }

    // Get Page URL
    public String fetchPageURL(){
        return driver.getCurrentUrl();
    }
}
