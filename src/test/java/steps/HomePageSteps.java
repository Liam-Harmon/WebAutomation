package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import factory.DriverFactory;
import utils.ConfigReader;
import utils.Constants;

public class HomePageSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage= new HomePage(driver);

    @Given("user has opened portfolio site")
    public void user_has_opened_portfolio_site() {
        System.out.println("Base URL: " + ConfigReader.get("baseUrl"));
        driver.get(ConfigReader.get("baseUrl"));
    }

    @Then("user checks portfolio url")
    public void user_checks_portfolio_url() {
        Assert.assertEquals(Constants.PORTFOLIO_URL, homePage.getPageURL());
    }

    @Then("user clicks on My Portfolio Logo")
    public void user_clicks_on_my_portfolio_logo(){
        homePage.clickMyPortfolioLogo();
    }

}
