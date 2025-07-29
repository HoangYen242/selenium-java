package common;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class BaseTest {
    @AfterMethod
    protected void captureScreenShot(ITestResult testResult) {
        if (!testResult.isSuccess()) {
            Browser.captureScreenShot((testResult.getMethod().getMethodName()));
        }
    }

    @AfterClass
    protected void tearDown() {
        Browser.quit();
    }
}
