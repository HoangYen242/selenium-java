package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class KeyPressPage {
    private By keyTextbox = By.cssSelector("input[type='text']");
    private By resultLabel = By.id("result");
    public void open(){
        visit("https://the-internet.herokuapp.com/key_presses?");
    }

    public void pressKey(CharSequence key){
        keyPresses(keyTextbox, key);
    }

    public String getResult(){
        return getText(resultLabel);
    }
}
