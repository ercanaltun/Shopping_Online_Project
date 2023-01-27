package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US005TC002 extends TestBaseRapor {//Yeni urun ekle (Add new); urun icin virtual veya downloadable secenegi olmali
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager urun icin virtual veya downloadable secenegi oldugunu gorur
     */
    PearlyMarketPageAkin page;
    @Test(groups = "gp1")
    public void US005TC002() {
        extentTest=extentReports.createTest("Yeni urun ekle (Add new)","virtual veya downloadable secenekleri");

        page = new PearlyMarketPageAkin();
        Login.login();
        extentTest.info("Login olundu");
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        extentTest.info("StoreManager 'a gidildi");
        ReusableMethods.jsScrollClick(page.products);
        extentTest.info("Products 'a gidildi");
        page.addNewButton.click();
        Assert.assertTrue(page.virtualClick.isDisplayed() && page.downloadableClick.isDisplayed());
        extentTest.pass("virtual veya downloadable secenekleri goruldu");
        Driver.closeDriver();


    }
}
