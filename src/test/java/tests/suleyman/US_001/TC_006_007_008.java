package tests.suleyman.US_001;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.VerificationCode;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class TC_006_007_008 extends TestBaseRapor {

    //TC006 TC007 TC008
    //1 - vendor https://pearlymarket.com/ sayfasina gider
    //2 - Register 'a tiklar
    //3 - Acilan pencerede Become A Vendor butonuna tiklar
    //4 - Registration sayfasinda email,password,confirm password 'un gorundugu dogrular
    //5 - Gecerli email adres girer emaile gelen dogrulama kodunu girer
    //6 - Sifreyi sadece rakamlardan, sadece kucuk harflerde ,sadece buyuk harflerden olusturup ayni password ve confirm password'u girer
    //7 - Register Butonuna tiklar
    //8 - 'Password strength should be atleast "Good.' uyarisinin gorundugunu dogrular

    PearlyMarketPageSuleyman page;

    @DataProvider
    public static Object[][] gecersizSifreler() {
        return new Object[][]{
                {"123123123123", "123123123123"},
                {"GECERSIZSIFRE", "GECERSIZSIFRE"},
                {"gecersizsifre", "gecersizsifre"}};
    }


    @Test(dataProvider = "gecersizSifreler", groups = "negatif")
    public void US001_TC006_007_008(String password, String confirmPassword) {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US001_TC006_TC007_TC008 Negatif Test", "Vendor gecersiz sifre  ile kayit olmamali");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        page.registerHomePage.click();
        extentTest.info("Register link'ine tiklar");

        page.becomeAVendor.click();
        extentTest.info("Acilan pencerede Become a Vendor'a gider");

        Assert.assertTrue(page.registerEmailBox.isDisplayed()
                && page.registerPasswordBox.isDisplayed()
                && page.registerConfirmPwdBox.isDisplayed());
        extentTest.info("Register sayfasinda email,password ,confirm password'un gorundugunu dogrular");

        VerificationCode.getEmailCode();
        extentTest.info("Email ve email'e gelen dogrulama kodunu girer");

        page.registerPasswordBox.sendKeys(password);
        page.registerConfirmPwdBox.sendKeys(confirmPassword);
        extentTest.info("Gecersiz bir sifre ile password ve confirm password ayni olarak girer");


        page.registerButton.click();
        extentTest.info("Register button'a tiklar");


        ReusableMethods.waitFor(2);
        String expectedText = "Password strength should be atleast \"Good\".";
        String actualText = page.weakPasswordText.getText();
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("Password strength should be atleast \"Good\". uyarisinin gorundugunu dogrular");

        try {
            ReusableMethods.getScreenshotWebElement("TC006-TC007-TC008-GecersizSifre", page.weakPasswordText);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.waitFor(2);
        extentTest.pass("Gecersiz sifrelerle register negatif test bitti");

        Driver.quitDriver();
    }
}
