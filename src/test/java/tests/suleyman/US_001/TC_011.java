package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.VerificationCode;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_011 extends TestBaseRapor {

    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin basariyla gorunur oldugunu dogrular
    //3-  Register butonuna tiklayin
    //4 - Acilan pencerede Becamo vendor butonuna tiklar
    //5 -email , password , confirm pasword gorunur oldugunu dogrular
    //6 -Gecerli email adres ve email'e gelen onay kodu girer
    //7 - Password ve confirm password ayni bilgiler girilir
    //8 - Register butonuna tiklar
    //9 - Registration Successfully Completed. gorundugunu dogrular
    //10 - Not Right now butonuna tiklar
    //11 - Store Manager'in goruntuldugunu dogrular
    //12- Log out'a tiklar  ve Giris sayfasina basariyla yonlendirildigini dogrular

    PearlyMarketPageSuleyman page;

    @Test
    public void US001_TC11() {
        extentTest = extentReports.createTest("TC011", "Vendor olarak Register");
        page = new PearlyMarketPageSuleyman();


        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");


        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Anasayfa gorundugunu dogrular");


        page.registerHomePage.click();
        extentTest.info("Register butonuna tiklar");


        page.becomeAVendor.click();
        extentTest.info("Acilan pencereden become a vendor'a gidilir");


        Assert.assertTrue(page.registerEmailBox.isDisplayed()
                && page.registerPasswordBox.isDisplayed()
                && page.registerConfirmPwdBox.isDisplayed());
        extentTest.info("email , password ,confirm password gorundugunu dogrular");


        VerificationCode.getEmailCode(); // method
        extentTest.info("Gecerli email adres ve email onay kodu girildi");


        page.registerPasswordBox.sendKeys("Qa123456!");
        ReusableMethods.waitFor(2);

        page.registerConfirmPwdBox.sendKeys("Qa123456!");
        ReusableMethods.waitFor(2);
        extentTest.info("password ve confirm password ayni bilgiler girilir");


        page.registerButton.click();
        extentTest.info("Register Butonuna tiklar");


        Assert.assertTrue(page.registrationSuccessfully.isDisplayed());
        ReusableMethods.waitFor(2);
        extentTest.info("Registration Successfully Completed. gorundugu dogrulanir");


        page.notRightNowButton.click();
        extentTest.info("Acilan sayfada Not Right now 'a tiklar");


        Assert.assertTrue(page.storeManagerTitle.isDisplayed());
        extentTest.info("Store Manager sayfasinin gorundugunu dogrular");


        ReusableMethods.jsScrollClick(page.logOutManager);
        Assert.assertTrue(page.registerHomePage.isDisplayed());
        extentTest.pass("Log out'a tiklae giris sayfasina gidildigini dogrular.");

        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }
}
