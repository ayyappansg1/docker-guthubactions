package pages.common;

import helper.LocalHelper;
import objectRepo.commonRepo.TimeOff;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimeOff_Page extends TimeOff {

    protected static final Logger logger = LoggerFactory.getLogger(TimeOff_Page.class);
    private final LocalHelper localHelper = new LocalHelper();
    private final WebDriver driver;

    public TimeOff_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void clickNextButton(){
        if(localHelper.checkLoader(atlas_Loader,driver)){
            localHelper.scrollIntoView(next_btn,driver);
            localHelper.clickElement(next_btn,driver);
        }
    }

}
