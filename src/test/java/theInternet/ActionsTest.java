package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HoversPage;
import pages.KeyPressesPage;
import pages.RightClickPage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class ActionsTest extends BaseTest {
    HoversPage hoversPage;
    RightClickPage rightClickPage;
    KeyPressesPage keyPressPage;


    @BeforeClass
    void openBrowser() {
        Browser.launch("chrome");
        hoversPage = new HoversPage();
        rightClickPage = new RightClickPage();
        keyPressPage = new KeyPressesPage();
    }

    @BeforeMethod
    void setUp(Method method) {
        Test testAnnotation = method.getAnnotation(Test.class);
        if (Arrays.asList(testAnnotation.groups()).contains("hovers")) {
            hoversPage.open();
        } else if (Arrays.asList(testAnnotation.groups()).contains("context")) {
            rightClickPage.open();
        } else if (Arrays.asList(testAnnotation.groups()).contains("keypress")) {
            keyPressPage.open();
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

    @DataProvider
    public Object[][] validKeysData() {
        return new Object[][]{
                {"A", "A"},
                {"B", "B"},
                {Keys.SPACE, "SPACE"},
                {Keys.BACK_SPACE, "BACK_SPACE"},
                {Keys.ENTER, "ENTER"}
        };
    }

    @DataProvider
    public Object[][] invalidKeysData() {
        return new Object[][]{
                {"A", "You entered: A"},
                {Keys.SPACE, "You entered: BACK_SPACE"},
                {Keys.BACK_SPACE, "You entered: ENTER"},
        };
    }

    @Test(dataProvider = "validKeysData", groups = "keypress")
    void couldDetectValidKey(CharSequence key, String expectedResult) {
        keyPressPage.pressKey(key);

        String result = keyPressPage.getResult();
        Assert.assertEquals(result, "You entered: " + expectedResult);
    }

    @Test(dataProvider = "invalidKeysData", groups = "keypress")
    void couldIgnoreInvalidKey(CharSequence key, String expectedResult) {
        keyPressPage.pressKey(key);

        String result = keyPressPage.getResult();
        Assert.assertNotEquals(result, expectedResult,"Unexpected result for key: " + key);
    }
}
