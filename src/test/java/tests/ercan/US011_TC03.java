package tests.ercan;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US011_TC03 extends BeforeAfterMethods {
    @Test
    public void testCase3() {

        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Products", "Min Order Quantity karşısındaki arama butonuna  pozitif değer girer");
        pearlyMarketPageErcan.myStore.click();
        extentTest.info("Store Manager tıklandı");

        pearlyMarketPageErcan.pruducts.click();
        extentTest.info("Products sekmesi tıklandı");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        pearlyMarketPageErcan.edit.click();
        extentTest.info("ürünlerden 2.ürünün edit butonu click edildi");

        ReusableMethods.jsScroll(pearlyMarketPageErcan.inventory);
        ReusableMethods.waitFor(1);
        pearlyMarketPageErcan.toptanUrunAyarlar.click();
        extentTest.info("Toptan Ürün Gösterme Ayarları click edildi");

        ReusableMethods.waitFor(3);
        pearlyMarketPageErcan.minOrder.clear();
        ReusableMethods.waitFor(2);
        pearlyMarketPageErcan.minOrder.sendKeys("100");
        extentTest.info("Min Order Quantity karşısındaki arama butonuna  pozitif değer girildi");

        pearlyMarketPageErcan.submit.click();
        extentTest.info("Submit butonunu tıklandı");

        //11. Min Order Quantity(minimum sipariş miktarı) alt kısmında "productSuccessfullyPublished" text'ini görür
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPageErcan.productSuccessfullyPublishedText.isDisplayed());
        extentTest.info("Min Order Quantity alt kısmında productSuccessfullyPublished text'i görüldü");
    }
}
