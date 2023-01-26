package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.ConfirmAccount;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_010 extends TestBaseRapor {

    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Register butonuna tiklar
    //3 - Acilan pencerede Become a Vendor butonuna tiklayin
    //4 - Gecerli email adres ve dogrulama kodu girer
    //5 - Gecerli sifre ile password ile confirm password'u girer
    //6 - Register butonuna tiklar
    //7 - Email uzerinden hesabi onaylar
    //8 - Acilan sekmede https://pearlymarket.com/ url'e gidildigini dogrular.

    PearlyMarketPageSuleyman page;

    @Test
    public void US001_TC010() {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US001_TC010", "Email uzerinden account onaylanmalı");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        page.registerHomePage.click();
        extentTest.info("register tiklar");


        page.becomeAVendor.click();
        extentTest.info("Acilan pencerede Become A Vendor'a tiklar");


        ConfirmAccount.confirmAccount(); //method
        extentTest.info("email ve email'e gelen dogrulama kodunu girer");
        extentTest.info("password ve confirm password girer");
        extentTest.info("Register butona tiklar");
        extentTest.info("Email'e gelen register onay linkine tiklar");


        String expectedUrl = "https://pearlymarket.com/";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        extentTest.info("Acilan pencerenin https://pearlymarket.com/ url oldugunu dogrular");
        extentTest.pass("Test bitti");


        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }
}
