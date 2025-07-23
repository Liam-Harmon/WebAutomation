package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import pages.ProjectsPage;
import utils.Constants;

public class ProjectsSteps {

    WebDriver driver = DriverFactory.getDriver();
    ProjectsPage projectsPage= new ProjectsPage(driver);

    @Then("user clicks on projects in top nav")
    public void user_clicks_on_projects_in_top_nav(){
        projectsPage.clickProjectsTopNav();
    }

    @Then("user validates projects page url")
    public void user_validates_projects_page_url(){
        Assert.assertEquals(Constants.PROJECTS_PORTFOLIO_URL, projectsPage.getPageURL());
    }

    @Then("user validates projects page title")
    public void user_validates_project_title(){
        Assert.assertEquals(Constants.PROJECTS_TITLE, projectsPage.getProjectsTitleText());
    }

    @Then("user sees list of projects displayed")
    public void user_sees_list_of_projects_displayed(){
        Assert.assertTrue(projectsPage.isProjectsListDisplayed());
    }
}
