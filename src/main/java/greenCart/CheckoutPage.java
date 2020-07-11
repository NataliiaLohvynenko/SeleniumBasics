package greenCart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends PageClass{


    @FindBy(className = "promoCode")
    WebElement promoCodeField;

    @FindBy(className = "promoBtn")
    WebElement promocodeBtn;

    @FindBy(className = "promoInfo")
    WebElement promoInfo;

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }



    public void applyPromocode(String promocode){
        wait.until(ExpectedConditions.visibilityOf(promoCodeField));
        promoCodeField.sendKeys(promocode);
        promocodeBtn.click();
    }

    public String getPromoInfo(){
        wait.until((d)->promoInfo.isDisplayed());
        // wait.until(ExpectedCondition)
        return  promoInfo.getText();
    }


}
