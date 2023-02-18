import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestMainSectionTitles {
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
                new Object[]{"Sale"}
        );
        return data.iterator();
    }

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup();
        chromedriver = new ChromeDriver();
        wait = new WebDriverWait(chromedriver, Duration.ofMinutes(1));
        // chromedriver.manage().window().maximize();

    }

    @Test(dataProvider = "myData")
    public void verifyMainCategorySectionTitles(String title) {
        chromedriver.manage().deleteAllCookies();
        String pageName = title.replaceAll("& ", "")
                .replaceAll(" ", "-")
                .toLowerCase()
                .replace("holidays","holiday")
                .replace("decor-pillows","home-decor-pillows")
                .replace("inspiration","inspirations")
                .replace("food-drink","food-and-drink");
        String url = "https://www.worldmarket.com/category/"
                + pageName +".do";
        chromedriver.get(url);

        String actualTitle = chromedriver.findElement(By.xpath("//h1[@class='wm-header' and contains(text(),'"+title+"')]")).getText();
        Assert.assertEquals(actualTitle, title.replace("Decor & Pillows","Home Decor & Pillows"));

    }
}
