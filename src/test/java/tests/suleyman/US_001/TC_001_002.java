package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_001_002 extends TestBaseRapor {

    //TC_001
    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin basariyla gorunur oldugunu dogrulayin
    //3-  Register butonuna tiklar
    //4 - Acilan pencereden Become a vendor butonun gorundugunu dogrular

    //TC_002
    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin basariyla gorunur oldugunu dogrulayin
    //3-  Register butonuna tiklar
    //4 - Acilan pencereden Become a vendor butonuna tiklar
    //5 - Registration sayfasinda email , password , confirm pasword gorunur oldugunu dogrular


    PearlyMarketPageSuleyman page;

    @Test
    public void US001_TC001() {
        extentTest = extentReports.createTest("TC001",
                "Vendor olarak kayitta Become vendor butonu ile navigate edin");

        page = new PearlyMarketPageSuleyman();

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Anasayfanin gorundugunu dogrular");

        page.registerHomePage.click();
        extentTest.info("Register'a tiklar");

        ReusableMethods.waitForVisibility(page.becomeAVendor, 15);

        Assert.assertTrue(page.becomeAVendor.isDisplayed());
        extentTest.info("Becoma a Vendor gorundu");
    }


    @Test(dependsOnMethods = "US001_TC001")
    public void US001_TC002() {

        extentTest = extentReports.createTest("TC002",
                "Registration sayfasında uc özellik olmalı; email, password, confirm password");

        ReusableMethods.jsScrollClick(page.becomeAVendor);
        extentTest.info("Become vendor butonuna tiklar");

        Assert.assertTrue(page.registerEmailBox.isDisplayed()
                && page.registerPasswordBox.isDisplayed()
                && page.registerConfirmPwdBox.isDisplayed());
        extentTest.info("email,password,confirm password gorundugu dogrulandi");
        ReusableMethods.waitFor(2);

        extentTest.pass("test bitti");

        Driver.quitDriver();
    }
}
