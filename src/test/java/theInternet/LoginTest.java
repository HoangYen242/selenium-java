package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
    @Test
    void withValidCredentialsShouldLoginSuccess(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");

        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");

        driver.findElement(By.cssSelector("button[type=submit]")).click();

        String welcomeMessage = driver.findElement(By.className("subheader")).getText();
        Assert.assertEquals(welcomeMessage, "Welcome to the Secure Area. When you are done click logout below.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");

    }
}
