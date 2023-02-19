import org.testng.Assert;
import org.testng.annotations.Test;


public class TestOnChrome {


    @Test
    public void testTitleOnChrome() {
        SetupDrivers.driver.get("https://www.worldmarket.com/category/furniture.do");
        String expectedSiteTitle ="Furniture - Affordable & Unique Home Sets | World Market";
        String actualTitle = SetupDrivers.driver.getTitle();
        Assert.assertEquals(actualTitle, expectedSiteTitle);
        SetupDrivers.driver.manage().deleteAllCookies();
    }



}
