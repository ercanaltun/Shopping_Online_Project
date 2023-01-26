package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.VerificationCode;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_009 {

    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 -  Register linkinetiklar
    //3 - Acilan pencerede Becamo a vendor butonuna tiklayin
    //4 - Gecerli bir email adresi ve email dogrulama kodunu girer
    //5 - password ve confirm password farkli bilgiler girilir
    //6 - Register butonuna tiklar
    //7 - 'Password and Confirm-password are not same.' uyarisinin goruntulendigini dogrular

    PearlyMarketPageSuleyman page;

    @Test(groups = "negatif")
    public void US001_TC009() throws IOException {

        page = new PearlyMarketPageSuleyman();

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));


        page.registerHomePage.click();


        page.becomeAVendor.click();


        VerificationCode.getEmailCode(); //method


        page.registerPasswordBox.sendKeys("qa1234567!");
        page.registerConfirmPwdBox.sendKeys("qa1257767!");


        page.registerButton.click();


        String expectedText = "Password and Confirm-password are not same.";
        String actualText = page.passwordNotSameText.getText();
        Assert.assertEquals(actualText, expectedText);


        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }
}
