package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.ElementUtil;
import utils.WebLogger;  // assuming WebLogger now has pass/fail methods

public class ProjectsPage {

    ElementUtil elementUtil;
    WebDriver driver;

    // Constructor
    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    // Locators
    private final By projectsTopNav = By.xpath("//a[normalize-space()='Projects']");
    private final By projectsPageTitle = By.xpath("//h1[normalize-space()='Projects']");
    private final By projectsList = By.xpath("//div[@class='card']");
    private final By projectTitle = By.xpath("(//div[@class='card']//h2)[1]");
    private final By projectImage = By.xpath("(//div[@class='card']//img)[1]");
    private final By projectDescription = By.xpath("(//div[@class='card']//p)[1]");
    private final By projectTags = By.xpath("(//div[@class='card']//div[contains(text(),'Tags:')])[1]");
    private final By projectGithubLink = By.xpath("(//div[@class='card']//div[contains(text(),'Link')])[1]");
    private final By projectDeleteBtn = By.xpath("(//div[@class='card']//button[contains(text(),'Delete')])[1]");
    private final By projectsAddProjectBtn = By.xpath("//button[normalize-space()='Add Project']");
    private final By projectsProjectName = By.xpath("//input[@placeholder='Enter project name']");
    private final By projectsProjectDescription = By.xpath("//textarea[@placeholder='Enter description']");
    private final By projectsProjectGitHubLink = By.xpath("//input[@placeholder='https://github.com/...']");
    private final By projectsProjectTags = By.xpath("//input[@placeholder='React, Spring Boot, Fullstack']");
    private final By projectsProjectImageURL = By.xpath("(//input[@type='url'])[2]");
    private final By projectProjectsImageAltText = By.xpath("(//input[@class='form-control'])[5]");
    private final By projectsProjectSaveChanges = By.xpath("//button[normalize-space()='Save Changes']");
    private final By projectsProjectNewTitle = By.xpath("//div@class='test']");

    // Actions & Methods

    public void clickProjectsTopNav() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doClick(projectsTopNav);
            WebLogger.pass("Clicked Projects Top Nav successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to click Projects Top Nav: " + e.getMessage());
            throw e;
        }
    }

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

    public String getProjectsTitleText() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            String text = elementUtil.doGetText(projectsPageTitle);
            WebLogger.pass("Fetched Projects Page Title: " + text);
            return text;
        } catch (Exception e) {
            WebLogger.fail("Failed to fetch Projects Page Title: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectsListDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectsList);
            WebLogger.pass("Projects List displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Projects List: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectTitleDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectTitle);
            WebLogger.pass("Project Title displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Project Title: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectImageDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectImage);
            WebLogger.pass("Project Image displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Project Image: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectDescriptionDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectDescription);
            WebLogger.pass("Project Description displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Project Description: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectTagsDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectTags);
            WebLogger.pass("Project Tags displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Project Tags: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectGHLinkDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectGithubLink);
            WebLogger.pass("Project GitHub Link displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Project GitHub Link: " + e.getMessage());
            throw e;
        }
    }

    public boolean isProjectDeleteBtnDisplayed() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectDeleteBtn);
            WebLogger.pass("Project Delete Button displayed: " + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to check Project Delete Button: " + e.getMessage());
            throw e;
        }
    }

    public void clickAddProject() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doClick(projectsAddProjectBtn);
            WebLogger.pass("Clicked Add Project successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to click Add Project: " + e.getMessage());
            throw e;
        }
    }

    public void enterProjectName() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doSendKeysCharByChar(projectsProjectName, Constants.PROJECT_NAME);
            WebLogger.pass("Entered Project Name successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to enter Project Name: " + e.getMessage());
            throw e;
        }
    }

    public void enterProjectDescription() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doSendKeysCharByChar(projectsProjectDescription, Constants.PROJECT_DESCRIPTION);
            WebLogger.pass("Entered Project Description successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to enter Project Description: " + e.getMessage());
            throw e;
        }
    }

    public void enterProjectGitHubLink() {
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doSendKeysCharByChar(projectsProjectGitHubLink, Constants.PROJECT_GITHUB_LINK);
            WebLogger.pass("Entered GitHub link successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to enter GitHub link: " + e.getMessage());
            throw e;
        }
    }

    public void enterProjectTags(){
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doSendKeysCharByChar(projectsProjectTags, Constants.PROJECT_TAGS);
            WebLogger.pass("Entered Tags successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to enter Tags: " + e.getMessage());
            throw e;
        }
    }

    public void enterProjectImageURL(){
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doSendKeysCharByChar(projectsProjectImageURL, Constants.PROJECT_IMAGE_URL);
            WebLogger.pass("Entered Image URL successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to enter Image URL: " + e.getMessage());
            throw e;
        }
    }

    public void enterProjectImageAltText(){
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doSendKeysCharByChar(projectProjectsImageAltText, Constants.PROJECT_IMAGE_ALT_TEXT);
            WebLogger.pass("Entered Image Alt successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to enter Image Alt: " + e.getMessage());
            throw e;
        }
    }

    public void clickProjectSaveChangesBtn(){
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doClick(projectsProjectSaveChanges);
            WebLogger.pass("Click Save Changes successfully");
        } catch (Exception e) {
            WebLogger.fail("Failed to click Save Changes: " + e.getMessage());
            throw e;
        }
    }

    public boolean isNewProjectTitleDisplayed(){
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            boolean displayed = elementUtil.isElementDisplayed(projectsProjectNewTitle);
            WebLogger.pass("New Project Title is displayed" + displayed);
            return displayed;
        } catch (Exception e) {
            WebLogger.fail("Failed to find New Project Title: " + e.getMessage());
            throw e;
        }
    }
}
