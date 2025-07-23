package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ConfigReader;

import java.time.Duration;

public class DriverFactory {
    private static WebDriver driver;

    private DriverFactory() {}

    private static String driverVersion;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigReader.get("browser");

            switch (browser.toLowerCase()) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverVersion = WebDriverManager.firefoxdriver().getDownloadedDriverVersion();
                    driver = new FirefoxDriver();
                    break;

                case "chrome":
                default:
                    WebDriverManager.chromedriver().setup();
                    driverVersion = WebDriverManager.chromedriver().getDownloadedDriverVersion();
                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(
                    Long.parseLong(ConfigReader.get("implicitWait"))));
        }
        return driver;
    }

    public static String getDriverVersion() {
        return driverVersion;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
