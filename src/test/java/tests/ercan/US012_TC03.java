package tests.ercan;

import org.testng.Assert;
import org.testng.annotations.Test;

public class US012_TC03 extends BeforeAfterMethods {

    @Test
    public void testCase3() {

        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Addresses", "Adreslerin doğruluğu sorgulanır");
        pearlyMarketPageErcan.addresses.click();
        extentTest.info("Addresses butonuna tıklandı");

        Assert.assertTrue(pearlyMarketPageErcan.billingAddresses.isDisplayed());
        extentTest.info("Shipping Address(Teslimat adresi) listelendiği görüldü");

        Assert.assertTrue(pearlyMarketPageErcan.shippingAddresses.isDisplayed());
        extentTest.info("Billing Address(Faruta adresi) listelendiği görüldü");

        Assert.assertEquals(pearlyMarketPageErcan.billingAddresses.getText(), pearlyMarketPageErcan.shippingAddresses.getText());
        extentTest.info("Billing Address(Faruta adresi) ile Shipping Address(Teslimat adresi)'in aynı olduğu doğrulandı");

    }
}
