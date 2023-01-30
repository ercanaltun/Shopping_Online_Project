package tests.zeliha._US013_;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US013_Negative_TC001 extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();


    @Test
    public void NegativeTC_001() throws IOException, InterruptedException {

        extentTest = extentReports.createTest("US013 Negatif Test 01", "Gerekli adimlar gecildikten sonra US013 Negatif Test 01 tamamlanmali");

        //1 - Vendor https://pearlymarket.com/ sayfasina gider
        //2 - Vendor olarak login yapar
        Login.login();
        extentTest.info("Vendor login oldu");


        ReusableMethods.waitForClickablility(pearlyMarketPage.myAcount,3000);

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


        //7- Vendor Submit butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //8- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");

        //8- Vendor "Please insert atleast Coupon Title before submit." yazisinin gorunur oldugunu test eder
        ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);

        Assert.assertTrue(pearlyMarketPage.pleaseInsertAtleastCouponTitle.isDisplayed());
        extentTest.info("Please insert atleast Coupon Title before submit. gorundu");

        try {
            ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);
        } catch (Exception e) {
            ReusableMethods.getScreenshotWebElement("US013_NTC_001",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        }

        Thread.sleep(3000);

        ReusableMethods.getScreenshotWebElement("US013_NTC_001",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        extentTest.pass("Please insert atleast Coupon Title before submit. yazisinin screenshoti alindi");


        //9- Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass("US013 Negatif Test 01 tamamlandi");


    }
}
