package tests.methods;

import pages.PearlyMarketPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login {

    static PearlyMarketPage page;

    public static void login() {

        page = new PearlyMarketPage();
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        page.ilkSignIn.click();
        page.emailBox.sendKeys(ConfigReader.getProperty("projeEmail"));
        page.passwordBox.sendKeys(ConfigReader.getProperty("projePassword"));
        page.ikinciSignIn.click();
    }
}
