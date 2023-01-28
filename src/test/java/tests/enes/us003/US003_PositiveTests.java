package tests.enes.us003;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageEnes;
import tests.enes.Login;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class US003_PositiveTests extends TestBaseRapor {

    PearlyMarketPageEnes market = new PearlyMarketPageEnes();
    Faker faker = new Faker();


    @Test
    public void TC_001() {

        extentTest = extentReports.createTest("TC_001", "Orders da Browse products/ Go Shop a gidilmeli.");

        Login.login();

        // 3. vendor Anasayfada bulunan Sign Out' a  tıkla
        market.signOut.click();
        Assert.assertTrue(market.myAccount.isDisplayed());

        // 4. vendor Orders'a tıkla
        market.orders.click();
        extentTest.info("orders text'ine tıklandi.");

        // 5. vendor sayfasında "Browse products" / "GO SHOP" butonuna tıklar.
        ReusableMethods.jsScrollClick(market.goShop);
        extentTest.info("'Browse products' / 'GO SHOP' butonuna tıklandi.");

        extentTest.pass("Orders da Browse products/ Go Shop' a gidilmistir.");
    }

    @Test(dependsOnMethods = "TC_001")
    public void TC_002() throws InterruptedException {
        extentTest = extentReports.createTest("TC_002", "5 urun secilmeli ve Secilen ürünler tek tek sepete aktarilmali.");

        // 1. vendor Urun sayfasinda 5 tane urunu sepete ekler.
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

            extentTest.info("Urun sayfasinda 5 tane urunu sepete eklenir.");

            if (Integer.parseInt(market.cartCount.getText()) == 5) {
                break;
            }
        }

        extentTest.pass("5 urun secilmeli ve Secilen ürünler tek tek sepete aktarilmistir.");


    }

    // TC_003 Sepete gidilmeli  ve oradan checkout a gidilmeli.
    @Test(dependsOnMethods = "TC_002")
    public void TC_003() throws InterruptedException {
        extentTest = extentReports.createTest("TC_003", "Sepete gidilmeli  ve ordan checkout a gidilmeli.");

        // 1. vendor Sepet butonuna tikla.
        ReusableMethods.jsScrollClick(market.cart);
        extentTest.info("Sepet butonuna tiklanir.");

        // 2.Acilan ekranda "VIEW CART" butonuna tıklar.
        market.viewCart.click();
        Thread.sleep(1000);
        extentTest.info("'VIEW CART' butonuna tıklanir.");

        // 3. "PROCEED TO CHECKOUT" butonuna  tıklar.
        ReusableMethods.jsScrollClick(market.proceedToCheckout);
        extentTest.info("'PROCEED TO CHECKOUT' butonuna tıklanir.");

        extentTest.pass("Sepete gidilmeli  ve ordan checkout' a gidilmiştir.");
    }


    // TC_004 Tum address bilgileri tam olarak girilmeli.
    @Test(dependsOnMethods = "TC_003")
    public void TC_004() {
        extentTest = extentReports.createTest("TC_004", "Tum address bilgileri tam olarak girilmeli.");

        // 1. vendor First Name gir
        market.name.clear();
        market.name.sendKeys(Faker.instance().name().firstName());
        extentTest.info("'First Name' alanina name girilir.");

        // 2. vendor Last name gir.
        market.lastName.clear();
        market.lastName.sendKeys(Faker.instance().name().lastName());
        extentTest.info("'Last Name' alanina name girilir.");

        // 3. vendor Company name gir
        market.company.clear();
        market.company.sendKeys(Faker.instance().company().name());
        extentTest.info("'Company' alanina name girilir.");

        // 4. vendor Country/ Region seçimi yapar
        ReusableMethods.jsScrollClick(market.country);
        market.countryList.click();
        extentTest.info("'Country/ Region' seçimi yapilir.");

        // 5. vendor Street adress gir.
        market.streetAdress.clear();
        market.streetAdress.sendKeys(Faker.instance().address().streetAddress());
        extentTest.info("'Street' adress girilir.");

        // 6. vendor  Town/City adı gir.
        market.town.clear();
        market.town.sendKeys("Elazig");
        extentTest.info("'Town/City' adı girilir.");

        // 7. vendor State / Country seçimi yap.
        ReusableMethods.waitForClickablility(market.state, 5);
        ReusableMethods.jsScrollClick(market.state);
        ReusableMethods.jsScrollClick(market.stateList);
        extentTest.info("'State / Country' seçimi yapilir.");

        // 8. vendor Postcode/zip gir.
        market.zipCode.clear();
        market.zipCode.sendKeys(Faker.instance().address().zipCode());
        extentTest.info("'Postcode/zip' alani yapilir.");

        // 9. vendor Phone gir.
        market.phone.clear();
        market.phone.sendKeys(faker.phoneNumber().cellPhone());
        extentTest.info("'Phone' alani girilir.");

        extentTest.pass("Tum address bilgileri tam olarak girilmiştir.");

    }


    // TC_005 Place order diyerek order yapılmalı
    @Test(dependsOnMethods = "TC_004")
    public void TC_005() {
        extentTest = extentReports.createTest("TC_005", "Place order diyerek order yapilmali.");

        //1. vendor Place order'a tıkla.
        ReusableMethods.jsScrollClick(market.placeOrder);
        extentTest.info("Place order'a tıklanir.");

        // "Thank you. Your order has been received."
        Assert.assertTrue(market.orderCompleteText.getText().contains(ConfigReader.getProperty("orderCompleteText")));
        extentTest.info("'Thank you. Your order has been received.' texti izlenebilmistir.");

        extentTest.pass("Place order diyerek order yapilmistir");


        Driver.closeDriver();

    }

}
