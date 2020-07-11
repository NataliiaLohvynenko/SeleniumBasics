package CardPageTest;


import Utils.BaseTest;
import greenCart.CheckoutPage;
import greenCart.GreenCartMainPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class AddBtn extends BaseTest{

    GreenCartMainPage greenCartMainPage;
    CheckoutPage checkoutPage;


    @Test(groups = {"smoke"},dataProvider = "vegetables")
    public void addButtonTest(String vegetables) throws IOException {
        greenCartMainPage = new GreenCartMainPage(driver);
        greenCartMainPage.goToMainPage();
        greenCartMainPage.clickAddButton(vegetables);
        Assert.assertTrue(Integer.parseInt(greenCartMainPage.getPrice())>0);
        greenCartMainPage.openCart();
        greenCartMainPage.proceedTocheckout();

        //     System.out.println(greenCartMainPage.getPrice());
    }

    @Parameters({"coupon"})
    @Test(dependsOnMethods = "addButtonTest")
    public void promoCodeCheck(@Optional("test") String coupon){
        checkoutPage = new CheckoutPage(driver);

        checkoutPage.applyPromocode(coupon);

        File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File("src\\test.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(checkoutPage.getPromoInfo(),"Invalid code ..!");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }





    }

    @DataProvider(name = "vegetables")
    public Object[] getVegetables(){


        return new Object[]{"Beetroot"};

    }



}
