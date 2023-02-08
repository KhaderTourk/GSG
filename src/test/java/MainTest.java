import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class MainTest {

    String expectedTitle ="W3Schools Online Web Tutorials";
    String expectedMainTitle ="Learn to Code";
    private static WebDriver chromedriver = null;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
//        WebDriverManager.edgedriver().setup();
//        WebDriver fox = new FirefoxDriver();
//        WebDriver edge = new EdgeDriver();
        chromedriver = new ChromeDriver();
        chromedriver.manage().window().maximize();
        chromedriver.get("https://www.w3schools.com/");
    }
    @Test
    public void testTitleOnChrome() {
        String actualTitle = chromedriver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    @Test
    public void testMainTitle() {
        String actualTitle = chromedriver.findElement(By.xpath("//h1[@class='learntocodeh1' and contains(text(),'Learn to Code')]")).getText();
        Assert.assertEquals(actualTitle, expectedMainTitle);
    }
    @Test
    public void testIsDisplayed() {
        WebElement actualTitle = chromedriver.findElement(By.xpath("//h1[@class='learntocodeh1' and contains(text(),'Learn to Code')]"));
        Assert.assertTrue(actualTitle.isDisplayed());
    }
    @Test
    public void testIsEnabled() {
        WebElement actualTitle = chromedriver.findElement(By.xpath("//h1[@class='learntocodeh1' and contains(text(),'Learn to Code')]"));
        Assert.assertTrue(actualTitle.isEnabled());
    }

    @AfterClass
    public void tearDownTest() {
        chromedriver.quit();
       // chromedriver.close();
    }

//    @BeforeClass
//    public void setUp(){
//        System.out.println("Before Test");
//    }
//
//    @Test(priority = 2)
//    public void testOne(){
//        System.out.println("Test One");
//
//        Assert.assertEquals(2,2);
//    }
//
//    @Test(priority = 1)
//    public void testTwo(){
//        System.out.println("Test Two");
//    }


//@BeforeSuite
   // @BeforeTest
//    @BeforeClass
//    @BeforeMethod
//    @Test
//    @AfterMethod
//    @AfterClass
   // @AfterTest
//    @AfterSuite

}
