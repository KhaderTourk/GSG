import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestAddItemToCart {
    @Test(priority = 2,groups = "chrome",dataProvider = "myData")
    public void verifyFirstItemExistOnChrome(String title) {
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
