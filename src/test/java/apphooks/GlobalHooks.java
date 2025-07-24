package apphooks;

import com.aventstack.extentreports.Status;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import factory.DriverFactory;
import utils.ConfigReader;
import utils.ExtentTestManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

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
            String screenshotPath = captureScreenshot(screenshot, scenario.getName());

            ExtentTestManager.getTest().log(Status.FAIL, "Scenario Failed: " + scenario.getName());
            if (screenshotPath != null) {
                ExtentTestManager.getTest().addScreenCaptureFromPath(screenshotPath);
            }
        } else {
            ExtentTestManager.getTest().log(Status.PASS, "Scenario Passed: " + scenario.getName());
        }

        DriverFactory.quitDriver();
        ExtentTestManager.flush(); // Important to flush after every scenario
    }

    private String captureScreenshot(byte[] screenshot, String screenshotName) {
        String path = "target/screenshots/" + screenshotName.replaceAll(" ", "_") + ".png";
        try {
            Files.createDirectories(Paths.get("target/screenshots/"));
            Files.write(Paths.get(path), screenshot);
            return path;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
