import org.testng.annotations.AfterSuite;

public class TearDownDrivers {
    @AfterSuite(groups = "chrome")
    public void tearDownChrome() {
        SetupDrivers.driver.quit();
    }
    @AfterSuite(groups = "edge")
    public void tearDownEdge() {
        SetupDrivers.driver.quit();
    }
    @AfterSuite(groups = "firefox")
    public void tearDownFirefox() {
        SetupDrivers.driver.quit();
    }
}
