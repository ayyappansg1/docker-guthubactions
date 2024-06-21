package pages.Timeandattendance;

import com.github.javafaker.Faker;
import helper.LocalHelper;
import objectRepo.Timeandattendance.TimeoffPolicyListingPageRepo;
import org.openqa.selenium.By;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class TimeoffPolicyListingPageActions extends TimeoffPolicyListingPageRepo {
    protected static final Logger logger = LoggerFactory.getLogger(TimeoffPolicyListingPageActions.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public TimeoffPolicyListingPageActions(WebDriver driver){
        this.driver = driver;
    }

    public void selectCustomerFromDropdown() throws InterruptedException {
        try{
            localHelper.scrollIntoView(customerDropdown,driver);
            localHelper.clickElement(customerDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(travelmateOption,"Travelmate Limited",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(customerDropdown,driver);
            localHelper.clickElement(customerDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(travelmateOption,"Travelmate Limited",driver);

        }
    }
    public void applyColumnFilter() throws InterruptedException {
           // localHelper.scrollIntoView(customerDropdown,driver);
            localHelper.clickElement(coulmnFilterButton,driver);
            localHelper.clickElement(customerCheckBox,driver);
            localHelper.clickElement(saveButton,driver);
    }

    public void selectStatusFromDropdown() throws InterruptedException {
        try{
            localHelper.scrollIntoView(statusDropdown,driver);
            localHelper.clickElement(statusDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(statusDropdownOption,"Inactive",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(statusDropdown,driver);
            localHelper.clickElement(statusDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(statusDropdownOption,"Inactive",driver);

        }
    }
    public boolean verifyListingPageOnlyShowsSelectedCustomer() throws InterruptedException {
        Thread.sleep(5000);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
        return localHelper.checkTwoTextPresentInTheList(tableCustomerText,"Travelmate Limited","All",driver);
    }
    public boolean verifyListingPageOnlyShowsSelectedTimeoffType() throws InterruptedException {

        boolean bool= localHelper.checkTimeoffTypeShowingInListingPage(tableTimeoffTypeText,"Paid x Weekly",driver);
        Thread.sleep(10000);
        return bool;
    }

    public boolean verifyListingPageOnlyShowsActivePolicies(){
        return localHelper.checkParticularTextPresentInList(tableStatusText,"Inactive",driver);
    }
    public void clickSortByDesc(){
        localHelper.clickElement(sortByDesc,driver);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
    }
    public void clickAddTimeoffPolicyButton(){
        localHelper.clickElement(addPolicyButton,driver);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
    }
    public String fillBusinessDaysRelatedFields(String type){
        Faker faker = new Faker();

        try{
            localHelper.clickElement(timeoffTypeDropdown,driver);
            localHelper.getParticularTextFromDropdown(timeoffTypeOption,"Frequency Weekly",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.clickElement(timeoffTypeDropdown,driver);
            localHelper.getParticularTextFromDropdown(timeoffTypeOption,"Frequency Weekly",driver);

        }
        String policyName=faker.name().firstName();
        localHelper.sendKeys(timeoffPolicyNameTextBox,policyName+"UI ",driver);
        if(type!=null){
            localHelper.clickElement(unlimitedTimeoffCheckBox,driver);
            localHelper.sendKeys(accrualStartsTextBox, "0", driver);
            localHelper.clickElement(submitButton, driver);
        }else {
            localHelper.sendKeys(accrualStartsTextBox, "0", driver);
            localHelper.sendKeys(amountTextBox, "1", driver);
            localHelper.sendKeys(carrryoverAmount, "10", driver);
            localHelper.clickElement(submitButton, driver);
        }
        return policyName;
    }
    public String fillCalendarDaysRelatedFields(String type){
        Faker faker = new Faker();

        try{
            localHelper.clickElement(timeoffTypeDropdown,driver);
            localHelper.getParticularTextFromDropdown(timeoffTypeOption,"Frequency Weekly",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.clickElement(timeoffTypeDropdown,driver);
            localHelper.getParticularTextFromDropdown(timeoffTypeOption,"Frequency Weekly",driver);

        }
        String policyName=faker.name().firstName();
        localHelper.sendKeys(timeoffPolicyNameTextBox,policyName+"UI ",driver);
        try{
            localHelper.clickElement(businessCalendarDropdown,driver);
            //localHelper.getParticularTextFromDropdown(timeoffTypeOption,"Frequency Monthly",driver);
            localHelper.sendKeys(businessCalendarDropdownInput,"Calendar",driver);
            localHelper.clickElement(calendarDaysOption,driver);
        }catch (TimeoutException  e){
            localHelper.clickElement(businessCalendarDropdown,driver);
            //localHelper.getParticularTextFromDropdown(timeoffTypeOption,"Frequency Monthly",driver);
            localHelper.sendKeys(businessCalendarDropdownInput,"Calendar",driver);
            localHelper.clickElement(calendarDaysOption,driver);
        }
        if(type!=null){
            localHelper.clickElement(unlimitedTimeoffCheckBox,driver);
            localHelper.sendKeys(accrualStartsTextBox, "0", driver);
            localHelper.clickElement(submitButton, driver);
        }else {
            localHelper.sendKeys(accrualStartsTextBox, "0", driver);
            localHelper.sendKeys(amountTextBox, "1", driver);
            localHelper.sendKeys(carrryoverAmount, "10", driver);
            localHelper.clickElement(submitButton, driver);
        }
        return policyName;
    }
    public boolean checkCreatedPolicyNameAppearFirstInListingPAge(String text){
        String policyName=null;
        try {
            policyName=localHelper.getTextWithWaitForParticularText(firstPolicyName, text, driver);
        }catch (TimeoutException e){
            Assert.fail("Created Policy Not Appear First in Listing Page");
        }
        if(policyName.contains(text)){
            return true;
        }else{
            return false;
        }


    }
    public boolean checkListOfPolicyShowingAsDescendedOrder(){
        List<String> li=localHelper.getAllText(policyNameListFromTable,driver);
        List<String> newList=localHelper.descendingOrderList(li);
        if(li.size()==newList.size()){
            return true;
        }else{
            return false;
        }
    }

    public void selectTimeoffTypeFromDropdown() {
        try{
            localHelper.scrollIntoView(policyTypeDropdown,driver);
            localHelper.clickElement(policyTypeDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(policyTypeDropdownOption,"Paid X Weekly",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(policyTypeDropdown,driver);
            localHelper.clickElement(policyTypeDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(policyTypeDropdownOption,"Paid X Weekly",driver);

        }
    }
}
