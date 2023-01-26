package tests.nur;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.PearlyMarketPageNur;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US018_all extends TestBaseRapor {

    /*
        Refund Requests(Geri Odeme Talepleri) - TC1007, TC1008, TC1009, TC1010
     */
    PearlyMarketPageNur pageN = new PearlyMarketPageNur();
    @BeforeTest
    public void goRefund() throws IOException {
        extentTest=extentReports.createTest("Positive Test","Refund Requests(Geri Odeme Talepleri) gorulebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        pageN.signIn.click();
        pageN.emailTextBox.sendKeys(ConfigReader.getProperty("vendor2email"));
        pageN.passTextBox.sendKeys(ConfigReader.getProperty("vendor2pass"));
        pageN.ikinciLoginButtonu.click();
        extentTest.info("Vendor olarak siteye giris yapildi");
        ReusableMethods.jsScrollClick(pageN.myAccount);
        pageN.storeManager.click();
        ReusableMethods.jsScrollClick(pageN.refund);
        extentTest.info("Refund'a gidildi");
        Assert.assertTrue(pageN.refundRequests.isDisplayed());
        extentTest.info("Refund Requests webtable goruntulendi");
    }

    @Test (priority = 1)
    public void requestID() {
        MyMethods.isInTable("Request ID");
        extentTest.pass("Request ID webtableda basariyla goruldu");
    }

    @Test ( dependsOnMethods = "requestID")
    public void orderID() {

        MyMethods.isInTable("Order ID");
        extentTest.pass("Ordert ID webtableda basariyla goruldu");
    }

    @Test (dependsOnMethods = "orderID")
    public void amountValue() {
        MyMethods.isInTable("Amount");
        extentTest.pass("Amount value webtableda basariyla goruldu");
    }

    @Test ( dependsOnMethods = "amountValue")
    public void typeAndReasonValues() {
        MyMethods.isInTable("Type");
        MyMethods.isInTable("Reason");
        extentTest.pass("Type ve Reason values webtableda basariyla goruldu");
        ReusableMethods.getActions().sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        try {
            ReusableMethods.getScreenshot( "Refund Requests WebTable");
        } catch (IOException e) {

        }

        Driver.closeDriver();
    }

}
