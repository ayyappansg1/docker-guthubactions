package helper;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Time;
import java.time.Duration;
import java.util.*;

public class LocalHelper {

    public static int timeOutInSeconds = 50;
    public static int minTime = 10;
    public static int avgTime = 30;
    protected static final Logger logger = LoggerFactory.getLogger(LocalHelper.class);
    protected static List<WebElement> elementList;

    public void clickElement(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element, driver);
        try {
            driver.findElement(element).click();
        } catch (NoSuchElementException | TimeoutException e) {
            logger.error("Error found on click Element.");
            logger.error(e.getMessage());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            highlightElement(element, driver);
            driver.findElement(element).click();
        } catch (ElementClickInterceptedException e) {
            logger.error("Error found on click Element : ElementClickInterceptedException");
            logger.info("Element : ");
            logger.info(String.valueOf(element));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            try {
                highlightElement(element, driver);
                jsExecutorClick(element, driver);
            } catch (JavascriptException q) {
                logger.info("Inside javascriptException.Checking by Mouse hover and click");
                highlightElement(element, driver);
                mouseHoverAndClick(element, driver);
            }
        }
    }

    public void normalClick(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try {
            highlightElement(element, driver);
            driver.findElement(element).click();
        } catch (NoSuchElementException | TimeoutException e) {
            logger.error("Error found on click Element.");
            logger.error(e.getMessage());
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            wait.until(ExpectedConditions.elementToBeClickable(element));
            highlightElement(element, driver);
            driver.findElement(element).click();
        }
    }

    public void mouseHoverAndClick(By element, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        highlightElement(element, driver);
        WebElement elements = driver.findElement(element);
        Actions actions = new Actions(driver);
        actions.moveToElement(elements).click().perform();

    }

    public void clearElement(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = driver.findElement(element_by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        highlightElement(element_by, driver);
        element.clear();
    }

    public boolean verifyElement(By element, WebDriver driver) throws InterruptedException {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            //Thread.sleep(10000);
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            WebElement ele = wait.until(ExpectedConditions.presenceOfElementLocated(element));
            highlightElement(element, driver);

            return ele.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }


    public boolean verifyElement(By element, int Time, WebDriver driver) {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
            return driver.findElement(element).isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void simpleSendKeys(By element_by, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        highlightElement(element_by, driver);
        driver.findElement(element_by).click();
        // driver.findElement(element_by).sendKeys(text);
    }

    public void simpleSendKeysAnother(By element_by, String text, WebDriver driver) {
        highlightElement(element_by, driver);
        driver.findElement(element_by).sendKeys(text);
    }

    public void highlightElement(By element_by, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 4px solid red;');", driver.findElement(element_by));

    }

    public void getParticularTextFromDropdown(By element_by, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        elementList = driver.findElements(element_by);
        for (WebElement webElement : elementList) {
            if (webElement.getText().contains(text)) {
                try {
                    webElement.click();
                } catch (ElementClickInterceptedException e) {
                    jsExecutorClickUsingWebElement(webElement, driver);
                }
                break;
            }
        }
        logger.info("Get one random element");

    }

    public void sendKeys(By element_by, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        try {
            highlightElement(element_by, driver);
            WebElement element = driver.findElement(element_by);
            try {
                wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
                highlightElement(element_by, driver);
            } catch (NoSuchElementException | TimeoutException e) {
                logger.error("No such element exception or Time out exception  on sendKeys");
                wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
                highlightElement(element_by, driver);
                logger.info("We found the element on second time");
            }
            try {
                wait.until(ExpectedConditions.elementToBeClickable(element_by));
                element.click();
            } catch (ElementClickInterceptedException e) {
                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
                wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
                wait2.until(ExpectedConditions.elementToBeClickable(element_by));
                scrollIntoView(element_by, driver);
                jsExecutorClick(element_by, driver);
            }
            try {
                element.clear();
                element.sendKeys(text);
            } catch (NoSuchElementException | TimeoutException e) {
                logger.error("Time out Exception or no such element exception found on ");
                logger.info(String.valueOf(element_by));
                wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
                element.clear();
                element.sendKeys(text);
            } catch (ElementNotInteractableException e) {
                logger.error("Element Not Interactable exception.Trying to send value through java script executor");
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].value = '" + text + "';", driver.findElement(element_by));
            }
        } catch (NoSuchElementException e) {
            logger.info("Send Keys - No such element exception");
            WebElement element = driver.findElement(element_by);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }

    public void simpleSendKeysNew(By element, String text, WebDriver driver) {
        highlightElement(element, driver);
        driver.findElement(element).sendKeys(text);
    }

    public void sendKeywWithClearText(By element_by, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        WebElement element = driver.findElement(element_by);
        //element.click();
    /*Actions action=new Actions(driver);
    action.click(element).perform();*/
        logger.info("Before Clearing using Java script executor");
        clearUsingJavaScript(element, driver);
        element.sendKeys(text);
    }

    public void clearUsingJavaScript(WebElement element, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = '';", element);

    }

    public String getText(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
            WebElement element = driver.findElement(element_by);
            highlightElement(element_by, driver);
            return element.getText();
        } catch (NoSuchElementException | TimeoutException e) {
            logger.error("Time out exception or No such element exception");
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait2.until(ExpectedConditions.visibilityOfElementLocated(element_by));
            WebElement element = driver.findElement(element_by);
            highlightElement(element_by, driver);
            return element.getText();
        }
    }

    public String getTextWithWaitForParticularText(By element_by, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = driver.findElement(element_by);
        wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        highlightElement(element_by, driver);

        return element.getText();
    }

    public List<String> getAllText(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        List<String> li = new LinkedList<>();
        List<WebElement> element = driver.findElements(element_by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        for (WebElement ele : element) {
            try {
                li.add(ele.getText());
            } catch (StaleElementReferenceException e) {
                li.add(ele.getText());
            }
        }
        return li;
    }

    public List<String> descendingOrderList(List<String> li) {
        List<String> newList = new LinkedList<>();
        newList.addAll(li);
        Collections.sort(newList, Collections.reverseOrder());
        return newList;
    }

    public void dropDownSelectByText(By element_by, String text, WebDriver driver) {
        WebElement element = driver.findElement(element_by);
        Actions actions = new Actions(driver);
        element.click();
        actions.sendKeys(text).sendKeys(Keys.chord(Keys.ENTER)).perform();
    }

    public void checkDropdownValues(By element_by, String dropdownValues, WebDriver driver) {
        WebElement element = driver.findElement(element_by);
        Select select = new Select(element);
        String[] valueArray = dropdownValues.split(",");
        List<WebElement> options = select.getOptions();
        for (WebElement value : options) {
            for (String s : valueArray) {
                if (!value.getText().equals(s)) {
                    logger.info("Value not found in dropdown :");
                    logger.info(String.valueOf(value));
                }
            }
        }
    }

    public void waitForPageURL(String url, WebDriver driver) {
        new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.urlContains(url));
    }

    public void jsExecutorClick(By element_by, WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        wait.until(ExpectedConditions.elementToBeClickable(element_by));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        highlightElement(element_by, driver);
        WebElement element = driver.findElement(element_by);
        js.executeScript("arguments[0].click()", element);
        logger.info("Button clicked using Js Executor");
    }

    public void jsExecutorClickUsingWebElement(WebElement element_by, WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element_by);
        logger.info("Button clicked using Js Executor");
    }

    public void jsExecutorSendValue(By element_by, String Value, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        WebElement element = driver.findElement(element_by);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        element.sendKeys(Value);
    }

    public void multipleClicks(By element_by, WebDriver driver) {
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element_by));
        wait.until(ExpectedConditions.elementToBeClickable(element_by));

        List<WebElement> element = driver.findElements(element_by);
        for (WebElement ClickElement : element) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", ClickElement);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click()", ClickElement);
        }
    }

    public void selectDropdownByVisibleText(By element_by, String Value, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        WebElement element = driver.findElement(element_by);
        Select select = new Select(element);
        select.selectByVisibleText(Value);
    }

    public boolean verifyEnabledElement(By element_by, WebDriver driver) throws TimeoutException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        return driver.findElement(element_by).isEnabled();
    }

    public void pressTabKey(By element_by, WebDriver driver) throws InterruptedException {
        WebElement element = driver.findElement(element_by);
        // element.click();
        jsExecutorClick(element_by, driver);
        Thread.sleep(2000);
        new Actions(driver).sendKeys(Keys.chord(Keys.TAB)).perform();
    }

    public void scrollIntoView(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        WebElement element = driver.findElement(element_by);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoViewIfNeeded();", element);
        wait.until(ExpectedConditions.elementToBeClickable(element_by));
    }

    public void waitUntilElementPresent(By element_by, WebDriver driver) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
            wait.until(ExpectedConditions.elementToBeClickable(element_by));
            highlightElement(element_by, driver);
        } catch (NoSuchElementException | TimeoutException e) {
            logger.info("Element is not at all clickable");
        }
    }

    public String getAttributeValue(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        return driver.findElement(element_by).getAttribute("value");
    }

    public void sendTextByCharacter(By element_by, String sendChar, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));

        for (int i = 0; i <= sendChar.length() - 1; i++) {
            StringBuilder sb = new StringBuilder();
            driver.findElement(element_by).sendKeys(sb.append(sendChar.charAt(i)).toString());
        }
    }

    public WebElement getRandomElement(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.visibilityOfElementLocated(element_by));
        elementList = driver.findElements(element_by);
        int eleSize = elementList.size();
        // logger.info("Element size: "+String.valueOf(eleSize));
        if (eleSize == 1) {
            if (elementList.get(0).getText().equalsIgnoreCase("No options") || elementList.get(0).getText().contains("Loading")) {
                logger.info("No option or loading found in the drop-down");
                wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(element_by));
                elementList = driver.findElements(element_by);
            }
            logger.info("The dropdown is showing only one value");
            return elementList.get(new Random().nextInt(eleSize));
        }
        logger.info("Get one random element");
        return elementList.get(new Random().nextInt(eleSize));

    }

    public Boolean checkLoader(By element_by, WebDriver driver, String loader_txt) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            return wait.until(ExpectedConditions.invisibilityOfElementWithText(element_by, loader_txt));
        } catch (NoSuchElementException | TimeoutException e) {
            return true;
        }
    }

    public Boolean checkLoader(By element_by, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        try {
            return wait.until(ExpectedConditions.invisibilityOfElementLocated(element_by));
        } catch (TimeoutException e) {
            logger.error("The page takes very long time to load");
            WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
            return wait2.until(ExpectedConditions.invisibilityOfElementLocated(element_by));
        } catch (NoSuchElementException e) {
            return true;
        }

    }

    public void get(String url, WebDriver driver) {
        driver.get(url);
    }

    public void switchTab(WebDriver driver) {
        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(0));
    }

    public boolean checkElement(By element, WebDriver driver) {
        return driver.findElement(element).isEnabled();
    }

    public void closeTab(WebDriver driver) {
        driver.close();
    }

    public void hardRefresh(WebDriver driver) {
        driver.manage().deleteAllCookies();
        ((JavascriptExecutor) driver).executeScript("location.reload(true);");
        logger.info("Cache removed");
        driver.navigate().refresh();
    }


    public void getParticularTextFromDropdownCheckBox(By firstDrowdown, String particularText, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.presenceOfElementLocated(firstDrowdown));
        List<WebElement> elements = driver.findElements(firstDrowdown);
        for (WebElement ele : elements) {
            if (ele.getText().equalsIgnoreCase(particularText)) {
                logger.info("the Option is " + ele.getText());
                WebElement elem = ele.findElement(By.xpath("span"));
                wait.until(ExpectedConditions.elementToBeClickable(elem));
                jsExecutorClickUsingWebElement(elem, driver);
                break;
            }
        }
    }

    public boolean checkParticularTextPresentInList(By element, String text, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.presenceOfElementLocated(element));

        List<WebElement> elements = driver.findElements(element);
        for (WebElement ele : elements) {
            try {
                wait.until(ExpectedConditions.textToBePresentInElement(ele, text));
                if (!ele.getText().contains(text)) {
                    logger.info("That Text is " + ele.getText());
                    return false;
                }
            } catch (StaleElementReferenceException e) {
                logger.info("Inside StaleElement Reference Exception");

                try {
                    if (!ele.getText().contains(text)) {
                        return false;
                    }
                } catch (StaleElementReferenceException m) {
                    logger.info("Inside another StaleElement Reference Exception");

                    if (!ele.getText().contains(text)) {
                        return false;
                    }
                }
            } catch (TimeoutException m) {
                logger.info("Inside timeout Exception");
                try {
                    if (ele.getText().contains(text)) {
                        return true;
                    } else {
                        return false;
                    }
                } catch (StaleElementReferenceException e) {
                    if (ele.getText().contains(text)) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean checkTimeoffTypeShowingInListingPage(By element, String text, WebDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
        List<WebElement> elements = driver.findElements(element);
        checkLoader(By.xpath("//div[@id='atlas-full-loader']"),driver);

        try {
            for (WebElement ele : elements) {
                if (!ele.getText().contains(text)) {
                    logger.info("That Text is " + ele.getText());
                    return false;
                }
            }
            return true;
        }catch (StaleElementReferenceException e){
            elements = driver.findElements(element);
            for (WebElement ele : elements) {
                if (!ele.getText().contains(text)) {
                    logger.info("Text not found in element: " + ele.getText());
                    wait.until(ExpectedConditions.textToBePresentInElement(ele,text));
                    return false;
                }
            }
            return true;
        }catch (TimeoutException ex) {
            // Handle other exceptions
            logger.debug("No idea may be again Stale element");
            return false;
        }

    }
        public boolean checkTwoTextPresentInTheList(By element, String text1, String text2, WebDriver driver){
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.presenceOfElementLocated(element));
            boolean presentOrNotStatus = false;
            List<WebElement> elements = driver.findElements(element);
            for (WebElement ele : elements) {
                try {
                    if (ele.getText().contains(text1) || ele.getText().contains(text2)) {
                        logger.info("That Text is " + ele.getText());
                        presentOrNotStatus = true;
                    } else {
                        presentOrNotStatus = false;
                    }
                } catch (StaleElementReferenceException e) {
                    if (ele.getText().contains(text1) || ele.getText().contains(text2)) {
                        logger.info("That Text is " + ele.getText());
                        presentOrNotStatus = true;
                    } else {
                        presentOrNotStatus = false;
                    }
                } catch (TimeoutException m) {
                    presentOrNotStatus = false;
                }
            }
            return presentOrNotStatus;
        }

        public void clickDuplicateButtonBasedOnParticularText (String text, WebDriver driver){
            String elementName = "//span[text()='" + text + "']//following-sibling::span//div[@class='action-item']/*[local-name()='svg']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
            highlightElement(By.xpath(elementName), driver);
            clickElement(By.xpath(elementName), driver);
        }
        public void clickDeActivateButtonBasedOnParticularText (String text, WebDriver driver){
            String elementName = "//span[text()='" + text + "']//following-sibling::span//div[@data-testid=\"action-switch\"]//span[@class='slider round']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
            highlightElement(By.xpath(elementName), driver);
            clickElement(By.xpath(elementName), driver);
        }
        public void clickActivateButtonBasedOnParticularText (String text, WebDriver driver){
            String elementName = "//span[text()='" + text + "']//following-sibling::span//div[@data-testid=\"action-switch\"]//span[@class='slider round']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
            highlightElement(By.xpath(elementName), driver);
            clickElement(By.xpath(elementName), driver);
        }
        public boolean checkDeleteIconDisplayed (String text, WebDriver driver)throws InterruptedException {
            String elementName = "//span[text()='" + text + "']//following-sibling::span//div[@data-testid='delete-action']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
            highlightElement(By.xpath(elementName), driver);
            return verifyElement(By.xpath(elementName), driver);
        }
        public boolean checkDeleteIconNotDisplayed (String text, WebDriver driver)throws InterruptedException {
            String elementName = "//span[text()='" + text + "']//following-sibling::span//div[@data-testid='delete-action']";
            return waitTillElementDisappears(By.xpath(elementName), driver);
        }
        public boolean waitTillElementDisappears (By element, WebDriver driver)throws InterruptedException {
            try {
                //driver.manage().timeouts().implicitlyWait(avgTime, TimeUnit.SECONDS);
                //Thread.sleep(10000);
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
                wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
                return driver.findElement(element).isDisplayed();
            } catch (NoSuchElementException | TimeoutException e) {
                logger.info("Im here.May be because of No such element expection or timeout exception");
                return true;
            }
        }

        public void clickDeleteButtonBasedOnParticularText (String policyName, WebDriver driver){
            String elementName = "//span[text()='" + policyName + "']//following-sibling::span//div[@data-testid='delete-action']//*[local-name()='svg']";
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementName)));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(elementName)));
            highlightElement(By.xpath(elementName), driver);
            clickElement(By.xpath(elementName), driver);
        }

        public boolean checkPolicyDeleted (String text, WebDriver driver)throws InterruptedException {
            String elementName = "//span[text()='" + text + "_Copy']";
            return waitTillElementDisappears(By.xpath(elementName), driver);
        }
    }
