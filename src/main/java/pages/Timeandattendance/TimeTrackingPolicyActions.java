package pages.Timeandattendance;

import com.github.javafaker.Faker;
import helper.LocalHelper;
import objectRepo.Timeandattendance.TimeTrackingPolicyRepo;
import org.openqa.selenium.By;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class TimeTrackingPolicyActions extends TimeTrackingPolicyRepo {
    protected static final Logger logger = LoggerFactory.getLogger(TimeTrackingPolicyActions.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public TimeTrackingPolicyActions(WebDriver driver){
        this.driver = driver;
    }
    public void selectCustomerFromDropdown() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPolicyName));
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
    public void selectTimeoffTypeFromDropdown() throws InterruptedException {
        try{
            localHelper.scrollIntoView(policyTypeDropdown,driver);
            localHelper.clickElement(policyTypeDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(policyTypeDropdownOption,"Frequency Monthly",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(policyTypeDropdown,driver);
            localHelper.clickElement(policyTypeDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(policyTypeDropdownOption,"Frequency Monthly",driver);

        }
    }
    public void selectStatusFromDropdown() throws InterruptedException {
        try{
            localHelper.scrollIntoView(statusDropdown,driver);
            localHelper.clickElement(statusDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(statusDropdownOption,"Active",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(statusDropdown,driver);
            localHelper.clickElement(statusDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(statusDropdownOption,"Active",driver);

        }
    }
    public boolean verifyListingPageOnlyShowsSelectedCustomer(){
        return localHelper.checkParticularTextPresentInList(tableCustomerText,"Travelmate Limited",driver);
    }
    public boolean verifyListingPageOnlyShowsSelectedTimeoffType(){
        return localHelper.checkParticularTextPresentInList(tableCustomerText,"Frequency Monthly",driver);
    }
    public boolean verifyListingPageOnlyShowsActivePolicies(){
        return localHelper.checkParticularTextPresentInList(tableStatusText,"Active",driver);
    }
    public void clickSortByDesc(){
        localHelper.clickElement(sortByDesc,driver);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
    }
    public void clickAddPolicyButton(){
        localHelper.clickElement(addPolicyButton,driver);
    }
    public boolean verifyListingPageOnlyShowsSelectedTTType(){
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
        return localHelper.checkParticularTextPresentInList(tableTTTypeText,"Multiple Daily Entry",driver);
    }
    public void selectTTTypeFromDropdown() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPolicyName));
        try{
            localHelper.scrollIntoView(policyTypeDropdown,driver);
            localHelper.clickElement(policyTypeDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(policyTypeDropdownOption,"Multiple Daily Entry",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(policyTypeDropdown,driver);
            localHelper.clickElement(policyTypeDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(policyTypeDropdownOption,"Multiple Daily Entry",driver);

        }
    }
    public boolean checkListOfPolicyShowingAsDescendedOrder(){
        List<String> li=localHelper.getAllText(policyNameListFromTable,driver);
        logger.info("First");
        for(String s:li){
            logger.info(s);
        }
        List<String> newList=localHelper.descendingOrderList(li);
        logger.info("Second");
        for(String s:newList){
            logger.info(s);
        }
        boolean listsAreEqual = true;

        if (li.size() == newList.size()) {
            logger.info("First list size"+li.size());
            logger.info("Second list size"+newList.size());
            return listsAreEqual;
        } else{
            return listsAreEqual=false;
        }
        /*if(li.equals(newList)){
            return true;
        }else{
            return false;
        }*/
    }
    public void selectCountryFromDropdown() throws InterruptedException {
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPolicyName));
        try{
            localHelper.scrollIntoView(countryDropdown,driver);
            localHelper.clickElement(countryDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(countryDropdownOption,"Austria",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(countryDropdown,driver);
            localHelper.clickElement(countryDropdown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(countryDropdownOption,"Austria",driver);

        }
    }
    public boolean verifyListingPageOnlyShowsSelectedCountry(){
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
        return localHelper.checkParticularTextPresentInList(tableCountryText,"Austria",driver);
    }

    public String fillTTPolicy(String single, String monthly) {
        localHelper.checkLoader(By.xpath("//div[@id='atlas-full-loader']"),driver);
        Faker faker=new Faker();
//        try {
//            localHelper.normalClick(nameEditingPencilIcon, driver);
//        }catch (ElementClickInterceptedException m){
//            logger.info("Inside Element Click intercepted exception");
            localHelper.clickElement(nameEditingPencilIcon, driver);
        //}
        String policyName=faker.name().fullName();
        localHelper.sendKeywWithClearText(policyNameTextBox,policyName+" UI",driver);
        try{
            localHelper.scrollIntoView(assignToCountriesDropDown,driver);
            localHelper.clickElement(assignToCountriesDropDown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(assignToCountriesDropDownOption,"Austria",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(assignToCountriesDropDown,driver);
            localHelper.clickElement(assignToCountriesDropDown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(assignToCountriesDropDownOption,"Austria",driver);
        }
        localHelper.checkLoader(By.xpath("//div[@id='atlas-full-loader']"),driver);
        try{
            localHelper.scrollIntoView(assignToCustomerDropDown,driver);
            localHelper.clickElement(assignToCustomerDropDown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(assignToCustomerDropDownOption,"Travelmate Limited",driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        }catch (TimeoutException  e){
            localHelper.scrollIntoView(assignToCustomerDropDown,driver);
            localHelper.clickElement(assignToCustomerDropDown,driver);
            localHelper.getParticularTextFromDropdownCheckBox(assignToCustomerDropDownOption,"Travelmate Limited",driver);
        }
        if(single.equalsIgnoreCase("Multi")){
            localHelper.clickElement(multiEntryButton,driver);
        }
        if(monthly.equalsIgnoreCase("Twice A Month")){
            try{
                localHelper.scrollIntoView(frequencyButton,driver);
                localHelper.clickElement(frequencyButton,driver);
                localHelper.getParticularTextFromDropdown(twiceAMonthOption,"Twice A Month",driver);
                //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
                //localHelper.clickElement(dropdown_gender_one,driver);
            }catch (TimeoutException  e){
                localHelper.scrollIntoView(frequencyButton,driver);
                localHelper.clickElement(frequencyButton,driver);
                localHelper.getParticularTextFromDropdown(twiceAMonthOption,"Twice A Month",driver);
            }
        }
        localHelper.sendKeys(effectiveDate,"01/Oct/2023",driver);
        localHelper.clickElement(saveButton,driver);
        return policyName;
    }
    public boolean checkCreatedPolicyNameAppearFirstInListingPAge(String text){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(ExpectedConditions.elementToBeClickable(firstPolicyName));
        String policyName = null;
        try {
            policyName = localHelper.getTextWithWaitForParticularText(firstPolicyName, text, driver);
        } catch (TimeoutException e) {
            Assert.fail("Created Policy Not Appear First in Listing Page");
        }
        if (policyName.contains(text)) {
            return true;
        } else {
            return false;
        }

    }

        public void applyColumnFilter() throws InterruptedException {
            WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(firstPolicyName));
            // localHelper.scrollIntoView(customerDropdown,driver);
            localHelper.clickElement(coulmnFilterButton,driver);
            localHelper.clickElement(statusCheckBox,driver);
            localHelper.clickElement(saveButtonFromColumnFilter,driver);
        }

}
