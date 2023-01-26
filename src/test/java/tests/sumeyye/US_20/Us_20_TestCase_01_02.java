package tests.sumeyye.US_20;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSumeyye;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class Us_20_TestCase_01_02 extends TestBaseRapor {

    PearlyMarketPageSumeyye pearlyMarketPageSumeyye = new PearlyMarketPageSumeyye();

    @Test

    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("TC_001", "Store manager olarak ürünlerin incelenebilmesi " +
                "Kullanici bilgileri, yorumları görülmeli ");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("Url'e gidildi");
        pearlyMarketPageSumeyye.ilkSignInButton.click();
        extentTest.info("Sign in butonuna tiklandi");
        pearlyMarketPageSumeyye.emailBox.sendKeys(ConfigReader.getProperty("vendorEmail") + Keys.ENTER);
        extentTest.info("Gecerli email yazildi");
        pearlyMarketPageSumeyye.passwordBox.sendKeys(ConfigReader.getProperty("vendorSifre") + Keys.ENTER);
        extentTest.info("Gecerli password girildi");
        pearlyMarketPageSumeyye.ikinciSignInButton.click();
        extentTest.info("İkinci sign in butonu tiklandi, giris yapildi");

        extentTest.info("Log in olundu");

        ReusableMethods.waitFor(10);
        // My Account butonunun görünür olduğunu test eder

        ReusableMethods.jsScroll(pearlyMarketPageSumeyye.myAccountButton);
        Assert.assertTrue(pearlyMarketPageSumeyye.myAccountButton.isDisplayed());
        extentTest.info("My Account butonu gorundu");


        // Vendor My Account'a tıklar
        ReusableMethods.jsScrollClick(pearlyMarketPageSumeyye.myAccountButton);
        extentTest.info("My Account butonu tiklandi");


        // Vendor Store Manager butonunun görünür olduğunu test eder

        Assert.assertTrue(pearlyMarketPageSumeyye.storeManagerButton.isDisplayed());
        extentTest.info("Store Manager butonu gorundu");


        // Vendor Store Manager butonuna tıklar

        Thread.sleep(3000);
        pearlyMarketPageSumeyye.storeManagerButton.click();
        Thread.sleep(3000);
        extentTest.info("Store Manager butonu tiklandi");


        // Vendor Reviews butonunun görünür olduğunu test eder
        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.reviewsButton);
        Assert.assertTrue(pearlyMarketPageSumeyye.reviewsButton.isDisplayed());
        extentTest.info("Reviews butonu gorundu");

        // Vendor Reviews butonuna tıklar

        Thread.sleep(3000);
        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.reviewsButton);
        pearlyMarketPageSumeyye.reviewsButton.click();
        Thread.sleep(3000);
        extentTest.info("Reviews butonu tiklandi");


        // Vendor Product Reviews butonunun görünür olduğunu test eder
        Assert.assertTrue(pearlyMarketPageSumeyye.productReviewsButton.isDisplayed());
        extentTest.info("Product Reviews butonu gorundu");


        // Vendor Product Reviews butonuna tıklar

        pearlyMarketPageSumeyye.productReviewsButton.click();
        extentTest.info("Product Reviews butonu tiklandi");

        // Vendor Author ve Comment siralanir

        ReusableMethods.jsScroll(pearlyMarketPageSumeyye.authorHeader);

        for (WebElement author : pearlyMarketPageSumeyye.authorInformations) {
            Assert.assertTrue(author.isDisplayed());
        }

        for (WebElement commentsInformation : pearlyMarketPageSumeyye.commentsInformations) {
            Assert.assertTrue(commentsInformation.isDisplayed());
        }


        extentTest.info("Kullanici bilgileri ve yorumlari gorundu");

    }



        @Test (dependsOnMethods ="test01")

        public void test02() throws InterruptedException {
            extentTest = extentReports.createTest("TC_002", "Store manager olarak ürünlerin incelenebilmesi " +
                    "Kullanicilarin verdikleri rate ve comment tarihi tanimlanmali");

            Thread.sleep(5000);


            // Vendor Rate ve Date siralanir

            for (WebElement starRating : pearlyMarketPageSumeyye.starRatings) {
                Assert.assertTrue(starRating.isDisplayed());
            }

            for (WebElement date : pearlyMarketPageSumeyye.dates) {
                Assert.assertTrue(date.isDisplayed());
            }


            extentTest.pass("Kullanicilarin verdikleri rate ve comment tarihi tanimlandi");


        }




}
