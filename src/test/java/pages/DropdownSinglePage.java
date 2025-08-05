package pages;

import org.openqa.selenium.By;

import static common.Browser.*;

public class DropdownSinglePage {
    private By selectDropdown = By.id("dropdown");

    public void open(){
        visit("https://the-internet.herokuapp.com/dropdown");
    }

    public void selectAnOption(String text){
        selectByVisibleText(selectDropdown, text);
    }

    public boolean getResult(String result){
        By selectedOption = By.xpath("//option[.='" + result + "']");
        return isSelected(selectedOption);    }

    public boolean isDropdownMultiple(){
        return isMultiple(selectDropdown);
    }
}
