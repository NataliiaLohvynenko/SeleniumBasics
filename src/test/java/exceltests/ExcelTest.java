package exceltests;

import Utils.BaseTest;

import greenCart.GreenCartMainPage;
import static org.assertj.core.api.Assertions.assertThat;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Row;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ExcelTest extends BaseTest {



@Test
    public void getSearchResultByText() throws IOException {

   // String product = "Cucumber";
    ExcelDriven excelDriven = new ExcelDriven();

    List<String> products = excelDriven.product();
    GreenCartMainPage greenCartMainPage =  new GreenCartMainPage(driver);
    greenCartMainPage.goToMainPage();
    products.stream()
            .forEach((st)-> {
                greenCartMainPage.searchViaSearchField(st);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                assertThat(greenCartMainPage.getSearchResultProduct().getAttribute("alt")).as("expexted: "+ st).containsIgnoringCase(st);

            });
   /* greenCartMainPage.searchViaSearchField(product);
    Assert.assertTrue(greenCartMainPage.getSearchResultProduct().getAttribute("alt").contains(product));


*/


}
}


