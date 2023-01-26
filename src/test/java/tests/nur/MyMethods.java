package tests.nur;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PearlyMarketPageNur;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class MyMethods extends TestBaseRapor {
     static PearlyMarketPageNur pageN;

    public static void loginn(){
        pageN = new PearlyMarketPageNur();
        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        pageN.signIn.click();
        pageN.emailTextBox.sendKeys(ConfigReader.getProperty("projeEmail"));
        pageN.passTextBox.sendKeys(ConfigReader.getProperty("projePassword"));
        pageN.ikinciLoginButtonu.click();

    }

    public static void addNewCustomer(){
        extentTest=extentReports.createTest("Test","Add new customer");
        pageN = new PearlyMarketPageNur();
        MyMethods.loginn();
        extentTest.info("Vendor olarak siteye giris yapildi");
        ReusableMethods.jsScrollClick(pageN.myAccount);
        pageN.storeManager.click();
        ReusableMethods.jsScrollClick(pageN.customers);
        pageN.addNewButton.click();
        extentTest.info("Add New Customer butonuna tiklandi");

    }

    public static void isInTable(String expectedWord)  {
       pageN = new PearlyMarketPageNur();
       Assert.assertTrue((pageN.tabloBasliklari).getText().contains(expectedWord));
       System.out.println(expectedWord +" basligi tabloda goruldu");

      switch(expectedWord) {
          case  "Request ID":
              for (WebElement w : pageN.requestIDValues){
                  Assert.assertTrue(w.isDisplayed());
                  System.out.println("Request ID " +w.getText());
                  ReusableMethods.waitFor(1);
              }
              break;
          case "Order ID":
              for (WebElement w : pageN.orderIDValues){
                  Assert.assertTrue(w.isDisplayed());
                  System.out.println("Order ID " +w.getText());
                  ReusableMethods.waitFor(1);
              }
              break;
          case "Amount":
              for (WebElement w : pageN.amountValues){
                  Assert.assertTrue(w.isDisplayed());
                  System.out.println("Amount " +w.getText());
                  ReusableMethods.waitFor(1);
              }
              break;
          case "Type":
              for (WebElement w : pageN.typeValues){
                  Assert.assertTrue(w.isDisplayed());
                  System.out.println("Type " +w.getText());
                  ReusableMethods.waitFor(1);
              }

          case "Reason":
              for (WebElement w : pageN.requestIDValues){
                  Assert.assertTrue(w.isDisplayed());
                  System.out.println("Reason " +w.getText());
                  ReusableMethods.waitFor(1);
              }
              break;

      }

    }

}
