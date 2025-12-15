package pages;

import common.Browser;
import org.openqa.selenium.By;

import static common.Browser.visit;

public class InfiniteScrollPage {
    private By paragraphsLocator = By.xpath("//*[@class='jscroll-added']");

    public void open() {
        visit("https://the-internet.herokuapp.com/infinite_scroll");
    }

    public int getParagraphCount() {
        return Browser.getDriver()
                .findElements(paragraphsLocator)
                .size();
    }

    public long getPageHeight() {
        return (long) Browser.runJS(
                "return document.body.scrollHeight;");
    }

    public void scrollDown() {
        Browser.runJS("window.scrollBy(0, 2000)");
    }

    public void waitForNewContent(long heightBefore) {
        Browser.getWait().until(
                drv -> getPageHeight() > heightBefore);
    }
}
