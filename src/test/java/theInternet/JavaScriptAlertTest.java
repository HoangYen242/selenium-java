package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.JavaScriptAlertPage;

public class JavaScriptAlertTest extends BaseTest {
    JavaScriptAlertPage javaScriptAlertPage;

    @BeforeClass
    void openBrowser() {
        Browser.launch("chrome");
        javaScriptAlertPage = new JavaScriptAlertPage();
    }

    @BeforeMethod
    void setUp() {
        javaScriptAlertPage.open();
    }


    @Test
    void shouldAcceptJSAlert() {
        javaScriptAlertPage.clickForJSAlertButton();
        javaScriptAlertPage.acceptAlert();
        Assert.assertEquals(javaScriptAlertPage.getResultMessage()
                , "You successfully clicked an alert");
    }

    @Test
    void shouldDetectMismatchInJSAlert() {
        javaScriptAlertPage.clickForJSAlertButton();
        javaScriptAlertPage.acceptAlert();
        Assert.assertNotEquals(javaScriptAlertPage.getResultMessage(), "You successfully clicked an alert.");
    }

    @DataProvider
    Object[][] confirmActions() {
        return new Object[][]{
                {"accept", "You clicked: Ok"},
                {"dismiss", "You clicked: Cancel"}
        };
    }

    @DataProvider
    Object[][] invalidActions() {
        return new Object[][]{
                {"accept", "You clicked: Cancel"},
                {"dismiss", "You clicked: OK"}
        };
    }

    @Test(dataProvider = "confirmActions")
    void shouldHandleJSConfirmCorrectly(String action, String expectedMessage) {
        javaScriptAlertPage.clickForJSConfirmButton();

        if (action.equals("accept")) {
            javaScriptAlertPage.acceptAlert();
        } else if (action.equals("dismiss")) {
            javaScriptAlertPage.dismissAlert();
        }

        Assert.assertEquals(javaScriptAlertPage.getResultMessage()
                , expectedMessage
                , "Result message " + action + " is incorrect.");
    }

    @Test(dataProvider = "invalidActions")
    void shouldDetectMismatchInJSConfirm(String action, String expectedMessage) {
        javaScriptAlertPage.clickForJSConfirmButton();

        if (action.equals("accept")) {
            javaScriptAlertPage.acceptAlert();
        } else if (action.equals("dismiss")) {
            javaScriptAlertPage.dismissAlert();
        }

        Assert.assertNotEquals(javaScriptAlertPage.getResultMessage()
                , expectedMessage
                , "Unexpected result message for " + action);
    }

    @DataProvider
    Object[][] promptData() {
        return new Object[][]{
                {"Hello", "accept", "You entered: Hello"},
                {"Hello", "dismiss", "You entered: null"},
                {"", "accept", "You entered:"},
                {"", "dismiss", "You entered: null"},
                {"chào", "accept", "You entered: chào"},
                {"@#$", "accept", "You entered: @#$"},
                {"\uD83D\uDE0A", "accept", "You entered: \uD83D\uDE0A"},
        };
    }

    @DataProvider
    Object[][] promptFailData() {
        return new Object[][]{
                {"Hello", "accept", "You entered: hello"},
                {"Hello", "dismiss", "You entered:"},
                {"", "dismiss", "You entered: hi"},
                {"", "dismiss", "You entered:"}
        };
    }

    @Test(dataProvider = "promptData")
    void shouldHandleJSPromptInputCorrectly(String text, String action, String expectedMessage) {
        javaScriptAlertPage.clickForJSPromptButton();
        javaScriptAlertPage.enterTextInPrompt(text);

        if (action.equals("accept")) {
            javaScriptAlertPage.acceptAlert();
        } else if (action.equals("dismiss")) {
            javaScriptAlertPage.dismissAlert();
        }

        Assert.assertEquals(javaScriptAlertPage.getResultMessage()
                , expectedMessage
                , "Result message " + action + " is incorrect.");

    }

    @Test(dataProvider = "promptFailData")
    void shouldDetectMismatchInJSPrompt(String text, String action, String expectedMessage) {
        javaScriptAlertPage.clickForJSPromptButton();
        javaScriptAlertPage.enterTextInPrompt(text);

        if (action.equals("accept")) {
            javaScriptAlertPage.acceptAlert();
        } else if (action.equals("dismiss")) {
            javaScriptAlertPage.dismissAlert();
        }

        Assert.assertNotEquals(javaScriptAlertPage.getResultMessage()
                , expectedMessage
                , "Unexpected result for: " + action);
    }

    @DataProvider
    Object[][] promptActions(){
        return new Object[][]{
                {"Hello", Keys.ENTER, "You entered: Hello"},
                {"Hello", Keys.ESCAPE, "You entered: null"},
                {"", Keys.ENTER, "You entered:"},
                {"", Keys.ESCAPE, "You entered: null"},

        };
    }

    @Test(dataProvider = "promptActions")
    void shouldHandleJSPromptInputWithKeyBoardCorrectly(String text, CharSequence key, String expectedMessage) {
        javaScriptAlertPage.clickForJSPromptButton();
        javaScriptAlertPage.enterTextInPrompt(text);

        Browser.pressKeyOnAlert(key);

        Assert.assertEquals(javaScriptAlertPage.getResultMessage(), expectedMessage, "Result message " + key + " is incorrect.");
    }
}

