package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PearlyMarketPageNur {

    public PearlyMarketPageNur() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@class='login inline-type']")
    public WebElement signIn;

    @FindBy(xpath = "//*[@id='username']")
    public WebElement emailTextBox;

    @FindBy (xpath = "//*[@id='password']")
    public WebElement passTextBox;

    @FindBy (xpath = "//*[@name='login']")
    public WebElement ikinciLoginButtonu;

    @FindBy (xpath="(//*[text()='My Account'])[2]")
    public WebElement myAccount;

    @FindBy (xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    @FindBy (xpath = "(//*[@class='text'])[7]")
    public WebElement customers;

    @FindBy (xpath = "//thead//tr")
    public WebElement tabloBasliklarCustomers;  // ogren

    @FindBy (xpath = "//tbody//tr//td")
    public List<WebElement> musteriBilgileri;

    @FindBy (xpath = "//*[@class='dt-button buttons-print']")
    public WebElement printButton;

    @FindBy (xpath = "//*[@class='dt-button buttons-pdf buttons-html5']")
    public WebElement pdfButton;

    @FindBy (xpath = "//*[@class='dt-button buttons-excel buttons-html5']")
    public WebElement excelButton;

    @FindBy (xpath = "//*[@class='dt-button buttons-csv buttons-html5']")
    public WebElement csvButton;


    @FindBy (xpath = "(//*[text()='Add New'])[1]")
    public WebElement addNewButton;

    @FindBy (xpath = "//*[@id='user_name']")
    public WebElement customerUsernameTextbox;

    @FindBy (xpath = "//*[@value='Submit']")
    public WebElement submitButton;

    @FindBy (xpath = "//*[text()='hanna hug']")
    public WebElement newCustomerAdded;

    @FindBy (xpath = "//*[@id='bfirst_name']")
    public WebElement billigFirstnameTextbox;


    @FindBy(xpath = "//*[contains(text(), 'Customer Successfully Saved.')]")
    public WebElement customerSuccessfullySaved;

    @FindBy (xpath = "//*[@name='same_as_billing']")
    public WebElement sameAsBilling;

    @FindBy (xpath = "//*[@id='sfirst_name']")
    public WebElement shippingFirstnameTextbox;

    @FindBy (xpath = "(//*[@class='wcfmfa fa-retweet'])[1]")
    public WebElement refund;

    @FindBy (xpath = "//tbody//tr//td")
    public List<WebElement> refundRequestsWT;

    @FindBy (xpath = "//*[@class='wcfm-container wcfm-top-element-container']")
    public WebElement refundRequests;

    @FindBy (xpath = "//thead//tr")
    public WebElement tabloBasliklari;

    //
    @FindBy (xpath = "//*[@aria-label='Request ID']")
    public WebElement requestID;

    @FindBy (xpath = "//tbody//tr//td[2]")
    public List<WebElement> requestIDValues;

    @FindBy (xpath = "//tbody//tr//td[3]")
    public List<WebElement> orderIDValues;

    @FindBy (xpath = "//tbody//tr//td[4]")
    public List<WebElement> amountValues;

    @FindBy (xpath = "//tbody//tr//td[5]")
    public List<WebElement> typeValues;

    @FindBy (xpath = "//tbody//tr//td[6]")
    public List<WebElement> reasonValues;

    @FindBy (css= "#wcfm_payments_listing")
    public WebElement webtablemm;




}
