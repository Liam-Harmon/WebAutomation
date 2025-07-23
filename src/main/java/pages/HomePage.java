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
    public String getPageURL(){
        WebLogger.info("Fetch Page URL");
        elementUtil.delay(Constants.TINY_WAIT);
        return elementUtil.fetchPageURL();
    }

    public void clickMyPortfolioLogo(){
        WebLogger.info("Clicking My Portfolio Logo");
        elementUtil.delay(Constants.TINY_WAIT);
        elementUtil.doClick(myPortfolioLogo);
    }
}

