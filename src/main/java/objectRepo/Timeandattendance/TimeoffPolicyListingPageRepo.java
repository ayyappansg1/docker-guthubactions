package objectRepo.Timeandattendance;

import org.openqa.selenium.By;

public class TimeoffPolicyListingPageRepo {
    public By customerDropdown = By.xpath("//span[text()='Customer']//following-sibling::span[text()='Please Select']");
    public By coulmnFilterButton = By.xpath("//button[@data-testid=\"columns-filter-btn\"]");
    public By customerCheckBox = By.xpath("//label[text()='Customer']");
    public By saveButton = By.xpath("//button[@data-testid=\"save-table-header-options\"]");



    public By travelmateOption = By.xpath("(//div[contains(@class,'dropdown__option__container')])[2]/span");
    public By tableCustomerText = By.xpath("//div[@class='table__row']//span[text()='Customer']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//child::div[@class='table__row ']//span[contains(@class,'row-customer')]");
    public By tableTimeoffTypeText = By.xpath("//div[@class='table__row']//span[text()='Customer']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//child::div[@class='table__row ']//span[contains(@class,'row-type')]");
    public By tableStatusText = By.xpath("//div[@class='table__row']//span[text()='Customer']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//child::div[@class='table__row ']//span[contains(@class,'row-status')]");

    public By policyTypeDropdown = By.xpath("//span[text()='Type']//following-sibling::span[text()='Please Select']");
    public By policyTypeDropdownOption = By.xpath("(//span[text()='Type']//following-sibling::div/div)[2]/span");
    public By policyTypeDropdownCheckBox = By.xpath("(//span[text()='Type']//following-sibling::div/div)[2]/span/span");
     public By statusDropdownOption = By.xpath("(//span[text()='Status']//following-sibling::div/div)[2]/span");
    public By statusDropdownCheckBox = By.xpath("(//span[text()='Type']//following-sibling::div/div)[2]/span/span");
    public By statusDropdown = By.xpath("//span[text()='Status']//following-sibling::span[text()='Please Select']");

    public By sortByDesc=By.xpath("//span[text()='Policy Name']//*[local-name()='svg' and @class='sort-down']");
    public By policyNameListFromTable=By.xpath("//div[@class='table__row']//span[text()='Customer']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//child::div[@class='table__row ']//span[contains(@class,'row-name')]");
    public By addPolicyButton=By.xpath("//button[@data-testid='add-policy']");
    public By timeoffTypeDropdown=By.xpath("//span[text()='Time Off Type']//following-sibling::span");
    public By timeoffTypeOption = By.xpath("(//span[text()='Time Off Type']//following-sibling::div/div)[1]/span");
    public By timeoffPolicyNameTextBox = By.xpath("//input[@data-testid='policy-name']");
    public By accrualStartsTextBox = By.xpath("//input[@data-testid='accrual-start']");
    public By amountTextBox = By.xpath("//input[@data-testid='accrual-amount']");
    public By carrryoverAmount = By.xpath("//input[@data-testid='carryover-amount']");
    public By submitButton = By.xpath("//button[@type='submit']");
    public By firstPolicyName = By.xpath("(//div[@class='table__row']//span[text()='Customer']//ancestor::div[@class='table__header']//following-sibling::div[@class='table__body']//child::div[@class='table__row ']//span[contains(@class,'row-name')])[1]");
    public By businessCalendarDropdown = By.xpath("//label[contains(text(),'Busines')]//following-sibling::div/div/div");
    public By businessCalendarDropdownInput = By.xpath("//input[@id='react-select-2-input']");
    public By calendarDaysOption = By.xpath("//div[@id='react-select-2-option-1']");
    public By unlimitedTimeoffCheckBox = By.xpath("//input[@id='isUnlimittedTimeoff']");


}
