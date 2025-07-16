package browsers;

import com.google.common.base.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v137.emulation.Emulation;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class OpenMicrosoftEdgeBrowserTest {
    @Test
    void defaultMode(){
        WebDriver driver = new EdgeDriver();
        driver.get("https://www.selenium.dev/");
        driver.quit();
    }


}
