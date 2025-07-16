package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static common.Browser.*;

public class TodoMVCPage {
    public void open() {
        visit("https://todomvc.com/examples/javascript-es6/dist/#/");
    }

    public void createNewTask(String name) {
        sendKeys(By.className("new-todo"), name+Keys.ENTER);
    }

    public String getLatestTaskName() {
        return getTextWait(By.cssSelector(".todo-list > li:last-child"));
    }

    public void markComplete(String taskName) {
        click(By.xpath(String.format("//label[.='%s']/preceding-sibling::input", taskName)));
    }

    public void selectCompletedTaskView() {
        click(By.linkText("Completed"));
    }

    public void selectAllTaskView() {
        if(isDisplayed(By.linkText("All"))) {
            click(By.linkText("All"));
        }
    }

    public int getItemsLeft() {
        String itemLeft = getText(By.cssSelector(".todo-count strong"));
        if (itemLeft.equals("")) {
            return 0;
        } else return Integer.parseInt(itemLeft);
    }

    public void delete(String taskName) {
        hover(getTaskByName(taskName));
        click(By.xpath(String.format("//label[.='%s']/following-sibling::button", taskName)));
    }

    public void updateName(String oldTaskName, String newTaskName) {
        doubleClick(getTaskByName(oldTaskName));
        WebElement editTaskBtn = getDriver()
                .findElement(By.xpath(String.format("//label[.='%s']/../..",oldTaskName)))
                .findElement(By.cssSelector("input.edit"));

        executeJSScript("arguments[0].value=''", editTaskBtn);

        editTaskBtn.sendKeys(newTaskName+Keys.ENTER);
    }

    public boolean isTaskNameDisplay(String name){
        return isDisplayed(getTaskByName(name));    }

    private By getTaskByName(String name){
        return By.xpath(String.format("//label[.='%s']",name));
    }
}
