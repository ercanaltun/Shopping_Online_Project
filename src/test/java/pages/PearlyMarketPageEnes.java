package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PearlyMarketPageEnes {

    public PearlyMarketPageEnes() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(css = ".login.inline-type")
    public WebElement ilkSignIn;

    @FindBy(css = "#username")
    public WebElement emailBox;

    @FindBy(css = "#password")
    public WebElement password;

    @FindBy(css = ".woocommerce-form-login__submit")
    public WebElement ikinciSignIn;

    @FindBy(xpath = "//*[text()='Sign Out']")
    public WebElement signOut;

    @FindBy(xpath = "(//*[text()='My Account'])[3]")
    public WebElement myAccount;


    @FindBy(xpath = "(//*[text()='Orders'])[1]")
    public WebElement orders;


    @FindBy(xpath = "//*[text()='Go Shop']")
    public WebElement goShop;



    @FindBy(css = ".product-details>h3>a")
    public List<WebElement> conList;

    @FindBy(xpath = "//*[@name='add-to-cart']")
    public WebElement sepeteEkle;

    @FindBy(xpath = "(//*[@class='cart-count'])[1]")
    public WebElement cartCount;

    @FindBy(xpath = "//*[@class='cart-toggle']")
    public WebElement cart;

    @FindBy(xpath = "//*[@class='button wc-forward']")
    public WebElement viewCart;

    @FindBy(xpath = "//*[text()='Checkout']")
    public WebElement checkout;

    @FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
    public WebElement proceedToCheckout;

    @FindBy(xpath = "//*[@id='billing_first_name']")
    public WebElement name;

    @FindBy(xpath = "//*[@id='billing_last_name']")
    public WebElement lastName;

    @FindBy(xpath = "//*[@id='billing_company']")
    public WebElement company;

    @FindBy(xpath = "//*[@id='select2-billing_country-container']")
    public WebElement country;

    @FindBy(xpath = "//ul[@id='select2-billing_country-results']/li[text()='United States (US)']")
    public WebElement countryList;

    @FindBy(xpath = "//*[@id='billing_address_1']")
    public WebElement streetAdress;

    @FindBy(xpath = "//*[@id='billing_city']")
    public WebElement town;

    @FindBy(xpath = "(//span[@class='select2-selection__rendered'])[2]")
    public WebElement state;

    @FindBy(xpath = "//ul[@class='select2-results__options']//li[text()='Alaska']")
    public  WebElement stateList;


    @FindBy(xpath = "//input[@id='billing_postcode']")
    public WebElement zipCode;

    @FindBy(xpath = "//input[@id='billing_phone']")
    public WebElement phone;

    @FindBy(xpath = "//*[@id='billing_email']")
    public WebElement emailAdress;

    @FindBy(xpath = "//*[@id='place_order']")
    public WebElement placeOrder;

    @FindBy(xpath = "//*[text()='Thank you. Your order has been received.']")
    public WebElement orderCompleteText;

    @FindBy(xpath = "//li[@class='woocommerce-mini-cart-item mini-item mini_cart_item']")
    public List<WebElement> viewCartList;

    @FindBy(xpath = "//*[text()='Price']")
    public WebElement price;

    @FindBy(xpath = "//*[text()='Quantity']")
    public WebElement quantity;

    @FindBy(xpath = "(//*[text()='Subtotal'])[1]")
    public WebElement subtotal;

    @FindBy(xpath = "(//tbody//button[2])[1]")
    public WebElement firstPlus;


    @FindBy(xpath = "(//tbody//button[1])[1]")
    public WebElement firstMinus;

    @FindBy(xpath = "//*[@name='update_cart']")
    public WebElement updateCart;

    @FindBy(xpath = "//*[text()='Cart updated.']")
    public WebElement updateCartText;

    @FindBy(xpath = "(//*[@title='Qty'])[1]")
    public WebElement firstStockInformation;

    @FindBy(xpath = "//*[@id='coupon_code']")
    public WebElement coupon;

    @FindBy(xpath = "//h4[text()='Shipping']")
    public List<WebElement> shippingList;

    @FindBy(xpath = "(//bdi)[last()]")
    public WebElement totalInformation;

    @FindBy(xpath = "//a[text()='Continue Shopping']")
    public WebElement ContinueShopping;

    @FindBy(xpath = "//*[@name='clear_cart']")
    public WebElement clearCart;

    @FindBy(xpath = "//div[text()='Cart is cleared.']")
    public WebElement clearMessage;

    @FindBy(xpath = "//*[@data-id='billing_first_name']")
    public WebElement billingFirstName;

    @FindBy(xpath = "//*[@data-id='billing_last_name']")
    public WebElement billingLastName;

    @FindBy(xpath = "//*[@data-id='billing_address_1']")
    public WebElement billingaddressMajor;

    @FindBy(xpath = "//*[@data-id='billing_city']")
    public WebElement billingCity;

    @FindBy(xpath = "//*[@data-id='billing_postcode']")
    public WebElement billingPostcode;

    @FindBy(xpath = "//*[@data-id='billing_phone']")
    public WebElement billingPhone;

    @FindBy(xpath = "//*[@data-id='billing_email']")
    public WebElement billingEmail;


}
