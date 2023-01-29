package tests.fatmaNur.US008;

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
    public void US08_TC02() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("US08_TC002", "Backorders tercihi yapilmali");

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


        //6.vendor acilan sayfada sayfa sonundaki "My Account" butonuna gider
        ReusableMethods.jsScroll(fatmaNurPage.myAccount);
        Thread.sleep(3000);
        extentTest.info("'myAccount' butonuna gidildi"); /* *** */


        //7. vendor "My Account" butonunun görünürlügünü test eder.
        Assert.assertTrue(fatmaNurPage.myAccount.isDisplayed());
        Thread.sleep(3000);
        extentTest.info("'myAccount'butonu izlendi"); /* *** */


        //8. vendor "myAccount buttonuna tıklar
        ReusableMethods.jsScrollClick(fatmaNurPage.myAccount);
        extentTest.info("'myAccount' butonu tiklandi."); /* *** */

        //9. vendor "Store Manager" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.storeManager.isDisplayed());
        extentTest.info("'Store Manager' butonu izlendi."); /* *** */


        //10.vendor "Store Manager" butonuna tıklar
        fatmaNurPage.storeManager.click();
        extentTest.info("'Store Manager' butonu tiklandi."); /* *** */


        //11.vendor "Product" butonunun göründügünü test eder
        Assert.assertTrue(fatmaNurPage.product.isDisplayed());
        extentTest.info("'Store Manager' butonu tiklandi."); /* *** */


        //12. vendor "Product" butonuna tıklar
        fatmaNurPage.product.click();
        extentTest.info("Product butonuna tıklandi"); /* *** */

        //13.vendor ürünü secer
        ReusableMethods.jsScroll(fatmaNurPage.firstProduct);
        ReusableMethods.jsScrollClick(fatmaNurPage.firstProduct);
        extentTest.info("Urun secildi"); /* *** */

        //14. vendor sectigi ürünün edit butonuna tıklar
        ReusableMethods.jsScrollClick(fatmaNurPage.edit);
        extentTest.info("'Edit' butonu tiklandi"); /* *** */


        //15. Vendor "ALLOW BACKORDERS" açılan kutucuğundan mutlaka seçim yapmalıdır.
        ReusableMethods.jsScrollClick(fatmaNurPage.backorders);
        Select select = new Select(fatmaNurPage.backorders);

        List<WebElement> backOrdersCount = select.getOptions();
        Random random = new Random();

        int index = random.nextInt(backOrdersCount.size());

        while (index == 1) {
            index = random.nextInt(backOrdersCount.size());
        }

        select.selectByIndex(index);

        extentTest.info("'BACKORDERS' tercihi yapildi"); /* *** */

        //16. Vendor  "SOLD İNDİVİDUALY" kutucuğunu check edip etmeyeceğini tercih etmelidir.
        ReusableMethods.jsScroll(fatmaNurPage.soldIndividually);
        ReusableMethods.jsScrollClick(fatmaNurPage.soldIndividually);

        //17. Vendor SUBMİT butonuna tıklar.
        ReusableMethods.jsScroll(fatmaNurPage.submitProductButton);
        ReusableMethods.jsScrollClick(fatmaNurPage.submitProductButton);
        extentTest.info("'Submit' butonu tiklandi"); /* *** */

        //18. Vendor SUBMİT yapıldıgını sayfa başında ki "PUSHLİED" yazısının görünürlüğü ile doğrulamalıdır.
        ReusableMethods.waitForVisibility(fatmaNurPage.submitProductStockSuccess, 3);
        Assert.assertTrue(fatmaNurPage.submitProductStockSuccess.isDisplayed());
        ReusableMethods.getScreenshot("Stock Successfully Published.");


        extentTest.pass("stock successfully published  yazisi izlenmistir."); /* *** */

        Driver.closeDriver();

    }


}