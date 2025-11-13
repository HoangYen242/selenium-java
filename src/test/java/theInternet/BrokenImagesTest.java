package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BrokenImagesPage;

import java.util.List;

public class BrokenImagesTest extends BaseTest {
    BrokenImagesPage brokenImagesPage;

    @BeforeClass
    void openBrowser(){
        Browser.launch("chrome");
        brokenImagesPage = new BrokenImagesPage();
        brokenImagesPage.open();
    }

    @BeforeMethod
    void setUp(){
        brokenImagesPage.open();
    }

    @Test
    void shouldVerifyBrokenImages() {
        int imgBrokenCount = brokenImagesPage.getBrokenImagesCount();

        System.out.println("Total number of broken images: " + imgBrokenCount);

//        Assert.assertTrue(imgBrokenCount > 0, "No broken images were detected.");
        Assert.assertEquals(imgBrokenCount, 2, "No broken images were detected.");
    }
}
