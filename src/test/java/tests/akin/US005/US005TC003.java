package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US005TC003 extends TestBaseRapor {//Urun ismi ekle  product title, satis Fiyati
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Product Title sekmesine tiklar ve urun ismi yazar
    5	Store Manager Price($)  sekmesine  tiklar ve fiyat yazar
    6	Store Manager fiyat girilebildigini gorur

     */
    PearlyMarketPageAkin page;
    @Test(groups = "gp1")
    public void US005TC003() {

        extentTest=extentReports.createTest("Urun ismi   product title ve  satis Fiyati","Urun ismi   product title ve  satis Fiyati girilmeli");

        page = new PearlyMarketPageAkin();
        Login.login();
        extentTest.info("Login olundu");
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        extentTest.info("StoreManager 'a gidildi");
        ReusableMethods.jsScrollClick(page.products);
        extentTest.info("Products 'a gidildi");
        page.addNewButton.click();
        extentTest.info("AddNew butonu secildi");
        page.productTitle.sendKeys("Xiaomi");
        page.priceGirisi.sendKeys("800");
        extentTest.info("productTitle ve  price degeri girildi");
        Assert.assertTrue(page.productTitle.isDisplayed()&&page.priceGirisi.isDisplayed());
        extentTest.pass("Urun ismi   product title ve  satis Fiyati basarili olarak girildi");
        Driver.closeDriver();

    }
}
