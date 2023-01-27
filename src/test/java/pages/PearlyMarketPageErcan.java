package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageErcan {

    public PearlyMarketPageErcan(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signInFirst;
    @FindBy(xpath = "//*[@id='username']")
    public WebElement emailaddress;
    @FindBy(xpath = "//*[@class='woocommerce-button button woocommerce-form-login__submit']")
    public WebElement signInLast;
    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAccount;
    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement myStore;
    @FindBy(xpath = "(//span[@class='text'])[4]")
    public WebElement pruducts;
    @FindBy(xpath = "(//span[@class='wcfmfa fa-edit text_tip'])[2]")
    public WebElement edit;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[9]")
    public WebElement toptanUrunAyarlar;
    @FindBy(xpath = "(//select[@id='piecetype'])")
    public WebElement pieceTypeSelect;
    @FindBy(xpath = "//input[@id='unitpercart']")
    public WebElement unitsPerPiece;
    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement submit;
    @FindBy(xpath = "//input[@id='minorderqtytr']")
    public WebElement minOrder;
    @FindBy(xpath = "//span[@class='icon-box-icon icon-orders']")
    public WebElement orders;
    @FindBy(xpath = "(//*[@class='woocommerce-orders-table__cell woocommerce-orders-table__cell-order-total'])[1]")
    public WebElement ordersVisible;
    @FindBy(xpath = "(//*[text()='Addresses'])[1]")
    public WebElement addresses;
    @FindBy(xpath = "//*[.='gelgit sokak gece saat kac oldu apartmani deneme 1234 yol gel git'][1]")
    public WebElement billingAddresses;
    @FindBy(xpath = "(//*[text()='gelgit sokak gece saat kac oldu apartmani deneme 1234 yol gel git'])[2]")
    public WebElement shippingAddresses;
    @FindBy(xpath = "//*[text()='Account details']")
    public WebElement accountDetails;

    @FindBy(xpath = "//*[@id='account_email']")
    public WebElement hesapBilgisiEmailAdres;

    @FindBy(xpath = "//*[@id='account_first_name']")
    public WebElement hesapBilgisiFirstName;

    @FindBy(xpath = "//button[@name='save_account_details']")
    public WebElement saveChange;

    @FindBy(xpath = "//*[@class='woocommerce-message alert alert-simple alert-icon alert-close-top alert-success']")
    public WebElement accountChangedDetailsSuccesfulyText;

    @FindBy(xpath = "(//a[text()='Downloads'])[1]")
    public WebElement downloads;

    @FindBy(xpath = "(//span[text()='Downloads remaining'])[1]")
    public WebElement downloadsRemaning;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
    public WebElement productSuccessfullyPublishedText;
    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;

    @FindBy(xpath = "//input[@id='account_email']")
    public WebElement emailBox;




}
