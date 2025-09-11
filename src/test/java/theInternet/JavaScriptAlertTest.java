package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest extends BaseTest {
    JavaScriptAlertPage javaScriptAlertPage;

    @BeforeClass
    void openBrowser(){
        Browser.launch("chrome");
        javaScriptAlertPage = new JavaScriptAlertPage();
    }

    @BeforeMethod
    void setUp(){
        javaScriptAlertPage.open();
    }

    @Test
    void jsAlert(){
        javaScriptAlertPage.clickForJSAlert();
        javaScriptAlertPage.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResult(),"You successfully clicked an alert");
    }

    @Test
    void jsConfirm(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

//        driver.switchTo().alert().accept();//OK
//        String successMessage = driver.findElement(By.id("result")).getText();
//        Assert.assertEquals(successMessage,"You clicked: Ok");

        driver.switchTo().alert().dismiss();//cancel
        String cancelMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(cancelMessage,"You clicked: Cancel");

    }

    @Test
    void jsCPrompt(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("Hello");

        driver.switchTo().alert().accept();
        String resultMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(resultMessage,"You entered: Hello");


    }
}
