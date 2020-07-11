package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class DriverFactory {


    private static Supplier<WebDriver> chromeDriver = () -> {
        System.setProperty("webdriver.chrome.driver","D:\\education\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    };

    private static Supplier<WebDriver> fireFox = () ->{
        System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static Supplier<WebDriver> ieDriver = ()->{
        System.setProperty("webdriver.ie.driver","src\\main\\resources\\IEDriverServer.exe");
        return new InternetExplorerDriver();
    };

    private static Map<String,Supplier<WebDriver>>DRIVER = new HashMap<>();

    static {
        DRIVER.put("chrome", chromeDriver);
        DRIVER.put("ie",ieDriver);
        DRIVER.put("firefox", fireFox);
    }

    public static WebDriver getDriver(String browser){
        return DRIVER.get(browser).get();
    }



}
