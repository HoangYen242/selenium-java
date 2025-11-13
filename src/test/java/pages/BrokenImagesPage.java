package pages;

import common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static common.Browser.runJS;
import static common.Browser.visit;

public class BrokenImagesPage {
    private By images = By.tagName("img");
    public void open(){
        visit("https://the-internet.herokuapp.com/broken_images");
    }

    public List<WebElement> getAllImages(){
        return Browser.getDriver().findElements(images);
    }

    public int getBrokenImagesCount(){
        List<WebElement> imgs = getAllImages();
        int imgBrokenCount = 0;

        for (WebElement img : imgs) {
            Long width = (Long) runJS("return arguments[0].naturalWidth;", img);

            if(width==0){
                imgBrokenCount++;
                System.out.println("Broken: " + img.getAttribute("src"));
            }else {
                System.out.println("OK: " + img.getAttribute("src"));
            }
        }
        return imgBrokenCount;
    }
}

