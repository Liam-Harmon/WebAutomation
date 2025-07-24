package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static final ExtentReports extent = ExtentManager.getExtentReports();

    // Thread-safe test storage
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    private static final Map<Long, ExtentTest> extentTestMap = new HashMap<>();

    // Start a new test for the thread
    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }

    // Get current test for the thread
    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    // End test: here we just flush the report
    public static synchronized void endTest() {
        extent.flush();
    }

    // Use this if you want to flush the report explicitly at the end of all tests
    public static synchronized void flush() {
        extent.flush();
    }
}
