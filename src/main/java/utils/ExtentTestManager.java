package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    private static ExtentReports extent = ExtentManager.getExtentReports();
    private static Map<Long, ExtentTest> extentTestMap = new HashMap<>();
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static synchronized ExtentTest getTest() {
        return extentTest.get();
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName) {
        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);
        extentTestMap.put(Thread.currentThread().getId(), test);
        return test;
    }
}
