package pages.Timeandattendance;

import common.TestUtil;
import helper.LocalHelper;
import objectRepo.Timeandattendance.Requesttimeoff;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

public class Requesttimeoffclass extends Requesttimeoff {
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;
    static String tomorrow; static String dateone;
    Properties prop = new TestUtil().init_Properties("common/Timeoff");
    Properties uatprop = new TestUtil().init_Properties("common/Login");


    public Requesttimeoffclass(WebDriver driver) {
        this.driver=driver;
    }


    public void clickontimeoffstepper()
    {
        try {
            localHelper.scrollIntoView(Timeoff, driver);
            localHelper.clickElement(Timeoff, driver);
        }catch (TimeoutException e){
            String url=driver.getCurrentUrl();
            String newurl=url.replace("profile","timeoff");
            driver.get(newurl);
        }
    }

    public void requesttimeofffunction(int numberofdates, int plusnumbers) throws InterruptedException {
        generateDatesExcludingWeekends(numberofdates,plusnumbers);
        localHelper.scrollIntoView(Requesttimeoffbutton,driver);
        localHelper.verifyElement(By.className("time-off-card-wrapper"),driver);
        localHelper.clickElement(Requesttimeoffbutton,driver);
        localHelper.checkLoader(loader,driver);
        try{
           // localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(timeofftype_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(timeofftype_dropdown,"Paid",driver);
            Thread.sleep(4000);
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.presenceOfElementLocated(timeofftype_First_option));
            localHelper.checkLoader(loader,driver);
            Thread.sleep(4000);
            try {
                localHelper.clickElement(timeofftype_First_option, driver);
            }catch (TimeoutException m){
                localHelper.jsExecutorClick(timeofftype_First_option, driver);
            }
        }catch(TimeoutException e){
            localHelper.clickElement(timeofftype_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(timeofftype_dropdown,"Paid",driver);
            localHelper.checkLoader(loader,driver);
            localHelper.clickElement(timeofftype_First_option,driver);
        }

      //  localHelper.clickElement(timeofftype_option,driver);
        localHelper.clickElement(Fromdate,driver);
        localHelper.sendKeys(Fromdateinput, dateone,driver);
        localHelper.sendKeys(Fromdateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.sendKeys(Todateinput, dateone,driver);
        localHelper.sendKeys(Todateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.scrollIntoView(clickonrequestbutton,driver);
        localHelper.clickElement(clickonrequestbutton,driver);
        localHelper.verifyElement(By.className("pending-request-card-wrapperr"),driver);
    }
    public void requesttimeofffunctionforapprove(int numberofdates, int plusnumbers) throws InterruptedException {
        /*generateDatesExcludingWeekends(numberofdates,plusnumbers);
        localHelper.scrollIntoView(Requesttimeoffbutton,driver);
        localHelper.verifyElement(By.className("time-off-card-wrapper"),driver);
        localHelper.clickElement(Requesttimeoffbutton,driver);
        localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
        try{
            // localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(timeofftype_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(timeofftype_dropdown,"Paid",driver);
            Thread.sleep(4000);
            WebDriverWait wait=new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.presenceOfElementLocated(timeofftype_First_option));
            localHelper.checkLoader(By.xpath("//div[@class='loaderContainer']"),driver);
            Thread.sleep(4000);
            try {
                localHelper.clickElement(timeofftype_First_option, driver);
            }catch (TimeoutException m){
                localHelper.jsExecutorClick(timeofftype_First_option, driver);
            }
        }catch(TimeoutException | ElementNotVisibleException e){
            localHelper.clickElement(timeofftype_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(timeofftype_dropdown,"",driver);
            localHelper.clickElement(timeofftype_First_option,driver);
        }
        localHelper.clickElement(Fromdate,driver);
        localHelper.sendKeys(Fromdateinput, dateone,driver);
        localHelper.sendKeys(Fromdateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.sendKeys(Todateinput, dateone,driver);
        localHelper.sendKeys(Todateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.scrollIntoView(clickonrequestbutton,driver);
        localHelper.clickElement(clickonrequestbutton,driver);
        localHelper.verifyElement(By.className("pending-request-card-wrapperr"),driver);*/

        generateDatesExcludingWeekends(numberofdates,plusnumbers);
        localHelper.scrollIntoView(Requesttimeoffbutton,driver);
        localHelper.verifyElement(By.className("time-off-card-wrapper"),driver);
        localHelper.clickElement(Requesttimeoffbutton,driver);
        localHelper.checkLoader(loader,driver);
        try{
            // localHelper.scrollIntoView(postalCode_txt,driver);
            localHelper.clickElement(timeofftype_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(timeofftype_dropdown,"Paid",driver);
            Thread.sleep(4000);
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(50));
            wait.until(ExpectedConditions.presenceOfElementLocated(timeofftype_First_option));
            localHelper.checkLoader(loader,driver);
            Thread.sleep(4000);
            try {
                localHelper.clickElement(timeofftype_First_option, driver);
            }catch (TimeoutException m){
                localHelper.jsExecutorClick(timeofftype_First_option, driver);
            }
        }catch(TimeoutException e){
            localHelper.clickElement(timeofftype_dropdown,driver);
            // getRandomValue = localHelper.getRandomElement(dropdown_First_Values,driver).getText().toLowerCase();
            localHelper.jsExecutorSendValue(timeofftype_dropdown,"Paid",driver);
            localHelper.checkLoader(loader,driver);
            localHelper.clickElement(timeofftype_First_option,driver);
        }

        //  localHelper.clickElement(timeofftype_option,driver);
        localHelper.clickElement(Fromdate,driver);
        localHelper.sendKeys(Fromdateinput, dateone,driver);
        localHelper.sendKeys(Fromdateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.sendKeys(Todateinput, dateone,driver);
        localHelper.sendKeys(Todateinput, String.valueOf(Keys.ENTER),driver);
        //localHelper.scrollIntoView(clickonrequestbutton,driver);
        localHelper.clickElement(clickonrequestbutton,driver);
        localHelper.verifyElement(Requesttimeoffbutton,driver);
    }

    public void edittimeoffrequest(int numberofdates, int plusnumbers) throws InterruptedException {
        generateDatesExcludingWeekends(numberofdates,plusnumbers);
        localHelper.scrollIntoView(approvebutton,driver);
        localHelper.clickElement(approvebutton,driver);
        localHelper.checkLoader(loader,driver);
        localHelper.clickElement(Fromdate,driver);
        localHelper.sendKeys(Fromdateinput, String.valueOf(Keys.BACK_SPACE),driver);
        localHelper.sendKeys(Fromdateinput, "3",driver);
        localHelper.sendKeys(Fromdateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.clickElement(Todateinput,driver);
        localHelper.sendKeys(Todateinput, String.valueOf(Keys.BACK_SPACE),driver);
        localHelper.sendKeys(Todateinput, "3",driver);
        localHelper.sendKeys(Todateinput, String.valueOf(Keys.ENTER),driver);
        localHelper.scrollIntoView(clickonrequestbutton,driver);
        localHelper.clickElement(clickonrequestbutton,driver);
        localHelper.verifyElement(By.className("pending-request-card-wrapperr"),driver);
    }

    public void openemployeeforaction()
    {
        localHelper.clickElement(openemployee,driver);
    }

    public void declinetimeoffrequest(boolean urlFlag,String url)
    {
        try {
            localHelper.scrollIntoView(declinebutton, driver);
            localHelper.clickElement(declinebutton, driver);
            localHelper.clickElement(declineconfirmbutton, driver);
        }catch (TimeoutException e){
            if(urlFlag) {
                driver.get(url + prop.getProperty("QA_Timeoff_URL"));
            }else{
                driver.get(url + prop.getProperty("UAT_Timeoff_URL")+uatprop.getProperty("WSE_Through_API_ID"));
            }
            localHelper.scrollIntoView(declinebutton, driver);
            localHelper.clickElement(declinebutton, driver);
            localHelper.clickElement(declineconfirmbutton, driver);
        }
    }
    public void approvetimeoffrequest(boolean urlFlag,String url)
    {
        try{
        localHelper.scrollIntoView(approvebutton,driver);
        localHelper.clickElement(approvebutton,driver);
            localHelper.checkLoader(loader,driver);
    }catch (TimeoutException e){
            if(urlFlag) {
                driver.get(url + prop.getProperty("QA_Timeoff_URL"));
            }else{
                driver.get(url + prop.getProperty("UAT_Timeoff_URL")+uatprop.getProperty("WSE_Through_API_ID"));
            }
            localHelper.scrollIntoView(approvebutton,driver);
            localHelper.clickElement(approvebutton,driver);
    }
    }
    public void verifySuccessMessage() throws InterruptedException {
        localHelper.verifyElement(successMessage, driver);

    }
    public void cancelapprovedtimeoffrequest()
    {
        localHelper.scrollIntoView(cancelbutton,driver);
        localHelper.clickElement(cancelbutton,driver);
        localHelper.checkLoader(loader,driver);
    }
    private static final Random random = new Random();

    public static List<LocalDate> generateDatesExcludingWeekends(int numberOfDates) {

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        List<LocalDate> dates = new ArrayList<>();
        for (int i = 0; i < numberOfDates; i++) {

            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                dateone = date.format(formatter);
                System.out.println(dateone);
            } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                dateone = date.format(formatter);
                System.out.println(dateone);
            }
            dates.add(date);
        }
        dateone = date.format(formatter);
        return dates;
    }
    public static List<LocalDate> generateDatesExcludingWeekends(int numberOfDates,int plusnumbers) {
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM uuuu");
        LocalDate date = currentDate.plusDays(random.nextInt(plusnumbers));
        List<LocalDate> dates = new ArrayList<>();
        for (int i = 0; i < numberOfDates; i++) {

            if (date.getDayOfWeek() == DayOfWeek.SATURDAY) {
                date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                dateone = date.format(formatter);
                System.out.println(dateone);
            } else if (date.getDayOfWeek() == DayOfWeek.SUNDAY) {
                date = date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)).with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                dateone = date.format(formatter);
                System.out.println(dateone);
            }
            dates.add(date);
        }
        dateone = date.format(formatter);
        System.out.println(dates);
        return dates;
    }

}
