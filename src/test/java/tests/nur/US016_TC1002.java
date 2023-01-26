package tests.nur;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageNur;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;

public class US016_TC1002 extends TestBaseRapor {

    /*
      Kisilerin tum bilgileri pdf, excel ve csv olarak indirilebilmeli

         1. Vendor olarak https://pearlymarket.com ‘a git
         2. Store Manager’a tikla
         3. Customers’a tikla
         4. Print ‘e tikla, Pdf ‘e tikla, Excel'e tikla, csv ‘ye tikla
         5. İndirilen  files’ in indirilip indirilmediği test et
        */
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Positive Test","Musterilerin tum bilgileri pdf, excel ve csa olarak indirilebilmeli");
        PearlyMarketPageNur pageN = new PearlyMarketPageNur();
        MyMethods.loginn();
        extentTest.info("Vendor olarak siteye giris yapildi");
        ReusableMethods.jsScrollClick(pageN.myAccount);
        pageN.storeManager.click();
        ReusableMethods.jsScrollClick(pageN.customers);
        extentTest.info("Manage Customers Webtable'ina gidildi");
        pageN.printButton.click();
        pageN.pdfButton.click();
        pageN.excelButton.click();
        pageN.csvButton.click();
        extentTest.info("print, pdf, excel ve csv butonlarina tiklandi");
        ReusableMethods.waitFor(1);
        String pdfDosyaYolu = "/Users/nur/Downloads/Store Manager - Pearly Market.pdf";
        Assert.assertTrue(Files.exists(Paths.get(pdfDosyaYolu)));
        ReusableMethods.waitFor(1);
        String excelDosyaYolu = "/Users/nur/Downloads/Store Manager - Pearly Market.xlsx";
        Assert.assertTrue(Files.exists(Paths.get(excelDosyaYolu)));
        ReusableMethods.waitFor(1);
        String csvDosyaYolu = "/Users/nur/Downloads/Store Manager - Pearly Market.csv";
        Assert.assertTrue(Files.exists(Paths.get(csvDosyaYolu)));
        extentTest.pass("Dosyalar basariyla indirildi");
        Driver.closeDriver();

    }
}
