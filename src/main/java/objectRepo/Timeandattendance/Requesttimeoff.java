package objectRepo.Timeandattendance;

import org.openqa.selenium.By;

public class Requesttimeoff {
    public By Timeoff = By.xpath("//*[@data-testid='left-panel-7']");
    public By Requesttimeoffbutton = By.xpath("//*[@data-testid='request-off-btn']");
    public By timeofftype_dropdown = By.xpath("//div[@data-testid='predictive-search-Time Off Type']//span[2]//input");
    public By loader=By.xpath("//div[@class='loaderContainer']");
    public By timeofftype_option = By.xpath("//*[@id=\"options\"]/li");
    public By timeofftype_First_option = By.xpath("//ul[@class='option-list']/li/span");

    public By Fromdate = By.className("react-datepicker__input-container");
    public By Fromdateinput = By.name("FromDate");
    public By Todateinput = By.name("ToDate");
    public By clickonrequestbutton = By.xpath("//span[text()='Request']//parent::button");
    public By openemployee = By.xpath("//*[@data-testid='row-data-0']");
    public By declinebutton = By.xpath("//*[@data-testid='cancel-button-pr-0']");
    public By declineconfirmbutton = By.xpath("//*[@data-testid='decline-btn']");
    public By approvebutton = By.xpath("//*[@data-testid='edit-button-pr-0']");
    public By cancelbutton = By.xpath("//*[@data-testid='remove-btn-0']");
    public By successMessage = By.xpath("//div[text()='Successfully updated TimeOff status']");

}
