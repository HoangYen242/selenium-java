package pages;

import org.openqa.selenium.By;
import static common.Browser.*;

public class BodyMassIndexPage {
    private By metricUnitTab = By.xpath("//a[.='Metric Units']");//private
    private By clearButton = By.xpath("//input[@value='Clear']");
    private By ageTextBox = By.id("cage");
    private By maleRadioButton = By.cssSelector("label[for=csex1]");
    private By femaleRadioButton = By.cssSelector("label[for=csex2]");
    private By heightTextBox = By.id("cheightmeter");
    private By weightTextBox = By.id("ckg");
    private By calculateButton = By.xpath("//input[@value='Calculate']");
    private By resultLabel = By.cssSelector(".rightresult .bigtext b");

    public void open() {
        visit("https://www.calculator.net/bmi-calculator.html");
    }

    public void selectMetricTab() {
        clickWait(metricUnitTab);
    }

    public void clearForm() {
        clickWait(clearButton);
    }

    public void fillCalculatorForm(String age, String gender, String height, String weight) {
        sendKeys(ageTextBox, age);
        if (gender.equalsIgnoreCase("male")) {
            check(maleRadioButton);
        } else {
            check(femaleRadioButton);
        }
        sendKeys(heightTextBox, height);
        sendKeys(weightTextBox, weight);
        clickWait(calculateButton);
    }

    public String getResult() {
        return getTextWait(resultLabel)
                .replace("BMI = ", "")
                .replace("kg/m2", "")
                .trim();
    }
}
