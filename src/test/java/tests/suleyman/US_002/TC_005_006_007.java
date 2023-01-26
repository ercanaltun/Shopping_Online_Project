package tests.suleyman.US_002;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PearlyMarketPageSuleyman;
import tests.methods.Login;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TC_005_006_007 extends TestBaseRapor {

    //TC005
    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in'e tiklar
    //3 -  Acilan sayfada gecerli email ve sifre girer
    //4 - Sign in butonuna tiklar
    //5 - My Account'a gider
    //6 -  Acilan sayfada "ORDERS", "DOWNLOADS", "ADDRESSES", "ACCOUNT DETAILS", "WISHLIST", "LOGOUT" seceneklerinin goruldugunu dogrular

    //TC006
    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in linkine tiklar
    //3 - Acilan pencerede gecerli email ve password girilir
    //4 - Sign in Botununa tiklayin
    //5 - Acilan sayfadan My Account'a gider
    //6 - Dashboard, Store Manager, Orders, Downloads, Addresses, Account details ,Wishlist goruntulendigini dogrular
    //7 - kapatir

    //TC007
    //1 - vendor  https://pearlymarket.com/ sayfasina gider
    //2 - Sign in linkine tiklar
    //3 - Acilan pencerede gecerli email ve password girilir
    //4 - Sign in Botununa tiklayin
    //5 - Acilan sayfada My Account linkine tiklar
    //6 - Support Tickets, Followings, Logout  gorundugunu dogrulayin
    //7- sayfayi kapatir

    PearlyMarketPageSuleyman page;

    @Test
    public void US002_TC005() {

        page = new PearlyMarketPageSuleyman();

        List<String> expectedDashboardList = new ArrayList<>(
                Arrays.asList("ORDERS", "DOWNLOADS", "ADDRESSES", "ACCOUNT DETAILS", "WISHLIST", "LOGOUT"));
        Collections.sort(expectedDashboardList);

        extentTest = extentReports.createTest(
                "US002_TC005", "My Account sayfasinda ORDERS\", " +
                        "\"DOWNLOADS\", " +
                        "\"ADDRESSES\", " +
                        "\"ACCOUNT DETAILS\", " +
                        "\"WISHLIST\", " +
                        "\"LOGOUT  gorundugunu dogrular");

        Login.login();
        extentTest.info("Vendor login olur");

        ReusableMethods.jsScrollClick(page.myAccountLink);
        extentTest.info("My Account linkine gider");


        List<WebElement> actualDashboardList = page.myAccountPageList;
        List<String> actualDashboardListString = new ArrayList<>();

        for (WebElement w : actualDashboardList) {

            actualDashboardListString.add(w.getText());
        }
        Collections.sort(actualDashboardListString);
        System.out.println(actualDashboardListString);
        System.out.println(expectedDashboardList);

        for (int i = 0; i < actualDashboardListString.size(); i++) {

            Assert.assertEquals(actualDashboardListString.get(i), expectedDashboardList.get(i));
        }
        extentTest.info("\"ORDERS\", \"DOWNLOADS\", \"ADDRESSES\", \"ACCOUNT DETAILS\", \"WISHLIST\", \"LOGOUT\" My Accoun'a gorundugunu dogrular");
        extentTest.pass("US002 TC005 test bitti");
    }


    int i;
    List<String> expectedList = new ArrayList<>(
            Arrays.asList("Store Manager", "Orders", "Downloads", "Addresses", "Account details", "Wishlist"));

    @Test(dependsOnMethods = "US002_TC005")
    public void US002_TC006() {

        extentTest = extentReports.createTest("US002 TC006",
                "Dashboard, Store Manager, Orders, Downloads, Addresses, Account details ,Wishlist goruntulendigini dogrular");

        int count = 1;
        for (i = 1; i < 7; i++) {

            System.out.println(count + " -> " + page.dashboardList.get(i).getText());
            count++;
            Assert.assertEquals(page.dashboardList.get(i).getText(), expectedList.get(i - 1));
        }
        extentTest.info("Dashboard, Store Manager, Orders, Downloads, Addresses, Account details ,Wishlist gorundugunu dogrular");
        extentTest.pass("US002_TC006 test bitti");
    }


    List<String> expectedList2 = new ArrayList<>(
            Arrays.asList("Support Tickets", "Followings", "Logout"));
    @Test(dependsOnMethods = "US002_TC006")
    public void US002_TC007() throws IOException {

        extentTest = extentReports.createTest("US002 TC007",
                "Support Tickets, Followings, Logout goruntulendigini dogrular");
        ReusableMethods.jsScroll(page.dashBoardList);
        ReusableMethods.getScreenshotWebElement("dashboardSS", page.dashBoardList);

        int count = 7;
        for (i = 7; i < 10; i++) {

            System.out.println(count + " -> " + page.dashboardList.get(i).getText());
            count++;
            Assert.assertEquals(page.dashboardList.get(i).getText(), expectedList2.get(i - 7));
        }
        extentTest.info("Support Tickets, Followings, Logout gorundugunu dogrular");
        extentTest.pass("US002_TC007 test bitti");

        Driver.quitDriver();
    }
}
