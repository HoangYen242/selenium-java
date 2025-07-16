package calculator;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.BodyMassIndexPage;

public class BodyMassIndexTest extends BaseTest {
    BodyMassIndexPage bodyMassIndexPage;

    @Parameters ({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        bodyMassIndexPage = new BodyMassIndexPage();
        bodyMassIndexPage.open();
    }

    @BeforeMethod
    void setUp() {
        bodyMassIndexPage.selectMetricTab();
        bodyMassIndexPage.clearForm();
    }

    @DataProvider
    Object[][] data() {
        return new Object[][]{
                {"26", "male", "180", "65", "20.1"},
                {"32", "male", "150", "65", "28.9"},
                {"30", "female", "170", "65", "22.5"},
        };
    }

    @Test(dataProvider = "data")
    void tc01(String age, String gender, String height, String weight, String expectedResult) {
        bodyMassIndexPage.fillCalculatorForm(age, gender, height, weight);
        Assert.assertEquals(bodyMassIndexPage.getResult(), expectedResult);
    }

}

