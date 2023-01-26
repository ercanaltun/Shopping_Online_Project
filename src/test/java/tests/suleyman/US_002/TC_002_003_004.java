package tests.suleyman.US_002;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC_002_003_004 extends TestBaseRapor {

    //TC_002
    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in butonuna tiklar
    //3 - Gecerli email adresi girer
    //4 - Gecersiz sifre girer
    //5 - Sign'in butonuna tiklar
    //6 -  'Wrong username or password.' uyarisinin gorundugunu dogrular


    //TC_003
    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in butonuna tiklar
    //3 - Gecersiz email adresi girer
    //4 - Gecerli sifre girer
    //5 - Sign'in butonuna tiklar
    //6 -  'Wrong username or password.' uyarisinin gorundugunu dogrular

    //TC_004
    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in butonuna tiklar
    //3 - Gecersiz email adresi girer
    //4 - Gecersiz sifre girer
    //5 - Sign'in butonuna tiklar
    //6 -  'Wrong username or password.' uyarisinin gorundugunu dogrular

    PearlyMarketPageSuleyman page;

    @DataProvider
    public static Object[][] gecersizGirisBilgileri() {
        return new Object[][]{
                {ConfigReader.getProperty("projeEmail"), ConfigReader.getProperty("wrongPassword")},
                {ConfigReader.getProperty("wrongEmail"), ConfigReader.getProperty("projePassword")},
                {ConfigReader.getProperty("wrongEmail"), ConfigReader.getProperty("wrongPassword")}};
    }

    @Test(dataProvider = "gecersizGirisBilgileri", groups = "negatif")
    public void negativeLogin(String email, String password) {

        page = new PearlyMarketPageSuleyman();

        extentTest = extentReports.createTest("US002_TC002_TC003_TC004", "Vendor gecersiz giris bilgileri ile login olmamali");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        page.ilkSignIn.click();
        extentTest.info("Signin Linkine tiklar");

        page.emailBox.sendKeys(email);
        page.passwordBox.sendKeys(password);
        extentTest.info("Gecersiz giris bilgilerini girer");

        page.ikinciSignIn.click();
        extentTest.info("signIn Butonuna tiklar");

        String expectedText = "Wrong username or password.";
        String actualText = page.wrongSignInText.getText();
        Assert.assertEquals(actualText, expectedText);
        extentTest.info("Wrong username or password. uyarisinin gorundugunu dogrular");

        ReusableMethods.waitFor(1);
        extentTest.pass("negatif test basarili");
    }

    @Test(dependsOnMethods = "negativeLogin")
    public void testClose() {

        Driver.quitDriver();
    }

}
