package common;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import ch.qos.logback.core.util.TimeUtil;
import com.aventstack.extentreports.ExtentReports;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Attachment;
import io.restassured.path.json.JsonPath;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

@Listeners({ListenerClass.class, ExtentReportListener.class})
public class BaseTest {

    protected static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;
    public String appURL;
    protected Properties prop;
    public ExtentReportListener extentReportListener;

    ExtentReports extent = ExtentReportManager.getInstance();

    protected JsonPath jsonPathEvaluator;
    protected String baseURI;

    @BeforeMethod(alwaysRun = true)
    protected void SetUp() {
        String browser = "CHROME";
        if(browser.equals("CHROME")){
          WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.addArguments("--disable-dev-shm-usage");
            try {
                driver = new RemoteWebDriver(new URL("http://localhost:4444/"),options);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }


        }
        else if(browser.equals("FIREFOX")){
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
        }
        else
          logger.error("Please check the Browser name");
        logger.info(browser+" BROWSER WAS STARTED SUCCESSFULLY");
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        appURL= "https://core-qa.atlasbyelements.com/";
        //   driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
      //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        driver.get(appURL);
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    @AfterMethod(alwaysRun = true)
    protected void tearDown(ITestResult result) {
        logger.info(("[tearDown]"));
        if(result.getStatus()==ITestResult.FAILURE||result.getStatus()==ITestResult.SKIP){
            try {
                TestUtil.getScreenshot(driver, String.valueOf(result.getName()));
                attachScreenshotsToAllureReport(driver);
                attachLog(String.valueOf(result.getMethod()).replaceAll("[()]",""));

                logger.info("Screenshot taken for Failed TC");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        driver.quit();
        extent.flush();
    }

    @Attachment(value = "Failed TC Screenshot",type = "image/png")
    public void attachScreenshotsToAllureReport(WebDriver driver){
        ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "{0}",type = "text/plain")
    public static void attachLog(String message){
        logger.info(message);
    }
    @BeforeSuite
    public void before(){
        extentReportListener=new ExtentReportListener(driver);
    }
}
