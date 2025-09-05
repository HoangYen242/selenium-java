package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.Browser.*;

public class HoversPage {
    private By avatarImages = By.cssSelector(".figure img");
    private By caption = By.tagName("h5");
    private By parentAvatar = By.xpath("./..");
    private By profileLink = By.tagName("a");

    public void open(){
        visit("https://the-internet.herokuapp.com/hovers");
    }

    public List<WebElement> getAvatars(){
        return Browser.getDriver().findElements(avatarImages);
    }

    public void hoverOnAvatar(WebElement avatar){
        Browser.hoverElement(avatar);
    }

    public void hoverOnAllAvatars(){
        for (WebElement avatar :  getAvatars()){
            Browser.hoverElement(avatar);
        }
    }

    public String getUsernameText(WebElement avatar){
        WebElement parent = avatar.findElement(parentAvatar);
        return parent.findElement(caption).getText();
    }

    public String getProfileLink(WebElement avatar){
        WebElement parent = avatar.findElement(parentAvatar);
        return parent.findElement(profileLink).getText();
    }
}
