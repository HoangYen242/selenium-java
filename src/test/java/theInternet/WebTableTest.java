package theInternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class WebTableTest {
    @Test
    void validateBiggestDuePerson(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/tables");

        List< WebElement> dueColumn = driver.findElements(By.cssSelector("table#table1 tbody tr td:nth-child(4)"));

        List<Float> dueValue = dueColumn
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList())
                .stream().map(due -> due.replace("$",""))
                .collect(Collectors.toList())
                .stream()
                .map(Float::parseFloat)
                .collect(Collectors.toList());

        Float maxDue = dueValue
                .stream()
                .max(Comparator.naturalOrder())
                .orElseThrow(NoSuchElementException::new);
        int indexOfMaxDue = dueValue.indexOf(maxDue);

        String lastNameOfBiggestDuePerson = driver.findElement(By.cssSelector(String.format("table#table1 tbody tr:nth-child(%d) td:nth-child(1)", indexOfMaxDue+1))).getText();
        String firstNameOfBiggestDuePerson = driver.findElement(By.cssSelector(String.format("table#table1 tbody tr:nth-child(%d) td:nth-child(2)", indexOfMaxDue+1))).getText();

        Assert.assertEquals(String.format("%s %s", firstNameOfBiggestDuePerson, lastNameOfBiggestDuePerson), "Jason Doe");
    }
}

