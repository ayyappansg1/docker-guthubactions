package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class ScreenshotUtils {
    public static String captureScreenshot(WebDriver driver, String screenshotName) {
        try {
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
            String screenshotPath = System.getProperty("user.dir") + File.separator + "FailedTestsScreenshots" + File.separator + screenshotName + ".png";
            System.out.println("PAth is "+screenshotPath);
            FileUtils.writeByteArrayToFile(new File(screenshotPath), screenshot);
            return screenshotPath;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
