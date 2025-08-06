package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.DropdownSinglePage;

public class DropdownSingleSelectTest extends BaseTest {
    DropdownSinglePage dropdownPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        dropdownPage = new DropdownSinglePage();
        dropdownPage.open();
    }

    @Test
    void selectOptionSuccessfully() {
        if (dropdownPage.isDropdownMultiple()) {
            System.out.println("Able select multiple options");
        } else {
            System.out.println("Select only 1 option");
        }

        dropdownPage.selectAnOption("Option 1");
        Assert.assertTrue(dropdownPage.getResult("Option 1"));

        dropdownPage.selectAnOption("Option 2");
        Assert.assertTrue(dropdownPage.getResult("Option 2"));

    }
}
