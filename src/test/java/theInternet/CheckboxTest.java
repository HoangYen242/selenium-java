package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.CheckboxPage;

public class CheckboxTest extends BaseTest {
    CheckboxPage checkboxPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser){
        Browser.launch(browser);
        checkboxPage = new CheckboxPage();
        checkboxPage.open();
    }

    @BeforeMethod
    void setUp() {
        checkboxPage.open();
    }

    @Test
    void validateCheckSuccessfully() {
       checkboxPage.checkAllCheckboxes();

       Assert.assertTrue(checkboxPage.isCheckbox1State());
       Assert.assertTrue(checkboxPage.isCheckbox2State());
    }

    @Test
    void validateUncheckSuccessfully() {
       checkboxPage.uncheckAllCheckboxes();

       Assert.assertFalse(checkboxPage.isCheckbox1State());
       Assert.assertFalse(checkboxPage.isCheckbox2State());
    }

}
