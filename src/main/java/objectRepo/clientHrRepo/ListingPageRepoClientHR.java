package objectRepo.clientHrRepo;

import org.openqa.selenium.By;

public class ListingPageRepoClientHR {

    public By searchInput = By.xpath("//input[@class='input-box search-bar']");

    public By countryDropdown = By.xpath("//div[contains(text(),'Country')]/following-sibling::div[@class='a-dropdown']");
    public By customerDropdown = By.xpath("//div[contains(text(),'Customer')]/following-sibling::div[@class='a-dropdown']");
    public By countryLabel = By.xpath("//div[@class='form-label'][contains(text(),'Country')]");
    public By customerLabel = By.xpath("//div[@class='form-label'][contains(text(),'Customer')]");
    public By countryPlaceholderText = By.xpath("//div[contains(text(),'Country')]/following-sibling::div/span[@class='a-dropdown__label undefined']");
    public By customerPlaceholderText = By.xpath("//div[contains(text(),'Customer')]/following-sibling::div/span[@class='a-dropdown__label undefined']");

    public By DropdownOpen = By.xpath("//div[@class='a-dropdown isOpen']");
    public By applyFilterButton = By.xpath("//span[text()='Apply Filters']//parent::button");
    public By CustomerDropdownOpen = By.xpath("//div[@class='a-dropdown isOpen']");
    public By dropDownOpenSearch = By.xpath("//div[@class='a-dropdown__option open']/div/input");
    public By name_Click = By.xpath("(//span[@class='table__row__data column-clickable'])[1]");

    public By countryIndia = By.xpath("//span[@value='a840aa13-04b8-4ce4-bc03-c6ae3e60d765']");
    public By travelMate=By.xpath("//span[@value='8798bb31-6602-4199-b269-7fbcf5208ecc']");

    public By countryAfghanistan = By.xpath("//span[@value='5e085ed8-b63b-43c3-b253-fbb023ea5e6c']");

    public By statusDropdown = By.xpath("//div[contains(text(),'Status')]/following-sibling::div[@class='a-dropdown']");
    public By statusLabel = By.xpath("//div[@class='form-label'][contains(text(),'Status')]");
    public By statusPlaceholderText = By.xpath("//div[contains(text(),'Status')]/following-sibling::div/span[@class='a-dropdown__label undefined']");

    public By statusActiveSelect= By.xpath("//span[@class='a-dropdown__option__item multi-select'][@value='5']");
    public By statusActiveSelected = By.xpath("//span[@class='a-dropdown__option__item opt-selected multi-select'][@value='5']");

    public By customizationButton = By.xpath("//div[@class='column-display-option ']");
    public By customizationDateCreated = By.xpath("//span[text()='Date Created']//preceding-sibling::input");
    public By internalCustomizationDateCreated = By.xpath("//input[@data-testId='startDate_5']");
    public By customizationSaveView = By.xpath("//span[contains(text(),'Save View')]");
    public By customizationReset = By.xpath("//div[@class='reset-option']");

    public By downloadButton = By.xpath("//div[@class='download-button']");
    public By addEmployeeButton = By.xpath("//button[@data-testId='add-employee-button']");
    public By addEmployeePopUp = By.xpath("//div[@class='custom-modal-popup']");
    public By clearFilter = By.xpath("//button[@class='a-button secondary-btn square-lg large me-4']");

    public By clearAll = By.xpath("//button[@class='a-button secondary-btn square-md']");

    public By Name = By.xpath("//span[@class='table__row__header column-name']");
    public By EmployeeID = By.xpath("//span[@class='table__row__header column-employee_id']");
    public By jobTitle = By.xpath("//span[@class='table__row__header column-jobTitile']");
    public By internalJobTitle = By.xpath("//span[@class='table__row__header column-role']");
    public By customer = By.xpath("//span[@class='table__row__header column-customerName']");
    public By Country = By.xpath("//span[@class='table__row__header column-country']");
    public By Status = By.xpath("//span[@class='table__row__header column-status']");
    public By Timesheet = By.xpath("//span[@class='table__row__header column-timeSheet']");
    public By PendingTasks = By.xpath("//span[@class='table__row__header column-pendingTasks']");
    public By DateCreated = By.xpath("//span[@class='table__row__header column-startDate']");

