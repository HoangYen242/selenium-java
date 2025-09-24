package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class JavaScriptAlertPage {
    private By jsAlertButton = By.xpath("//button[.='Click for JS Alert']");
    private By jsConfirmButton = By.xpath("//button[.='Click for JS Confirm']");
    private By jsPromptButton = By.xpath("//button[.='Click for JS Prompt']");
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
        click(jsConfirmButton);
    }

    public void dismissAlert(){
        dismissAlertIfPresent();
    }

    public void clickForJSPromptButton(){
        click(jsPromptButton);
    }

    public void enterTextInPrompt(String text){
        sendKeysToAlert(text);
    }

}
