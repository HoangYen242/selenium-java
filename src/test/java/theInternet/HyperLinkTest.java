package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.HyperLinkPage;

public class HyperLinkTest extends BaseTest {
    HyperLinkPage hyperLinkPage;

    @Parameters({"browser"})
    @BeforeClass
    void openBrowser(String browser){
        Browser.launch(browser);
        hyperLinkPage = new HyperLinkPage();
        hyperLinkPage.open();
    }

    @BeforeMethod
    void setUp(){
        hyperLinkPage.open();
    }

    @DataProvider(name= "hyperlinkData")
    Object[][] data(){
        return new  Object[][]{
                {"200", "https://the-internet.herokuapp.com/status_codes/200", "https://the-internet.herokuapp.com/status_codes"},
                {"301", "https://the-internet.herokuapp.com/status_codes/301", "https://the-internet.herokuapp.com/status_codes"},
        };
    }

    @Test(dataProvider = "hyperlinkData")
    void canNavigateBackViaHereLink(String code, String expectedURL, String expectedBackURL) {
        hyperLinkPage.openHyperlink(code);
        Assert.assertEquals(hyperLinkPage.getCurrentURL(), expectedURL);

        hyperLinkPage.returnViaHereLink();
        Assert.assertEquals(hyperLinkPage.getCurrentURL(), expectedBackURL);
    }

    @Test(dataProvider = "hyperlinkData")
    void canNavigateBackViaBrowserBack(String code, String expectedURL, String expectedBackURL) {
        hyperLinkPage.openHyperlink(code);
        Assert.assertEquals(hyperLinkPage.getCurrentURL(), expectedURL);

        hyperLinkPage.returnViaBrowserBack();
        Assert.assertEquals(hyperLinkPage.getCurrentURL(), expectedBackURL);
    }
}
