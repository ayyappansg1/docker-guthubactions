package email.emailPage;

import email.emailRepo.MailSacRepo;
import helper.LocalHelper;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class MailSacPage extends MailSacRepo {

    protected static final Logger logger = LoggerFactory.getLogger(MailSacPage.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public MailSacPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEmailInbox(){
        try{
            driver.navigate().refresh();
            localHelper.clickElement(emailInbox,driver);
            }
        catch (TimeoutException | NoSuchElementException e){
            driver.navigate().refresh();
            localHelper.clickElement(emailInbox,driver);
            logger.info("Verified Email inbox");
        }}


    public void clickUnblockLink(){
        localHelper.clickElement(unblockLink_link,driver);
        localHelper.closeTab(driver);
        localHelper.switchTab(driver);
    }

    public void openMailSacPage(String url){
        driver.navigate().refresh();
        localHelper.get(url,driver);
    }

    public void loginToMailSac(String username, String pwd) {
        localHelper.sendKeys(username_txt,username,driver);
        localHelper.sendKeys(password_txt,pwd,driver);
        localHelper.clickElement(signIn_btn,driver);
    }

    public void clickGetStartedBtn(){
        localHelper.clickElement(getStarted_btn,driver);
        localHelper.closeTab(driver);
        localHelper.switchTab(driver);
    }
    public void getOTP(){
        localHelper.clickElement(getStarted_btn,driver);
        localHelper.closeTab(driver);
        localHelper.switchTab(driver);
    }
}
