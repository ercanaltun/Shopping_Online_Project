package tests.zeliha._US015_;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US015_Negative_TC001 extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();

    @Test
    public void NegativeTC_001() throws IOException, InterruptedException {

        extentTest = extentReports.createTest("US015 Negatif Test 01", "Gerekli adimlar gecildikten sonra US014 Negatif Test 01 tamamlanmali");

        //1 - Vendor https://pearlymarket.com/ sayfasina gider
        //2 - Vendor olarak login yapar
        Login.login();
        extentTest.info("Vendor login oldu");

        //3-  Vendor My Account butonuna tiklar
        ReusableMethods.waitForClickablility(pearlyMarketPage.myAcount,2000);
        ReusableMethods.jsScroll(pearlyMarketPage.myAcount);
        extentTest.info("My Account butonuna gidilir");
        ReusableMethods.jsScrollClick(pearlyMarketPage.myAcount);
        extentTest.info("My Account butonu gorunur");

        //4- Vendor Store Manager butonuna tiklar
        pearlyMarketPage.storeManager.click();
        extentTest.info("Store Manager butonu tiklanir");

        //5- Vendor Coupons butonuna tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.couponsButton);
        extentTest.info("Coupons butonuna gidilir");
        pearlyMarketPage.couponsButton.sendKeys(Keys.ENTER);
        extentTest.info("Coupons butonu tiklanir");

        //6- Vendor Add New butonuna tiklar
        pearlyMarketPage.addNewButton.sendKeys(Keys.ENTER);
        extentTest.info("Add New butonuna tiklandi");

        //7- Vendor Add Coupon sayfasinda
        Assert.assertTrue(pearlyMarketPage.addCouponSayfaDogrulama.isDisplayed());
        extentTest.info("Vendor Add Coupon sayfasinda");

        /*8- Vendor US_013 deki TC adimlarini tamamlamadan sonraki adimlara gecer*/
        extentTest.info("US_013 deki TC adimlarini tamamlamadan sonraki adimlara gecildi");

        //9- Vendor Limit butonuna tiklar
        Assert.assertTrue(pearlyMarketPage.limitButton.isDisplayed());
        extentTest.info("Limit butonunun gorunur");
        ReusableMethods.jsScroll(pearlyMarketPage.limitButton);
        extentTest.info("Limit butonuna gidildi");
        ReusableMethods.jsScrollClick(pearlyMarketPage.limitButton);
        extentTest.info("Limit butonuna tiklandi");


        //10- Vendor Usage limit per coupon box'ini doldurur
        ReusableMethods.waitForClickablility(pearlyMarketPage.useLimitPerCouponBox,5);
        Assert.assertTrue(pearlyMarketPage.useLimitPerCouponBox.isDisplayed());
        extentTest.info("Usage limit per coupon box'i gorunur");
        pearlyMarketPage.useLimitPerCouponBox.sendKeys(ReusableMethods.getFaker().number().digits(2));
        extentTest.info("Usage limit per coupon box'ina deger girildi");

        //11- Vendor Limit usage to X items box'ini doldurur
        ReusableMethods.waitForClickablility(pearlyMarketPage.limitUsageToXItemsBox, 1000);
        Assert.assertTrue(pearlyMarketPage.limitUsageToXItemsBox.isDisplayed());
        extentTest.info("Limit usage to X items box'i gorunur");
        pearlyMarketPage.limitUsageToXItemsBox.sendKeys(ReusableMethods.getFaker().number().digit());
        extentTest.info("Limit usage to X items box'ina deger girildi");


        //12- Vendor Usage limit per user box'ini doldurur
        Assert.assertTrue(pearlyMarketPage.usageLimitPerUserBox.isDisplayed());
        extentTest.info("Usage limit per use box'i gorunur");
        pearlyMarketPage.usageLimitPerUserBox.sendKeys(ReusableMethods.getFaker().number().digit());
        extentTest.info("Usage limit per use box'ina deger girildi");

        //13- Vendor Submit butonunun gorunur oldugunu dogrular
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //14- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");
        //pearlyMarketPage.submitButton.click();

        //15- Vendor "Please insert atleast Coupon Title before submit." yazisinin goruldugunu dogrular
        ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);

        Assert.assertTrue(pearlyMarketPage.pleaseInsertAtleastCouponTitle.isDisplayed());
        extentTest.info("Please insert atleast Coupon Title before submit. gorundu");

        try {
            ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);
        } catch (Exception e) {
            ReusableMethods.getScreenshotWebElement("US014_NTC_001",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        }

        Thread.sleep(3000);

        ReusableMethods.getScreenshotWebElement("US014_NTC_001",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        extentTest.pass("Please insert atleast Coupon Title before submit. yazisinin screenshoti alindi");

        //16- Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass("US015 Negatif Test 01 tamamlandi");

    }
}
