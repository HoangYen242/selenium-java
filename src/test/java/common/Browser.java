package common;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class Browser {
    //Selenium Owner methods -> static method

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static int TIME_OUT_IN_SECONDS = 30;

    public static void launch(String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            driver = new ChromeDriver(chromeOptions);
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new IllegalArgumentException(browserName + " is not support!!");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIME_OUT_IN_SECONDS));
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void captureScreenShot(String fileName) {
        TakesScreenshot scrShot = ((TakesScreenshot) Browser.getDriver());
        File ScrFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(String.format("target/%s.png", fileName));
        try {
            FileUtils.copyFile(ScrFile, DestFile);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void quit() {
        driver.quit();
    }

    public static void check(By element) {
        if (!driver.findElement(element).isSelected()) {
            driver.findElement(element).click();
        }
    }

    public static void uncheck(By element) {
        if (driver.findElement(element).isSelected()) {
            driver.findElement(element).click();
        }
    }

    public static void click(By element){
        driver.findElement(element).click();
    }

    public static void clickWait(By element){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    public static String getText(By element){
        return driver.findElement(element).getText();
    }

    public static String getTextWait(By element){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).getText();
    }

    public static void sendKeys(By element, CharSequence withText){
        driver.findElement(element).sendKeys(withText);
    }

    public static void visit(String url){
        driver.get(url);
    }

    public static void hover(By element){
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(element)).perform();
    }

    public static void doubleClick(By element){
        Actions actions = new Actions(driver);
        actions.doubleClick(driver.findElement(element)).perform();
    }

    public static void executeJSScript(String script, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(script, element);
    }

    public static boolean isDisplayed(By element){
        return driver.findElements(element).size()>0;
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public static void clearAndType(By element, String text){
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(text);
    }

    public static void clearCookies(){
        if(driver !=null){
            driver.manage().deleteAllCookies();
        }
    }

    public static void waitForUrl(String expectedUrl){
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    public static void acceptAlertIfPresent(){
        try {
            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(3));
            Alert alert = shortWait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert was present and accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }
    }

    public static boolean isSelected(By element){
        return driver.findElement(element).isSelected();
    }

    public static boolean isMultiple(By locator) {
        Select select = new Select(driver.findElement(locator));
        return select.isMultiple();
    }

    public static void selectByVisibleText(By element, String text){
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public static void deselectVisibleText(By element, String text){
        Select select = new Select(driver.findElement(element));
        if(select.isMultiple()){
            select.deselectByVisibleText(text);
        }else {
            throw new UnsupportedOperationException("Cannot deselect option from single-select dropdown");
        }
    }

    public static String getFirstSelectedOptionText(By element){
        Select select = new Select(driver.findElement(element));
        return select.getFirstSelectedOption().getText();
    }

    public static List<String> getSelectedOptionsText(By element) {
        Select select = new Select(driver.findElement(element));
        return select.getAllSelectedOptions()
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
