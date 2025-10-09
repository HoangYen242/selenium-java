package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class NestFramesPage {
    private By framesText = By.xpath("html/body");
    private By middleFrameText = By.id("content");


    public void open(){
        visit("https://the-internet.herokuapp.com/nested_frames");//origin session
    }

    public void switchToFrameByName(String frameName){
        switchToFrame(frameName);
    }

    public void switchToTopParent(){
        switchToParentFrame();
    }

    public void switchToOriginSession(){
        switchToDefaultContent();
    }

    public String getFrameBodyText(){
        return getFrameTextSafely(framesText);
    }

    public String getMiddleFrameText(){
        return getFrameTextSafely(middleFrameText);
    }

    public String getTextFromNestedFrames(String... frames){
        for (String frame : frames){
            switchToFrame(frame);
        }
        String lastFrame = frames[frames.length - 1];
        By locator;

        if(lastFrame.equals("frame-middle")){
            locator = middleFrameText;
        }else {
            locator = framesText;
        }

        String text = getFrameTextSafely(framesText);
        switchToDefaultContent();
        return text;
    }
}
