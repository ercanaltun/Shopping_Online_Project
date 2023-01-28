package tests.ercan;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US012_TC02 extends BeforeAfterMethods {

    @Test
    public void testCase2() {

        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Download", "İndirilen ürünlerin olduğu doğrulanır");
        ReusableMethods.waitFor(5);
        pearlyMarketPageErcan.downloads.click();
        extentTest.info("Download'a tıklandı");

        Assert.assertTrue(pearlyMarketPageErcan.downloadsRemaning.isDisplayed());
        extentTest.info("İndirilen ürünlerin olduğu doğrulandı");
    }
}
