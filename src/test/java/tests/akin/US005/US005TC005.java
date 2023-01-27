package tests.akin.US005;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageAkin;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;

public class US005TC005 extends TestBaseRapor {//Kisa tanımlama ve geniş tanımlama (short description, Description)
    /*
    1	Store Manager login olur
    2	Store Manager sekmesine gelir
    3	Store Manager Short description bolumune tiklar
    4	Store Manager urunle ilgili kisa bilgilendirme yazar
    5	Store Manager  description bolumune tiklar
    6	Store Manager urunle ilgili  bilgilendirme yazar
    7	Store Manager Media Libraryden eklenecek foto secilir Select butonuna tiklar
    8	Store Manager Media Libraryden eklenecek  diger foto secilir ve Add to Gallery botununa tiklar
    9	Store Manager kategori secimi yapar
    10	Store Manager Submit butonuna tiklar
    11	Store Manager "Product Successfully Published." yazisini gorur
     */
    PearlyMarketPageAkin page;

    @Test(groups = "gp1")
    public void US005TC005() throws InterruptedException, IOException {
        extentTest = extentReports.createTest("Kisa tanımlama ve geniş tanımlama", "tanımlama ");

        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        page = new PearlyMarketPageAkin();
        Login.login();
        extentTest.info("Login olundu");
        page.signOutButton.click();
        ReusableMethods.jsScrollClick(page.storeManager);
        extentTest.info("StoreManager 'a gidildi");
        ReusableMethods.jsScrollClick(page.products);
        extentTest.info("Products 'a gidildi");
        page.addNewButton.click();
        extentTest.info("AddNew butonu secildi");
        page.productTitle.sendKeys("car");
        extentTest.info("productTitle girildi");
        page.priceGirisi.sendKeys("800000");
        extentTest.info("price degeri girildi");
        WebElement iframe1 = Driver.getDriver().findElement(By.cssSelector("div>iframe#excerpt_ifr"));
        Driver.getDriver().switchTo().frame(iframe1);
        page.shortDescription.sendKeys("Super car");
        extentTest.info("shortDescription  girildi");
        Driver.getDriver().switchTo().defaultContent();
        WebElement iframe2 = Driver.getDriver().findElement(By.cssSelector("div>iframe#description_ifr"));
        Driver.getDriver().switchTo().frame(iframe2);
        page.description.sendKeys("Super Car is good");
        extentTest.info("Description  girildi");
        Driver.getDriver().switchTo().defaultContent();
        page.fotoEkleme1.click();
        page.mediaLibrary.click();
        page.foto1.click();
        page.fotoSelectButton.click();
        js.executeScript("arguments[0].click();", page.foto2Ekleme);
        Thread.sleep(2000);
        js.executeScript("arguments[0].click();", page.foto2);
        Thread.sleep(1000);
        page.fotoAddToGalleryButton.click();
        extentTest.info("Fotograflar  eklendi");
        ReusableMethods.jsScrollClick(page.electronicsKategorisi);
        extentTest.info("Kategori secimi yapildi");
        ReusableMethods.jsScrollClick(page.submitButton);
        ReusableMethods.waitForVisibility(page.tamamYazisi, 15);
        Assert.assertTrue(page.tamamYazisi.isDisplayed());
        extentTest.pass("tamam yazisi goruldu");
        ReusableMethods.getScreenshotWebElement("ok", page.tamamYazisi);
        Driver.closeDriver();
    }
}
