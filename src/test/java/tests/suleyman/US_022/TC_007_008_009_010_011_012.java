package tests.suleyman.US_022;

import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class TC_007_008_009_010_011_012 {

    //1 - kullanici  https://pearlymarket.com/ sayfasina gider
    //2 - Trending kategoride tumunu gor tiklar
    //3 - Urun siralama bolumunden fiyatlari dusukten buyuge sirala bolumu secer
    //4 - Urun fiyatlarinin kucukten buyuge siralandigi dogrulanir

    PearlyMarketPageSuleyman page;

    @Test(priority = 1)
    public void US022_TC007() throws IOException {

        page = new PearlyMarketPageSuleyman();

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));

        ReusableMethods.jsScrollClick(page.trendingSeeAll);

        ReusableMethods.select(page.trendingDdm).selectByVisibleText("Sort by price: low to high");
        ReusableMethods.waitFor(4);

        ReusableMethods.getScreenshot("Trendinglowtohigh");
    }

    @Test(dependsOnMethods = "US022_TC007")
    public void US022_TC008() throws IOException {

        page = new PearlyMarketPageSuleyman();

        ReusableMethods.waitFor(3);
        ReusableMethods.select(page.trendingDdm).selectByVisibleText("Sort by price: high to low");
        ReusableMethods.waitFor(4);

        ReusableMethods.getScreenshot("Trendinghightolow");
    }

    @Test(priority = 2)
    public void US022_TC009() throws IOException {

        page = new PearlyMarketPageSuleyman();

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));

        ReusableMethods.jsScrollClick(page.newArrivalsSeeAll);

        ReusableMethods.select(page.newArrivalsDdm).selectByVisibleText("Sort by price: low to high");
        ReusableMethods.waitFor(4);

        ReusableMethods.getScreenshot("NewArrivalslowtohigh");
    }

    @Test(dependsOnMethods = "US022_TC009")
    public void US022_TC010() throws IOException {

        page = new PearlyMarketPageSuleyman();

        ReusableMethods.waitFor(3);
        ReusableMethods.select(page.newArrivalsDdm).selectByVisibleText("Sort by price: high to low");
        ReusableMethods.waitFor(4);

        ReusableMethods.getScreenshot("NewArrivalshightolow");
    }

    @Test(priority = 3)
    public void US022_TC011() throws IOException {

        page = new PearlyMarketPageSuleyman();

        Driver.getDriver().get(ConfigReader.getProperty("projeUrl"));

        ReusableMethods.jsScrollClick(page.bestSellerSeeAll);

        ReusableMethods.select(page.bestSellerDdm).selectByVisibleText("Sort by price: low to high");
        ReusableMethods.waitFor(4);

        ReusableMethods.getScreenshot("BestSellerlowtohigh");
    }

    @Test(dependsOnMethods = "US022_TC011")
    public void US022_TC012() throws IOException {

        page = new PearlyMarketPageSuleyman();

        ReusableMethods.waitFor(3);
        ReusableMethods.select(page.bestSellerDdm).selectByVisibleText("Sort by price: high to low");
        ReusableMethods.waitFor(4);


        ReusableMethods.getScreenshot("BestSellerhightolow");

        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }

}
