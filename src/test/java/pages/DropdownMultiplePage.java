package pages;

import org.openqa.selenium.By;

import java.util.List;

import static common.Browser.*;

public class DropdownMultiplePage {
    private By selectDropdown = (By.id("fruits"));

    public void open(){
        visit("https://output.jsbin.com/osebed/2");
    }

    public void selectMultipleOptions(String text){
        selectByVisibleText(selectDropdown, text);
    }

    public void deselectOption(String text){
        deselectVisibleText(selectDropdown, text);
    }

    public boolean isDropdownMultiple(){
        return isMultiple(selectDropdown);
    }

    public List<String> getSelectOptions(){
        return getSelectedOptionsText(selectDropdown);
    }
}
