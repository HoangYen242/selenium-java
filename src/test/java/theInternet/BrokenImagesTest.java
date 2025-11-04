package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class BrokenImagesTest {
    @Test
    void shouldVerifyBrokenImages() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");

        List<WebElement> images = driver.findElements(By.tagName("img"));
        int imgBrokenCount = 0;

        for (WebElement img : images) {
            Long width = (Long) ((JavascriptExecutor) driver)
                    .executeScript("return arguments[0].naturalWidth;", img);
            if(width==0){
                imgBrokenCount++;
                System.out.println("Broken: " + img.getAttribute("src"));
            }else {
                System.out.println("OK: " + img.getAttribute("src"));
            }
        }
        System.out.println("Total number of broken images: " + imgBrokenCount);

//        Assert.assertTrue(imgBrokenCount > 0, "No broken images were detected.");
        Assert.assertEquals(imgBrokenCount, 2, "No broken images were detected.");
    }
}
