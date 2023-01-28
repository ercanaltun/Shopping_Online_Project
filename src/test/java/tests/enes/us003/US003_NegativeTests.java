package tests.enes.us003;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageEnes;
import tests.enes.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US003_NegativeTests extends TestBaseRapor {
    PearlyMarketPageEnes market = new PearlyMarketPageEnes();


    @Test
    public void TC_006() throws InterruptedException {

        extentTest = extentReports.createTest("TC_006",
                "Adres bilgilerinde Name, LastName, Street Adress, Town/City, Postcode/zip, Phone, Email Adress alanlari bos birakildiginda order girilmemeli.");

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


        // 6. vendor Urun sayfasinda 1 tane urunu sepete ekler
        for (int i = 1; i < market.conList.size(); i++) {

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

            if (Integer.parseInt(market.cartCount.getText()) == 1) {
                extentTest.info("Urun sayfasinda 1 tane urunu sepete eklemistir.");
                break;
            }

        }

        // 7. vendor Sepet butonuna tikla.
        ReusableMethods.jsScrollClick(market.cart);
        extentTest.info("Sepet butonuna tiklanir.");

        // 8. vendor acilan ekranda "Checkout" butonuna tıklar.
        market.checkout.click();
        extentTest.info("'Checkout' butonuna tıklanir.");

        // 9. vendor First Name siler.
        market.name.clear();
        extentTest.info("'First Name' alanina name silinir.");

        // 10. vendor Last name siler.
        market.lastName.clear();
        extentTest.info("'Last Name' alanina name silinir.");

        // 11. vendor Company name gir.
        market.company.clear();
        market.company.sendKeys(Faker.instance().company().name());
        extentTest.info("'Company' alanina name siler.");

        // 12. vendor Country/ Region seçimi yapar.
        ReusableMethods.jsScrollClick(market.country);
        market.countryList.click();
        extentTest.info("'Country/ Region' seçimi yapilir.");

        // 13. vendor Street adress siler.
        market.streetAdress.clear();
        extentTest.info("'Street' adress silinir.");

        // 14. vendor  Town/City adı siler.
        market.town.clear();
        extentTest.info("'Town/City' adı silinir.");

        // 15. vendor State / Country seçimi yap.
        ReusableMethods.waitForClickablility(market.state, 5);
        ReusableMethods.jsScrollClick(market.state);
        ReusableMethods.jsScrollClick(market.stateList);
        extentTest.info("'State / Country' seçimi yapilir.");

        // 16. vendor Postcode/zip siler.
        market.zipCode.clear();
        extentTest.info("'Postcode/zip' alani silinir.");

        // 17. vendor Phone siler.
        market.phone.clear();
        extentTest.info("'Phone' alani silinir.");

        // 18. vendor Email Adress siler.
        ReusableMethods.jsScroll(market.emailAdress);
        market.emailAdress.clear();
        extentTest.info("'Email Adress' alani silinir.");

        // 19. vendor Place order'a tıklanir.
        ReusableMethods.jsScrollClick(market.placeOrder);
        extentTest.info("Place order'a tıklanir.");

        ReusableMethods.waitForVisibility(market.billingFirstName, 8);

        // 'BILLING FIRST NAME is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingFirstName.isDisplayed());
        extentTest.info("'BILLING FIRST NAME is a required field.' uyarisi izlenmiştir.");

        // 'BILLING LAST NAME is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingLastName.isDisplayed());
        extentTest.info("' BILLING LAST NAME is a required field.' uyarisi izlenmiştir.");

        // 'BILLING STREET ADDRESS is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingaddressMajor.isDisplayed());
        extentTest.info("'BILLING STREET ADDRESS is a required field.' uyarisi izlenmiştir.");

        // 'BILLING TOWN / CITY is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingCity.isDisplayed());
        extentTest.info("'BILLING TOWN / CITY is a required field.' uyarisi izlenmiştir.");

        // 'BILLING ZIP CODE is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingPostcode.isDisplayed());
        extentTest.info("'BILLING ZIP CODE is a required field.' uyarisi izlenmiştir.");

        // 'BILLING PHONE is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingPhone.isDisplayed());
        extentTest.info("'BILLING ZIP CODE is a required field.' uyarisi izlenmiştir.");

        // 'BILLING EMAIL ADDRESS is a required field.' uyarisi izlenmelidir.
        Assert.assertTrue(market.billingEmail.isDisplayed());
        extentTest.info("'BILLING EMAIL ADDRESS is a required field.' uyarisi izlenmiştir.");


        extentTest.pass("Adres bilgilerinde Name, LastName, Street Adress, Town/City, Postcode/zip, " +
                "Phone, Email Adress alanlari bos birakildiginda order girilemedi.");

        Driver.closeDriver();

    }

}






