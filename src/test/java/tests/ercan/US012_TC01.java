package tests.ercan;

import org.testng.annotations.Test;

public class US012_TC01 extends BeforeAfterMethods {

    @Test
    public void testCase1() {
        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Siparişler", "Siparişler edilmiş ürünlerin sıralandığını görür");
        pearlyMarketPageErcan.orders.click();
        extentTest.info("Açılan ekrandan Orders'ı tıklandı");

        pearlyMarketPageErcan.ordersVisible.isDisplayed();
        extentTest.info("Siparişler edilmiş ürünlerin sıralandığını dogrulandı");

    }
}
