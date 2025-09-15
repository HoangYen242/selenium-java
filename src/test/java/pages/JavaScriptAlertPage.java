package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class JavaScriptAlertPage {
    private By jsAlertButton = By.xpath("//button[.='Click for JS Alert']");
    private By jsConfirmbutton = By.xpath("//button[.='Click for JS Confirm']");
    private By resultLabel = By.id("result");


    public void open(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickForJSAlertButton(){
        click(jsAlertButton);
    }

    public void acceptAlert(){
        acceptAlertIfPresent();
    }

    public String getResultMessage(){
        return getText(resultLabel);
    }

    public void clickForJSConfirmButton(){
        click(jsConfirmbutton);
    }

    public void dismissAlert(){
        dismissAlertIfPresent();
    }

}
