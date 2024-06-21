package pages.common;

import helper.LocalHelper;
import objectRepo.clientHrRepo.ListingPageRepoClientHR;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
//import java.util.concurrent.TimeUnit;

public class ListingPage extends ListingPageRepoClientHR {

    protected static final Logger logger = LoggerFactory.getLogger(ListingPage.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public ListingPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean searchInput_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(searchInput,driver);
    }
    public boolean countryDropdown_IsPresent() throws InterruptedException {
        Thread.sleep(10000);
        return localHelper.verifyElement(countryDropdown,driver);}
    public boolean statusDropdown_IsPresent() throws InterruptedException {         Thread.sleep(10000);
        return localHelper.verifyElement(statusDropdown,driver); }
    public boolean customerDropdown_IsPresent() throws InterruptedException {
        Thread.sleep(10000);
        return localHelper.verifyElement(customerDropdown,driver);}

    public boolean downloadButton_IsPresent() throws InterruptedException { return localHelper.verifyElement(downloadButton,driver);}
    public boolean customizationButton_IsPresent() throws InterruptedException { return localHelper.verifyElement(customizationButton,driver);}

    public boolean clearFilter_IsPresent() throws InterruptedException { return localHelper.verifyElement(clearFilter,driver);}

    public boolean clearAll_IsPresent() throws InterruptedException { return localHelper.verifyElement(clearAll,driver);}

    public boolean searchCloseButton_IsPresent() throws InterruptedException { return localHelper.verifyElement(searchCloseButton,driver);}

