package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest {
    WebDriver driver;
    WebElement checkbox1;
    WebElement checkbox2;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        checkbox1 = driver.findElement(By.cssSelector("#checkboxes input:first-child"));
        checkbox2 = driver.findElement(By.cssSelector("#checkboxes input:last-child"));
    }

    @Test
    void validateCheckSuccessfully() {
        check(checkbox1);
        Assert.assertTrue(checkbox1.isSelected());

        check(checkbox2);
        Assert.assertTrue(checkbox2.isSelected());
    }

    @Test
    void validateUncheckSuccessfully() {
        uncheck(checkbox1);
        Assert.assertFalse(checkbox1.isSelected());

        uncheck(checkbox2);
        Assert.assertFalse(checkbox2.isSelected());
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

    static void check(WebElement element) {
        if (!element.isSelected()) {
            element.click();
        }
    }

    static void uncheck(WebElement element) {
        if (element.isSelected()) {
            element.click();
        }
    }
}
