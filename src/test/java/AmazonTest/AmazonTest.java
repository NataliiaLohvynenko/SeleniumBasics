package AmazonTest;

import Utils.BaseTest;
import amazon.HomePageAmazon;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class AmazonTest extends BaseTest {

    HomePageAmazon homePageAmazon;

    @Test
    public void hoverMouse(){
        homePageAmazon = new HomePageAmazon(driver);
        homePageAmazon.goTo();
       // homePageAmazon.hoverAccountAndLists();
        homePageAmazon.searchInCapitalLetter("hello");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



  /*      Set<String> ids =driver.getWindowHandles();
        Iterator<String> it = ids.iterator();
        String parentId=it.next();
        String childWindow = it.next();

        driver.switchTo().window(childWindow);*/


    }
}


