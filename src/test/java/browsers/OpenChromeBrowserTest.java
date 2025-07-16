package browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v137.emulation.Emulation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OpenChromeBrowserTest {
    @Test
    void defaultMode() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void headlessMode() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=new");

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }

    @Test
    void openBrowserWithMobileViewMode() {
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 344);
        deviceMetrics.put("height", 882);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.selenium.dev/");
        Assert.assertEquals(driver.getTitle(), "Selenium");
        driver.quit();
    }

    @Test
    void openBrowserWithFakeGeoLocation(){
        WebDriver driver = new ChromeDriver();
        DevTools devTools = ((HasDevTools) driver).getDevTools();
        devTools.createSession();
        devTools.send(Emulation.setGeolocationOverride(
                Optional.of(37.386052),  // Latitude
                Optional.of(-122.083851), // Longitude
                Optional.of(1),           // Accuracy
                Optional.empty(),         // Altitude
                Optional.empty(),         // Heading
                Optional.empty(),         // Speed
                Optional.empty()
        ));
        driver.get("https://oldnavy.gap.com/stores");
    }


}
