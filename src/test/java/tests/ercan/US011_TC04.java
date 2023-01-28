package tests.ercan;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.io.IOException;

public class US011_TC04 extends BeforeAfterMethods {


    @Test
    public void testCase4() throws IOException {

        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Products", "Units Per Piece karşısındaki arama butonuna  negatif değer girer");
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
        pearlyMarketPageErcan.unitsPerPiece.sendKeys("-100");
        extentTest.info("Units Per Piece karşısındaki arama butonuna  negatif değer girildi");

        pearlyMarketPageErcan.submit.click();
        ReusableMethods.waitFor(2);
        extentTest.info("Submit butonunu tıklandı");

        //12.Units Per Piece(parça başına )alt kısmında "productSuccessfullyPublished" text'ini görmemeli
        Assert.assertTrue(pearlyMarketPageErcan.productSuccessfullyPublishedText.isDisplayed());
        ReusableMethods.waitFor(5);

        ReusableMethods.jsScroll(pearlyMarketPageErcan.inventory);
        ReusableMethods.waitFor(1);
        pearlyMarketPageErcan.toptanUrunAyarlar.click();
        ReusableMethods.waitFor(3);
        ReusableMethods.getScreenshot(pearlyMarketPageErcan.unitsPerPiece.getText());
        extentTest.info("productSuccessfullyPublished text'i görüldü ve negatif değer kabul ettiği doğrulandı ");


    }


}
