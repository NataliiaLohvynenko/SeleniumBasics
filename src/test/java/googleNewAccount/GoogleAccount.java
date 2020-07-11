package googleNewAccount;

import Utils.BaseTest;
import googleAccount.GoogleAccountPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GoogleAccount extends BaseTest {

    GoogleAccountPage googleAccountPage;

    @Test
    public void newAccount(){
        googleAccountPage = new GoogleAccountPage(driver);

        googleAccountPage.goTo();
        googleAccountPage.getWindow("confAgreementWindow");
        File src=	 ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(src,new File("src"));
        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
