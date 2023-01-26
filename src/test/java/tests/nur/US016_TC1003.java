package tests.nur;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageNur;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US016_TC1003 extends TestBaseRapor {

    /*
       Yeni musteri eklenebilmeli; kullanıcı adi, email, isim, soyisim bilgileri ile

     */
    PearlyMarketPageNur pageN = new PearlyMarketPageNur();

    @Test
    public void test01() {
        extentTest=extentReports.createTest("Positive Test","Yeni musteri eklenebilmeli");
        MyMethods.addNewCustomer();
        ReusableMethods.getActions().sendKeys(pageN.customerUsernameTextbox,ConfigReader.getProperty("addCostumerUsername")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("addCostumerEmail")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("addCostumerFirstname")).
                sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("addCostumerLastname")).perform();
        ReusableMethods.jsScrollClick(pageN.submitButton);
        extentTest.info("Yeni musteri bilgileri girildi");
        ReusableMethods.jsScrollClick(pageN.customers);
        Assert.assertTrue(pageN.newCustomerAdded.isDisplayed());
        extentTest.pass("Musteri basariyla kaydedildi");
        Driver.closeDriver();
    }
}
