package pages;

import common.Browser;
import org.openqa.selenium.By;

import static common.Browser.*;

public class HyperLinkPage {
    private By hyperlink(String code) {
//        return By.cssSelector(String.format("a[href='status_codes/%s']", code));
         return By.xpath(String.format("//a[@href='status_codes/%s']", code));
    }
    private By backHereLink = By.linkText("here");

    public void open() {
        visit("https://the-internet.herokuapp.com/status_codes");
    }

    public void openHyperlink(String code) {
        click(hyperlink(code));
    }

    public void returnViaHereLink() {
        click(backHereLink);
    }

    public void returnViaBrowserBack(){
        back();
    }

    public String getCurrentURL() {
        return Browser.getCurrentUrl();
    }
}
