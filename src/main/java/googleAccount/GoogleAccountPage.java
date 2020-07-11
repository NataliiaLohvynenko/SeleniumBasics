package googleAccount;

import greenCart.PageClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GoogleAccountPage extends PageClass {



    @FindBy(xpath = "//li[1]//a[1]")
    WebElement info;

    @FindBy(xpath = "//li[2]//a[1]")
    WebElement confAgreement;

    @FindBy(xpath = "//li[3]//a[1]")
    WebElement conditions;


    public GoogleAccountPage(WebDriver driver) {
        super(driver);
    }


    public void goTo(){
        driver.get("https://accounts.google.com/signup");
    }

    private String getwiWindowId(String window){

        info.click();
        confAgreement.click();
        conditions.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();


        String parentWindow =it.next();
        String infoWindow = it.next();
        String confAgreementWindow = it.next();
        String conditions = it.next();

        Map<String, String> windowIdMap = new HashMap<>();
        windowIdMap.put("parentWindow", parentWindow);
        windowIdMap.put("infoWindow", infoWindow);
        windowIdMap.put("confAgreementWindow", confAgreementWindow);
        windowIdMap.put("conditions", conditions);

        return windowIdMap.get(window);

    }

    public void getWindow(String window){
        driver.switchTo().window(getwiWindowId(window));
        System.out.println(driver.getTitle());


    }

    /*public void getwindows(){
        confAgreement.click();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> it = windows.iterator();
        String parentWindow =it.next();

        String childWindow = it.next();
        driver.switchTo().window(childWindow);
        System.out.println(driver.getTitle());

    }
*/

}
