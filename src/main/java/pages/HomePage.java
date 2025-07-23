package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.ElementUtil;
import utils.WebLogger;

public class HomePage {

    ElementUtil elementUtil;
    WebDriver driver;

    // Locators
    private By usernameField = By.xpath("//input[@id='user-name']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By loginButton = By.xpath("//input[@id='login-button']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    // Methods and Actions
    public void enterUsername(String username) {
        WebLogger.info("Entering username: " + username);
        elementUtil.delay(Constants.SHORT_WAIT);
        elementUtil.doSendKeys(usernameField, username);
    }

    public void enterPassword(String password) {
        WebLogger.info("Entering password: [PROTECTED]");
        elementUtil.delay(Constants.SHORT_WAIT);
        elementUtil.doSendKeys(passwordField, password);
    }

    public void clickLogin() {
        WebLogger.info("Clicking login button");
        elementUtil.delay(Constants.SHORT_WAIT);
        elementUtil.doClick(loginButton);
    }

    public String getPageTitle() {
        elementUtil.delay(Constants.SHORT_WAIT);
        String title = driver.getTitle();
        WebLogger.info("Retrieved page title: " + title);
        return title;
    }
}

