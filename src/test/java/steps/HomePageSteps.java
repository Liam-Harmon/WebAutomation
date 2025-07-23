package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import factory.DriverFactory;
import utils.ConfigReader;
import utils.WebLogger;

import static org.junit.Assert.assertEquals;

public class HomePageSteps {

    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage= new HomePage(driver);

    @Given("user has opened portfolio site")
    public void user_has_opened_portfolio_site() {
        System.out.println("Base URL: " + ConfigReader.get("baseUrl"));
        driver.get(ConfigReader.get("baseUrl"));
    }

    @When("user enters valid username")
    public void user_enters_valid_username() {
        homePage.enterUsername("standard_user");
    }

    @Then("user enters valid password")
    public void user_enters_valid_password() {
        homePage.enterPassword("secret_sauce");
    }

    @When("user clicks login button")
    public void user_clicks_login_button(){
        homePage.clickLogin();
    }

    @Then("user validates portfolio title")
    public void user_validates_portfolio_title() {
        String actualTitle = homePage.getPageTitle();
        String expectedTitle = "Swag Labs";
        WebLogger.info("Validating page title. Expected: " + expectedTitle + ", Actual: " + actualTitle);
        assertEquals("Page title does not match!", expectedTitle, actualTitle);
    }
}
