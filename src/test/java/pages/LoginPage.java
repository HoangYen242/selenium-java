package pages;

import common.Browser;
import org.openqa.selenium.By;
import static common.Browser.*;

public class LoginPage {
    private By usernameTextBox = By.id("username");
    private By passwordTextBox = By.id("password");
    private By clickButton = By.cssSelector("button[type=submit]");

    public void open() {
        visit("https://the-internet.herokuapp.com/login");
    }

    public void enterCredentials(String username, String password) {
        sendKeys(usernameTextBox, username);
        sendKeys(passwordTextBox, password);

        click(clickButton);
    }

    public String getSuccessResult() {
        return getText(By.className("subheader"));
    }

    public String getErrorResult() {
        return getText(By.cssSelector("#flash"));
    }

    public String getCurrentUrl(){
        return Browser.getCurrentUrl();
    }


}
