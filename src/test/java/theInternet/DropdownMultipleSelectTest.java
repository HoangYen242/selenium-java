package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DropdownMultiplePage;

import java.util.List;

public class DropdownMultipleSelectTest extends BaseTest {
    DropdownMultiplePage dropdownMultiplePage;

    @BeforeClass
    void openBrowser() {
        Browser.launch("chrome");
        dropdownMultiplePage = new DropdownMultiplePage();
        dropdownMultiplePage.open();
    }

    @Test
    void selectMultipleOptionSuccessfully() {
        if (dropdownMultiplePage.isDropdownMultiple()) {
            System.out.println("Able select multiple options");
        } else {
            System.out.println("Select only 1 option");
        }

        dropdownMultiplePage.selectMultipleOptions("Banana");
        dropdownMultiplePage.selectMultipleOptions("Apple");
        dropdownMultiplePage.selectMultipleOptions("Orange");

        List<String> selectedBefore = dropdownMultiplePage.getSelectOptions();
        Assert.assertTrue(selectedBefore.containsAll(List.of("Banana", "Apple", "Orange")));

        dropdownMultiplePage.deselectOption("Apple");
        List<String> selectedAfter = dropdownMultiplePage.getSelectOptions();
        Assert.assertTrue(selectedAfter.contains("Banana"));
        Assert.assertTrue(selectedAfter.contains("Orange"));
        Assert.assertFalse(selectedAfter.contains("Apple"));
    }
}
