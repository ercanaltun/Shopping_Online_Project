package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPage {

    public PearlyMarketPage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Login
    @FindBy(css = ".login.inline-type")
    public WebElement ilkSignIn;
    @FindBy(css = "#username")
    public WebElement emailBox;
    @FindBy(css = "#password")
    public WebElement passwordBox;
    @FindBy(css = ".woocommerce-form-login__submit")
    public WebElement ikinciSignIn;
}
