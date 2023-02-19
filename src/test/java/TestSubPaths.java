import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestSubPaths {

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

        @Test(groups = "chrome",dataProvider = "myData")
    public void testMainNavBarElementsTitlesOnChrome(String title) {
            SetupDrivers.driver.manage().deleteAllCookies();
            String pageName = title.replaceAll("& ", "")
                    .replaceAll(" ", "-")
                    .toLowerCase()
                    .replace("holidays","holiday")
                    .replace("decor-pillows","home-decor-pillows")
                    .replace("inspiration","inspirations")
                    .replace("food-drink","food-and-drink");
            String url = "https://www.worldmarket.com/category/"
                    + pageName +".do";
            SetupDrivers.driver.get(url);

        String actualTitle = SetupDrivers.driver.findElement(By.xpath("//li[contains(text(),'"+title+"')]")).getText();
        Assert.assertEquals(actualTitle, title.replace("Decor & Pillows","Home Decor & Pillows"));
    }
    @Test(groups = "edge",dataProvider = "myData")
    public void testMainNavBarElementsTitlesOnEdge(String title) {
        SetupDrivers.driver.manage().deleteAllCookies();
        String pageName = title.replaceAll("& ", "")
                .replaceAll(" ", "-")
                .toLowerCase()
                .replace("holidays","holiday")
                .replace("decor-pillows","home-decor-pillows")
                .replace("inspiration","inspirations")
                .replace("food-drink","food-and-drink");
        String url = "https://www.worldmarket.com/category/"
                + pageName +".do";
        SetupDrivers.driver.get(url);

        String actualTitle = SetupDrivers.driver.findElement(By.xpath("//li[contains(text(),'"+title+"')]")).getText();
        Assert.assertEquals(actualTitle, title.replace("Decor & Pillows","Home Decor & Pillows"));
    }
    @Test(groups = "firefox",dataProvider = "myData")
    public void testMainNavBarElementsTitlesOnFirefox(String title) {
        SetupDrivers.driver.manage().deleteAllCookies();
        String pageName = title.replaceAll("& ", "")
                .replaceAll(" ", "-")
                .toLowerCase()
                .replace("holidays","holiday")
                .replace("decor-pillows","home-decor-pillows")
                .replace("inspiration","inspirations")
                .replace("food-drink","food-and-drink");
        String url = "https://www.worldmarket.com/category/"
                + pageName +".do";
        SetupDrivers.driver.get(url);

        String actualTitle = SetupDrivers.driver.findElement(By.xpath("//li[contains(text(),'"+title+"')]")).getText();
        Assert.assertEquals(actualTitle, title.replace("Decor & Pillows","Home Decor & Pillows"));
    }
}