    public By listNames = By.xpath("//div[@class='table__body']/div/span[1]/span");
    public By listEmpIDs = By.xpath("(//span[text()='Status']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//span)[3]");
    public By listCountries = By.xpath("//div[@class='table__body']/div/span[4]");
    public By listCustomers = By.xpath("//div[@class='table__body']/div/span[4]");
    public By internalListCountries = By.xpath("//div[@class='table__body']/div/span[5]");
    public By listStatus = By.xpath("(//span[text()='Status']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//span)[9]");
    public By listStatus_Internal = By.xpath("//div[@class='table__body']/div/span[7]");

    public By unSuccessfulSearchMessage = By.xpath("//div[@class='p-l-20 sidebar-inner-title']");

    public By searchCloseButton = By.xpath("//span[@class='search-close-icon']");

    public By paginationPrev = By.xpath("//button[@id='pagination-prev']");
    public By paginationNext = By.xpath("//button[@id='pagination-next']");
    public By paginationJumpTo = By.xpath("//span[@class='nav-count']/span[contains(text(),'Jump to')]");
    public By paginationGo  = By.xpath("//button[@id='pagination-go']");

    public By paginationNextButton = By.xpath("//button[@id='pagination-next']/span");
    public By paginationPrevButton = By.xpath("//button[@id='pagination-prev']");
    public By paginationJumpTo_Input = By.xpath("//input[@id='jump-to']");

    public By paginationPrev_Page_2 = By.xpath("//span[@class='current-count active'][text()='2']");
    public By paginationNext_Page_1 = By.xpath("//span[@class='current-count active'][text()='1']");
    public By paginationPrev_Page_5 = By.xpath("//span[@class='current-count active'][text()='5']");
    public By paginationShowingPage = By.xpath("//div[@class='pagination__options']/select");

    public By paginationEnd = By.xpath("//button[@class='nav-active']/following::span[@class='nav-start-end']");
    public By paginationStart = By.xpath("//button[@class='nav-active']/preceding::span[@class='nav-start-end']");

    public By paginationTotalPages = By.xpath("//span[@class='total-count']");
    public By paginationCurrentPage = By.xpath("//span[@class='current-count active']");

    public By profile_icon = By.xpath("//button[@class='user-profile-img-button initials-type']");
    public By userProfile_menu = By.xpath("//div[@class='user-profile-menu']");

    public By signOut_btn = By.xpath("//button[@id='sign-out-btn']");

    public By switchOrganization_btn = By.xpath("//button[@class='switch-btn']");
    public By travelMate_btn = By.xpath("//div[@class='org-title'][contains(text(),'Travelmate Limited')]");
    public By currentOrganization = By.xpath("//h4[contains(text(),'Current organization')]/following::div/div[@class='org-title']");
    public By switch_btn = By.xpath("//button[@class='a-button primary-blue small']/span");
    public By close_btn = By.xpath("//span[@class='close']");

    public By people_tab = By.xpath("//span[contains(text(), 'People')]");
    public By settings_tab = By.xpath("//span[text()='Settings']");
    public By manage_time_off_option = By.xpath("//p[@id='manage-time-off-menu']");
    public By manage_time_tracking_option = By.xpath("//p[@id='manage-time-tracking-menu']");
    public By public_holiday_tab = By.xpath("//button[text()='Public Holidays']");



    public By addSingleEmployee_option = By.xpath("//div[@data-testId='add-employee-button-option-0']");
    public By uploadMultipleEmployee_option = By.xpath("//div[@data-testId='add-employee-button-option-1']");

    public By firstRowInGrid = By.xpath("//div[@class='table__row ']");
    public By atlas_Loader = By.xpath("//div[@class='loaderContainer']");
    public By oops_err = By.xpath("//span[@class='module-not-loaded body-message']");
    public By filterButton = By.xpath("//div[@class='d-flex align-items-center']/img");

}
