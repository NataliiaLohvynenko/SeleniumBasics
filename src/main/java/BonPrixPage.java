import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BonPrixPage {

    @FindBy(tagName = "header")
    List<WebElement> header;

    @FindBy(xpath = "//span[contains(text(),'Koszyk')]")
    WebElement koszyk;

    public BonPrixPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    public List<WebElement> getHeader() {
        return header;
    }

    public WebElement getKoszyk() {
        koszyk.sendKeys(Keys.ENTER);
        return koszyk;
    }


}
