package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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

    @DataProvider
    Object[][] confirmActions(){
        return new Object[][]{
                {"accept", "You clicked: Ok"},
                {"dismiss", "You clicked: Cancel"}
        };
    }

    @DataProvider
    Object[][] invalidActions(){
        return new Object[][]{
                {"accept", "You clicked: Ok"},
                {"dismiss", "You clicked: OK"}
        };
    }

    @Test
    void shouldAcceptJSAlert(){
        javaScriptAlertPage.clickForJSAlertButton();
        javaScriptAlertPage.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResultMessage(),"You successfully clicked an alert");
    }

    @Test(dataProvider = "confirmActions")
    void shouldHandleJSConfirmCorrectly(String action, String expectedMessage){
        javaScriptAlertPage.clickForJSConfirmButton();

        if (action.equals("accept")){
            javaScriptAlertPage.acceptAlert();
        }else if (action.equals("dismiss")){
            javaScriptAlertPage.dismissAlert();
        }

        Assert.assertEquals(javaScriptAlertPage.getResultMessage()
                ,expectedMessage
                ,"Result message " + action + " is incorrect.");
    }

    @Test(dataProvider = "invalidActions")
    void shouldDetectMismatchInJSConfirm(String action, String expectedMessage){
        javaScriptAlertPage.clickForJSConfirmButton();

        if (action.equals("accept")){
            javaScriptAlertPage.acceptAlert();
        }else if(action.equals("dismiss")){
            javaScriptAlertPage.dismissAlert();
        }

        Assert.assertNotEquals(javaScriptAlertPage.getResultMessage(), expectedMessage, "Unexpected result message for " + action);
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
