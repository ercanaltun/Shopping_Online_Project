package tests.ercan;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

public class US011_TC02 extends BeforeAfterMethods {

    @Test
    public void testCase2() {
        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Products", "Units Per Piece karşısındaki arama butonuna  pozitif değer girer");
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
        pearlyMarketPageErcan.unitsPerPiece.clear();
        ReusableMethods.waitFor(2);
        pearlyMarketPageErcan.unitsPerPiece.sendKeys("100");
        extentTest.info("Units Per Piece karşısındaki arama butonuna  pozitif değer girildi");

        pearlyMarketPageErcan.submit.click();
        extentTest.info("Submit butonunu tıklandı");


        //11.Units Per Piece(parça başına ) alt kısmında "productSuccessfullyPublished" text'ini görür
        ReusableMethods.waitFor(1);
        Assert.assertTrue(pearlyMarketPageErcan.productSuccessfullyPublishedText.isDisplayed());
        extentTest.info("Units Per Piece alt kısmında productSuccessfullyPublished text'i görüldü");
    }
}
