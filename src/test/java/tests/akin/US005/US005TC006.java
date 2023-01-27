package tests.akin.US005;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US005TC006 extends TestBaseRapor {//Urun fotosu ekleme Negatif Test
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Add New Product simgesine tiklar
    4	Store Manager Kategori secimini yapar
    5	Store Manager Submit butonuna tiklar
    6	Store Manager ""Please insert Product Title before submit."
                        "Featured img: This field is required."  ve
                        "Gallery Images: This field is required."
                               uyarilarinin ciktigini gorur"
     */
    PearlyMarketPageAkin page;

    @Test(groups = "gp1")
    public void US005TC006() throws IOException {
        extentTest = extentReports.createTest("Urun fotosu ekleme Negatif Test", "Negatif Test ");
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
        ReusableMethods.jsScrollClick(page.electronicsKategorisi);
        extentTest.info("Kategori secildi");
        ReusableMethods.jsScrollClick(page.submitButton);
        extentTest.info("submit butonu tiklandi");
        Assert.assertTrue(page.uyariYazisiNegatifTest.isDisplayed());
        extentTest.pass("Uyari yazisi goruldu");
        ReusableMethods.getScreenshotWebElement("negatifTest", page.uyariYazisiNegatifTest);
        Driver.closeDriver();


    }
}
