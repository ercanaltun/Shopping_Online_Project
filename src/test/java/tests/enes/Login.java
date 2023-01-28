package tests.enes;

import pages.PearlyMarketPageEnes;
import utilities.ConfigReader;
import utilities.Driver;

public class Login {

    static PearlyMarketPageEnes pearlyMarketPage;

    public static void login() {

        pearlyMarketPage = new PearlyMarketPageEnes();
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        pearlyMarketPage.ilkSignIn.click();
        pearlyMarketPage.emailBox.sendKeys(ConfigReader.getProperty("projeEmail"));
        pearlyMarketPage.password.sendKeys(ConfigReader.getProperty("projePassword"));
        pearlyMarketPage.ikinciSignIn.click();
    }
}
