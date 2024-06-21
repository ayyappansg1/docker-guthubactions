package pages.Timeandattendance;

import com.github.javafaker.Faker;
import helper.LocalHelper;
import objectRepo.Timeandattendance.PublicHolidayListingPageRepo;
import org.openqa.selenium.By;
//import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.util.List;

public class PublicHolidayPolicyListingPageActions extends PublicHolidayListingPageRepo {
    protected static final Logger logger = LoggerFactory.getLogger(PublicHolidayPolicyListingPageActions.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public PublicHolidayPolicyListingPageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void selectCustomerFromDropdown() throws InterruptedException {
        try {
            localHelper.scrollIntoView(customerDropdown, driver);
            localHelper.clickElement(customerDropdown, driver);
            localHelper.getParticularTextFromDropdownCheckBox(travelmateOption, "Travelmate Limited", driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        } catch (TimeoutException  e) {
            localHelper.scrollIntoView(customerDropdown, driver);
            localHelper.clickElement(customerDropdown, driver);
            localHelper.getParticularTextFromDropdownCheckBox(travelmateOption, "Travelmate Limited", driver);

        }
    }

    public void selectCountryFromDropdown() throws InterruptedException {
        try {
            localHelper.scrollIntoView(countryDropdown, driver);
            localHelper.clickElement(countryDropdown, driver);
            localHelper.getParticularTextFromDropdownCheckBox(countryDropdownOption, "Austria", driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        } catch (TimeoutException  e) {
            localHelper.scrollIntoView(countryDropdown, driver);
            localHelper.clickElement(countryDropdown, driver);
            localHelper.getParticularTextFromDropdownCheckBox(countryDropdownOption, "Austria", driver);

        }
    }

    public void selectStatusFromDropdown() throws InterruptedException {
        try {
            localHelper.scrollIntoView(statusDropdown, driver);
            localHelper.clickElement(statusDropdown, driver);
            localHelper.getParticularTextFromDropdownCheckBox(statusDropdownOption, "Active", driver);
            //localHelper.sendKeys(customerDropdown,"Travelmate",driver);
            //localHelper.clickElement(dropdown_gender_one,driver);
        } catch (TimeoutException  e) {
            localHelper.scrollIntoView(statusDropdown, driver);
            localHelper.clickElement(statusDropdown, driver);
            localHelper.getParticularTextFromDropdownCheckBox(statusDropdownOption, "Active", driver);

        }
    }

    public boolean verifyListingPageOnlyShowsSelectedCustomer() throws InterruptedException {
        Thread.sleep(5000);
        return localHelper.checkParticularTextPresentInList(tableCustomerText, "Travelmate Limited", driver);
    }

    public boolean verifyListingPageOnlyShowsSelectedCountry() {
        return localHelper.checkParticularTextPresentInList(tableCountryText, "Austria", driver);
    }

    public boolean verifyListingPageOnlyShowsActivePolicies() {
        return localHelper.checkParticularTextPresentInList(tableStatusText, "Active", driver);
    }

    public void clickSortByDesc() {
        localHelper.clickElement(sortByDesc, driver);
        localHelper.checkLoader(By.xpath("//div[@id='atlas-full-loader']"),driver);
    }

    public void clickAddPublicHolidaysButton() {
        localHelper.clickElement(addPublicHolidayButton, driver);
    }
    public void editExistingPolicy() {
        localHelper.clickElement(viewExistingPolicy, driver);
    }

    public String fillPHPolicyDetails() {
        Faker faker = new Faker();
        String policyName = faker.name().firstName();
        localHelper.sendKeys(phPolicyNameTextBox, policyName + " UI", driver);
        localHelper.clickElement(countryDropdownInPopup, driver);
        // localHelper.sendKeys(countryTextBoxInDropDown, "Austria", driver);
        localHelper.getParticularTextFromDropdown(allCountryOptions, "Austria", driver);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"), driver);
        localHelper.clickElement(yearDropdown, driver);
        localHelper.getParticularTextFromDropdown(yearDropdownOption, "2024", driver);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"), driver);
        localHelper.clickElement(continueButton, driver);
        localHelper.clickElement(saveButton, driver);
        return policyName;
    }

    public boolean checkListOfPolicyShowingAsDescendedOrder() {
        List<String> li = localHelper.getAllText(policyNameListFromTable, driver);
        List<String> newList = localHelper.descendingOrderList(li);
        if (li.equals(newList)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean checkCreatedPolicyNameAppearFirstInListingPAge(String text) {
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
    public boolean checkUpdatedPolicyNameAppearFirstInListingPAge(String text) {
        String policyName = null;
        try {
            policyName = localHelper.getTextWithWaitForParticularText(firstPolicyName, text, driver);
        } catch (TimeoutException e) {
            Assert.fail("Updated Policy Not Appear in Listing Page");
        }
        if (policyName.contains(text)) {
            return true;
        } else {
            return false;
        }

    }
    public boolean checkDuplicatePolicyNameAppearFirstInListingPAge(String text) {
        String policyName = null;
        try {
            policyName = localHelper.getTextWithWaitForParticularText(firstPolicyName, text, driver);
        } catch (TimeoutException e) {
            Assert.fail("Updated Policy Not Appear in Listing Page");
        }
        if (policyName.contains(text)) {
            return true;
        } else {
            return false;
        }

    }

    public String editPHDetails() {
        Faker faker = new Faker();
        String policyName = faker.name().firstName();
        localHelper.clickElement(pHPolicyEditButton, driver);
        localHelper.clickElement(editIconForName, driver);
        localHelper.clearElement(phPolicyNameTextBox,driver);
        localHelper.sendKeys(phPolicyNameTextBox, policyName + " UI updated", driver);
        localHelper.clickElement(editIconForName, driver);
        localHelper.clickElement(saveButton, driver);
        localHelper.clickElement(saveButton, driver);
        return policyName;
    }
    public String clickDuplicateButton(String policyName) {
        //String policyName=localHelper.getText(viewExistingPolicy, driver);
        localHelper.clickDuplicateButtonBasedOnParticularText(policyName, driver);
        return localHelper.getTextWithWaitForParticularText(viewExistingPolicy,policyName+"_Copy", driver);
    }
    public void clickDeActivateButton(String duplicatedPolicyName) {
      //  String policyName=localHelper.getText(viewExistingPolicy, driver);
        localHelper.clickDeActivateButtonBasedOnParticularText(duplicatedPolicyName, driver);
    }
    public void clickActivateButtonBasedOnPolicy(String policyName) {
        localHelper.clickActivateButtonBasedOnParticularText(policyName, driver);
    }
    public void clickDeleteButtonBasedOnPolicy(String policyName) {
        localHelper.clickDeleteButtonBasedOnParticularText(policyName, driver);
        localHelper.clickElement(deletePHPolicyConfirmation,driver);
    }
    public boolean checkPHPolicyDeActivated(String text) throws InterruptedException {
        return localHelper.checkDeleteIconDisplayed(text, driver);
    }

    public boolean checkPHPolicyActivated(String text) throws InterruptedException {
        return localHelper.checkDeleteIconNotDisplayed(text, driver);

    }
    public boolean checkPHPolicyDeleted(String text) throws InterruptedException {
        return localHelper.checkPolicyDeleted(text, driver);

    }
}
