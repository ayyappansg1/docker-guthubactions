package common;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.IOException;

public class ExtentReportListener extends TestListenerAdapter {
    private ExtentTest test;
    private WebDriver driver;
    public ExtentReportListener() {
        // Initialization code, if needed
    }

    // Constructor to accept WebDriver instance
    public ExtentReportListener(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = ExtentReportManager.createTest(result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.log(Status.FAIL, "Test failed");
//        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName());
//        try {
//            test.addScreenCaptureFromPath(screenshotPath);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test passed");
    }
}
