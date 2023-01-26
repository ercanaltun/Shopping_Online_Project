package tests.nur;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageNur;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US016_TC1001 extends TestBaseRapor {

    /*
       TC_1001 : Manage customers olarak kayitli kisilerin isim/ kullanıcı adi/ emaili,
                adresi, harcama miktarı, son siparişleri görülmeli
     */

    @Test
    public void test01() throws InterruptedException {
        extentTest=extentReports.createTest("Positive Test","Manage customers olarak kayitli " +
                "kisilerin isim/ kullanıcı adi/ emaili, adresi, harcama miktarı, son siparişleri görülmeli");
        PearlyMarketPageNur pageN = new PearlyMarketPageNur();
        MyMethods.loginn();
        extentTest.info("Vendor olarak siteye giris yapildi");
        ReusableMethods.jsScrollClick(pageN.myAccount);
        pageN.storeManager.click();
        ReusableMethods.jsScrollClick(pageN.customers);
        extentTest.info("Manage Customers Webtable'ina gidildi");

        for (WebElement w : pageN.musteriBilgileri) {
            Assert.assertTrue(w.isDisplayed());
            Thread.sleep(500);
        }
        extentTest.pass("Manage Customers bilgileri basariyla goruntulendi.");
        Driver.closeDriver();
    }

}
