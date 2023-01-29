package tests.fatmaNur.US009;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageFatmaNur;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TC_02 extends TestBaseRapor {

    @Test
    public void US009_TC02() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("US09_TC002","Ne kadar sürede teslimat yapilacagi belirlenmeli");

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


        // 6 - Vendor My Account butonuna tiklar
        ReusableMethods.jsScrollClick(fatmaNurPage.myAccount);
        Thread.sleep(3000);


        // 7. vendor "Store Manager" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.storeManager.isDisplayed());
        extentTest.info("'myAccount' tiklandi"); /* *** */

        // 9.vendor "Store Manager" butonuna tıklar
        fatmaNurPage.storeManager.click();
        extentTest.info("'Store Manager' butonu tiklandi."); /* *** */

        //10.vendor "Product" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.product.isDisplayed());
        extentTest.info("'Product'butonu izlendi"); /* *** */

        //11. vendor "Product" butonuna tıklar
        fatmaNurPage.product.click();
        extentTest.info("Product butonuna tıklandi"); /* *** */

        // 12. vendor ürünü secer
        ReusableMethods.jsScrollClick(fatmaNurPage.firstProduct);
        extentTest.info("Urun secildi"); /* *** */

        // 13. vendor sectigi ürünün edit butonuna tıklar
        ReusableMethods.jsScrollClick(fatmaNurPage.edit);
        extentTest.info("'Edit' butonu tiklandi"); /* *** */

        // 14.Vendor "SHIPPING" butonuna tıklamalıdır.
        ReusableMethods.jsScroll(fatmaNurPage.shipping);
        ReusableMethods.jsScrollClick(fatmaNurPage.shipping);
        extentTest.info("'SHIPPING' butonu tiklandi"); /* *** */

        // 15.Vendor "SHIPPING" menüsünde olduğunu doğrulamalıdır.
        Assert.assertTrue(fatmaNurPage.shipping.isDisplayed());
        extentTest.info("'Shipping' menüsü izlendi"); /* *** */

        // 16.Vendor "Processing Time" açılır menüsünden teslimat süresini seçmelidir.
        fatmaNurPage.processingTime.click();
        Select select = new Select(fatmaNurPage.processingTime);

        List<WebElement> processingTimeCount = select.getOptions();
        Random random = new Random();

        int index = random.nextInt(processingTimeCount.size());

        while (index == 1) {
            index = random.nextInt(processingTimeCount.size());
        }

        select.selectByIndex(index);
        extentTest.info("'Processing time' secilir"); /* *** */


        // 18. Vendor SUBMİT butonuna tıklar.
        ReusableMethods.jsScroll(fatmaNurPage.submitProductButton);
        ReusableMethods.jsScrollClick(fatmaNurPage.submitProductButton);
        extentTest.info("'Submit' butonu tiklandi"); /* *** */

        //19. Vendor SUBMİT yapıldıgını "PUSHLİED" yazısının görünürlüğü ile doğrulamalıdır.
        ReusableMethods.waitForVisibility(fatmaNurPage.submitProductStockSuccess,3);
        Assert.assertTrue(fatmaNurPage.submitProductStockSuccess.isDisplayed());
        ReusableMethods.getScreenshot("Stock Successfully Published.");
        extentTest.pass("product successfully published yazisi izlenmistir.");

        Driver.closeDriver();



    }
}
