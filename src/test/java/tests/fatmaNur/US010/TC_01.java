package tests.fatmaNur.US010;

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
    public void US10_01() throws IOException {

        extentTest = extentReports.createTest("US010_TC001", "Renk secenegi belirlenmeli, tum renkler secilmeli");

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
        ReusableMethods.jsScrollClick(fatmaNurPage.myAccount);
        extentTest.info("'myAccount' tiklandi"); /* *** */

        //7. vendor "Store Manager" butonunun göründügünü test eder
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


        // 14.Vendor "ATTRİBİTUES" sekmesine tıklamalıdır.
        ReusableMethods.jsScroll(fatmaNurPage.attributes);
        ReusableMethods.jsScrollClick(fatmaNurPage.attributes);
        extentTest.info("'Attributues' butonu tiklandi"); /* *** */

        // 15. Vendor "ATTRİBİTUES" sekmesin de olduğunu doğrulamalıdır.
        Assert.assertTrue(fatmaNurPage.attributes.isDisplayed());
        extentTest.info("'Attributues' butonu izlendi"); /* *** */

        //16.Vendor "Color" butununa tıklamalıdır
       // fatmaNurPage.color.click();

        ReusableMethods.jsScrollClick(fatmaNurPage.colorSelect);
        extentTest.info("'Color' butunu tiklandi"); /* *** */

        //17.Vendor açılan pencerede "SELECT ALL" seçeneğine tıklamalıdır. Tüm renkleri seçmelidir.
        ReusableMethods.jsScrollClick(fatmaNurPage.selectAllColor);
        extentTest.info("'Color' secildi"); /* *** */


        //18. Vendor SUBMİT butonuna tıklar.
        ReusableMethods.jsScroll(fatmaNurPage.submitProductButton);
        ReusableMethods.jsScrollClick(fatmaNurPage.submitProductButton);
        extentTest.info("'Submit' butonu tiklandi"); /* *** */

        //19. Vendor SUBMİT yapıldıgını "PUSHLİED" yazısının görünürlüğü ile doğrulamalıdır.
        ReusableMethods.waitForVisibility(fatmaNurPage.submitProductStockSuccess,3);
        //Assert.assertTrue(fatmaNurPage.submitProductStockSuccess.isDisplayed());
        ReusableMethods.getScreenshot("ProductSuccessfullyPublished");
        extentTest.info("Product successfully published");

        Driver.closeDriver();

    }
}
