package tests.zeliha._US013_;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US013_Negative_TC003 extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();

    @Test
    public void NegativeTC_003() throws IOException, InterruptedException {

        extentTest = extentReports.createTest("US013 Negatif Test 03", "Gerekli adimlar gecildikten sonra US013 Negatif Test 03 tamamlanmali");

        //1 - Vendor https://pearlymarket.com/ sayfasina gider
        //2 - Vendor olarak login yapar
        Login.login();

        ReusableMethods.waitForClickablility(pearlyMarketPage.myAcount,5);

        Thread.sleep(3000);
        //3 - Vendor My Account butonuna tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.myAcount);
        extentTest.info("My Account butonuna gidilir");
        Assert.assertTrue(pearlyMarketPage.myAcount.isDisplayed());
        extentTest.info("My Account butonu gorunur");
        ReusableMethods.jsScrollClick(pearlyMarketPage.myAcount);
        extentTest.info("My Account butonuna tiklanir");


        //4- Vendor Store Manager butonuna tiklar
        Assert.assertTrue(pearlyMarketPage.storeManager.isDisplayed());
        extentTest.info("Store Manager butonu gorunur");
        pearlyMarketPage.storeManager.click();
        extentTest.info("Store Manager butonu tiklanir");

        //5- Vendor Coupons butonuna tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.couponsButton);
        extentTest.info("Coupons butonuna gidilir");
        Assert.assertTrue(pearlyMarketPage.couponsButton.isDisplayed());
        extentTest.info("Coupons butonunun gorunur");
        pearlyMarketPage.couponsButton.sendKeys(Keys.ENTER);
        extentTest.info("Coupons butonu tiklanir");

        //6- Vendor Add New butonuna tiklar
        Assert.assertTrue(pearlyMarketPage.addNewButton.isDisplayed());
        extentTest.info("Add New butonunun gorunur");
        pearlyMarketPage.addNewButton.sendKeys(Keys.ENTER);
        extentTest.info("Add New butonuna tiklandi");


        //7- Vendor Coupon expiry date kismini doldurur

        Thread.sleep(3000);
        ReusableMethods.jsScroll(pearlyMarketPage.couponExpiryDate);

        try {
            ReusableMethods.jsScrollClick(pearlyMarketPage.couponAmountBox);
            ReusableMethods.jsScrollClick(pearlyMarketPage.couponExpiryDate);
            extentTest.info("CouponExpiryDate box'ina gidildi");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.getActions()
                .dragAndDrop(pearlyMarketPage.couponExpiryDate,pearlyMarketPage.couponMonth)
                .click(pearlyMarketPage.couponMonth).perform();
        extentTest.info("CouponExpiryDate blogunda acilir tarih kismina gidildi");
        ReusableMethods.select(pearlyMarketPage.couponMonth).selectByVisibleText("Dec");
        extentTest.info("CouponExpiryDate acilir menuden ay secildi");

        ReusableMethods.getActions()
                .dragAndDrop(pearlyMarketPage.couponMonth,pearlyMarketPage.couponYear)
                .click(pearlyMarketPage.couponYear).perform();
        extentTest.info("CouponExpiryDate blogunda acilir tarih kismina gidildi");
        ReusableMethods.select(pearlyMarketPage.couponYear).selectByVisibleText("2022");
        pearlyMarketPage.couponYear.click();
        extentTest.info("CouponExpiryDate acilir menuden yil secildi");

        for (WebElement dayElement : pearlyMarketPage.couponDay) {
            String text = dayElement.getText();
            if (text.equals("23")){
                ReusableMethods.jsScrollClick(dayElement);
                break;
            }
        }
        extentTest.info("CouponExpiryDate acilir menuden gun secildi");



        //8- Vendor Allov free shipping checkbox'ini tiklar
        Assert.assertTrue(pearlyMarketPage.allowFreeShipping.isDisplayed());
        extentTest.info("Allow Free Shipping checkbox gorunur");
        ReusableMethods.jsScroll(pearlyMarketPage.allowFreeShipping);
        extentTest.info("Allow Free Shipping checkbox'ina gidildi'");
        ReusableMethods.waitForClickablility(pearlyMarketPage.allowFreeShipping,3000);
        pearlyMarketPage.allowFreeShipping.click();
        extentTest.info("Allow Free Shipping checkbox tiklandi");

        //9- Vendor Submit butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //10- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");

        //11- Vendor "Please insert atleast Coupon Title before submit." yazisinin gorunur oldugunu test eder
        ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);

        Assert.assertTrue(pearlyMarketPage.pleaseInsertAtleastCouponTitle.isDisplayed());
        extentTest.info("Please insert atleast Coupon Title before submit. gorundu");

        try {
            ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);
        } catch (Exception e) {
            ReusableMethods.getScreenshotWebElement("US013_NTC_003",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        }

        Thread.sleep(3000);

        ReusableMethods.getScreenshotWebElement("US013_NTC_003",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        extentTest.pass("Please insert atleast Coupon Title before submit. yazisinin screenshoti alindi");


        //12- Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass("US013 Negatif Test 03 tamamlandi");

    }

}
