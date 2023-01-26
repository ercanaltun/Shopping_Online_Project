package tests.methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import pages.PearlyMarketPageSuleyman;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.ArrayList;
import java.util.List;

public class VerificationCode {

    static String email;

    static int code;

    public static void getEmailCode() {

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

        page.registerEmailBox.sendKeys(VerificationCode.email);
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
        ReusableMethods.waitForVisibility(page.verificationCode, 10);
        code = Integer.parseInt(page.verificationCode.getText().replaceAll("\\D", ""));

        String code2 = String.valueOf(code); //gelen kodu string yapti

        Driver.getDriver().switchTo().defaultContent(); //iframe den cikis


        Driver.getDriver().switchTo().window(windowList.get(0));

        page.verificationCodeBox.sendKeys(code2); //verification code box'a email'e gelen  kodu gonder
    }
}
