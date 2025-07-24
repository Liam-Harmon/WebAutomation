package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.ElementUtil;
import utils.WebLogger;

public class HomePage {

    ElementUtil elementUtil;
    WebDriver driver;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    // Locators
    private final By myPortfolioLogo = By.xpath("//a[@class='navbar-brand']");

    // Methods and Actions

    public String getPageURL() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            String url = elementUtil.fetchPageURL();
            WebLogger.pass("Fetched Page URL: " + url);
            return url;
        } catch (Exception e) {
            WebLogger.fail("Failed to fetch Page URL: " + e.getMessage());
            throw e;
        }
    }

    public void clickMyPortfolioLogo() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doClick(myPortfolioLogo);
            WebLogger.pass("Clicked My Portfolio Logo successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to click My Portfolio Logo: " + e.getMessage());
            throw e;
        }
    }
}
