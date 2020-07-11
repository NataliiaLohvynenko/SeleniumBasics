package amazon;

import greenCart.PageClass;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import javax.swing.*;

public class HomePageAmazon extends PageClass {
    @FindBy(className = "nav-line-2")
    WebElement accauntsAndLists;

    @FindBy(name = "field-keywords")
    WebElement searchbox;

    @FindBy(xpath = "//div[@class='nav-search-submit nav-sprite']//input[@class='nav-input']")
    WebElement searchBtn;

    Actions action = new Actions(driver);

    public HomePageAmazon(WebDriver driver) {
        super(driver);
    }

    public void goTo(){
        driver.get("https://www.amazon.com/");
    }

    public void hoverAccountAndLists(){
        action.moveToElement(accauntsAndLists).build().perform();

    }

    public void searchInCapitalLetter(String searchText){
        action.moveToElement(searchbox).click().keyDown(Keys.SHIFT).sendKeys(searchText).build().perform();
        searchBtn.click();


    }



}
