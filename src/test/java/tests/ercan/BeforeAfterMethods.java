package tests.ercan;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.PearlyMarketPageErcan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class BeforeAfterMethods extends TestBaseRapor {
    PearlyMarketPageErcan pearlyMarketPageErcan = new PearlyMarketPageErcan();
    Actions actions = new Actions(Driver.getDriver());
    Select select;

    Faker faker = new Faker();

    @BeforeMethod
    public void seTup() {

        extentTest = extentReports.createTest("Login", "Başarılı bir şeklide login olduğu ve My Account'a tıklandığı görüldü");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("Url'e gidildi");

        pearlyMarketPageErcan.signInFirst.click();
        extentTest.info("Signin butonuna tıklandı");

        pearlyMarketPageErcan.emailaddress.sendKeys(ConfigReader.getProperty("projeEmail"));
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("projePassword")).perform();
        pearlyMarketPageErcan.signInLast.click();
        extentTest.info("gecerli bir username ve password girildi");

        ReusableMethods.jsScroll(pearlyMarketPageErcan.myAccount);
        ReusableMethods.waitFor(5);
        pearlyMarketPageErcan.myAccount.click();
        extentTest.info("My Account'a tklandı");

    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