    public boolean tableHeaderName_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(Name,driver);
    }
    public boolean tableHeaderEmpId_IsPresent() throws InterruptedException { return localHelper.verifyElement(EmployeeID,driver);  }
    public boolean tableHeaderJobTitle_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(jobTitle,driver);
    }
    public boolean tableHeaderInternalJobTitle_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(internalJobTitle,driver);
    }
    public boolean tableHeaderCountry_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(Country,driver);
    }
    public boolean tableHeaderStatus_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(Status,driver);
    }
    public boolean tableHeaderCustomer_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(customer,driver);
    }
    public boolean tableHeaderTimesheet_IsPresent() throws InterruptedException {
        return localHelper.verifyElement(Timesheet,driver);
    }
    public boolean tableHeaderPendingTasks_IsPresent() throws InterruptedException {  return localHelper.verifyElement(PendingTasks,driver); }
    public boolean paginationPrev_IsPresent() throws InterruptedException { return localHelper.verifyElement(paginationPrev,driver); }
    public boolean paginationNext_IsPresent() throws InterruptedException { return localHelper.verifyElement(paginationNext,driver); }
    public boolean paginationJumpTo_IsPresent() throws InterruptedException { return localHelper.verifyElement(paginationJumpTo,driver); }
    public boolean paginationGo_IsPresent() throws InterruptedException { return localHelper.verifyElement(paginationGo,driver); }
    public boolean paginationShowing_IsPresent() throws InterruptedException { return localHelper.verifyElement(paginationShowingPage,driver); }


    public String dateCreatedIsPresent(){ return localHelper.getText(DateCreated,driver); }
    public String dateCreatedIsPresentInGrid(){ return localHelper.getText(DateCreated,driver); }

    public boolean verifyDefaultGridIsPresent() throws InterruptedException { return tableHeaderName_IsPresent() && tableHeaderEmpId_IsPresent() && tableHeaderJobTitle_IsPresent() && tableHeaderCountry_IsPresent() &&  tableHeaderStatus_IsPresent() ;}
    public boolean verifyInternalDefaultGridIsPresent() throws InterruptedException { return tableHeaderName_IsPresent() && tableHeaderEmpId_IsPresent() && tableHeaderInternalJobTitle_IsPresent() && tableHeaderCustomer_IsPresent() && tableHeaderCountry_IsPresent() &&  tableHeaderStatus_IsPresent() && tableHeaderTimesheet_IsPresent();}
    public String getCountryLabelText() {
        return localHelper.getText(countryLabel,driver);
    }
    public String getCustomerLabelText() {
        return localHelper.getText(customerLabel,driver);
    }
    public String getStatusLabelText() { return localHelper.getText(statusLabel,driver);}
    public String getCountryPlaceholderText(){ return localHelper.getText(countryPlaceholderText,driver); }
    public String getCustomerPlaceholderText(){ return localHelper.getText(customerPlaceholderText,driver); }
    public String getStatusPlaceholderText() { return localHelper.getText(statusPlaceholderText,driver);}

    public void sendKeysCharacterByCharacter(WebElement element, String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            element.sendKeys(String.valueOf(c));
        }
    }

    public void performSearchBy(String query) throws InterruptedException {

        WebElement searchInputElement = driver.findElement(searchInput);
        searchInputElement.clear();
        sendKeysCharacterByCharacter(searchInputElement, query);
        //localHelper.sendKeywWithClearText(searchInput, query, driver);
         //localHelper.sendKeys(searchInput, query, driver);
        try {
            if(localHelper.checkLoader(atlas_Loader,driver)){
                verifyOopsErrPage();
            }else if(localHelper.checkLoader(atlas_Loader,driver)){
                logger.info("Verify 2nd check");
                verifyOopsErrPage();
            }
        }catch (TimeoutException e){
            logger.info("The page is taking more time to load");
            logger.info("Waiting for one more time");
            if(localHelper.checkLoader(atlas_Loader,driver)){
                verifyOopsErrPage();
            }
        }
    }
    public void directNavigateToWSE(String employeeId,WebDriver driver){
        driver.get("https://core-uat.atlasbyelements.com/#/people/post-timeoff/"+employeeId);

    }
    public String searchByNameIsSuccessful(String value) {
        return verifySearchResults(listNames,value,driver);
    }

    public String searchByIdIsSuccessful(String value){
        if(localHelper.getText(listEmpIDs,driver).contains(value)){
           return value;
        }
        return localHelper.getText(listEmpIDs, driver);
    }

    public String unsuccessfulSearchMessage(){ return localHelper.getText(unSuccessfulSearchMessage,driver); }

    public void openCountryDropdown(){
        localHelper.clickElement(countryDropdown,driver);
    }

    public void clickSearchInput() {localHelper.clickElement(searchInput,driver);}

    public void clickClearAll() {localHelper.clickElement(clearAll,driver);}

    public void openCustomerDropdown(){
        localHelper.clickElement(customerDropdown,driver);
    }

    public void closeCountryDropdown() throws InterruptedException {
        localHelper.clickElement(DropdownOpen,driver);
        Thread.sleep(3000);
    }
    public void closeCustomerDropdown() throws InterruptedException {
        localHelper.clickElement(CustomerDropdownOpen,driver);
        Thread.sleep(3000);
    }
    public void clickApplyFilterButton() throws InterruptedException {
        localHelper.clickElement(applyFilterButton,driver);
        Thread.sleep(3000);
    }

    public void clickFilterButton(){
        localHelper.clickElement(filterButton,driver);
    }
    public void selectCountry(){ localHelper.jsExecutorClick(countryIndia,driver);    }

    public String searchByCountryIsSuccessful(String countryName) throws InterruptedException {
        Thread.sleep(4000);
        return this.verifyFilteredResults(listCountries, countryName,driver);
    }
    public void selectTravelMate(){ localHelper.jsExecutorClick(travelMate,driver);    }
    public String searchByCustomerIsSuccessful(String countryName) throws InterruptedException {
        Thread.sleep(5000);
        return this.verifyFilteredResults(listCustomers, countryName,driver);
    }
    public String internalSearchByCountryIsSuccessful(String countryName) throws InterruptedException {
        Thread.sleep(5000);
        return this.verifyFilteredResults(internalListCountries, countryName,driver);
    }

    public void selectActiveStatus() {
        localHelper.clickElement(statusDropdown,driver);
        localHelper.clickElement(statusActiveSelect,driver);
    }

    public boolean checkActiveStatusSelected() throws InterruptedException {
        return localHelper.verifyElement(statusActiveSelected,driver);
    }
    public String checkActiveStatus(String statusOption) throws InterruptedException {
        Thread.sleep(4000);
        return this.verifyFilteredResults(listStatus, statusOption,driver);
    }
    public String internalCheckActiveStatus(String statusOption) throws InterruptedException {
        Thread.sleep(4000);
        if(localHelper.checkLoader(atlas_Loader,driver)){
            return this.verifyFilteredResults(listStatus_Internal, statusOption,driver);
            }
        return statusOption;
    }
    public void deSelectStatus(){ localHelper.clickElement(statusActiveSelected,driver);   }

    public String checkResultStatus(String statusOption) throws InterruptedException {
        Thread.sleep(4000);
        //localHelper.clickElement(DropdownOpen, driver);
        return this.verifyFilteredResults(listStatus, statusOption,driver);
    }

    public void clickResetInCustomization(){
        localHelper.clickElement(customizationReset,driver);
    }
    public void clickClearFilter() { localHelper.clickElement(clearFilter,driver);        }

    public void clickSearchCloseButton() { localHelper.clickElement(searchCloseButton,driver);        }
    public void clickName() { localHelper.clickElement(name_Click,driver);        }
    public void clickCustomizationButton() { localHelper.clickElement(customizationButton,driver);   }
    public void clickDateCreatedInCustomization(){ localHelper.clickElement(customizationDateCreated,driver);  }
    public void clickInternalDateCreatedInCustomization(){ localHelper.clickElement(internalCustomizationDateCreated,driver);  }

    public void saveViewInCustomization(){ localHelper.jsExecutorClick(customizationSaveView,driver);   }

    public boolean verifyNextButtonEnabled(){ return localHelper.verifyEnabledElement(paginationNextButton, driver); }
    public boolean clickPrevButtonEnabled(){ return localHelper.verifyEnabledElement(paginationPrevButton, driver); }

    public void clickNextPageButton(){ localHelper.jsExecutorClick(paginationNextButton, driver); }
    public void clickPrevPageButton(){ localHelper.jsExecutorClick(paginationPrevButton, driver); }

    public boolean verifyNextPageIsOpened() throws InterruptedException { return localHelper.verifyElement(paginationPrev_Page_2,driver);}
    public boolean verifyPrevPageIsOpened() throws InterruptedException { return localHelper.verifyElement(paginationNext_Page_1,driver);  }

    public boolean verifyJumpToEnabled(){
       return localHelper.verifyEnabledElement(paginationJumpTo_Input,driver);
    }
    public void sendValueJumpTo(String pageNo){ localHelper.jsExecutorSendValue(paginationJumpTo_Input,pageNo,driver); }
    public void clickGoToPage(){ localHelper.jsExecutorClick(paginationGo,driver);   }
    public boolean checkJumpPageIsDisplayed() throws InterruptedException { return localHelper.verifyElement(paginationPrev_Page_5,driver);  }
    public void selectPaginationCount(String value){ localHelper.selectDropdownByVisibleText(paginationShowingPage,value,driver);   }

    public boolean showingByThirtyIsDisplayed(String tableSize){
        localHelper.checkDropdownValues(paginationShowingPage,tableSize,driver);
        return true;
    }

    public String getCurrentPage(){ return localHelper.getText(paginationCurrentPage,driver);  }
    public String getTotalPages(){ return localHelper.getText(paginationTotalPages,driver);   }

    public void verifyPaginationEnd(){ localHelper.verifyEnabledElement(paginationEnd,driver);  }
    public void verifyPaginationStart(){ localHelper.verifyEnabledElement(paginationStart,driver);  }

    public void clickPaginationEnd(){ localHelper.jsExecutorClick(paginationEnd,driver);  }
    public void clickPaginationStart(){ localHelper.jsExecutorClick(paginationStart,driver);  }


    public String verifyFilteredResults(By element_by, String checkValue, WebDriver driver){
        //driver.manage().timeouts().setScriptTimeout(5,TimeUnit.SECONDS);
        //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));

        try{
            List<WebElement> results = driver.findElements(element_by);
            for (WebElement res:results) {
                for(int i=0;i<results.size();i++) {
                    if (!res.getText().equals(checkValue)) {
                       // logger.info(res.getText());
                        return res.getText();
                    }
                }
            }
        }
        catch (StaleElementReferenceException e){
            logger.info("Stale Element Reference Exception");
            logger.info(String.valueOf(e));
        }
        return checkValue;
    }

    public String verifySearchResults(By element_by, String containedValue, WebDriver driver){
        WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(50));
        wait.until(driver1 -> String
                .valueOf(((JavascriptExecutor) driver).executeScript("return document.readyState"))
                .equals("complete"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));

        try {
            List<WebElement> results = driver.findElements(element_by);
            for (WebElement res:results) {
                for(int i=0;i<results.size();i++) {
                    if (!res.getText().contains(containedValue)) {
                        logger.info("Found a different value "+res.getText());
                        return res.getText();
                    }
                    else {
                        logger.info(res.getText());
                    }
                }
            }
        }
        catch (StaleElementReferenceException e){
            logger.info("Stale Element Reference Exception");
            logger.info(String.valueOf(e));
        }
        return containedValue;
    }

    public void clickAddEmployeeButton() {
        if(localHelper.checkLoader(atlas_Loader,driver)){
            localHelper.clickElement(addEmployeeButton,driver);
        }else if(localHelper.verifyElement(addEmployeeButton,10,driver)){
            localHelper.clickElement(addEmployeeButton,driver);
        }
    }
    public void clickAddSingleEmployeeOption(){  localHelper.clickElement(addSingleEmployee_option,driver);     }
    public boolean AddEmployeePopUp_IsDisplayed(){ return localHelper.verifyEnabledElement(addEmployeePopUp,driver);    }

    public void clickPeopleTab(){
        localHelper.jsExecutorClick(people_tab, driver);
        try {
            if(localHelper.checkLoader(atlas_Loader,driver)){
                verifyOopsErrPage();
            }else if(localHelper.checkLoader(atlas_Loader,driver)){
                logger.info("Verify 2nd check");
                verifyOopsErrPage();
            }
        }catch (TimeoutException e){
            logger.info("The page is taking more time to load");
            logger.info("Waiting for one more time");
            if(localHelper.checkLoader(atlas_Loader,driver)){
                verifyOopsErrPage();
            }

        }
    }
    public void clickSettingsTab(){
        localHelper.jsExecutorClick(settings_tab, driver);

    }
    public void selectManageTimeoff(){
        localHelper.jsExecutorClick(manage_time_off_option, driver);

    }
    public void selectManageTimeTracking(){
        localHelper.jsExecutorClick(manage_time_tracking_option, driver);

    }
    public void clickPublicHolidaysTab(){
        localHelper.jsExecutorClick(public_holiday_tab, driver);

    }

    public void verifyOopsErrPage(){
        if(localHelper.verifyElement(oops_err,3,driver)){
            logger.error("We are getting the error on our people page.");
            localHelper.hardRefresh(driver);
            localHelper.jsExecutorClick(people_tab,driver);
        }else {
            logger.info("People page has launched successfully");
        }
    }

    public String getCurrentOrganization(){  return localHelper.getText(currentOrganization,driver);     }

    public void switchToTravelMateOrganization(){
        try {
            if(localHelper.checkLoader(atlas_Loader,driver)){
                if(localHelper.verifyEnabledElement(profile_icon,driver)){
                    localHelper.clickElement(profile_icon, driver);
                }
            }

        }catch (TimeoutException | NoSuchElementException  | ElementNotInteractableException e){
            logger.error("Exception found on clicking the profile icon");
            localHelper.jsExecutorClick(profile_icon,driver);
        }
        localHelper.clickElement(switchOrganization_btn, driver);
        if(!getCurrentOrganization().equalsIgnoreCase("TravelMate Limited")) {
            localHelper.clickElement(travelMate_btn, driver);
            localHelper.jsExecutorClick(switch_btn, driver);
        } else{
            localHelper.clickElement(close_btn,driver);
        }
        if (localHelper.verifyElement(userProfile_menu,5,driver)){
            logger.error("The user profile menu is not closing automatically");
            localHelper.clickElement(userProfile_menu,driver);
        }
    }

    public void signOutApplication()  {
        localHelper.clickElement(profile_icon,driver);
        localHelper.clickElement(signOut_btn,driver);
        localHelper.hardRefresh(driver);

    }

    public void clickFirstEmployee(String empID) throws InterruptedException {
        if(searchByIdIsSuccessful(empID).equals(empID)){
            localHelper.clickElement(listEmpIDs,driver);
        }
        else{
            //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            clickClearFilter();
            performSearchBy(empID);
            if(searchByIdIsSuccessful(empID).equals(empID)){
                localHelper.clickElement(listEmpIDs,driver);
            }
        }
    }
}
