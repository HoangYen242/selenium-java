package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class CheckboxPage {
    private By checkbox1 = By.cssSelector("#checkboxes input:first-child");
    private By checkbox2 = By.cssSelector("#checkboxes input:last-child");

    public void open(){
        visit("https://the-internet.herokuapp.com/checkboxes");
    }

    public void checkAllCheckboxes(){
        check(checkbox1);
        check(checkbox2);
    }

    public void uncheckAllCheckboxes(){
        uncheck(checkbox1);
        uncheck(checkbox2);
    }

    public boolean isCheckbox1State(){
        return isSelected(checkbox1);
    }

    public boolean isCheckbox2State(){
        return isSelected(checkbox2);
    }


}
