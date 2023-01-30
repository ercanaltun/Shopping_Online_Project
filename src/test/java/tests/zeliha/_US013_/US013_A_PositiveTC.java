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

public class US013_A_PositiveTC extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();

    @Test
    public void TC_001() throws  IOException {

        extentTest = extentReports.createTest("CouponCoduVerme", "Gerekli adimlar gecildikten sonra coupon codu verebilmeli");

        //1 - Vendor https://pearlymarket.com/ sayfasina gider
        //2 - Vendor login olur

        Login.login();
        extentTest.info("Vendor login oldu");

        ReusableMethods.waitForClickablility(pearlyMarketPage.myAcount,5);

        //3- Vendor My Account butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.myAcount);
        extentTest.info("My Account butonuna gidilir");

        Assert.assertTrue(pearlyMarketPage.myAcount.isDisplayed());
        extentTest.info("My Account butonu gorunur");

        //4-  Vendor My Account butonuna tiklar
        ReusableMethods.jsScrollClick(pearlyMarketPage.myAcount);
        extentTest.info("My Account butonuna tiklanir");

        //5 - Vendor Store Manager butonunun gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.storeManager.isDisplayed());
        extentTest.info("Store Manager butonu gorunur");

        //6- Vendor Store Manager butonuna tiklar
        pearlyMarketPage.storeManager.click();
        extentTest.info("Store Manager butonu tiklanir");

        //7- Vendor Coupons butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.couponsButton);
        extentTest.info("Coupons butonuna gidilir");
        Assert.assertTrue(pearlyMarketPage.couponsButton.isDisplayed());
        extentTest.info("Coupons butonunun gorunur");

        //8- Vendor Coupons butonuna tiklar
        pearlyMarketPage.couponsButton.sendKeys(Keys.ENTER);
        extentTest.info("Coupons butonu tiklanir");

        //9- Vendor Add New butonunun gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.addNewButton.isDisplayed());
        extentTest.info("Add New butonunun gorunur");

        //10- Vendor Add New butonuna tiklar
        pearlyMarketPage.addNewButton.sendKeys(Keys.ENTER);
        extentTest.info("Add New butonuna tiklandi");

        //11- Vendor Code blogunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.addCoupon);
        extentTest.info("Code bloguna gidilir");
        Assert.assertTrue(pearlyMarketPage.codeBox.isDisplayed());
        extentTest.info("Code blogu gorunur");

        //12- Vendor Code bloguna kod yazar
        pearlyMarketPage.codeBox.sendKeys(ReusableMethods.getFaker().number().digits(8));
        extentTest.info("Code bloguna kod yazildi");

        //13- Vendor Code blogunun dolu oldugunu dogrular
        ReusableMethods.getScreenshotWebElement("Code",pearlyMarketPage.codeBox);
        extentTest.info("Code blogunun dolu oldugu dogrulandi");

        extentTest.pass("Store Manager olarak coupon kodu verildi");
    }

    @Test(dependsOnMethods = "TC_001")
    public void TC_002() throws IOException {

        extentTest = extentReports.createTest("DescriptionAdiVerebilme", "Gerekli adimlar gecildikten sonra Description adi verebilmeli");

        //1-Vendor login olur

        //2- Vendor Description butonunun erişilebilir oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.descriptionBox.isDisplayed());
        extentTest.info("Description butonu erisilir");

        //3- Vendor Descpription kısmını doldurur
        pearlyMarketPage.descriptionBox.sendKeys("Lucky coupon");
        extentTest.info("Description kismi dolduruldu");

        //4- Vendor Descpription dolu oldugunu kontrol eder
        ReusableMethods.getScreenshotWebElement("Descpription Lucky coupon",pearlyMarketPage.descriptionBox);
        extentTest.info("Description kismi dolu");

        extentTest.pass("Description yazildi");

    }

    @Test(dependsOnMethods = "TC_002")
    public void TC_003() throws IOException {

        extentTest = extentReports.createTest("DiscountTypeAcilirMenuSecimi", "Gerekli adimlar gecildikten sonra DiscountType açılır menuden secim yapilmali");

        //1-Vendor login olur

        //2- Vendor DiscountType açılır menusunun gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.discountTypeBox.isDisplayed());
        extentTest.info("DiscountType açılır menu gorunur");

        //3-Vendor acilir menuden secim yapar
        ReusableMethods.select(pearlyMarketPage.discountTypeBox).selectByVisibleText("Fixed Product Discount");
        extentTest.info("DiscountType açılır menuden secim yapildi");

        //4- Vendor yaptıgı secimin gorundugunu dogrular
        ReusableMethods.getScreenshotWebElement("DiscountType DropDown",pearlyMarketPage.discountTypeBox);
        extentTest.info("DiscountType açılır menu secimi gorunur");
        extentTest.pass("Indirim sekli / discount belirlendi");

    }

    @Test(dependsOnMethods = "TC_003")
    public void TC_004() throws IOException {

        extentTest = extentReports.createTest("CouponAmountDegeriVerme", "Gerekli adimlar gecildikten sonra Coupon amount bloguna deger verebilmeli");

        //1- Vendor login olur

        //2- Vendor Coupon amount blogunun gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.couponAmountBox.isDisplayed());
        extentTest.info("Coupon amount blogu gorunur");

        //3- Vendor Coupon amount degerini girebilmeli
        pearlyMarketPage.couponAmountBox.clear();
        extentTest.info("Coupon amount blogu temizlendi");
        pearlyMarketPage.couponAmountBox.sendKeys(ReusableMethods.getFaker().number().digits(3));
        extentTest.info("Coupon amount bloguna deger verildi");

        //4- Vendor girdigi degerin goruntulendigini test edebilmeli
        ReusableMethods.getScreenshotWebElement("Coupon amount",pearlyMarketPage.couponAmountBox);
        extentTest.info("Coupon amount blogu dolu");

        extentTest.pass("Coupon amount belirlendi");

    }

    @Test(dependsOnMethods = "TC_004")
    public void TC_005() throws IOException {

        extentTest = extentReports.createTest("CouponExpiryDateKismiDoldurma", "Gerekli adimlar gecildikten sonra CouponExpiryDate kismindan tarih secilebilmeli");

        //1- Vendor login olur

        //2- Vendor CouponExpiryDate kismina tiklayinca date kutusunun gorunur oldugunu test eder

        ReusableMethods.jsScroll(pearlyMarketPage.couponExpiryDate);
        extentTest.info("CouponExpiryDate box'ina gidildi");

        ReusableMethods.waitForClickablility(pearlyMarketPage.couponExpiryDate,3000);

        ReusableMethods.jsScrollClick(pearlyMarketPage.couponExpiryDate);
        extentTest.info("CouponExpiryDate box'ina tiklandi");
        Assert.assertTrue(pearlyMarketPage.couponDateBox.isDisplayed());
        extentTest.info("CouponExpiryDate box'i gorunur");

        //3- Vendor CouponExpiryDate bloguna tarih girebilmeli
        ReusableMethods.jsScrollClick(pearlyMarketPage.couponExpiryDate);
        extentTest.info("CouponExpiryDate box'i tiklandi");

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

        //4- Vendor girdigi tarihin goruntulendigini test edebilmeli
        ReusableMethods.getScreenshotWebElement("CouponExpiryDate",pearlyMarketPage.couponExpiryDate);
        extentTest.info("CouponExpiryDate box'inda tarih gorunur");

        extentTest.pass("Coupon expiry date / urun kuponu son kullanım tarihi girildi");

    }

    @Test(dependsOnMethods = "TC_005")
    public void TC_006() throws IOException {

        extentTest = extentReports.createTest("AllowFreeShippingCheckboxTiklama", "Gerekli adimlar gecildikten sonra Allow Free Shipping checkbox'i tiklanmali");

        //1- Vendor login olur

        //2- Vendor Allow Free Shipping checkbox gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.allowFreeShipping.isDisplayed());
        extentTest.info("Allow Free Shipping checkbox gorunur");

        //3- Vendor Allow Free Shipping checkbox tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.allowFreeShipping);
        extentTest.info("Allow Free Shipping checkbox'ina gidildi'");

        ReusableMethods.waitForClickablility(pearlyMarketPage.allowFreeShipping,3000);
        //ReusableMethods.jsScrollClick(pearlyMarketPage.allowFreeShipping);
        pearlyMarketPage.allowFreeShipping.click();
        extentTest.info("Allow Free Shipping checkbox tiklandi");

        //4- Vendor Allow Free Shipping checkbox'inin tiklandigini test eder
        ReusableMethods.getScreenshotWebElement("Allow Free Shipping",pearlyMarketPage.allowFreeShipping);
        extentTest.info("Allow Free Shipping checkbox tiklandi");

        extentTest.pass("Free shipping uygulandi");

    }

    @Test(dependsOnMethods = "TC_006")
    public void TC_007() throws IOException, InterruptedException {

        extentTest = extentReports.createTest("ShowOnStoreCheckboxTiklama", "Gerekli adimlar gecildikten sonra Show on Store checkbox'i tiklanmali");

        //1- Vendor login olur

        //2- Vendor Show on Store checkbox gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.showOnStore.isDisplayed());
        extentTest.info("Show on Store checkbox gorunur");


        //3- Vendor Show on Store checkbox tiklar
        ReusableMethods.jsScrollClick(pearlyMarketPage.showOnStore);
        extentTest.info("Show on Store checkbox tiklandi");

        //4- Vendor Show on Store checkbox'inin tiklandigini test eder
        ReusableMethods.getScreenshotWebElement("Show on Store",pearlyMarketPage.showOnStore);
        extentTest.info("Show on Store checkbox'inin tiklandigi dogrulandi");

        //5- Vendor tum bilgilerin dolduruldugunu kontrol eder
        ReusableMethods.getScreenshotWebElement("US_013 tum bilgiler",pearlyMarketPage.couponVerification);
        extentTest.info("US_013 tum bilgiler dolduruldugu kontrol edildi");

        //6- Vendor Submit butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //7- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");


        //8- Vendor "Coupon Successfully Published." yazisinin cıktigini dogrular

        ReusableMethods.waitForVisibility(pearlyMarketPage.couponSuccessfullyPublish,5);

        Assert.assertTrue(pearlyMarketPage.couponSuccessfullyPublish.isDisplayed());
        extentTest.info("Coupon Successfully Published. yazisi dogrulandi");

        try {
            ReusableMethods.waitForVisibility(pearlyMarketPage.couponSuccessfullyPublish,5);
        } catch (Exception e) {
            ReusableMethods.getScreenshotWebElement("US_0013_Coupon Successfully Published.",pearlyMarketPage.couponSuccessfullyPublish);
        }

        ReusableMethods.getScreenshotWebElement("US_0013_Coupon Successfully Published.",pearlyMarketPage.couponSuccessfullyPublish);
        extentTest.info("Coupon Successfully Published. yazisinin screenshoti alindi");

        ReusableMethods.waitForVisibility(pearlyMarketPage.draftButton,5);

        //9- Vendor Draft butonunun gorunur oldugunu dogrular
        ReusableMethods.jsScroll(pearlyMarketPage.draftButton);
        extentTest.info("Draft butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.draftButton.isDisplayed());
        extentTest.info("Draft butonu gorunur");

        //10- Vendor Draft butonuna tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.draftButton);
        extentTest.info("Draft butonuna gidildi");
        pearlyMarketPage.draftButton.sendKeys(Keys.ENTER);
        extentTest.info("Draft butonu tiklandi");

        //11- Vendor "Coupon Successfully Saved." yazisinin gorunur oldugunu dogrular
        ReusableMethods.waitForVisibility(pearlyMarketPage.couponSuccessfullySaved,5);

        Assert.assertTrue(pearlyMarketPage.couponSuccessfullySaved.isDisplayed());
        extentTest.info("Coupon Successfully Saved. yazisi dogrulandi");

        ReusableMethods.getScreenshotWebElement("US_0013_Coupon Successfully Saved.",pearlyMarketPage.couponSuccessfullySaved);
        extentTest.info("Coupon Successfully Saved. yazisinin screenshoti alindi");


        //12- Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass(" Show on store secilmistir");


    }

}
