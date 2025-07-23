package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Constants;
import utils.ElementUtil;
import utils.WebLogger;

public class ProjectsPage {

    ElementUtil elementUtil;
    WebDriver driver;

    // Constructor
    public ProjectsPage(WebDriver driver) {
        this.driver = driver;
        this.elementUtil = new ElementUtil(driver);
    }

    //Locators
    private final By projectsTopNav = By.xpath("//a[normalize-space()='Projects']");
    private final By projectsTitle = By.xpath("//h1[normalize-space()='Projects']");
    private final By projectsList = By.xpath("//div[@class='card']");

    //Actions & Methods
    public void clickProjectsTopNav(){
        WebLogger.info("Clicking Projects Top Nav");
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            elementUtil.doClick(projectsTopNav);
        } catch (Exception e){
            System.out.println("Error Message: " + e);
        }
    }

    public String getPageURL(){
        WebLogger.info("Fetching Page URL");
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            return elementUtil.fetchPageURL();
        } catch (Exception e){
            System.out.println("Error Message: " + e);
        }
        return "";
    }

    public String getProjectsTitleText(){
        WebLogger.info("Fetching Projects Title");
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            return elementUtil.doGetText(projectsTitle);
        } catch (Exception e){
            System.out.println("Error Message: " + e);
        }
        return "";
    }

    public boolean isProjectsListDisplayed(){
        WebLogger.info("Checking For Projects List");
        elementUtil.delay(Constants.TINY_WAIT);
        try {
            return elementUtil.isElementDisplayed(projectsList);
        } catch (Exception e){
            System.out.println("Error Message: " + e);
        }
        return false;
    }
}
