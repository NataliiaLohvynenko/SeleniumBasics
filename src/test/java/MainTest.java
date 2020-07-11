
import Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.function.Predicate;

public class MainTest extends BaseTest {

    BonPrixPage bonPrixPage;

    @Test
    public void maintest(){


        bonPrixPage = new BonPrixPage(driver);
        driver.get("https://www.bonprix.pl");
        System.out.println(bonPrixPage.getHeader().size());



    }
}
