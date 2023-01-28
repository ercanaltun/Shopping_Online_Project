package tests.enes.us004;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageEnes;
import tests.enes.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US004_PositiveTests extends TestBaseRapor {

    PearlyMarketPageEnes market = new PearlyMarketPageEnes();


    @Test
    public void TC_001() throws InterruptedException {
        extentTest = extentReports.createTest("TC_001", "Secilen ürünler View Cartta görülmeli; " +
                "Rakam, miktar ve toplam olarak görülmeli");

        Login.login();

        // 3. vendor Anasayfada bulunan Sign Out' a  tıkla
        market.signOut.click();
        Assert.assertTrue(market.myAccount.isDisplayed());

        extentTest.info("vendor Anasayfada bulunan Sign Out' a tikladi.");

        // 4. vendor Orders'a tıkla
        market.orders.click();
        extentTest.info("vendor orders text'ine tıkladi.");

        // 5. vendor sayfasında "Browse products" / "GO SHOP" butonuna tıklar.
        ReusableMethods.jsScrollClick(market.goShop);
        extentTest.info("vendor 'Browse products' / 'GO SHOP' butonuna tıklandi.");

        // 6. Urun sayfasinda 5 tane urunu sepete ekle
        for (int i = 0; i < market.conList.size(); i++) {
            Thread.sleep(2000);
            ReusableMethods.jsScrollClick(market.conList.get(i));
            Thread.sleep(1000);
            try {
                if (market.sepeteEkle.isDisplayed()) {
                    market.sepeteEkle.click();
                    Thread.sleep(2000);
                    Driver.getDriver().navigate().back();
                    Driver.getDriver().navigate().back();
                } else
                    Driver.getDriver().navigate().back();
            } catch (Exception e) {
                Driver.getDriver().navigate().back();
            }



            if (Integer.parseInt(market.cartCount.getText()) == 5) {
                break;
            }
        }

        extentTest.info("vendor urun sayfasinda 5 tane urunu sepete eklendi.");



        // 7. vendor sepet butonuna tikla.
        ReusableMethods.jsScrollClick(market.cart);
        extentTest.info("vendor Sepet butonuna tiklanir.");

        // 8. vendor secilen ürünler View Cartta görülmeli
        Assert.assertTrue(market.viewCartList.size() == 5);


        // 9. vendor acilan ekranda "VIEW CART" butonuna tıkla.
        market.viewCart.click();
        Thread.sleep(1000);
        extentTest.info("vendor 'VIEW CART' butonuna tıklanir.");

        // 10. vendor Price, Quantity, subtotal alanları izlenebilir.
        Assert.assertTrue(market.price.isDisplayed());
        Assert.assertTrue(market.quantity.isDisplayed());
        Assert.assertTrue(market.subtotal.isDisplayed());

        extentTest.pass("vendor secilen ürünler View Cartta görülmeli; Rakam, miktar ve toplam olarak izlenmistir");
    }

    @Test(dependsOnMethods = "TC_001")
    public void TC_002() {
        extentTest = extentReports.createTest("TC_002",
                "vendor arti ile urun rakami artirilabilmeli ve eksi ile rakamlar dusurulebilmeli.");

        //  1.Urun miktari 1 arttirilip, 1 azaltilabilir.
        int beforeCartCount = Integer.parseInt(market.cartCount.getText());

        ReusableMethods.jsScrollClick(market.firstPlus);

        ReusableMethods.jsScrollClick(market.updateCart);

        ReusableMethods.jsScroll(market.cartCount);
        ReusableMethods.waitFor(10);
        int afterPlusCartCount = Integer.parseInt(market.cartCount.getText());

        Assert.assertTrue(beforeCartCount < afterPlusCartCount);


        ReusableMethods.jsScrollClick(market.firstMinus);

        ReusableMethods.jsScrollClick(market.updateCart);
        ReusableMethods.waitFor(10);
        int afterMinusCartCount = Integer.parseInt(market.cartCount.getText());

        Assert.assertTrue(afterMinusCartCount < afterPlusCartCount);

        extentTest.info("vendor urun miktari 1 arttirilip, 1 azaltilmistir.");

        // 2.Urun miktari 1 arttirilip update cart yapilmali.
        try {
            ReusableMethods.jsScrollClick(market.firstPlus);

        } catch (Exception e) {

        }

        ReusableMethods.jsScrollClick(market.updateCart);
        Assert.assertTrue(market.updateCartText.isDisplayed());

        extentTest.pass("vendor arti ile urun rakami artirilmistir ve eksi ile rakamlar dusurulebilmistir.");
    }

    @Test(dependsOnMethods = "TC_002")
    public void TC_003() {

        extentTest = extentReports.createTest("TC_003", "Stok fazlası urun eklenememeli.");

        // 1. vendor stok fazlasi urun adedi girip Update cart butonuna tıkla.

        ReusableMethods.waitFor(10);
        int beforeOverstock = Integer.parseInt(market.cartCount.getText());

        int stock = Integer.parseInt(market.firstStockInformation.getAttribute("max")) + 1;
        market.firstStockInformation.sendKeys(String.valueOf(stock));
        extentTest.info("vendor stok fazlasi urun adedi girilmistir.");

        ReusableMethods.jsScrollClick(market.updateCart);
        int afterOverstock = Integer.parseInt(market.cartCount.getText());
        extentTest.info("vendor update cart butonuna tiklanmistir.");


        Assert.assertTrue(beforeOverstock == afterOverstock);
        extentTest.pass("vendor stok fazlasi urun eklenememistir.");

    }


    @Test(dependsOnMethods = "TC_003")
    public void TC_004() {

        extentTest = extentReports.createTest("TC_004", "Coupon secenegi izlenmeli");

        // 1.Coupon discount alanı izlenmeli.
        ReusableMethods.jsScroll(market.coupon);
        Assert.assertTrue(market.coupon.isDisplayed());
        extentTest.info("vendor coupon secenegi izlenmiştir.");

        extentTest.pass("vendor coupon secenegi izlenebilmistir.");
    }

    @Test(dependsOnMethods = "TC_004")
    public void TC_005() {
        extentTest = extentReports.createTest("TC_005",
                "Shipping bilgileri sag tarafta görülmeli ve toplam rakam sagda populate etmeli.");
        ReusableMethods.jsScrollClick(market.cart);
        market.viewCart.click();

        // 1. Shipping alanları izlenebilir olmalı.
        for (int i = 0; i < market.shippingList.size(); i++) {
            Assert.assertTrue(market.shippingList.get(i).isDisplayed());

        }
        extentTest.info("vendor shipping bilgileri sag tarafta izlenmiştir.");

        // 2. Total bilgisi izlenebilmeli.
        Assert.assertTrue(market.totalInformation.isDisplayed());
        extentTest.info("vendor total bilgisi izlenmiştir.");

        extentTest.pass("vendor shipping bilgileri sag tarafta gorulmustur ve toplam rakam sagda populate edilmistir.");
    }

    @Test(dependsOnMethods = "TC_005")
    public void TC_006() {
        extentTest = extentReports.createTest("TC_006",
                "Proceed to checkout butonunun ekranda olduğunu teyit edilmeli.");

        // 1. Proceed to checkout butonunu ekranda izlenebilir.
        ReusableMethods.jsScroll(market.proceedToCheckout);
        Assert.assertTrue(market.proceedToCheckout.isDisplayed());
        extentTest.info("vendor proceed to checkout butonu izlenmiştir.");

        extentTest.pass("vendor proceed to checkout butonunun ekranda olduğunu teyit edilmistir.");
    }

    @Test(dependsOnMethods = "TC_006")
    public void TC_007() {
        extentTest = extentReports.createTest("TC_007", "Tekrar shopping devam etme butonu olmalı.");

        // 1. CONTINUE SHOPPIN buton izlenebilir.
        ReusableMethods.jsScroll(market.ContinueShopping);
        Assert.assertTrue(market.ContinueShopping.isDisplayed());
        extentTest.info("vendor CONTINUE SHOPPING butonu izlenmiştir.");

        extentTest.pass("vendor CONTINUE SHOPPING butonunun ekranda olduğunu teyit edilmistir.");


    }

    @Test(dependsOnMethods = "TC_007")
    public void TC_008() {
        extentTest = extentReports.createTest("TC_008", "Clear cart ile rakamlar silinebilmeli.");

        // 1. "CLEAR CART" butonuna tıkla

        ReusableMethods.jsScrollClick(market.clearCart);

        ReusableMethods.waitForVisibility(market.clearMessage,10);

        Assert.assertTrue(market.clearMessage.isDisplayed());

        extentTest.info("vendor 'Cart is cleared' texti izlenmiştir.");

        extentTest.pass("vendor Clear cart ile rakamlar silinebilmeli.");

        Driver.closeDriver();
    }
}
