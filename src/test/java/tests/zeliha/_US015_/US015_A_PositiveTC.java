package tests.zeliha._US015_;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import tests.zeliha._US013_.US013_A_PositiveTC;
import tests.zeliha._US014_.US014_A_PositiveTC;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US015_A_PositiveTC extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();

    @Test
    public void TC_001() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("UsagelimitPerCouponBox", "Gerekli adimlar gecildikten sonra Usage limit per coupon box doldurulmali");

        //1 - Vendor https://pearlymarket.com/  sayfasina gider
        //2-Vendor login olur
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


        /*8- Vendor US_013 deki TC adimlarini tamamlar*/

        US013_A_PositiveTC us013_tc = new US013_A_PositiveTC();

        //Vendor Code blogunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.addCoupon);
        Assert.assertTrue(pearlyMarketPage.codeBox.isDisplayed());
        //Vendor Code bloguna kod yazar
        pearlyMarketPage.codeBox.sendKeys(ReusableMethods.getFaker().number().digits(8));
        //Vendor Code blogunun dolu oldugunu dogrular
        ReusableMethods.getScreenshotWebElement("Code",pearlyMarketPage.codeBox);


        try {
            us013_tc.TC_002();
            us013_tc.TC_003();
            us013_tc.TC_004();
            us013_tc.TC_005();
            us013_tc.TC_006();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        //Vendor Show on Store checkbox gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.showOnStore.isDisplayed());
        //Vendor Show on Store checkbox tiklar
        ReusableMethods.jsScrollClick(pearlyMarketPage.showOnStore);
        //Vendor Show on Store checkbox'inin tiklandigini test eder
        ReusableMethods.getScreenshotWebElement("Show on Store",pearlyMarketPage.showOnStore);

        extentTest.info("US_013 deki TC adimlarini tamamlandi");

        /*9- Vendor US_014 deki TC adimlarini tamamlar*/

        US014_A_PositiveTC us014_tc = new US014_A_PositiveTC();

        JavascriptExecutor jsx = (JavascriptExecutor)Driver.getDriver();
        jsx.executeScript("window.scrollBy(0,650)", "");


        //Vendor Minimum Spend blogunun gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.minimumAmountBox.isDisplayed());
        //Vendor Minimum Spend bloguna bir deger girer
        pearlyMarketPage.minimumAmountBox.sendKeys(ReusableMethods.getFaker().number().digits(2));
        //Vendor girdigi degerin goruldugunu kontrol eder
        ReusableMethods.getScreenshotWebElement("Minimum Spend",pearlyMarketPage.minimumAmountBox);

        Thread.sleep(3000);
        try {
            us014_tc.TC_002();
            us014_tc.TC_003();
            us014_tc.TC_004();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Vendor Exclude categories acilir menusunun gorunurlugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.excludeCategoriess);
        Assert.assertTrue(pearlyMarketPage.excludeCategoriess.isDisplayed());
        //Vendor Exclude categories acilir menuden secim yapar

        //Vendor Exclude categories acilir menuden secim yapar
        //ReusableMethods.waitForClickablility(pearlyMarketPage.excludeCategoriess,2000);

        try {
            pearlyMarketPage.excludeCategoriess.click();
            ReusableMethods.jsScrollClick(pearlyMarketPage.accessories);
        } catch (Exception e) {
            ReusableMethods.jsScrollClick(pearlyMarketPage.accessories);
        }

        //Vendor Exclude categories acilir menude yapmis oldugu secimin goruntulendigini test eder
        ReusableMethods.getScreenshotWebElement("Exclude categories",pearlyMarketPage.excludeCategoriess);

        extentTest.info("US_014 deki TC adimlarini tamamlandi");


        //10- Vendor Limit butonunun görünür oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.limitButton.isDisplayed());
        extentTest.info("Limit butonunun gorunur");

        //11- Vendor Limit  butonuna tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.limitButton);
        extentTest.info("Limit butonuna gidildi");
        ReusableMethods.jsScrollClick(pearlyMarketPage.limitButton);
        extentTest.info("Limit butonuna tiklandi");

        //12- Vendor Usage limit per coupon box'ina gorunur oldugunu test eder
        ReusableMethods.waitForClickablility(pearlyMarketPage.useLimitPerCouponBox,5);
        Assert.assertTrue(pearlyMarketPage.useLimitPerCouponBox.isDisplayed());
        extentTest.info("Usage limit per coupon box'i gorunur");

        //13- Vendor Usage limit per coupon box'ina deger girer
        pearlyMarketPage.useLimitPerCouponBox.sendKeys(ReusableMethods.getFaker().number().digits(2));
        extentTest.info("Usage limit per coupon box'ina deger girildi");

        //14- Vendor Usage limit per coupon box'ina deger girdigini dogrular
        ReusableMethods.getScreenshotWebElement("Usage limit per coupon",pearlyMarketPage.useLimitPerCouponBox);
        extentTest.info("Usage limit per coupon box'inin dolu oldugu dogrulandi");

        extentTest.pass("Usage limit per coupon box dolduruldu");
    }



    @Test(dependsOnMethods = "TC_001")
    public void TC_002() throws IOException {

        extentTest = extentReports.createTest("LimitUsageToXItemsBox", "Gerekli adimlar gecildikten sonra Limit usage to X items box doldurulmali");

        //1- Vendor login olur

        //2- Vendor Limit usage to X items box'inin görünür oldugunu test eder
        ReusableMethods.waitForClickablility(pearlyMarketPage.limitUsageToXItemsBox, 1000);
        Assert.assertTrue(pearlyMarketPage.limitUsageToXItemsBox.isDisplayed());
        extentTest.info("Limit usage to X items box'i gorunur");

        //3- Vendor Limit usage to X items box'ina deger girer
        pearlyMarketPage.limitUsageToXItemsBox.sendKeys(ReusableMethods.getFaker().number().digit());
        extentTest.info("Limit usage to X items box'ina deger girildi");

        //4- Vendor Limit usage to X items box'ina deger girdigini dogrular
        ReusableMethods.getScreenshotWebElement("Limit usage to X items",pearlyMarketPage.limitUsageToXItemsBox);
        extentTest.info("Limit usage to X items box'ininin dolu oldugu dogrulandi");

        extentTest.pass("Limit usage to X items box dolduruldu");

    }

    @Test(dependsOnMethods = "TC_002")
    public void TC_003() throws IOException {

        extentTest = extentReports.createTest("UsageLimitPerUseBox", "Gerekli adimlar gecildikten sonra Usage limit per use box doldurulmali");

        //1- Vendor login olur

        //2- Vendor Usage limit per use box'inin goruntulendigini test eder
        Assert.assertTrue(pearlyMarketPage.usageLimitPerUserBox.isDisplayed());
        extentTest.info("Usage limit per use box'i gorunur");

        //3- Vendor Usage limit per use box'inin içine deger girer
        pearlyMarketPage.usageLimitPerUserBox.sendKeys(ReusableMethods.getFaker().number().digit());
        extentTest.info("Usage limit per use box'ina deger girildi");

        //5- Vendor Submit butonunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //6- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");


        //7- Vendor "Coupon Successfully Published." yazisinin cıktigini dogrular

        ReusableMethods.waitForVisibility(pearlyMarketPage.couponSuccessfullyPublish,5);

        Assert.assertTrue(pearlyMarketPage.couponSuccessfullyPublish.isDisplayed());
        extentTest.info("Coupon Successfully Published. yazisi dogrulandi");

        try {
            ReusableMethods.waitForVisibility(pearlyMarketPage.couponSuccessfullyPublish,5);
        } catch (Exception e) {
            ReusableMethods.getScreenshotWebElement("US_0014_Coupon Successfully Published.",pearlyMarketPage.couponSuccessfullyPublish);
        }

        ReusableMethods.getScreenshotWebElement("US_0014_Coupon Successfully Published.",pearlyMarketPage.couponSuccessfullyPublish);
        extentTest.info("Coupon Successfully Published. yazisinin screenshoti alindi");


        //8- Vendor Draft butonunun gorunur oldugunu dogrular
        JavascriptExecutor jsx = (JavascriptExecutor)Driver.getDriver();
        jsx.executeScript("window.scrollBy(0,850)", "");

        ReusableMethods.jsScroll(pearlyMarketPage.draftButton);
        extentTest.info("Draft butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.draftButton.isDisplayed());
        extentTest.info("Draft butonu gorunur");

        //9- Vendor Draft butonuna tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.draftButton);
        extentTest.info("Draft butonuna gidildi");
        pearlyMarketPage.draftButton.sendKeys(Keys.ENTER);
        extentTest.info("Draft butonu tiklandi");

        //10- Vendor "Coupon Successfully Saved." yazisinin gorunur oldugunu dogrular
        ReusableMethods.waitForVisibility(pearlyMarketPage.couponSuccessfullySaved,5);

        Assert.assertTrue(pearlyMarketPage.couponSuccessfullySaved.isDisplayed());
        extentTest.info("Coupon Successfully Saved. yazisi dogrulandi");

        ReusableMethods.getScreenshotWebElement("US_0013_Coupon Successfully Saved.",pearlyMarketPage.couponSuccessfullySaved);
        extentTest.info("Coupon Successfully Saved. yazisinin screenshoti alindi");


        //8- Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass("Usage limit per use box dolduruldu");


    }

}