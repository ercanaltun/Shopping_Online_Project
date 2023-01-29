package tests.fatmaNur.US008;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageFatmaNur;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_01 extends TestBaseRapor {

    @Test
    public void US08_TC01() throws IOException, InterruptedException {

        extentTest = extentReports.createTest("US08_TC001", "Ürün miktari ve stok belirlenmeli");

        PearlyMarketPageFatmaNur fatmaNurPage = new PearlyMarketPageFatmaNur();


        //1.vendor PearlyMarket Url'ine gider.
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("'pearlyMarketUrl'e gidildi"); /* *** */

        //2.vendor "signin" butonuna tıklar
        fatmaNurPage.signIn.click();
        extentTest.info("sign in butonuna tiklandi"); /* *** */

        //3. vendor valid  bir "username" girer
        fatmaNurPage.username.sendKeys(ConfigReader.getProperty("projeEmail"));
        extentTest.info("'username' girildi"); /* *** */

        //4. vendor valid bir "password" girer
        fatmaNurPage.password.sendKeys(ConfigReader.getProperty("projePassword"));
        extentTest.info("'password' girildi"); /* *** */

        //5.vendor "signin" butonuna tıklar
        fatmaNurPage.login.click();
        extentTest.info("'sign in' butonuna tiklandi"); /* *** */

        //6 - Vendor My Account butonuna tiklar
        ReusableMethods.jsScroll(fatmaNurPage.myAccount);
        extentTest.info("'myAccount' tiklandi"); /* *** */

        //7.Vendor  "MY ACCOUNT" sayfasına giriş yaptığını doğrular
        ReusableMethods.jsScrollClick(fatmaNurPage.myAccount);
        extentTest.info("'myAccount'butonu izlendi"); /* *** */

        //8. vendor "Store Manager" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.storeManager.isDisplayed());
        extentTest.info("'Store Manager' butonu izlendi."); /* *** */

        //9.vendor "Store Manager" butonuna tıklar
        fatmaNurPage.storeManager.click();
        extentTest.info("'Store Manager' butonu tiklandi."); /* *** */

        //10.vendor "Product" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.product.isDisplayed());
        extentTest.info("'Product'butonu izlendi"); /* *** */

        //11. vendor "Product" butonuna tıklar
        fatmaNurPage.product.click();
        extentTest.info("Product butonuna tıklandi"); /* *** */

        //12. vendor ürünü secer
        ReusableMethods.jsScrollClick(fatmaNurPage.firstProduct);
        extentTest.info("Urun secildi"); /* *** */

        //13. vendor sectigi ürünün edit butonuna tıklar
        ReusableMethods.jsScrollClick(fatmaNurPage.edit);
        extentTest.info("'Edit' butonu tiklandi"); /* *** */

        //13.vendor "Manage Stock" butonuna tıklar
        ReusableMethods.jsScroll(fatmaNurPage.manage_stock);

        if  (!fatmaNurPage.manage_stock.isSelected()) {
            ReusableMethods.jsScrollClick(fatmaNurPage.manage_stock);
        }
        extentTest.info("'Manage Stock' butonu tiklandi"); /* *** */

        //14. vendor "Stock Qty" alanına int bir deger girer
        fatmaNurPage.stock_qty.clear();
        fatmaNurPage.stock_qty.sendKeys(ReusableMethods.getFaker().number().digits(3));
        fatmaNurPage.stock_qty.sendKeys(Keys.ENTER);
        extentTest.info("'Stock Qty' alanina değer girildi"); /* *** */

        //15. vendor "SUBMIT" butununa tıklar
        ReusableMethods.jsScroll(fatmaNurPage.submitProductButton);
        ReusableMethods.jsScrollClick(fatmaNurPage.submitProductButton);
        extentTest.info("'Submit' butonu tiklandi"); /* *** */

        //16. vendor stock successfully published yazısının gorunurlugunu test eder.
        ReusableMethods.waitForVisibility(fatmaNurPage.submitProductStockSuccess,3);
        Assert.assertTrue(fatmaNurPage.submitProductStockSuccess.isDisplayed());
        ReusableMethods.getScreenshotWebElement("Stock Successfully Published.", fatmaNurPage.submitProductStockSuccess);

        extentTest.pass("stock successfully published yazisi izlenmistir.");

        //17.vendor sayfayı kapatır.
        Driver.closeDriver();


    }

}

