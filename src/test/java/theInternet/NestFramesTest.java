package theInternet;

import common.BaseTest;
import common.Browser;
import org.openqa.selenium.NoSuchFrameException;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
    void shouldNavigateThroughAllNestedFrames() {
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

    @Test
    void shouldRetrieveTextUsingDynamicFrameSwitch(){
        Assert.assertEquals(nestFramePage.getTextFromNestedFrames("frame-top", "frame-left"), "LEFT");

        Assert.assertEquals(nestFramePage.getTextFromNestedFrames("frame-top", "frame-middle"),"MIDDLE");

        Assert.assertEquals(nestFramePage.getTextFromNestedFrames("frame-top", "frame-right"),"RIGHT");

        Assert.assertEquals(nestFramePage.getTextFromNestedFrames("frame-bottom"),"BOTTOM");
    }

    @Test
    void shouldThrowExceptionInvalidFrame(){
        Assert.assertThrows(NoSuchFrameException.class, () -> {
            nestFramePage.switchToFrameByName("nonexistent-frame");
        });
    }

    @DataProvider
    Object[][] framePairData(){
        return new Object[][]{
                {"frame-left", "frame-middle"}
//                {"frame-left", "frame-left"}
        };
    }
    @Test(dataProvider = "framePairData")
    void shouldCompareTextBetweenFrames(String firstFrame, String secondFrame){
        String firstText = nestFramePage.getTextFromNestedFrames("frame-top", firstFrame);
        String secondText = nestFramePage.getTextFromNestedFrames(secondFrame.equals("frame-bottom") ? "frame-bottom" : "frame-top", secondFrame);

        System.out.printf("Compare %s vs %s -> %s | %s%n", firstFrame, secondFrame, firstText, secondText);

        Assert.assertNotEquals(firstText, secondText, "Expected different texts but got same: " + firstFrame);
    }

    @DataProvider
    Object[][] frameMismatchData(){
        return new Object[][]{
                // frameName, intentionallyWrongExpectedText
                {"frame-left", "MIDDLE"}
//                {"frame-left", "LEFT"},
        };
    }

    @Test (dataProvider = "frameMismatchData")
    void shouldDetectMismatchTextOfEachFrame(String frameName, String wrongExpected){
        String actualText = frameName.equals("frame-bottom")
                ? nestFramePage.getTextFromNestedFrames("frame-bottom")
                : nestFramePage.getTextFromNestedFrames("frame-top", frameName);

        System.out.printf("Frame: %s -> expected: %s | actual: %s%n", frameName, wrongExpected, actualText);

        Assert.assertNotEquals(actualText, wrongExpected,
                String.format("%s returned unexpected value: actual='%s' expectedWrong='%s'",
                        frameName, actualText, wrongExpected));

    }
}
