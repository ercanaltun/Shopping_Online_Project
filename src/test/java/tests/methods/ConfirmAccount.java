package tests.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import pages.PearlyMarketPageSuleyman;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class ConfirmAccount {


    static String email;

    static int code;

    public static void confirmAccount() {

        PearlyMarketPageSuleyman page = new PearlyMarketPageSuleyman();

        ReusableMethods.waitFor(2);

        //yeni tabda gecici email sitesine git
        Driver.getDriver().switchTo().newWindow(WindowType.TAB);

        Driver.getDriver().get("https://www.mohmal.com/tr/inbox");


        List<String> windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(1));
        ReusableMethods.waitFor(2);


        email = page.geciciEmail.getText();
        System.out.println(email);


        Driver.getDriver().switchTo().window(windowList.get(0));
        ReusableMethods.waitFor(2);


        page.registerEmailBox.sendKeys(ConfirmAccount.email);
        ReusableMethods.waitFor(1);


        page.verificationCodeBox.click();


        ReusableMethods.waitFor(2);
        Driver.getDriver().switchTo().window(windowList.get(1));


        ReusableMethods.waitFor(2);
        Driver.getDriver().navigate().refresh();


        page.geciciEmailBox.click();
        WebElement iframe = Driver.getDriver().findElement(By.cssSelector("div>#read>div>iframe")); //iframe gir
        Driver.getDriver().switchTo().frame(iframe);


        ReusableMethods.waitFor(2);
        code = Integer.parseInt(page.verificationCode.getText().replaceAll("\\D", ""));
        String code2 = String.valueOf(code);


        Driver.getDriver().switchTo().defaultContent(); //iframe den cikis


        Driver.getDriver().switchTo().window(windowList.get(0));
        page.verificationCodeBox.sendKeys(code2);


        page.registerPasswordBox.sendKeys(ConfigReader.getProperty("projePassword"));
        page.registerConfirmPwdBox.sendKeys(ConfigReader.getProperty("projePassword"));

        page.registerButton.click();
        ReusableMethods.waitFor(2);


        Driver.getDriver().switchTo().window(windowList.get(1));
        ReusableMethods.waitFor(2);

        Driver.getDriver().navigate().refresh();
        ReusableMethods.waitFor(3);


        page.onayEmail.click();


        WebElement iframe2 = Driver.getDriver().findElement(By.cssSelector("div>#read>div>iframe")); //iframe gir
        Driver.getDriver().switchTo().frame(iframe2);
        ReusableMethods.jsScrollClick(page.visitNow);
        ReusableMethods.waitFor(2);


        windowList = new ArrayList<>(Driver.getDriver().getWindowHandles());
        Driver.getDriver().switchTo().window(windowList.get(2));


    }


}
