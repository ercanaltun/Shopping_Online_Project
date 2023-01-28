package tests.ercan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ReusableMethods;

import java.util.List;

public class US011_TC01 extends BeforeAfterMethods {

    @Test
    public void testCase1() {
        //Login olur ve My Account tıklanır

        extentTest = extentReports.createTest("Products", "Toptan Ürün Gösterme Ayarları'ndan Piece,Carton ve Kg seçeneklerinin gorunur oldugunu test eder");
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


        //9.Select butonunda : Piece, Carton ve Kg seçeneklerinin gorunur oldugunu test eder
        select = new Select(pearlyMarketPageErcan.pieceTypeSelect);
        List<WebElement> selectList = select.getOptions();
        for (int i = 1; i < selectList.size(); i++) {
            ReusableMethods.waitFor(1);
            Assert.assertTrue(selectList.get(i).isDisplayed());
            ReusableMethods.waitFor(1);
        }
        extentTest.info("Piece, Carton ve Kg seçeneklerinin gorunur oldugu test edildi");

        //10.Seceneklerin hepsinin secilebilir oldugunu dogrular.
        select = new Select(pearlyMarketPageErcan.pieceTypeSelect);
        selectList.get(1).click();
        ReusableMethods.waitFor(5);
        Assert.assertTrue(selectList.get(1).isSelected());
        selectList.get(2).click();
        ReusableMethods.waitFor(5);
        Assert.assertTrue(selectList.get(2).isSelected());
        selectList.get(3).click();
        ReusableMethods.waitFor(5);
        Assert.assertTrue(selectList.get(3).isSelected());
        extentTest.info("Piece, Carton ve Kg seçeneklerinin secilebilir oldugu test edildi");
    }

}
