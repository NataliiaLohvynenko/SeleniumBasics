package greenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public abstract class PageClass {

    protected WebDriver driver;

    WebDriverWait wait;

    public PageClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        PageFactory.initElements(driver,this);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

    }
}
