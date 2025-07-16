package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class JavaScriptAlertTest {
    @Test
    void jsAlert(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        driver.switchTo().alert().accept();//OK
        String resultMessage = driver.findElement(By.id("result")).getText();
        Assert.assertEquals(resultMessage,"You successfully clicked an alert");

    }

    @Test
    void jsConfirm(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();

//        driver.switchTo().alert().accept();
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
