package tests.suleyman.US_022;

import com.beust.ah.A;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.List;
import java.util.Random;

public class TC_001_004_002_005_003_006 extends TestBaseRapor {

    // us022_TC001
    //1 - kullanici  https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin gorundugunu dogrular
    //3 - Trending kategorisinde tumunu gor secer
    //4 - Acilan pencerede Trending kategorisinin goruntulendigini dogrular


    // us022_TC002
    //1 - kullanici  https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin gorundugunu dogrular
    //3 - New Arrivals kategorisinde tumunu gor secer
    //4 - Acilan sayfada New Arrivals kategorisinin goruntulendigini dogrular


    // us022_TC003
    //1 - kullanici  https://pearlymarket.com/ sayfasina gider
    //2 - Anasayfanin gorundugunu dogrular
    //3 - Best Seller kategorisinde tumunu gor secer
    //4 - Acilan sayfada Best Seller kategorisinin goruntulendigini dogrular

    PearlyMarketPageSuleyman page;
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public static final String ANSI_GREEN = "\u001B[32m";

    @Test(priority = 1)
    public void US022_TC001() throws IOException {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US022_TC001", "Trending kategorisi tumunu gor");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Ansayfa goruntulendi");

        ReusableMethods.jsScrollClick(page.trendingSeeAll);
        extentTest.info("Trending kategorisi tumunu gor tiklar");

        Assert.assertTrue(page.trendingPage.isDisplayed());
        extentTest.info("Trending sayfasinin gorundugunu dogrular");
        ReusableMethods.getScreenshot("TrendingSayfa");
        ReusableMethods.waitFor(2);
    }

    @Test(dependsOnMethods = "US022_TC001")
    public void US022_TC004() throws IOException {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US022_TC004", "Trending kategorisinde urunleri sirala");

        List<WebElement> trendingDDmList = ReusableMethods.select(page.trendingDdm).getOptions();

        Random random = new Random();
        ReusableMethods.waitFor(3);

        int index = random.nextInt(trendingDDmList.size());
        while (index == 0) {

            index = random.nextInt(trendingDDmList.size());
        }
        ReusableMethods.select(page.trendingDdm).selectByIndex(index);
        ReusableMethods.waitFor(3);
        System.out.println(ANSI_RED + ANSI_YELLOW_BACKGROUND + "Trending Sort By" + ANSI_RESET);
        for (WebElement w : trendingDDmList) {

            System.out.println(ANSI_GREEN + w.getText() + ANSI_RESET);
        }
        extentTest.info("Trending sort by'dan herhangi biri secildi ve sort by kategorisi konsolda yazdirir");
        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().back();

        extentTest.pass("US022_TC001_TC004 test bitti");
    }

    @Test(priority = 2)
    public void US022_TC002() throws IOException {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US022_TC002", "New Arrivals kategorisi tumunu gor");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");


        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Ansayfa goruntulendi");

        ReusableMethods.jsScrollClick(page.newArrivalsSeeAll);
        extentTest.info("Trending kategorisi tumunu gor tiklar");

        Assert.assertTrue(page.newArrivalsPage.isDisplayed());
        extentTest.info("Trending sayfasinin gorundugunu dogrular");
        ReusableMethods.getScreenshot("NewArrivals");

        ReusableMethods.waitFor(2);
    }

    @Test(dependsOnMethods = "US022_TC002")
    public void US022_TC005() throws IOException {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US022_TC005", "New Arrival kategorisinde urunleri sirala");

        List<WebElement> newArrivalsDdmList = ReusableMethods.select(page.newArrivalsDdm).getOptions();

        Random random = new Random();
        ReusableMethods.waitFor(3);

        int index = random.nextInt(newArrivalsDdmList.size());
        while (index == 0) {

            index = random.nextInt(newArrivalsDdmList.size());
        }
        ReusableMethods.select(page.newArrivalsDdm).selectByIndex(index);
        ReusableMethods.waitFor(3);
        System.out.println(ANSI_RED + ANSI_YELLOW_BACKGROUND + "New Arrivals Sort By" + ANSI_RESET);
        for (WebElement w : newArrivalsDdmList) {

            System.out.println(ANSI_GREEN + w.getText() + ANSI_RESET);
        }
        extentTest.info("New Arrival sort by'dan herhangi biri secildi ve sort by kategorisi konsolda yazdirir");

        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().back();

        extentTest.pass("US022_TC002_TC005 test bitti");
    }


    @Test(priority = 3)
    public void US022_TC003() throws IOException {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US022_TC003", "Best seller kategorisi tumunu gor");

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));
        extentTest.info("https://pearlymarket.com/ url'e gider");

        Assert.assertTrue(page.homePage.isDisplayed());
        extentTest.info("Ansayfa goruntulendi");

        ReusableMethods.jsScrollClick(page.bestSellerSeeAll);
        extentTest.info("Best Seller kategorisi tumunu gor tiklar");

        Assert.assertTrue(page.bestSellerPage.isDisplayed());
        extentTest.info("Best seller sayfasinin gorundugunu dogrular");

        ReusableMethods.getScreenshot("BestSeller");

        ReusableMethods.waitFor(2);
    }


    @Test(dependsOnMethods = "US022_TC003")
    public void US022_TC006() throws IOException {

        page = new PearlyMarketPageSuleyman();
        extentTest = extentReports.createTest("US022_TC006", "Best seller kategorisinde urunleri sirala");

        List<WebElement> bestSellerDdmList = ReusableMethods.select(page.bestSellerDdm).getOptions();

        Random random = new Random();
        ReusableMethods.waitFor(3);

        int index = random.nextInt(bestSellerDdmList.size());
        while (index == 0) {

            index = random.nextInt(bestSellerDdmList.size());
        }
        ReusableMethods.select(page.bestSellerDdm).selectByIndex(index);
        ReusableMethods.waitFor(3);
        System.out.println(ANSI_RED + ANSI_YELLOW_BACKGROUND + "Best Seller Sort By" + ANSI_RESET);
        for (WebElement w : bestSellerDdmList) {

            System.out.println(ANSI_GREEN + w.getText() + ANSI_RESET);
        }
        extentTest.info("Best seller sort by'dan herhangi biri secildi ve sort by kategorisi konsolda yazdirir");
        extentTest.pass("US022_TC001-TC002-TC003-TC004-TC005-TC006");
        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }
}
