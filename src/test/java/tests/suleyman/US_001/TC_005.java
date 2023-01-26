package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC_005 extends TestBaseRapor {

    // 1 - vendor https://pearlymarket.com/ sayfasina gider
    // 2 - Register butonuna tiklar
    // 3 - Acilan pencereden Become a Vendor'a gider
    // 4  - Registration'in email , password , confirm pasword gorunur oldugunu dogrular
    // 5 - Kayitli email adresi girilir ve dogrulama kodu girer
    // 6 - Gecerli sifre olusturun password ve confirm password'e ayni sifreyi girer
    // 7 - Register butonuna tiklayin
    // 8 - "This Email already exists. Please login to the site and apply as vendor."
    //      kayitli email girildiginde uyarisinin gorundugunu dogrular.

    PearlyMarketPageSuleyman page;

    @Test(groups = "negatif")
    public void US001_TC005() {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US001_TC005 Negatif Test", "Email unique olmali(Kayitli Email ile register olmamali)");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        page.registerHomePage.click();
        extentTest.info("Register linkine tiklar");

        page.becomeAVendor.click();
        extentTest.info("Acilan sayfadan Become a Vendor'a gider");

        Assert.assertTrue(page.registerEmailBox.isDisplayed()
                && page.registerPasswordBox.isDisplayed()
                && page.registerConfirmPwdBox.isDisplayed());
        extentTest.info("email,password,confirm password gorundugunu dogrular");

        page.registerEmailBox.sendKeys(ConfigReader.getProperty("projeEmail"));
        page.verificationCodeBox.sendKeys(ConfigReader.getProperty("verificationCode"));
        extentTest.info("kayitli email adres ve dogrulama kodu girer");

        page.registerPasswordBox.sendKeys(ConfigReader.getProperty("projePassword"));
        page.registerConfirmPwdBox.sendKeys(ConfigReader.getProperty("projePassword"));
        extentTest.info("password ve confirm password'u ayni girer");

        page.registerButton.click();
        extentTest.info("Register butonuna tiklar");

        String expectedText = "This Email already exists. Please login to the site and apply as vendor.";
        String actualText = page.emailAlreadyExistsText.getText();
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("This Email already exists. Please login to the site and apply as vendor. uyarisinin gorundugunu dogrular");
        extentTest.pass("US001-TC005 bitti");

        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }
}
