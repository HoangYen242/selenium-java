package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DynamicLoadingPage;

public class DynamicLoadingTest extends BaseTest {
    DynamicLoadingPage dynamicLoadingPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        dynamicLoadingPage = new DynamicLoadingPage();
        dynamicLoadingPage.open();
    }

    @BeforeMethod
    void setUp() {
        dynamicLoadingPage.open();
    }

    @DataProvider(name = "dynamicData")
    Object[][] data() {
        return new Object[][]{
                {"Hello World!", true},
                {"Hello", false}
        };
    }

    @Test(dataProvider = "dynamicData")
    void elementIsHidden(String expectedResult, boolean shouldMatch) {
        dynamicLoadingPage.clickStartButton();

        String actual = dynamicLoadingPage.getResult();
        if (shouldMatch) {
            Assert.assertEquals(actual, expectedResult, "Expected text should match");
        } else {
                Assert.assertNotEquals(actual, expectedResult, "Negative case: result should not match");
        }
    }
}
