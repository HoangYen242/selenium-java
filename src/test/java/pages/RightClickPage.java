package pages;

import common.Browser;
import org.openqa.selenium.By;

import static common.Browser.*;

public class RightClickPage {
    private By contextMenu = By.id("hot-spot");
    public void open(){
        visit("https://the-internet.herokuapp.com/context_menu");
    }

    public void rightClickContextArea(){
        rightClick(contextMenu);
    }

    public String getAlertText(){
        return getAlertTextIfPresent();
    }

    public void acceptAlert(){
        acceptAlertIfPresent();
    }
}
