package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HoversPage;
import pages.RightClickPage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ActionsTest extends BaseTest {
    HoversPage hoversPage;
    RightClickPage rightClickPage;

    @BeforeClass
    void openBrowser() {
        Browser.launch("chrome");
        hoversPage = new HoversPage();
        rightClickPage = new RightClickPage();
    }

    @BeforeMethod
    void setUp(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        if (Arrays.asList(testAnnotation.groups()).contains("hovers")) {
            hoversPage.open();
        } else if (Arrays.asList(testAnnotation.groups()).contains("context")) {
            rightClickPage.open();
        }
    }

    @Test(groups = "hovers")
    void shouldHoverOnAllAvatars() throws InterruptedException {
        List<WebElement> avatars = hoversPage.getAvatars();
        for (int i = 0; i < avatars.size(); i++) {
            WebElement avatar = avatars.get(i);
            hoversPage.hoverOnAvatar(avatar);

            String userName = hoversPage.getUsernameText(avatar);
            String profileLink = hoversPage.getProfileLink(avatar);

            System.out.println("Avatar " + (i + 1) + " caption:\n " + userName + "\n" + profileLink);

            Assert.assertEquals(userName, "name: user" + (i + 1));
            Assert.assertEquals(profileLink, "View profile");

//        List<WebElement> avatars = hoversPage.getAvatars();
//
//        for (int i = 0; i < avatars.size(); i++) {
//            WebElement avatar = avatars.get(i);
//            hoversPage.hoverOnAvatar(avatar);
//
//            String caption = hoversPage.getUsernameText(avatar);
//
//            System.out.println("Avatar " + (i + 1) + " caption:\n " + caption);
//
//            Assert.assertTrue(caption.contains("user" + (i + 1))
//                    , "Expected caption to contain user" + (i + 1));

//            Assert.assertTrue(hoversPage.isProfileLinkDisplayed(avatar)
//                    , "Expected 'View profile' link to be displayed for avartar " + (i + 1));
        }


    }

    @Test(groups = "context")
    void shouldClickOnContextRectangle() {
        rightClickPage.rightClickContextArea();

        String alertText = rightClickPage.getAlertText();
        Assert.assertEquals(alertText, "You selected a context menu");

        rightClickPage.acceptAlert();
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
