package tests.suleyman.US_002;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC_001 extends TestBaseRapor {

    /*
    1 - vendor  https://pearlymarket.com/ sayfasina gider
    2 - Anasayfanin gorunurlugu dogrulanir
    3 - Sign in'e tiklar
    4 - Gecerli email girilir
    6 - Gecerli password girilir
    6 - Sign'in butonuna tiklar
    7 - My Account'a tiklar
    8 - My Account sayfasina gidildigi dogrulanir
    9 - Log out'a tiklar
    10 - Vendor'un Sign in sayfasina yonlendirildigi dogrulanir
     */


    PearlyMarketPageSuleyman page;

    @Test
    public void US002_TC001() {

        page = new PearlyMarketPageSuleyman();


        extentTest = extentReports.createTest("US002 TC001 Vendor Login", "Gecerli giris bilgileri ile giris saglanmali");
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/");


        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Anasayfaya gidildi");


        page.ilkSignIn.click();
        extentTest.info("Sign in butonuna tiklandi");


        page.emailBox.sendKeys(ConfigReader.getProperty("projeEmail"));
        extentTest.info("Acilan pencerede gecerli email girildi");


        page.passwordBox.sendKeys(ConfigReader.getProperty("projePassword"));
        extentTest.info("Gecerli password girildi");


        page.ikinciSignIn.click();
        extentTest.info("Sign in butonuna tiklar");


        ReusableMethods.jsScrollClick(page.myAccountLink);
        extentTest.info("My Account'a gidilir");


        Assert.assertTrue(page.myAccountTitle.isDisplayed());
        extentTest.info("My Account sayfasina gidildigini dogrular");


        ReusableMethods.jsScrollClick(page.logOutMyAccount);
        extentTest.info("Log out'a tiklandi");


        Assert.assertTrue(page.signInPage.isDisplayed());
        extentTest.info("Giris sayfasina basariyla gidildi");
        extentTest.pass("Test bitti");


        ReusableMethods.waitFor(1);
        Driver.quitDriver();
    }
}
