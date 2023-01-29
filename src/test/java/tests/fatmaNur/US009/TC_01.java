package tests.fatmaNur.US009;

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
    public void US09_TC01() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("US09_TC001", "Kilo ve Boyut Belirlenmeli");

        PearlyMarketPageFatmaNur fatmaNurPage = new PearlyMarketPageFatmaNur();

        // 1.vendor PearlyMarket Url'ine gider.
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("'pearlyMarketUrl'e gidildi"); /* *** */

        // 2.vendor "signin" butonuna tıklar
        fatmaNurPage.signIn.click();
        extentTest.info("sign in butonuna tiklandi"); /* *** */

        // 3. vendor valid  bir "username" girer
        fatmaNurPage.username.sendKeys(ConfigReader.getProperty("projeEmail"));
        extentTest.info("'username' girildi"); /* *** */

        // 4. vendor valid bir "password" girer
        fatmaNurPage.password.sendKeys(ConfigReader.getProperty("projePassword"));
        extentTest.info("'password' girildi"); /* *** */

        // 5.vendor "signin" butonuna tıklar
        fatmaNurPage.login.click();
        extentTest.info("'sign in' butonuna tiklandi"); /* *** */

        // 6.vendor acilan sayfada sayfa sonundaki "My Account" butonuna gider
        ReusableMethods.jsScrollClick(fatmaNurPage.myAccount);
        Thread.sleep(3000);
        extentTest.info("'myAccount' butonuna gidildi"); /* *** */

        // 7 - Vendor My Account butonuna tiklar
        ReusableMethods.jsScroll(fatmaNurPage.myAccount);
        Assert.assertTrue(fatmaNurPage.myAccount.isDisplayed());
        ReusableMethods.jsScrollClick(fatmaNurPage.myAccount);
        extentTest.info("'myAccount' tiklandi"); /* *** */

        // 8. vendor "Store Manager" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.storeManager.isDisplayed());
        extentTest.info("'Store Manager' butonu izlendi."); /* *** */

        // 9.vendor "Store Manager" butonuna tıklar
        fatmaNurPage.storeManager.click();
        extentTest.info("'Store Manager' butonu tiklandi."); /* *** */

        // 10.vendor "Product" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.product.isDisplayed());
        extentTest.info("'Product'butonu izlendi"); /* *** */

        // 11. vendor "Product" butonuna tıklar
        fatmaNurPage.product.click();
        extentTest.info("Product butonuna tıklandi"); /* *** */

        // 12. ürüne tıklar
        ReusableMethods.jsScrollClick(fatmaNurPage.firstProduct);
        extentTest.info("Urun secildi"); /* *** */

        // 13.vendor Edit butununa tıklar
        ReusableMethods.jsScrollClick(fatmaNurPage.edit);
        extentTest.info("'Edit' butonu tiklandi"); /* *** */


        // 14.Vendor "SHIPPING" butonuna tıklamalıdır.
        ReusableMethods.jsScroll(fatmaNurPage.shipping);
        ReusableMethods.jsScrollClick(fatmaNurPage.shipping);
        extentTest.info("'SHIPPING' butonu tiklandi"); /* *** */


         // 15.Vendor "SHIPPING" menüsünde olduğunu doğrulamalıdır.
        Assert.assertTrue(fatmaNurPage.shipping.isDisplayed());

        // 16.Vendor"Weight (kg)" butonuna giriş yapmalıdır.
        fatmaNurPage.weight.clear();
        fatmaNurPage.weight.sendKeys(ReusableMethods.getFaker().number().digits(1));
        extentTest.info("'weight' girisi yapildi"); /* *** */

        // 17.Vendor "Dimensions" uzunluk/yükseklik/genişlik değerlerinin girişini yapmalıdır.
        fatmaNurPage.length.clear();
        fatmaNurPage.length.sendKeys(ReusableMethods.getFaker().number().digits(1));
        extentTest.info("'length' girisi yapildi"); /* *** */

        fatmaNurPage.width.clear();
        fatmaNurPage.width.sendKeys(ReusableMethods.getFaker().number().digits(1));
        extentTest.info("'width' girisi yapildi"); /* *** */

        fatmaNurPage.height.clear();
        fatmaNurPage.height.sendKeys(ReusableMethods.getFaker().number().digits(1));
        extentTest.info("'height' girisi yapildi"); /* *** */

        // 18. Vendor SUBMİT butonuna tıklar.
        //ReusableMethods.jsScroll(fatmaNurPage.submitProductButton);
        ReusableMethods.jsScrollClick(fatmaNurPage.submitProductButton);
        extentTest.info("'Submit' butonu tiklandi"); /* *** */

        //19. Vendor SUBMİT yapıldıgını sayfa başında ki "PUSHLİED" yazısının görünürlüğü ile doğrulamalıdır.
        //ReusableMethods.jsScroll(fatmaNurPage.submitProductStockSuccess);
        ReusableMethods.waitForVisibility(fatmaNurPage.submitProductStockSuccess,3);
        Assert.assertTrue(fatmaNurPage.submitProductStockSuccess.isDisplayed());
        ReusableMethods.getScreenshot("ProductSuccessfullyPublished");
        extentTest.pass("Product successfully published yazisi izlenmistir.");
        Driver.closeDriver();





    }
}
