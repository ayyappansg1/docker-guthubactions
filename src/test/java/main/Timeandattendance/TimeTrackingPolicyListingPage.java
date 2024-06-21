package main.Timeandattendance;

import common.BaseTest;
import helper.LocalHelper;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Timeandattendance.TimeTrackingPolicyActions;
import pages.common.ListingPage;
import pages.common.LoginPage;

public class TimeTrackingPolicyListingPage extends BaseTest {
    private final LocalHelper localHelper = new LocalHelper();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws InterruptedException {
        new LoginPage(driver).loginAs("SUPER ADMIN");
        new ListingPage(driver).clickSettingsTab();
        new ListingPage(driver).selectManageTimeTracking();
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 0)
    public void filterByCustomer() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).selectCustomerFromDropdown();
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).verifyListingPageOnlyShowsSelectedCustomer(),"Listing Page not only showing Selected Customer So dropdown not fetchin exact Customers");
    }
    @Description("Public Holiday Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 1)
    public void filterByCountry() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).selectCountryFromDropdown();
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).verifyListingPageOnlyShowsSelectedCountry(),"Listing Page not only showing Selected Country Policies So dropdown not fetching properly");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 2)
    public void filterByStatus() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).applyColumnFilter();
        new TimeTrackingPolicyActions(driver).selectStatusFromDropdown();
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).verifyListingPageOnlyShowsActivePolicies(),"Listing Page not only showing Active Policies");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 1)
    public void filterBySingleMultiType() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).selectTTTypeFromDropdown();
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).verifyListingPageOnlyShowsSelectedTTType(),"Listing Page not only showing Selected Policy Types So dropdown not fetching exact TTType");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 3)
    public void sortByPolicyName() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).applyColumnFilter();
        new TimeTrackingPolicyActions(driver).clickSortByDesc();
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).checkListOfPolicyShowingAsDescendedOrder(),"After Sorting ,Policy name not in descending order");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 4)
    public void createSingleEntryMonthlyTimeTrackingPolicy() throws InterruptedException {
       new TimeTrackingPolicyActions(driver).clickAddPolicyButton();
        String policyName=new TimeTrackingPolicyActions(driver).fillTTPolicy("Single","Monthly");
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 5)
    public void createSingleEntryTwiceAMonthTimeTrackingPolicy() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).clickAddPolicyButton();
        String policyName=new TimeTrackingPolicyActions(driver).fillTTPolicy("Single","Twice A Month");
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 6)
    public void createMultiEntryTwiceAMonthTimeTrackingPolicy() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).clickAddPolicyButton();
        String policyName=new TimeTrackingPolicyActions(driver).fillTTPolicy("Multi","Twice A Month");
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
    @Description("TimeoffPolicy Listing Page")
    @Owner("ayyappang.cs@atlashxm.com")
    @Test(groups = {"Regression"}, priority = 7)
    public void createMultiEntryMonthlyTimeTrackingPolicy() throws InterruptedException {
        new TimeTrackingPolicyActions(driver).clickAddPolicyButton();
        String policyName=new TimeTrackingPolicyActions(driver).fillTTPolicy("Multi","Monthly");
        Assert.assertTrue(new TimeTrackingPolicyActions(driver).checkCreatedPolicyNameAppearFirstInListingPAge(policyName),policyName+":This Created Policy Not Appears First");
    }
}

