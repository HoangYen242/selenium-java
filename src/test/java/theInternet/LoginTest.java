package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser) {
        Browser.launch(browser);
        loginPage = new LoginPage();
        loginPage.open();
    }

    @DataProvider(name= "validLoginData")
    Object[][] validLoginData() {
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "Welcome to the Secure Area. When you are done click logout below." },
        };
    }

    @DataProvider(name= "invalidLoginData")
    Object[][] invalidLoginData(){
        return new Object[][]{
                {"Tomsmith", "SuperSecretPassword!", "Your username is invalid!" },
        };
    }

    @DataProvider(name="redirectURLData")
    Object[][] redirectURLData(){
        return new Object[][]{
                {"tomsmith", "SuperSecretPassword!", "https://the-internet.herokuapp.com/secure" }
        };
    }

    @Test(dataProvider = "validLoginData")
    void testValidCredentials(String username, String password, String expectedResult) {
        loginPage.enterCredentials(username, password);
        Assert.assertEquals(loginPage.getSuccessResult(), expectedResult);
    }

    @Test(dataProvider = "invalidLoginData")
    void testInvalidCredentials(String username, String password, String expectedResult) {
        loginPage.enterCredentials(username, password);
        Assert.assertTrue(loginPage.getErrorResult().contains(expectedResult));
    }

    @Test(dataProvider = "redirectURLData")
    void testValidLoginRedirect(String username, String password, String expectedUrl){
        loginPage.enterCredentials(username, password);
        String currentUrl = loginPage.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }
}
