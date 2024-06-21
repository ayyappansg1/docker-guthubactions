package main.Timeandattendance;

import common.BaseTest;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Timeandattendance.TimeoffPolicyListingPageActions;
import pages.common.ListingPage;
import pages.common.LoginPage;

public class TimeoffPolicyListingPage extends BaseTest {
    private final LocalHelper localHelper = new LocalHelper();
    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        new LoginPage(driver).loginAs("SUPER ADMIN");
        new ListingPage(driver).clickSettingsTab();
        new ListingPage(driver).selectManageTimeoff();

    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 0)
    public void filterByCustomer() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        new TimeoffPolicyListingPageActions(driver).selectCustomerFromDropdown();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).verifyListingPageOnlyShowsSelectedCustomer(),"Listing Page not only showing Selected Customer So dropdown not fetchin exact Customers");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 1)
    public void filterByTimeoffType() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        new TimeoffPolicyListingPageActions(driver).selectTimeoffTypeFromDropdown();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).verifyListingPageOnlyShowsSelectedTimeoffType(),"Listing Page not only showing Selected Policy Types So dropdown not fetching exact TimeoffType");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 2)
    public void filterByStatus() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        new TimeoffPolicyListingPageActions(driver).selectStatusFromDropdown();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).verifyListingPageOnlyShowsActivePolicies(),"Listing Page not only showing Active Policies");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 3)
    public void sortByPolicyName() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        new TimeoffPolicyListingPageActions(driver).clickSortByDesc();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).checkListOfPolicyShowingAsDescendedOrder(),"After Sorting ,Policy name not in descending order");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 4)
    public void createBusinessDaysConfiguredTimeoffPolicy() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).clickAddTimeoffPolicyButton();
        String policyName=new TimeoffPolicyListingPageActions(driver).fillBusinessDaysRelatedFields(null);
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 5)
    public void createCalendarDaysConfiguredTimeoffPolicy() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).clickAddTimeoffPolicyButton();
        String policyName=new TimeoffPolicyListingPageActions(driver).fillCalendarDaysRelatedFields(null);
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 6)
    public void createBusinessDaysConfiguredUnlimitedTimeoffPolicy() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).clickAddTimeoffPolicyButton();
        String policyName=new TimeoffPolicyListingPageActions(driver).fillBusinessDaysRelatedFields("Unlimited");
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 5)
    public void createCalendarDaysConfiguredUnlimitedTimeoffPolicy() throws InterruptedException {
        new TimeoffPolicyListingPageActions(driver).clickAddTimeoffPolicyButton();
        String policyName=new TimeoffPolicyListingPageActions(driver).fillCalendarDaysRelatedFields("Unlimited");
        new TimeoffPolicyListingPageActions(driver).applyColumnFilter();
        Assert.assertTrue(new TimeoffPolicyListingPageActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
}
