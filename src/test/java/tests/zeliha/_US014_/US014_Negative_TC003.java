package tests.zeliha._US014_;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageZeliha;

import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US014_Negative_TC003 extends TestBaseRapor {

    PearlyMarketPageZeliha pearlyMarketPage = new PearlyMarketPageZeliha();

    @Test
    public void NegativeTC_003() throws IOException, InterruptedException {

        extentTest = extentReports.createTest("US014 Negatif Test 03", "Gerekli adimlar gecildikten sonra US014 Negatif Test 03 tamamlanmali");

        //1 - Vendor https://pearlymarket.com/ sayfasina gider
        //2 - Vendor olarak login yapar
        Login.login();
        extentTest.info("Vendor login oldu");

        //3-  Vendor My Account butonuna tiklar
        ReusableMethods.waitForClickablility(pearlyMarketPage.myAcount, 2000);
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

        JavascriptExecutor jsx = (JavascriptExecutor) Driver.getDriver();
        jsx.executeScript("window.scrollBy(0,850)", "");


        //9- Vendor Individual use only checkbox'ini tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.individualUseOnlyBox);
        extentTest.info("Individual use only checkbox'ina gidildi");
        Assert.assertTrue(pearlyMarketPage.individualUseOnlyBox.isDisplayed());
        extentTest.info("Individual use only checkbox'i gorunur");
        ReusableMethods.jsScrollClick(pearlyMarketPage.individualUseOnlyBox);
        extentTest.info("Individual use only checkbox'i tiklandi");


        //10- Vendor Exclude sale items checkbox'ini tiklar
        ReusableMethods.jsScroll(pearlyMarketPage.excludeSaleItemsBox);
        extentTest.info("Exclude sale items checkbox'ina gidildi");
        Assert.assertTrue(pearlyMarketPage.excludeSaleItemsBox.isDisplayed());
        extentTest.info("Exclude sale items checkbox'i gorunur");
        pearlyMarketPage.excludeSaleItemsBox.click();
        extentTest.info("Exclude sale items checkbox tiklandi");


        //11- Vendor Submit butonunun gorunur oldugunu dogrular
        ReusableMethods.jsScroll(pearlyMarketPage.submitButton);
        extentTest.info("Submit butonuna gidildi");
        Assert.assertTrue(pearlyMarketPage.submitButton.isDisplayed());
        extentTest.info("Submit butonu gorunur");

        //12- Vendor Submit butonuna tiklar
        pearlyMarketPage.submitButton.sendKeys(Keys.ENTER);
        extentTest.info("Submit butonu tiklandi");

        //13- Vendor "Please insert atleast Coupon Title before submit." yazisinin goruldugunu dogrular
        ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);

        Assert.assertTrue(pearlyMarketPage.pleaseInsertAtleastCouponTitle.isDisplayed());
        extentTest.info("Please insert atleast Coupon Title before submit. gorundu");

        try {
            ReusableMethods.waitForClickablility(pearlyMarketPage.pleaseInsertAtleastCouponTitle,5);
        } catch (Exception e) {
            ReusableMethods.getScreenshotWebElement("US014_NTC_003",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        }

        Thread.sleep(3000);

        ReusableMethods.getScreenshotWebElement("US014_NTC_003",pearlyMarketPage.pleaseInsertAtleastCouponTitle);
        extentTest.pass("Please insert atleast Coupon Title before submit. yazisinin screenshoti alindi");

        //14- Sayfayi kapatir
        Driver.closeDriver();
        extentTest.info("Sayfa kapatildi");

        extentTest.pass("US014 Negatif Test 03 tamamlandi");

    }
}
