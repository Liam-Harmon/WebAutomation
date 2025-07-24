package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ExtentManager {

    private static ExtentReports extent;

    public synchronized static ExtentReports getExtentReports() {
        if (extent == null) {
            String reportDir = "report";
            File dir = new File(reportDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            String reportPath = reportDir + File.separator + "ExtentReport_" + timestamp + ".html";

            ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
            htmlReporter.config().setDocumentTitle("Automation Test Report");
            htmlReporter.config().setReportName("Web Test Results");
            htmlReporter.config().setTheme(Theme.STANDARD);

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("Browser", ConfigReader.get("browser"));
            extent.setSystemInfo("ChromeDriver Version", getChromeDriverVersion());
            extent.setSystemInfo("Environment", ConfigReader.get("baseUrl"));
            extent.setSystemInfo("Author", "Liam Harmon");
        }

        return extent;
    }

    private static String getChromeDriverVersion() {
        try {
            String chromeDriverPath = System.getProperty("webdriver.chrome.driver");
            if (chromeDriverPath == null || chromeDriverPath.isEmpty()) {
                return "Path not set";
            }

            Process process = new ProcessBuilder(chromeDriverPath, "--version").start();
            try (Scanner scanner = new Scanner(process.getInputStream())) {
                if (scanner.hasNextLine()) {
                    String versionLine = scanner.nextLine();
                    String[] parts = versionLine.split(" ");
                    if (parts.length >= 2) {
                        return parts[1].trim();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Unknown";
    }
}
