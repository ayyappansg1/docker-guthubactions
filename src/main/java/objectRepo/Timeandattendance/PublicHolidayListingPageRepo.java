package objectRepo.Timeandattendance;

import org.openqa.selenium.By;

public class PublicHolidayListingPageRepo {
    public By customerDropdown = By.xpath("//span[text()='Customer']//following-sibling::span[text()='Please Select']");
    public By travelmateOption = By.xpath("(//div[contains(@class,'dropdown__option__container')])[2]/span");
    public By travelmateOptionCheckBox = By.xpath("(//div[contains(@class,'dropdown__option__container')])[2]/span/span");
    public By tableCustomerText = By.xpath("//div[@class='table__body']/div/span[2]");
    public By tableCountryText = By.xpath("//div[@class='table__body']/div/span[3]");
    public By tableStatusText = By.xpath("//div[@class='table__body']/div/span[4]");

    public By countryDropdown = By.xpath("//span[text()='Country']//following-sibling::span[text()='Please Select']");
    public By countryDropdownOption = By.xpath("(//span[text()='Country']//following-sibling::div/div)[2]/span");
    public By policyTypeDropdownCheckBox = By.xpath("(//span[text()='Country']//following-sibling::div/div)[2]/span");
    public By statusDropdownOption = By.xpath("(//span[text()='Status']//following-sibling::div/div)[2]/span");
    public By statusDropdownCheckBox = By.xpath("(//span[text()='Type']//following-sibling::div/div)[2]/span/span");
    public By statusDropdown = By.xpath("//span[text()='Status']//following-sibling::span[text()='Please Select']");

    public By sortByDesc=By.xpath("//span[text()='Policy Name']//*[local-name()='svg' and @class='sort-down']");
    public By policyNameListFromTable=By.xpath("//div[@class='table__body']//div[@class='table__row ']//span[contains(@class,'row-name')]");
    public By addPublicHolidayButton=By.xpath("//button[@data-testid='AddPublicHolidays']");
    public By viewExistingPolicy=By.xpath("(//div[@class='table__body']//div[@class='table__row ']//span[contains(@class,'row-name')])[1]");
    public By deletePHPolicyConfirmation=By.xpath("//button[@data-testid='delete-public-holiday-modal-continue']");

    public By phPolicyNameTextBox=By.xpath("//input[@name='policy-name']");
    public By pHPolicyEditButton=By.xpath("//button[@data-testid='edit-holiday']");
    public By editIconForName=By.xpath("//*[local-name()='svg' and @class='edit-icon-space']");

    public By countryDropdownInPopup=By.xpath("//div[@class='holiday-country required']//span[text()='Country']//following-sibling::span[text()='Please Select']");
    public By countryTextBoxInDropDown=By.xpath("//div[@class='a-dropdown__option open']//input[@class='a-dropdown__search']");
    public By allCountryOptions=By.xpath("//div[@class='a-dropdown__option open']/div[2]/span");
    public By yearDropdown=By.xpath("//span[text()='Year']//following-sibling::span[text()='Please Select']");
    public By yearDropdownOption=By.xpath("(//span[text()='Year']//following-sibling::div/div)[1]/span");
    public By continueButton=By.xpath("//button[@data-testid='continue-holiday']");
    public By saveButton=By.xpath("//button[@type='submit']");
    public By firstPolicyName=By.xpath("(//div[@class='table__body']/div/span[1])[1]");
}
