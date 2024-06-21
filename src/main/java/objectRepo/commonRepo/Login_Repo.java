package objectRepo.commonRepo;

import common.BaseTest;
import org.openqa.selenium.By;

public class Login_Repo extends BaseTest {

    // By locators
    public By loginEmail_txt = By.xpath("//input[@name='email']");
    public By loginPwd_txt = By.xpath("//input[@name='password']");
    public By next_btn = By.cssSelector("div button.primary-blue");
    public By next_btnAfterReset = By.xpath("//div[@class='login-from-submit']//button");

    public By code_txt = By.xpath("//input[@class='input-block ']");
    public By codeExpired_txt=By.xpath("//p[text()='Code expired. Please generate new code.']");
    public By acknowledge_checkbox = By.xpath("//input[@name='sampleCheckbox']");
    public By login_btn = By.xpath("//button[@class='a-button primary-blue small']");

    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
    public By error_msg = By.xpath("//div[@class='error-msg']/p");
    public By somethingWentWrong_msg = By.xpath("//div[@role='alert']/div");
    public By profile_icon = By.xpath("//button[@class='user-profile-img-button']");

}
