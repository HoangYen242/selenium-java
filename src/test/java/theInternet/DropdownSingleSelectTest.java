package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.DropdownSinglePage;

public class DropdownSingleSelectTest extends BaseTest {
    DropdownSinglePage dropdownSinglePage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        dropdownSinglePage = new DropdownSinglePage();
        dropdownSinglePage.open();
    }

    @BeforeMethod
    void setUp(){
        dropdownSinglePage.open();
    }

    @DataProvider(name = "dropdownData")
    Object[][] data(){
        return new Object[][]{
                {"Option 1", "Option 1"},
                {"Option 2", "Option 2"}
        };
    }

    @Test(dataProvider = "dropdownData")
    void selectOptionSuccessfully(String text, String expectedResult) {
        if (dropdownSinglePage.isDropdownMultiple()) {
            System.out.println("Able select multiple options");
        } else {
            System.out.println("Select only 1 option");
        }

        dropdownSinglePage.selectAnOption(text);
        Assert.assertTrue(dropdownSinglePage.getResult(expectedResult));

    }
}
