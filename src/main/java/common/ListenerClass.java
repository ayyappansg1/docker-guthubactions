package common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass implements ITestListener {

    protected static final Logger logger = LoggerFactory.getLogger(ListenerClass.class);
    public ListenerClass(){
        //        // Initialization code, if needed
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("Test case started : "+context.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        logger.error("Test case Failed : "+result.getMethod());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.error("Test case Skipped : "+result.getMethod());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }


    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        logger.info("Test case Passed : "+result.getMethod());
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("Execution finished ");
    }
}

