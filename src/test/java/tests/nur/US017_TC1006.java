package tests.nur;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageNur;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US017_TC1006 extends TestBaseRapor {
    /*
          Shipping address, Billing addressten farklı olarak eklenebilmeli
    */
    PearlyMarketPageNur pearlyMarketPageNur = new PearlyMarketPageNur();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Positive Test","Shipping address, Billing addressten farklı olarak eklenebilmeli");
        MyMethods.addNewCustomer();
        ReusableMethods.getActions().sendKeys(pearlyMarketPageNur.customerUsernameTextbox,ReusableMethods.getFaker().name().username()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().firstName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().lastName()).perform();
        ReusableMethods.jsScrollClick(pearlyMarketPageNur.billigFirstnameTextbox);

        ReusableMethods.getActions().sendKeys(pearlyMarketPageNur.billigFirstnameTextbox,ReusableMethods.getFaker().name().firstName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().lastName()).
                sendKeys(Keys.TAB).sendKeys("Loop7").
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().secondaryAddress()).
                sendKeys(Keys.TAB).sendKeys("Denmark",Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().cityName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().state()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().zipCode()).perform();
        extentTest.info("Billing address bilgileri girildi");
        pearlyMarketPageNur.sameAsBilling.click();
        ReusableMethods.getActions().sendKeys(pearlyMarketPageNur.shippingFirstnameTextbox,ReusableMethods.getFaker().name().firstName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().lastName()).
                sendKeys(Keys.TAB).sendKeys("Loop7").
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().secondaryAddress()).
                sendKeys(Keys.TAB).sendKeys("Denmark",Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().cityName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().state()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().zipCode()).perform();
        ReusableMethods.jsScrollClick(pearlyMarketPageNur.submitButton);
        extentTest.info("Farkli shipping address bilgileri girildi");
        ReusableMethods.waitForVisibility(pearlyMarketPageNur.customerSuccessfullySaved,5);
        Assert.assertTrue(pearlyMarketPageNur.customerSuccessfullySaved.isDisplayed());
        extentTest.info("Shipping ve Billing adres bilgileri farkli olarak musteri basariyla kaydedildi");
        Driver.closeDriver();
    }
}
