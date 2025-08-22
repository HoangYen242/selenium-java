package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class DynamicLoadingPage {
    private By startButton = By.cssSelector("#start button");
    private By resultLabel = By.cssSelector("#finish h4");
    public void open(){
        visit("https://the-internet.herokuapp.com/dynamic_loading/1");
    }

    public void clickStartButton(){
        click(startButton);
    }

    public String getResult(){
        return getTextWait(resultLabel)
                .trim();
    }
}
