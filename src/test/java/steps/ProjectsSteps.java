package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import pages.ProjectsPage;
import utils.Constants;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    @Then("user validates project contents")
    public void user_validates_project_contents(){
        assertAll(
                () -> assertTrue(projectsPage.isProjectTitleDisplayed(), "Project Title is not displayed"),
                () -> assertTrue(projectsPage.isProjectImageDisplayed(), "Project Image is not displayed"),
                () -> assertTrue(projectsPage.isProjectDescriptionDisplayed(), "Project Description is not displayed"),
                () -> assertTrue(projectsPage.isProjectGHLinkDisplayed(), "Project GitHub Link is not displayed"),
                () -> assertTrue(projectsPage.isProjectTagsDisplayed(), "Project Tags is not displayed"),
                () -> assertTrue(projectsPage.isProjectDeleteBtnDisplayed(), "Project Delete Button is not displayed")
        );
    }

    @Then("user clicks on Add Projects")
    public void user_clicks_on_add_projects(){
        projectsPage.clickAddProject();
    }

    @Then("user enters project name")
    public void user_enters_project_name(){
        projectsPage.enterProjectName();
    }

    @Then("user enters project description")
    public void user_enters_project_description(){
        projectsPage.enterProjectDescription();
    }

    @Then("user enters github link")
    public void user_enter_github_link(){
        projectsPage.enterProjectGitHubLink();
    }

    @Then("user enters tags")
    public void user_enter_tags(){
        projectsPage.enterProjectTags();
    }

    @Then("user enters image url")
    public void user_enter_image_url(){
        projectsPage.enterProjectImageURL();
    }

    @Then("user enters image alt text")
    public void user_enter_image_alt_text(){
        projectsPage.enterProjectImageAltText();
    }

    @Then("user clicks save changes")
    public void user_clicks_save_changes(){
        projectsPage.clickProjectSaveChangesBtn();
    }

    @Then("user validates newly added project")
    public void user_validates_newly_added_projects(){
        assertAll(
                () -> assertTrue(projectsPage.isNewProjectTitleDisplayed(), "New Project Title is not displayed")
        );
    }
}
