package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;
public class US005TC001 extends TestBaseRapor {//Products'ta urun listemi görmeliyim; status, stock, price, date
       /*
        1	Store Manager  https://pearlymarket.com/ adresine gider
        2	Store Manager Sign-in sekmesine tiklar
        3	Store Manager Username girer
        4	Store Manager Password girer
        5	Store Manager Sign-in butonuna tiklar
        6	Store Manager Sign Out butonuna tiklar
        7	Store Manager sekmesine tiklar
        8	Store Manager Products sekmesine tiklar
        9	Store Manager status,stock,price,date görünürlügünü doğrular
        */
    PearlyMarketPageAkin page;

    @Test(groups = "gp1")
    public void US005TC001() {
        extentTest=extentReports.createTest("Products'ta urun listeleme","Products'ta urun listemi görmeliyim; status, stock, price, date");

        page = new PearlyMarketPageAkin();
        Login.login();
        extentTest.info("Login olundu");
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        extentTest.info("StoreManager 'a gidildi");
        ReusableMethods.jsScrollClick(page.products);
        extentTest.info("Products 'a gidildi");
        Assert.assertTrue(page.statusBaslik.isDisplayed()
                && page.stockBaslik.isDisplayed()
                && page.priceBaslik.isDisplayed()
                && page.dateBaslik.isDisplayed());
        extentTest.pass("status, stock, price, date basliklari goruldu");
        Driver.closeDriver();

    }
}
