import Utils.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;


public class UploadFiles extends BaseTest {

    @Test
    public void AutoItTest() throws InterruptedException, IOException {
/*        driver.get("https://avepdf.com/en/text-to-pdf?gclid=CjwKCAjwlZf3BRABEiwA8Q0qqyb_ywRtpgec_Jr5laSuSaMTJOa0FN0cYW_6WXcBlJhQzr3JAE1pQhoCz10QAvD_BwE");

        driver.findElement(By.xpath("//li[1]//div[2]//button[1]//div[1]//span[1]//*[local-name()='svg']//*[name()='path' and contains(@d,'M26 29l6-1')]")).click();
        //(By.partialLinkText("Choose")).click();
        Thread.sleep(5000);
        Runtime.getRuntime().exec("D:\\education\\webdriver\\AutoIt\\file.exe");*/
        driver.get("https://altoconvertpdftojpg.com/");

       // driver.findElement(By.cssSelector("[class*='btn--choose']")).click();

        Thread.sleep(3000);

        Runtime.getRuntime().exec("C:\\Users\\rahul\\Documents\\check\\fileupload.exe");

        WebDriverWait wait=new WebDriverWait(driver,10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='medium']")));

    }

}
