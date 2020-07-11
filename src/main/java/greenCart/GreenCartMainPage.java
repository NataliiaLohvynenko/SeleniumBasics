package greenCart;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.function.Consumer;

public class GreenCartMainPage extends PageClass {

    Properties properties;
    File file;

    FileInputStream fis;



    @FindBy(xpath = "//button[text()='ADD TO CART']")
    List<WebElement> addButtons;

    @FindBy(css = "div.product")
    List<WebElement> products;

    @FindBy(xpath = "//td[text()='Price']/following-sibling::td[2]/strong")
    WebElement price;

    @FindBy(css = "a.cart-icon img")
    WebElement cart;

    @FindBy(css ="div.cart button")
    WebElement proceedTocheckout;

    @FindBy(className = "search-keyword")
    WebElement searchfield;

    @FindBy(xpath = "//img[contains(@alt,\"Kg\")]")
    WebElement searchResultProduct;

    public GreenCartMainPage(WebDriver driver) throws FileNotFoundException {
        super(driver);
    }

    public void goToMainPage() throws IOException {
         properties = new Properties();
         file = new File("src\\test\\java\\Utils\\file.properties");
         fis = new FileInputStream(file.getAbsolutePath());
         properties.load(fis);
        driver.get(properties.getProperty("url"));
    }

    public void  clickAddButton(String vegetable){
        products.stream()
               // .map(webElement -> webElement.findElement(By.partialLinkText(vegetable)))
                .filter(webElement -> webElement.findElements(By.xpath("./h4")).size()>0)
                .filter(webElement -> webElement.findElement(By.xpath("./h4")).getText().toLowerCase().contains(vegetable.toLowerCase()))
                .map(webElement -> webElement.findElement(By.xpath("./div[@class='product-action']/button")))
                .forEach(webElement -> webElement.click());
    }

    public void increnet(String vegetable){
        products.stream()
                // .map(webElement -> webElement.findElement(By.partialLinkText(vegetable)))
                .filter(webElement -> webElement.findElements(By.xpath("./h4")).size()>0 &&
                 webElement.findElement(By.xpath("./h4")).getText().toLowerCase().contains(vegetable.toLowerCase()))
                .map(webElement -> webElement.findElement(By.xpath("./div[@class='stepper-input']/a[@class='increment']")))
                .forEach(webElement -> webElement.click());

    }

    public String getPrice(){
        return price.getText();
    }

    public void openCart(){
        cart.click();
    }

    public void searchViaSearchField(String text){
        searchfield.clear();
        searchfield.sendKeys(text);

    }

    public void eraiseSearchFiels(){
        searchfield.clear();


    }

    public WebElement getSearchResultProduct(){
        return searchResultProduct;
    }

    public void proceedTocheckout(){

        proceedTocheckout.click();
    }




}
