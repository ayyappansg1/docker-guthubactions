package main.Timeandattendance;

import common.BaseTest;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Timeandattendance.PublicHolidayPolicyListingPageActions;
import pages.common.ListingPage;
import pages.common.LoginPage;

public class PublicHolidayListingPage extends BaseTest {
    private final LocalHelper localHelper = new LocalHelper();
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        new LoginPage(driver).loginAs("INTERNAL_HR_EMAIL");
        new ListingPage(driver).clickSettingsTab();
        new ListingPage(driver).selectManageTimeoff();
        new ListingPage(driver).clickPublicHolidaysTab();
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 0)
    public void filterByCustomer() throws InterruptedException {
        new PublicHolidayPolicyListingPageActions(driver).selectCustomerFromDropdown();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).verifyListingPageOnlyShowsSelectedCustomer(),"Listing Page not only showing Selected Customer So dropdown not fetching exact Customers");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 1)
    public void filterByCountry() throws InterruptedException {
        new PublicHolidayPolicyListingPageActions(driver).selectCountryFromDropdown();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).verifyListingPageOnlyShowsSelectedCountry(),"Listing Page not only showing Selected Country Policies So dropdown not fetching properly");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 2)
    public void filterByStatus() throws InterruptedException {
        new PublicHolidayPolicyListingPageActions(driver).selectStatusFromDropdown();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).verifyListingPageOnlyShowsActivePolicies(),"Listing Page not only showing Active Policies");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 3)
    public void sortByPolicyName() {
        new PublicHolidayPolicyListingPageActions(driver).clickSortByDesc();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkListOfPolicyShowingAsDescendedOrder(),"After Sorting ,Policy name not in descending order");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 4)
    public void createPHPolicy() {
        new PublicHolidayPolicyListingPageActions(driver).clickAddPublicHolidaysButton();
        String policyName=new PublicHolidayPolicyListingPageActions(driver).fillPHPolicyDetails();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 5)
    public void editPHPolicy()  {
        new PublicHolidayPolicyListingPageActions(driver).editExistingPolicy();
        String policyName=new PublicHolidayPolicyListingPageActions(driver).editPHDetails();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkUpdatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Edited Policy Not Appears First");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 6)
    public void duplicatePHPolicy() {
        new PublicHolidayPolicyListingPageActions(driver).clickAddPublicHolidaysButton();
        String policyName=new PublicHolidayPolicyListingPageActions(driver).fillPHPolicyDetails();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
        String duplicatedPolicyName=new PublicHolidayPolicyListingPageActions(driver).clickDuplicateButton(policyName+ " UI");
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkDuplicatePolicyNameAppearFirstInListingPAge(duplicatedPolicyName),policyName+":This Duplicated Policy Not Appears First");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 7)
    public void deactivatePHPolicy() throws InterruptedException {
        new PublicHolidayPolicyListingPageActions(driver).clickAddPublicHolidaysButton();
        String policyName=new PublicHolidayPolicyListingPageActions(driver).fillPHPolicyDetails();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
        String duplicatedPolicyName=new PublicHolidayPolicyListingPageActions(driver).clickDuplicateButton(policyName+ " UI");
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkDuplicatePolicyNameAppearFirstInListingPAge(duplicatedPolicyName),policyName+":This Duplicated Policy Not Appears First");
        new PublicHolidayPolicyListingPageActions(driver).clickDeActivateButton(duplicatedPolicyName);
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkPHPolicyDeActivated(duplicatedPolicyName),policyName+":This DeActivated Policy Not Appears First");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 8)
    public void activatePHPolicy() throws InterruptedException {
        new PublicHolidayPolicyListingPageActions(driver).clickAddPublicHolidaysButton();
        String policyName=new PublicHolidayPolicyListingPageActions(driver).fillPHPolicyDetails();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
        String duplicatedPolicyName=new PublicHolidayPolicyListingPageActions(driver).clickDuplicateButton(policyName+ " UI");
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkDuplicatePolicyNameAppearFirstInListingPAge(duplicatedPolicyName),policyName+":This Duplicated Policy Not Appears First");
        new PublicHolidayPolicyListingPageActions(driver).clickDeActivateButton(duplicatedPolicyName);
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkPHPolicyDeActivated(duplicatedPolicyName),policyName+":This DeActivated Policy Not Appears First");
        new PublicHolidayPolicyListingPageActions(driver).clickActivateButtonBasedOnPolicy(duplicatedPolicyName);
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkPHPolicyActivated(duplicatedPolicyName),policyName+":This Activated Policy Not Appears First");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 9)
    public void deletePHPolicy() throws InterruptedException {
        new PublicHolidayPolicyListingPageActions(driver).clickAddPublicHolidaysButton();
        String policyName=new PublicHolidayPolicyListingPageActions(driver).fillPHPolicyDetails();
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
        String duplicatedPolicyName=new PublicHolidayPolicyListingPageActions(driver).clickDuplicateButton(policyName+ " UI");
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkDuplicatePolicyNameAppearFirstInListingPAge(duplicatedPolicyName),policyName+":This Duplicated Policy Not Appears First");
        new PublicHolidayPolicyListingPageActions(driver).clickDeActivateButton(duplicatedPolicyName);
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkPHPolicyDeActivated(duplicatedPolicyName),policyName+":This DeActivated Policy Not Appears First");
        new PublicHolidayPolicyListingPageActions(driver).clickDeleteButtonBasedOnPolicy(duplicatedPolicyName);
        Assert.assertTrue(new PublicHolidayPolicyListingPageActions(driver).checkPHPolicyDeleted(duplicatedPolicyName),policyName+":This Deleted Policy is Appears in listing page");
    }
}
