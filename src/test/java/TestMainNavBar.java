import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestMainNavBar {

    @Test(priority = 1)
    public void startOpenPage() {
        SetupDrivers.driver.manage().deleteAllCookies();
        SetupDrivers.driver.get("https://www.worldmarket.com/category/furniture.do");
    }

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


    @Test(priority = 2,groups = "chrome",dataProvider = "myData")
    public void verifyMainCategoryNavTitlesOnChrome(String title) {
        String actualTitle = SetupDrivers.driver.findElement(
                By.xpath("//a[@id='ml-accessible-megamenu-"
                        +title.replaceAll("& ","")
                        .replaceAll(" ","-")
                        .toLowerCase()
                        .replace("holidays","holiday")
                        .replace("food-drink","food-and-drink")
                        +"-1']")).getText();
        Assert.assertEquals(actualTitle, title);
    }
    @Test(priority = 2,groups = "edge",dataProvider = "myData")
    public void verifyMainCategoryNavTitlesOnEdge(String title) {
        String actualTitle = SetupDrivers.driver.findElement(
                By.xpath("//a[@id='ml-accessible-megamenu-"
                        +title.replaceAll("& ","")
                        .replaceAll(" ","-")
                        .toLowerCase()
                        .replace("holidays","holiday")
                        .replace("food-drink","food-and-drink")
                        +"-1']")).getText();
        Assert.assertEquals(actualTitle, title);
    }
    @Test(priority = 2,groups = "firefox",dataProvider = "myData")
    public void verifyMainCategoryNavTitlesOnFirefox(String title) {
        String actualTitle = SetupDrivers.driver.findElement(
                By.xpath("//a[@id='ml-accessible-megamenu-"
                        +title.replaceAll("& ","")
                        .replaceAll(" ","-")
                        .toLowerCase()
                        .replace("holidays","holiday")
                        .replace("food-drink","food-and-drink")
                        +"-1']")).getText();
        Assert.assertEquals(actualTitle, title);
    }
}
