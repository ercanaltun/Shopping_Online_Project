package tests.ercan;


import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.PearlyMarketPageErcan;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US012_TC04 extends TestBaseRapor {

    PearlyMarketPageErcan pearlyMarketPageErcan = new PearlyMarketPageErcan();
    Actions actions = new Actions(Driver.getDriver());
    Select select;

    Faker faker = new Faker();

    @Test
    public void testName() throws InterruptedException {
        extentTest = extentReports.createTest("Account Details Update", "Kullanici hesap bilgilerini update edebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info(" url'e gidildi");

        pearlyMarketPageErcan.signInFirst.click();
        extentTest.info(" signin butonuna tıklandi");

        actions.click(pearlyMarketPageErcan.emailaddress).sendKeys(ConfigReader.getProperty("projeEmail")).sendKeys(Keys.TAB)
                .sendKeys(ConfigReader.getProperty("projePassword")).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).perform();
        extentTest.info(" gecerli kullanici bilgileri girerek giris yapildi");


        ReusableMethods.jsScroll(pearlyMarketPageErcan.myAccount);
        ReusableMethods.waitFor(5);
        pearlyMarketPageErcan.myAccount.click();
        extentTest.info(" my account butonunu tiklandi");

        pearlyMarketPageErcan.accountDetails.click();
        extentTest.info("Account details butonu tiklandi");

        assert pearlyMarketPageErcan.emailBox.isDisplayed();
        extentTest.info("Email butonu dogrulandi");


        pearlyMarketPageErcan.emailBox.clear();
        String fakerEmail = Faker.instance().internet().emailAddress();
        pearlyMarketPageErcan.emailBox.sendKeys(fakerEmail, Keys.ENTER);

        pearlyMarketPageErcan.accountChangedDetailsSuccesfulyText.isDisplayed();
        extentTest.info("Email butonu update edildi");

        pearlyMarketPageErcan.emailBox.clear();
        pearlyMarketPageErcan.emailBox.sendKeys(ConfigReader.getProperty("projeEmail"), Keys.ENTER);


    }
}