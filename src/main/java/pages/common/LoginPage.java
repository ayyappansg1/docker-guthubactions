package pages.common;

import common.TestUtil;
import helper.LocalHelper;
import objectRepo.commonRepo.Login_Repo;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class LoginPage extends Login_Repo {

    protected static final Logger logger = LoggerFactory.getLogger(LoginPage.class);
    private final LocalHelper localHelper = new LocalHelper();
    //private final String appURL= System.getProperty("APP_URL");
    private final WebDriver driver;
    int limit=0;
    int errorOTPLimit=0;
    Properties prop = new TestUtil().init_Properties("common/Login");
    Properties uatProp = new TestUtil().init_Properties("common/uatLogin");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public void verifyLoginPageOpenStatus() throws InterruptedException {
        logger.info("### Running verifyLoginPageOpenStatus method ###");
        try{
            if(localHelper.verifyElement(loginEmail_txt,driver)){
                logger.info("Login page has opened");
            }else{
                logger.info("Login page is not appearing");
                localHelper.hardRefresh(driver);
                logger.info("Page hard refreshed");
            }
        }catch (NoSuchElementException | TimeoutException e){
            logger.info("Login page is not appearing on UI");
            localHelper.hardRefresh(driver);
            logger.info("Page hard refreshed");
        }
    }

    public boolean verifySomethingWentWrong(){
        try{
            if(localHelper.verifyElement(somethingWentWrong_msg,3,driver)){
                logger.error("Something went wrong in the application ");
                logger.info("The toast msg is appearing on UI");
                localHelper.hardRefresh(driver);
                limit=limit+1;
                return true;
            }
        }catch (Exception e){
            logger.info("Exception :");
            logger.error(e.getMessage());
        }
        return false;
    }

    public void loginAs(String role) throws InterruptedException {
        verifyLoginPageOpenStatus();
        verifySomethingWentWrong();
            switch (role) {
                case "INTERNAL_HR_EMAIL":
                case "SUPER ADMIN":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("INTERNAL_HR_EMAIL"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "WSE_Through_API":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("WSE_Through_API"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "WSE_For_ManagerWSE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("WSE_For_ManagerWSE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "ManagerWSE_For_New_WSE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("ManagerWSE_For_New_WSE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "Manager_For_New_WSE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("Manager_For_New_WSE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("Manager_Only_Password"), driver);
                    break;
                case "CLIENT HR":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("CLIENT_HR_EMAIL"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "CLIENT_HR_NEW":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("CLIENT_HR_NEW_EMAIL"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "INTERNAL HRSD":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("INTERNAL_HRSD_EMAIL"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "MANAGER":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("MANAGER"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "EMPLOYEE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("EMPLOYEE_EMAIL"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "EMPLOYEE 3":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("EMPLOYEE_EMAIL_ACTIVE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "EMPLOYEE_FOR_TIME_OFF":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("EMPLOYEE_FOR_TIME_OFF"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "MANAGER_TIME_OFF":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("MANAGER_TIME_OFF"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "INSIGHTS_FREE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("INSIGHT_FREE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "EXPERT_MEMBER":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("EXPERT_MEMBER"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "EXPERT_MANAGER":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("EXPERT_MANAGER"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "INSIGHTS_COMPLIMENTARY":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("INSIGHTS_COMPLIMENTARY"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "INSIGHTS_ESSENTIALS":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("INSIGHTS_ESSENTIALS"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "CUSTOMER SUPPORT":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("CUSTOMER_SUPPORT"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "HR SERVICE":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("HR_SERVICE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "INSIGHT CONTENT VIEWER":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("INSIGHT_CONTENT_VIEWER"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "ACCOUNT ADMIN INSIGHTS":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("ACCOUNT_ADMIN_INSIGHTS"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "ACCOUNT ADMIN EOR":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("ACCOUNT_ADMIN_EOR"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "HR_ADMIN_WSE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("HR_ADMIN_WSE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;

                case "ManagerWSE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("ManagerWSE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD"), driver);
                    break;
                case "WSE":
                    localHelper.highlightElement(loginEmail_txt,driver);
                    localHelper.highlightElement(loginPwd_txt,driver);
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("WSE"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD_WSE"), driver);
                    break;
                case "WSE_New":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("WSE_New"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("Login_PWD_Usual"), driver);
                    break;
                case "WSE2":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("WSE2"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD_WSE"), driver);
                    break;
                case "WSE3":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("WSE3"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD_WSE"), driver);
                    break;
                case "Manager_New":
                    localHelper.sendKeys(loginEmail_txt, prop.getProperty("Manager_New"), driver);
                    localHelper.sendKeys(loginPwd_txt, prop.getProperty("LOGIN_PWD_WSE"), driver);

            }
        localHelper.clickElement(next_btn, driver);
        verifyCredentials();
        verifyOTPExpired(role);
    }

    private void verifyOTPExpired(String role) throws InterruptedException {
        if(localHelper.verifyElement(codeExpired_txt,2,driver)){
        localHelper.hardRefresh(driver);
        if(errorOTPLimit<4) {
            loginAs(role);
        }
        }
    }
    private void verifyOTPExpired(String username,String password) throws InterruptedException {
        if(localHelper.verifyElement(codeExpired_txt,5,driver)){
            localHelper.hardRefresh(driver);
            if(errorOTPLimit<=2) {
                loginAs(username,password);
            }
        }
    }

    public void loginAs(String username, String password) throws InterruptedException {
        localHelper.sendKeys(loginEmail_txt, username, driver);
        localHelper.sendKeys(loginPwd_txt, password, driver);
        localHelper.clickElement(next_btn, driver);
        boolean status=verifySomethingWentWrong();
        if(limit<=2) {
            if (status) {
                localHelper.hardRefresh(driver);
                loginAs(username, password);
            }
        }
        verifyCredentials();
        verifyOTPExpired(username,password);

    }
    public void loginAfterReset(String username, String password) throws InterruptedException {
        localHelper.sendKeys(loginEmail_txt, username, driver);
        localHelper.sendKeys(loginPwd_txt, password, driver);
        localHelper.clickElement(next_btnAfterReset, driver);
        boolean status=verifySomethingWentWrong();
        if(limit<=2) {
            if (status) {
                localHelper.hardRefresh(driver);
                loginAs(username, password);
            }
        }
        verifyCredentials();
        verifyOTPExpired(username,password);

    }
    public void verifyCredentials() throws InterruptedException {
        if(localHelper.verifyElement(error_msg,2,driver)){
            logger.info("Error found on login page : ");
            if(localHelper.getText(error_msg,driver).equals("Please provide correct email or password")){
                logger.error(localHelper.getText(error_msg, driver));
                logger.error("This credential is not valid, Please try the valid credentials");
            }else if(localHelper.getText(error_msg,driver).equals("Password retry attempts reached maximum limit, Please contact your administrator")){
                logger.error(localHelper.getText(error_msg, driver));
            }else{
                logger.error(localHelper.getText(error_msg, driver));
            }
            logger.info("Closing this session, we're facing some issue with the login");
        }else{
            logger.info("Two factor authentication page");
            twoFactorAuthentication(prop.getProperty("TWO_FACTOR_CODE"));

        }
    }

    public void twoFactorAuthentication(String two_factor_code) throws InterruptedException {
        try {
            localHelper.sendKeys(code_txt, two_factor_code, driver);
            clickAcknowledgeCheckbox();
            localHelper.clickElement(login_btn, driver);
            errorOTPLimit=errorOTPLimit+1;
        } catch (TimeoutException | NoSuchElementException e) {
            logger.error("Two factor authentication - It's taking more than the usual time");
            try{
                if(localHelper.checkLoader(atlas_Loader,driver)){
                    if(localHelper.verifyElement(code_txt,10,driver)){
                        localHelper.sendKeys(code_txt, two_factor_code, driver);
                        clickAcknowledgeCheckbox();
                        localHelper.clickElement(login_btn, driver);
                    }else{
                        logger.error("No login button found");
                    }
                }else{
                    logger.error("No loader found - Two factor authentication page could not appearing");
                }
            }catch (TimeoutException e2){
                logger.error("Two factor - Still page is loading");
                if(localHelper.checkLoader(atlas_Loader,driver)){
                    if(localHelper.verifyElement(code_txt,10,driver)){
                        localHelper.sendKeys(code_txt, two_factor_code, driver);
                        clickAcknowledgeCheckbox();
                        localHelper.clickElement(login_btn, driver);
                    }else{
                        logger.error("No login button found - Two factor authentication page is not opening");
                    }
                }
            }
        }
        // Verify the login
        try {
            if(localHelper.verifyElement(profile_icon,driver)){
                logger.info("Successfully login into the application");
            }else{
                verifyLoginSuccessful();
            }
        }catch (TimeoutException | NoSuchElementException e){
            // Verify the url
            logger.info(appURL);
            verifyLoginSuccessful();
        }
    }

    public void clickAcknowledgeCheckbox(){
        if(localHelper.verifyElement(acknowledge_checkbox,5,driver)){
            localHelper.clickElement(acknowledge_checkbox,driver);
            logger.info("Acknowledge checkbox is checked");
        }else {
            logger.info("This user doesn't have an acknowledge option");
        }
    }

    public void verifyLoginSuccessful(){
        logger.info("Verify login page");
        if (driver.getCurrentUrl().equals(appURL)) {
            logger.error("We're still in the login page");
            try {
                if (localHelper.verifyElement(login_btn, 5, driver)) {
                    localHelper.clickElement(login_btn, driver);
                }
            } catch (Exception ex) {
                logger.error("We're facing some issue in the login page");
                logger.info(String.valueOf(ex));
            }
        }
    }

}
