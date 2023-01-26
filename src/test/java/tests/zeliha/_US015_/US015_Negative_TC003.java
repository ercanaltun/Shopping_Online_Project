package tests.zeliha._US015_;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US015_Negative_TC003 extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();


    @Test
    public void NegativeTC_003() throws IOException {

        extentTest = extentReports.createTest("US015 Negatif Test 03", "Gerekli adimlar gecildikten sonra US015 Negatif Test 03 tamamlanmali");

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

        //8- Vendor daha once kaydedilmis Codu Code bloguna yazar
        ReusableMethods.jsScroll(pearlyMarketPage.addCoupon);
        extentTest.info("Code bloguna gidildi");
        Assert.assertTrue(pearlyMarketPage.codeBox.isDisplayed());
        extentTest.info("Code blogu gorunur");
        pearlyMarketPage.codeBox.sendKeys(ConfigReader.getProperty("registeredCode"));
        extentTest.info("Code bloguna daha once olusturulmus code yazilir");

        //9- Vendor Descpription kısmını doldurur
        Assert.assertTrue(pearlyMarketPage.descriptionBox.isDisplayed());
        extentTest.info("Descpription box'i gorunur");
        pearlyMarketPage.descriptionBox.sendKeys("Negative coupon");
        extentTest.info("Descpription box'i dolduruldu");
        ReusableMethods.getScreenshotWebElement("Negative_Code",pearlyMarketPage.codeBox);
        extentTest.info("Descpription box'i dolu");

        //10- Vendor DiscountType acilir menuden secim yapar
        Assert.assertTrue(pearlyMarketPage.discountTypeBox.isDisplayed());
        extentTest.info("DiscountType acilir menu gorunur");
        ReusableMethods.select(pearlyMarketPage.discountTypeBox).selectByVisibleText("Fixed Product Discount");
        extentTest.info("DiscountType acilir menuden secim yapildi");

        //11- Vendor Coupon amount degerini girebilmeli
        Assert.assertTrue(pearlyMarketPage.couponAmountBox.isDisplayed());
        extentTest.info("Coupon amount blogu gorunur");
        pearlyMarketPage.couponAmountBox.clear();
        extentTest.info("Coupon amount blogu temizlendi");
        pearlyMarketPage.couponAmountBox.sendKeys(ReusableMethods.getFaker().number().digits(3));
        extentTest.info("Coupon amount bloguna deger verildi");

        //12- Vendor CouponExpiryDate bloguna tarih girebilmeli
        pearlyMarketPage.couponExpiryDate.sendKeys("2022-10-27");
        extentTest.info("CouponExpiryDate box'ina tarih girildi");

        //13- Vendor Allow Free Shipping checkbox tiklar
        Assert.assertTrue(pearlyMarketPage.allowFreeShipping.isDisplayed());
        extentTest.info("Allow Free Shipping checkbox gorunur");
        ReusableMethods.jsScroll(pearlyMarketPage.allowFreeShipping);
        extentTest.info("Allow Free Shipping checkbox'ina gidildi'");
        ReusableMethods.waitForClickablility(pearlyMarketPage.allowFreeShipping,3000);
        //ReusableMethods.jsScrollClick(pearlyMarketPage.allowFreeShipping);
        pearlyMarketPage.allowFreeShipping.click();
        extentTest.info("Allow Free Shipping checkbox tiklandi");

        //14- Vendor Show on Store checkbox tiklar
        Assert.assertTrue(pearlyMarketPage.showOnStore.isDisplayed());
        extentTest.info("Show on Store checkbox gorunur");
        ReusableMethods.jsScrollClick(pearlyMarketPage.showOnStore);
        extentTest.info("Show on Store checkbox tiklandi");

        //15- Vendor Submit butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //16- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");

        //17- Vendor "Coupon code already exists - customers will use the latest coupon with this code." yazisinin cıktıgını dogrular
        ReusableMethods.jsScroll(pearlyMarketPage.couponCodeAlreadyExists);
        extentTest.info("Coupon code already exists - customers will use the latest coupon with this code. yazisina gidilir");
        Assert.assertTrue(pearlyMarketPage.couponCodeAlreadyExists.isDisplayed());
        extentTest.info("Coupon code already exists - customers will use the latest coupon with this code. yazisi gorunur");
        ReusableMethods.waitForVisibility(pearlyMarketPage.couponCodeAlreadyExists,9);
        ReusableMethods.getScreenshotWebElement("US015_NTC_003",pearlyMarketPage.couponCodeAlreadyExists);
        extentTest.info("Coupon code already exists - customers will use the latest coupon with this code. yazisinin screenshoti alindi");

        //18- Sayfa kapatilir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass("US015 Negatif Test 03 tamamlandi");

    }
}
