package objectRepo.Timeandattendance;

import org.openqa.selenium.By;

public class TimeTrackingPolicyRepo {
    public By customerDropdown = By.xpath("//span[text()='Customer']//following-sibling::span[text()='Please Select']");
    public By travelmateOption = By.xpath("(//div[contains(@class,'dropdown__option__container')])[2]/span");
    public By travelmateOptionCheckBox = By.xpath("(//div[contains(@class,'dropdown__option__container')])[2]/span/span");
    public By tableCustomerText = By.xpath("//div[@class='table__body']/div/span[4]");
    public By tableCountryText = By.xpath("//div[@class='table__body']/div/span[3]");
    public By tableStatusText = By.xpath("//div[@class='table__body']/div/span[5]");
    public By tableTTTypeText = By.xpath("//div[@class='table__body']/div/span[2]");
    public By policyTypeDropdown = By.xpath("//span[text()='Policy Type']//following-sibling::span[text()='Please Select']");
    public By policyTypeDropdownOption = By.xpath("(//span[text()='Policy Type']//following-sibling::div/div)[2]/span");

    public By countryDropdown = By.xpath("//span[text()='Country']//following-sibling::span[text()='Please Select']");
    public By countryDropdownOption = By.xpath("(//span[text()='Country']//following-sibling::div/div)[2]/span");
    public By policyTypeDropdownCheckBox = By.xpath("(//span[text()='Country']//following-sibling::div/div)[2]/span");
    public By statusDropdownOption = By.xpath("(//span[text()='Status']//following-sibling::div/div)[2]/span");
    public By statusDropdownCheckBox = By.xpath("(//span[text()='Type']//following-sibling::div/div)[2]/span/span");
    public By statusDropdown = By.xpath("//span[text()='Status']//following-sibling::span[text()='Please Select']");

    public By sortByDesc=By.xpath("//span[text()='Policy Name']//*[local-name()='svg' and @class='sort-down']");
    public By policyNameListFromTable=By.xpath("//div[@class='table__row ']//span[contains(@class,'row-name')]");
    public By addPolicyButton=By.xpath("//button[@data-testid='AddPolicy']");
    public By nameEditingPencilIcon=By.xpath("//span[@data-testid='edit-policy-name']//*[local-name()='svg']/*[name()='path']");
    public By policyNameTextBox=By.xpath("//input[@name='policyName']");
    public By assignToCountriesDropDown=By.xpath("//span[text()='Assign to Countries']//following-sibling::span[text()='Please Select']");
    public By assignToCountriesDropDownOption=By.xpath("(//span[text()='Assign to Countries']//following-sibling::div/div)[2]/span");
    public By assignToCustomerDropDown=By.xpath("//span[text()='Customers']//following-sibling::span[text()='Please Select']");
    public By assignToCustomerDropDownOption=By.xpath("(//span[text()='Customers']//following-sibling::div/div)[2]/span");
    public By multiEntryButton=By.xpath("//span[text()='Multiple Daily Entry']");
    public By frequencyButton=By.xpath("//label[contains(text(),'Time Tracking')]//following-sibling::div/span[text()='Monthly']");
    public By twiceAMonthOption=By.xpath("//label[contains(text(),'Time Tracking')]//following-sibling::div/div/div/span");
    public By effectiveDate=By.xpath("//input[@name='startDate']");
    public By saveButton=By.xpath("//button[@type='submit']");
    public By saveButtonFromColumnFilter=By.xpath("//span[text()='Save']");

    public By firstPolicyName=By.xpath("(//div[@class='table__row ']//span[contains(@class,'row-name')])[1]");
    public By coulmnFilterButton = By.xpath("//button[@data-testid=\"columns-filter-btn\"]");
    public By statusCheckBox = By.xpath("//label[text()='Status']");


}
