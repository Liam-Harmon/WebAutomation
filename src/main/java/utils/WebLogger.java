package utils;

import com.aventstack.extentreports.Status;

public class WebLogger {

    public static void pass(String message) {
        ExtentTestManager.getTest().log(Status.PASS, message);
    }

    public static void fail(String message) {
        ExtentTestManager.getTest().log(Status.FAIL, message);
    }

    public static void info(String message) {
        ExtentTestManager.getTest().log(Status.INFO, message);
    }

    public static void attachScreenshot(String path) {
        try {
            ExtentTestManager.getTest().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            fail("Failed to attach screenshot: " + e.getMessage());
        }
    }
}

