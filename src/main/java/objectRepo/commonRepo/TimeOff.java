package objectRepo.commonRepo;

import org.openqa.selenium.By;

public class TimeOff {
	  public By timeoff =By.xpath("//*[@data-testid='left-panel-7']");
	  public By requesttimeoff =By.xpath("//*[@data-testid='request-off-btn']");
	  public By timeofftype = By.xpath("(//*[@class='a-dropdown'])[1]");
	  public By timeofftypesearch = By.xpath("//*[@class='a-dropdown__search']");
	  public By selecttimeofftype = By.xpath("//*[@class='a-dropdown__option__item']");
	  public By fromdate = By.xpath("(//*[@class='a-input'])[1]");
	  public By todate = By.xpath("(//*[@class='a-input'])[2]"); 
	  public By requestsubmit =By.xpath("//*[@data-testid='request-submit']");
	  public By timeOffTaskLink =By.xpath("//*[@data-testid='timeOffTaskLink']");
	  public By editbutton =By.xpath("//*[@data-testid='edit-button-pr-0']");
	  public By declinebutton =By.xpath("//*[@data-testid='cancel-button-pr-0']");
	  public By declinebtn =By.xpath("//*[@data-testid='decline-btn']");
	  public By timesheet = By.className("link");
	  public By submittimesheet = By.xpath("//*[@data-testid='AddPolicy']");
	  public By actionbutton = By.xpath("//*[@id=\"root\"]/div/div[5]/div/div/div/div/div[3]/div/div[2]/div[1]/span[6]/span");
	  public By starttime = By.name("startTime0");
	  public By endtime = By.name("endTime0");
	  public By breaktime = By.name("break0");
	  public By timeSheetTaskLink =By.xpath("//*[@data-testid='timeSheetTaskLink']");
	  public By rejectbutton = By.xpath("//*[@class='a-button small custom-btn reject-btn']");
	  public By poprejectbutton =  By.xpath("//*[@class='a-button primary-blue custom-btn1']");
	  public By dashboard =By.xpath("//*[@data-testid='sidebar__item_Dashboard']");
	  
	  public By cardscroll = By.xpath("//*[@class='pending-request-card-wrapper']");

	  public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
	  public By next_btn = By.xpath("//button[@data-testId='next_btn']/span");
}
