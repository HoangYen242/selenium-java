package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.NestFramesPage;

public class NestFramesTest extends BaseTest {
    NestFramesPage nestFramePage;
    @BeforeClass
    void openBrowser(){
        Browser.launch("chrome");
        nestFramePage = new NestFramesPage();
        nestFramePage.open();
    }

    @BeforeMethod
    void setUp(){
        nestFramePage.open();
    }

    @Test
    void testNestFrames() {
        nestFramePage.switchToFrameByName("frame-top");
        nestFramePage.switchToFrameByName("frame-left");
        Assert.assertEquals(nestFramePage.getFrameBodyText(), "LEFT");

        nestFramePage.switchToTopParent();

        nestFramePage.switchToFrameByName("frame-middle");
        Assert.assertEquals(nestFramePage.getMiddleFrameText(), "MIDDLE");

        nestFramePage.switchToTopParent();

        nestFramePage.switchToFrameByName("frame-right");
        Assert.assertEquals(nestFramePage.getFrameBodyText(), "RIGHT");

        nestFramePage.switchToTopParent();

        nestFramePage.switchToOriginSession();

        nestFramePage.switchToFrameByName("frame-bottom");
        Assert.assertEquals(nestFramePage.getFrameBodyText(), "BOTTOM");
    }
}
