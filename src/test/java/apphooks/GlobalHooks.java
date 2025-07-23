package apphooks;

import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utils.ConfigReader;
import utils.ExtentTestManager;

public class GlobalHooks {

    @Before
    public void beforeScenario(Scenario scenario) {
        ConfigReader.initProperties();
        DriverFactory.getDriver();
        ExtentTestManager.startTest(scenario.getName());
    }

    @After
    public void afterScenario(Scenario scenario) {
        WebDriver driver = DriverFactory.getDriver();

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            ExtentTestManager.getTest().log(Status.FAIL, "Scenario Failed");
            ExtentTestManager.getTest().addScreenCaptureFromPath(captureScreenshot(screenshot, scenario.getName()));
            ExtentTestManager.getTest().fail(scenario.getName());
        } else {
            ExtentTestManager.getTest().log(Status.PASS, "Scenario Passed");
        }

        ExtentTestManager.endTest();
        DriverFactory.quitDriver();
    }

    private String captureScreenshot(byte[] screenshot, String screenshotName) {
        try {
            String path = "target/screenshots/" + screenshotName + ".png";
            java.nio.file.Path dest = java.nio.file.Paths.get(path);
            java.nio.file.Files.createDirectories(dest.getParent());
            java.nio.file.Files.write(dest, screenshot);
            return path;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
