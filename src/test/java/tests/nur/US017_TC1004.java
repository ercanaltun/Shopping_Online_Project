package tests.nur;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageNur;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US017_TC1004 extends TestBaseRapor {

    /*
      Billing address, isim, soy isim, şirket ismi, tel, adres1 ve adres2 (optional),
       ülke, sehir, posta kodu bilgileri girilerek musteri eklenebilmeli
     */
    Select select;
    PearlyMarketPageNur pageN = new PearlyMarketPageNur();
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Positive Test","Billing address bilgileri girilerek musteri eklenebilmeli");
        MyMethods.addNewCustomer();
        ReusableMethods.getActions().sendKeys(pageN.customerUsernameTextbox,ReusableMethods.getFaker().name().username()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().internet().emailAddress()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().firstName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().lastName()).perform();
        ReusableMethods.jsScrollClick(pageN.billigFirstnameTextbox);

        ReusableMethods.getActions().sendKeys(pageN.billigFirstnameTextbox,ReusableMethods.getFaker().name().firstName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().name().lastName()).
                sendKeys(Keys.TAB).sendKeys("Loop7").
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().phoneNumber().cellPhone()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().fullAddress()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().secondaryAddress()).
                sendKeys(Keys.TAB).sendKeys("Denmark",Keys.ENTER).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().cityName()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().state()).
                sendKeys(Keys.TAB).sendKeys(ReusableMethods.getFaker().address().zipCode()).perform();
       ReusableMethods.jsScrollClick(pageN.submitButton);
       extentTest.info("Billing address bilgileri girildi");
       ReusableMethods.waitForVisibility(pageN.customerSuccessfullySaved,5);
       Assert.assertTrue(pageN.customerSuccessfullySaved.isDisplayed());
       extentTest.pass("Billing address bilgileri girilerek musteri basariyla eklendi");
        Driver.closeDriver();
    }
}
