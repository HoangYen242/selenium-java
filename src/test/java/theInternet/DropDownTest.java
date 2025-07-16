package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropDownTest {
    @Test
    void selectOptionSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dropdown");

        Select select =  new Select(driver.findElement(By.id("dropdown")));

        if(select.isMultiple()){
            System.out.println("Able select multiple options");
        }else {
            System.out.println("Select only 1 option");
        }

        select.selectByVisibleText("Option 1");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Option 1']")).isSelected());
    }

    @Test
    void selectMultipleOptionSuccessfully(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://output.jsbin.com/osebed/2");

        Select select = new Select(driver.findElement(By.id("fruits")));

        if(select.isMultiple()){
            System.out.println("Able select multiple options");
        }else{
            System.out.println("Select only 1 option");
        }

        select.selectByVisibleText("Banana");
        select.selectByVisibleText("Apple");
//        select.deselectByVisibleText("Apple");

        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Banana']")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//option[.='Apple']")).isSelected());
    }
}
