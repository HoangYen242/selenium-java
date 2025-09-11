package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class JavaScriptAlertPage {
    private By jsAlertButton = By.xpath("//button[.='Click for JS Alert']");
    private By resultLabel = By.id("result");

    public void open(){
        visit("https://the-internet.herokuapp.com/javascript_alerts");
    }

    public void clickForJSAlert(){
        click(jsAlertButton);
    }

    public void acceptAlert(){
        acceptAlertIfPresent();
    }

    public String getResult(){
        return getText(resultLabel);
    }

}
