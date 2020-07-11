package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    protected WebDriver driver;

    protected WebDriverWait wait;

    @BeforeClass
    @Parameters("browser")
    public void setDriver(@Optional("chrome") String browser){

        driver= DriverFactory.getDriver(browser);
        wait = new WebDriverWait(driver,5);
        driver.manage().window().maximize();
    }

    /*@AfterClass
    public void driverQuit(){
        driver.quit();
    }
*/
}
