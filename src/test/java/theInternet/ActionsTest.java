package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HoversPage;

public class ActionsTest extends BaseTest {
    HoversPage hoversPage;
    @BeforeClass
    void openBrowser(){
        Browser.launch("chrome");
        hoversPage = new HoversPage();
        hoversPage.open();
    }
    @Test
    void shouldHoverOnAllAvatars() throws InterruptedException {
       hoversPage.hoverOnAllAvatars();
    }

    @Test
    void contextClickOnRectangle(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/context_menu");

        Actions mouse = new Actions(driver);
        mouse
                .contextClick(driver.findElement(By.id("hot-spot")))
                .perform();
        driver.switchTo().alert().accept();
    }

    @Test
    void keyPress() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/key_presses?");

        Actions keyboard = new Actions(driver);

        keyboard.sendKeys("A").perform();
        Thread.sleep(1000);

        keyboard.sendKeys("B").perform();
        Thread.sleep(1000);

        keyboard.sendKeys("C").perform();
        Thread.sleep(1000);

        keyboard.sendKeys("D").perform();
        Thread.sleep(1000);
    }
}
