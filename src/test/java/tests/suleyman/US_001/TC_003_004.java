package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC_003_004 extends TestBaseRapor {

    // TC_003
    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Register Butonuna tiklar
    //3 - Acilan pencereden Become a Vendor'a tiklar
    //4 - Email kutusu  ve dogrulama kodu bos kalir
    //5 - Password ve Confirm password ayni girilir
    //6 - Register butonuna tiklanir
    //7 - 'Email: This field is required.' ve 'Email Verification Code: This field is required' uyarilarinin gorundugunu dogrular

    // TC_004

    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin basariyla gorunur oldugunu dogrular
    //3 - Register butonuna tiklar
    //4 - Acilan pencerede Becamo a vendor butonuna tiklayin
    //5 - Gecersiz bir email adresi girer
    //7 - Dogrulama kodu gonderildi email uyarisinin gorundugunu dogrular


    PearlyMarketPageSuleyman page;

    @Test(groups = "negatif")
    public void US001_TC003() {

        page = new PearlyMarketPageSuleyman();

        extentTest = extentReports.createTest("US001_TC003 Negatif Test", "Email bos birakilamaz ve gecerli bir email olmali");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("vendor https://pearlymarket.com/");

        page.registerHomePage.click();
        extentTest.info("ilk sayfada register butonuna tiklar");

        page.becomeAVendor.click();
        extentTest.info("Become a Vendor'a tiklar");


        page.registerPasswordBox.sendKeys(ConfigReader.getProperty("projePassword"));
        page.registerConfirmPwdBox.sendKeys(ConfigReader.getProperty("projePassword"));
        extentTest.info("Email ve dogrulama kodu bos kalir");
        extentTest.info("password girildi");
        extentTest.info("confirm password girildi");


        page.registerButton.click();
        extentTest.info("Register Button'a tiklandi");

        ReusableMethods.waitFor(2);
        String expected1Text = "";
        Assert.assertTrue(page.emailDogrulamaBosText.isDisplayed() && page.emailKutusuBosText.isDisplayed());
        extentTest.info("'Email: This field is required.' ve 'Email Verification Code: This field is required' uyarisinin gorundugu dogrulandi");

        ReusableMethods.waitFor(2);
        extentTest.pass("Test TC003 bitti");
    }

    @Test(dependsOnMethods = "US001_TC003")
    public void US001_TC004() {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US001_TC004 Negatif Test", "Email bos birakilamaz ve gecerli bir email olmali");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("vendor https://pearlymarket.com/");


        page.registerHomePage.click();
        extentTest.info("ilk sayfada register butonuna tiklar");


        page.becomeAVendor.click();
        extentTest.info("Become a Vendor'a tiklar");


        String email = "alkl@qq.co";
        page.registerEmailBox.sendKeys(email);
        extentTest.info("Gecersiz email adres girer");

        page.verificationCodeBox.click();


        ReusableMethods.waitForVisibility(page.verificationSentToEmail, 10);
        String expectedText = "Verification code sent to your email: " + email + ".";
        String actualText = page.verificationSentToEmail.getText();
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("Verification code sent to your email: " + email + "." + "uyarisini gorundugunu dogrular");
        extentTest.pass("US001_TC003_TC004 bitti");

        Driver.quitDriver();
    }
}
