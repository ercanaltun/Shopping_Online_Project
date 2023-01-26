package tests.sumeyye.US_21;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSumeyye;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class Us_21_TestCase_01_02_03_04_05 extends TestBaseRapor {


    PearlyMarketPageSumeyye pearlyMarketPageSumeyye = new PearlyMarketPageSumeyye();

    @Test

    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("TC_001", "Store manager olarak satis raporlarinin incelenmesi " +
                "Yillik rakamlar görünmeli");


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


        // Vendor Reports butonunun görünür olduğunu test eder

        Thread.sleep(3000);
        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.reportsButton);
        Assert.assertTrue(pearlyMarketPageSumeyye.reportsButton.isDisplayed());
        Thread.sleep(3000);
        extentTest.info("Reports butonu gorundu");


        // Vendor Reports butonuna tıklar

        Thread.sleep(3000);
        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.reportsButton);
        pearlyMarketPageSumeyye.reportsButton.click();
        Thread.sleep(3000);
        extentTest.info("Reports butonu tiklandi");


        // Vendor Year butonunun görünür olduğunu test eder

        Thread.sleep(3000);
        pearlyMarketPageSumeyye.yearButton.isDisplayed();
        Thread.sleep(3000);

        extentTest.info("Year butonu gorundu");


        // Vendor Year butonuna tıklar

        pearlyMarketPageSumeyye.yearButton.click();

        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.yearButton);
        extentTest.info("Year butonu tiklandi");

        Thread.sleep(3000);


        // Vendor Year incelemesi yapar

        pearlyMarketPageSumeyye.reports.isDisplayed();
        Thread.sleep(3000);

        extentTest.pass("Year incelemesi gorundu ");


    }

    @Test(dependsOnMethods = "test01")

    public void test02() throws InterruptedException {
        extentTest = extentReports.createTest("TC_002", "Store manager olarak satis raporlarinin incelenmesi " +
                "Gecen ay rakamlari görünmeli");


        // Vendor Last Month butonunun görünür olduğunu test eder

        Thread.sleep(3000);
        pearlyMarketPageSumeyye.lastMonthButton.isDisplayed();
        Thread.sleep(3000);

        extentTest.info("Last Month butonu gorundu");


        // Vendor Last Month butonuna tıklar

        pearlyMarketPageSumeyye.lastMonthButton.click();

        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.lastMonthButton);
        extentTest.info("Last Month butonu tiklandi");


        // Vendor Last Month incelemesi yapar

        pearlyMarketPageSumeyye.reports.isDisplayed();
        Thread.sleep(3000);


        extentTest.pass("Last Month incelemesi gorundu ");


    }

    @Test(dependsOnMethods = "test02")

    public void test03() throws InterruptedException {
        extentTest = extentReports.createTest("TC_003", "Store manager olarak satis raporlarinin incelenmesi " +
                "Bu ay rakamlari gorunmeli");


        // Vendor This Month butonunun görünür olduğunu test eder

        Thread.sleep(3000);
        pearlyMarketPageSumeyye.thisMonthButton.isDisplayed();
        Thread.sleep(3000);

        extentTest.info("This Month butonu gorundu");


        // Vendor This Month butonuna tıklar

        pearlyMarketPageSumeyye.thisMonthButton.click();

        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.thisMonthButton);
        extentTest.info("This Month butonu tiklandi");


        // Vendor This Month incelemesi yapar

        pearlyMarketPageSumeyye.reports.isDisplayed();
        Thread.sleep(3000);

        extentTest.pass("This Month incelemesi gorundu");


    }

    @Test (dependsOnMethods = "test03")

    public void test04() throws InterruptedException {
        extentTest = extentReports.createTest("TC_004", "Store manager olarak satis raporlarinin incelenmesi " +
                "Son 7 Gun rakamlari gorunmeli");


        // Vendor Last 7 Days butonunun görünür olduğunu test eder

        Thread.sleep(3000);
        pearlyMarketPageSumeyye.last7DaysButton.isDisplayed();
        Thread.sleep(3000);

        extentTest.info("This Month butonu gorundu");


        // Vendor Last 7 Days butonuna tıklar

        pearlyMarketPageSumeyye.last7DaysButton.click();

        ReusableMethods.jsScroll((WebElement) pearlyMarketPageSumeyye.last7DaysButton);
        extentTest.info("Last 7 Days butonu tiklandi");


        // Vendor Last 7 Days incelemesi yapar

        pearlyMarketPageSumeyye.reports.isDisplayed();
        Thread.sleep(3000);


        extentTest.pass("Last 7 Days incelemesi gorundu ");


    }


    @Test (dependsOnMethods = "test04")

    public void test05() throws InterruptedException {
        extentTest = extentReports.createTest("TC_005", "Store manager olarak satis raporlarinin incelenmesi " +
                "Custom butonu tiklanmali, specific bir tarih secilmeli");


        // Vendor Custom butonunun görünür olduğunu test eder

        Thread.sleep(3000);
        pearlyMarketPageSumeyye.customButton.isDisplayed();
        Thread.sleep(3000);

        extentTest.info("Custom butonu gorundu");


        // Vendor Custom butonuna tıklar

        pearlyMarketPageSumeyye.customButton.click();

        extentTest.info("Custom butonu tiklandi");


        // Vendor specific bir tarih secer

        pearlyMarketPageSumeyye.DateRange.click();
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.jsScrollClick(pearlyMarketPageSumeyye.DayMonth);
        ReusableMethods.waitForVisibility(pearlyMarketPageSumeyye.day1,10);
        ReusableMethods.jsScrollClick(pearlyMarketPageSumeyye.day1);
        ReusableMethods.waitForVisibility(pearlyMarketPageSumeyye.day2,5);
        ReusableMethods.jsScrollClick(pearlyMarketPageSumeyye.day2);
        ReusableMethods.waitFor(5);
        actions.sendKeys(Keys.PAGE_DOWN).perform();


        extentTest.pass("Custom butonu tiklandi, specific bir tarih secildi");




    }


}
