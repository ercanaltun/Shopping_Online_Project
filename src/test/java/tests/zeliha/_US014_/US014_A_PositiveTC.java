package tests.zeliha._US014_;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import tests.zeliha._US013_.US013_A_PositiveTC;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;


public class US014_A_PositiveTC extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();

    @Test
    public void TC_001() throws InterruptedException, IOException {

        extentTest = extentReports.createTest("MinimumSpend", "Gerekli adimlar gecildikten sonra Minimum Spend doldurulmali");

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

        us013_tc.TC_002();
        us013_tc.TC_003();
        us013_tc.TC_004();
        us013_tc.TC_005();
        us013_tc.TC_006();

        //Vendor Show on Store checkbox gorunur oldugunu test eder
        Assert.assertTrue(pearlyMarketPage.showOnStore.isDisplayed());
        //Vendor Show on Store checkbox tiklar
        ReusableMethods.jsScrollClick(pearlyMarketPage.showOnStore);
        //Vendor Show on Store checkbox'inin tiklandigini test eder
        ReusableMethods.getScreenshotWebElement("Show on Store",pearlyMarketPage.showOnStore);

        extentTest.info("US_013 deki TC adimlarini tamamlandi");

        JavascriptExecutor jsx = (JavascriptExecutor)Driver.getDriver();
        jsx.executeScript("window.scrollBy(0,650)", "");


         //ReusableMethods.waitForClickablility(pearlyMarketPage.minimumAmountBox,3000);


         //9- Vendor Minimum Spend blogunun gorunur oldugunu test eder
         Assert.assertTrue(pearlyMarketPage.minimumAmountBox.isDisplayed());
         extentTest.info("Minimum Spend blogu gorunur");

         //10- Vendor Minimum Spend bloguna bir deger girer
         pearlyMarketPage.minimumAmountBox.sendKeys(ReusableMethods.getFaker().number().digits(2));
         extentTest.info("Minimum Spend bloguna deger girildi");

         //11- Vendor girdigi degerin goruldugunu kontrol eder
         ReusableMethods.getScreenshotWebElement("Minimum Spend",pearlyMarketPage.minimumAmountBox);
         extentTest.info("Minimum Spend blogu degeri goruldu");
    }


    @Test(dependsOnMethods = "TC_001")
    public void TC_002() throws IOException {

        extentTest = extentReports.createTest("MaximumSpendGirme", "Gerekli adimlar gecildikten sonra Maximum Spend bloguna deger girilmeli");

        //1-Vendor login olur

        //2- Vendor Maximum Spend blogunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.maximumAmountBox);
        extentTest.info("Maximum Spend blogu bloguna gidildi");
        Assert.assertTrue(pearlyMarketPage.maximumAmountBox.isDisplayed());
        extentTest.info("Maximum Spend blogu gorunur");

        //3- Vendor Maximum Spend bloguna bir deger girer
        pearlyMarketPage.maximumAmountBox.sendKeys(ReusableMethods.getFaker().number().digits(3));
        extentTest.info("Maximum Spend blogu");

        //4- Vendor girdigi degerin goruldugunu kontrol eder
        ReusableMethods.getScreenshotWebElement("Maximum Spend",pearlyMarketPage.maximumAmountBox);
        extentTest.info("Maximum Spend blogu degeri gorunur");

        extentTest.pass("Maximum Spend miktarı girildi");
    }

    @Test(dependsOnMethods = "TC_002")
    public void TC_003() throws IOException {

        extentTest = extentReports.createTest("IndividualUseOnlyCheckbox", "Gerekli adimlar gecildikten sonra Individual use only checkbox tiklanmali");

        //1-Vendor login olur

        //2- Vendor Individual use only checkbox kutusunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.individualUseOnlyBox);
        extentTest.info("Individual use only checkbox'ina gidildi");
        Assert.assertTrue(pearlyMarketPage.individualUseOnlyBox.isDisplayed());
        extentTest.info("Individual use only checkbox'i gorunur");

        //3- Vendor  Individual use only checkbox kutusu tiklar
        pearlyMarketPage.individualUseOnlyBox.click();
        extentTest.info("Individual use only checkbox'i tiklandi");

        //4- Vendor  Individual use only checkbox kutusunun tiklandigini test eder
        ReusableMethods.getScreenshotWebElement("Individual use only",pearlyMarketPage.individualUseOnlyBox);
        extentTest.info("Individual use only checkbox tiklandigi goruldu");

        extentTest.pass("Individual use only checkbox kutusu tiklandi");

    }

    @Test(dependsOnMethods = "TC_003")
    public void TC_004() throws IOException {

        extentTest = extentReports.createTest("ExcludeSaleItemsCheckbox", "Gerekli adimlar gecildikten sonra  Exclude sale items checkbox tiklanmali");

        //1-Vendor login olur

        //2- Vendor Exclude sale items checkbox kutusunun gorunur oldugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.excludeSaleItemsBox);
        extentTest.info("Exclude sale items checkbox'ina gidildi");
        Assert.assertTrue(pearlyMarketPage.excludeSaleItemsBox.isDisplayed());
        extentTest.info("Exclude sale items checkbox'i gorunur");

        //3- Vendor  Exclude sale items checkbox kutusu tiklar
        pearlyMarketPage.excludeSaleItemsBox.click();
        extentTest.info("Exclude sale items checkbox tiklandi");

        //4- Vendor  Exclude sale items checkbox kutusunun tiklandigini test eder
        ReusableMethods.getScreenshotWebElement("Exclude sale items",pearlyMarketPage.excludeSaleItemsBox);
        extentTest.info("Exclude sale items checkbox tıklandıgı dogrulandi");

        extentTest.pass("Exclude sale items checkbox kutusu tiklandi");

    }

    @Test(dependsOnMethods = "TC_004")
    public void TC_005() throws IOException {

        extentTest = extentReports.createTest("ExcludeCategories", "Gerekli adimlar gecildikten sonra  Exclude categories secim yapilmali");

        //1-Vendor login olur

        //2- Vendor Exclude categories acilir menusunun gorunurlugunu test eder
        ReusableMethods.jsScroll(pearlyMarketPage.excludeCategoriess);
        extentTest.info("Exclude categories'e gidildi");
        Assert.assertTrue(pearlyMarketPage.excludeCategoriess.isDisplayed());
        extentTest.info("Exclude categories gorunur");

        //3- Vendor Exclude categories acilir menuden secim yapar
        //ReusableMethods.waitForClickablility(pearlyMarketPage.excludeCategoriess,2000);

        try {
            pearlyMarketPage.excludeCategoriess.click();
            ReusableMethods.jsScrollClick(pearlyMarketPage.accessories);
        } catch (Exception e) {
            ReusableMethods.jsScrollClick(pearlyMarketPage.accessories);
        }
        extentTest.info("Exclude categories acilir menusunden secim yapildi");

        //4- Vendor Exclude categories acilir menude yapmis oldugu secimin goruntulendigini test eder
        ReusableMethods.getScreenshotWebElement("Exclude categories",pearlyMarketPage.excludeCategoriess);
        extentTest.info("Exclude categories acilir menusu secimi dogrulandi");

        //5-Vendor tum bilgilerin dolduruldugunu kontrol eder
        ReusableMethods.getScreenshotWebElement("US_014 tum bilgiler",pearlyMarketPage.restrictionVerification);
        extentTest.info("Tum bilgilerin dolduruldugunu kontrol edildi");

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
            ReusableMethods.getScreenshotWebElement("US_0014_Coupon Successfully Published.",pearlyMarketPage.couponSuccessfullyPublish);
        }

        ReusableMethods.getScreenshotWebElement("US_0014_Coupon Successfully Published.",pearlyMarketPage.couponSuccessfullyPublish);
        extentTest.info("Coupon Successfully Published. yazisinin screenshoti alindi");


     //   ReusableMethods.waitForVisibility(pearlyMarketPage.draftButton,5);


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

        extentTest.pass("Exclude categories acilir menusunden secim yapildi");

    }


}
