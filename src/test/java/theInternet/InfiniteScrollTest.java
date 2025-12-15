package theInternet;

import common.BaseTest;
import common.Browser;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.InfiniteScrollPage;

public class InfiniteScrollTest extends BaseTest {
    InfiniteScrollPage infiniteScrollPage;

    @BeforeClass
    void openBrowser() {
        Browser.launch("chrome");
        infiniteScrollPage = new InfiniteScrollPage();
        infiniteScrollPage.open();
    }

    @BeforeMethod
    void setUp() {
        infiniteScrollPage.open();
    }

    @Test
    void verifyInfiniteScrollSuccessfully() {
        int countBefore = infiniteScrollPage.getParagraphCount();
        System.out.println("Initial paragraphs count: " + countBefore);

        for (int i = 1; i <= 5; i++) {
            long heightBefore = infiniteScrollPage.getPageHeight();
            infiniteScrollPage.scrollDown();
            infiniteScrollPage.waitForNewContent(heightBefore);

            int countAfter = infiniteScrollPage.getParagraphCount();

            if (countAfter == countBefore) {
                System.out.println("No more new content add scroll " + i + ". Stop scrolling");
                break;
            }

            System.out.println("Scroll " + i +
                    ": content increased from "
                    + countBefore + " -> " + countAfter);

            Assert.assertTrue(countAfter > countBefore, "No new content loaded on scroll " + i);

            countBefore = countAfter;
        }
    }

}
