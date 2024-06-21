package email.emailRepo;

import org.openqa.selenium.By;

public class MailSacRepo {
    public By emailInbox = By.xpath("//td[@class='col-xs-4']");
    public By unblockLink_link = By.xpath("//a[@class='btn btn-info btn-xs']");

    // Sign In page
    public By username_txt = By.xpath("//input[@name='username']");
    public By password_txt = By.xpath("//input[@name='password']");
    public By signIn_btn = By.xpath("//button[@type='submit']");

    // Inbox
    public By getStarted_btn = By.xpath("//a[contains(text(),'Get Started')]");
}
