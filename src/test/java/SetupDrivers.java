import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class SetupDrivers {
    public static WebDriver driver;
    public static WebDriverWait wait;

@BeforeSuite(groups = "chrome")
    public void setUpChromeDriver() {
        WebDriverManager.chromedriver().setup();
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    }

@BeforeSuite(groups = "edge")
    public void setUpEdgeDriver() {
        WebDriverManager.edgedriver().setup();
    driver = new EdgeDriver();
    wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    }

@BeforeSuite(groups = "firefox")
    public void setUpFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    wait = new WebDriverWait(driver, Duration.ofMinutes(1));
    }
}
