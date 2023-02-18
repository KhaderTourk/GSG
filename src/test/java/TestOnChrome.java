import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class TestOnChrome {

    String expectedSiteTitle ="Furniture - Affordable & Unique Home Sets | World Market";
    String expectedNavTitle ="Furniture";
    String expectedSectionTitle ="Furniture";
    String expectedPathTitle ="Furniture";
    public static WebDriverWait wait;
    private static WebDriver chromedriver = null;

    @DataProvider(name = "myData")
    public Iterator<Object[]> sectionsData() {
        List<Object[]> data = Arrays.asList(
                new Object[]{"Furniture"},
                new Object[]{"Outdoor"},
                new Object[]{"Rugs"},
                new Object[]{"Decor & Pillows"},
                new Object[]{"Lighting"},
                new Object[]{"Wall Decor & Mirrors"},
                new Object[]{"Kitchen"},
                new Object[]{"Dining"},
                new Object[]{"Food & Drink"},
                new Object[]{"Gifts"},
                new Object[]{"Holidays"},
                new Object[]{"Sale"},
                new Object[]{"Inspiration"}
        );
        return data.iterator();
    }

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        chromedriver = new ChromeDriver();
        wait = new WebDriverWait(chromedriver, Duration.ofMinutes(1));
       // chromedriver.manage().window().maximize();
        //chromedriver.get("https://www.worldmarket.com/category/furniture.do");
    }
    @Test
    public void testTitleOnChrome() {
        chromedriver.get("https://www.worldmarket.com/category/furniture.do");
        String actualTitle = chromedriver.getTitle();
        Assert.assertEquals(actualTitle, expectedSiteTitle);
        chromedriver.manage().deleteAllCookies();
    }

    @Test(dataProvider = "myData")
    public void verifyMainCategoryNavTitles(String title) {
        chromedriver.get("https://www.worldmarket.com/category/furniture.do");
        WebElement titleDisplayed = chromedriver.findElement(
                By.xpath("//a[@id='ml-accessible-megamenu-"
                        +title.replaceAll("& ","")
                        .replaceAll(" ","-")
                        .toLowerCase()
                        .replace("holidays","holiday")
                        .replace("food-drink","food-and-drink")
                        +"-1']"));
        String actualTitle = titleDisplayed.getText();
//wait.until(ExpectedConditions.visibilityOf(titleDisplayed));
        Assert.assertEquals(actualTitle, title);
        chromedriver.manage().deleteAllCookies();
    }

//    @Test
//    public void testIsDisplayed() {
//        String actualTitle = chromedriver.findElement(By.xpath("//h1[@class='wm-header' and contains(text(),'Furniture')]")).getText();
//        Assert.assertEquals(actualTitle, expectedSectionTitle);
//      //  Assert.assertTrue(actualTitle.isDisplayed());
//    }
//    @Test
//    public void testIsEnabled() {
//        WebElement titleDisplayed = chromedriver.findElement(By.xpath("//li[contains(text(),'Furniture')]"));
//        String actualTitle = chromedriver.findElement(By.xpath("//li[contains(text(),'Furniture')]")).getText();
//        Assert.assertEquals(actualTitle, expectedPathTitle);
//     //   Assert.assertTrue(actualTitle.isEnabled());
//    }

    @AfterClass
    public void tearDownTest() {
        chromedriver.quit();
    }
}
