import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TestOnFirefox {

    String expectedTitle ="W3Schools Online Web Tutorials";
    String expectedMainTitle ="Learn to Code";
    private static WebDriver fireFox = null;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        WebDriverManager.firefoxdriver().setup();
        String exePath = "./drivers/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", exePath);
        fireFox = new FirefoxDriver();
        //WebDriver fireFox = new FirefoxDriver();
       // fireFox.manage().window().maximize();
        fireFox.get("https://www.w3schools.com/");
    }
    @Test
    public void testTitleOnChrome() {
        String actualTitle = fireFox.getTitle();
        assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testMainTitle() {
        String actualTitle = fireFox.findElement(By.xpath("//h1[@class='learntocodeh1' and contains(text(),'Learn to Code')]")).getText();
        assertEquals(actualTitle, expectedMainTitle);
    }
    @Test
    public void testIsDisplayed() {
        WebElement actualTitle = fireFox.findElement(By.xpath("//h1[@class='learntocodeh1' and contains(text(),'Learn to Code')]"));
        assertTrue(actualTitle.isDisplayed());
    }
    @Test
    public void testIsEnabled() {
        WebElement actualTitle = fireFox.findElement(By.xpath("//h1[@class='learntocodeh1' and contains(text(),'Learn to Code')]"));
        assertTrue(actualTitle.isEnabled());
    }

    @AfterClass
    public void tearDownTest() {
        fireFox.quit();
    }
}
