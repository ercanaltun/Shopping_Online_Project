package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PearlyMarketPageSuleyman {

    public PearlyMarketPageSuleyman() {

        PageFactory.initElements(Driver.getDriver(), this);
    }


    // sign in
    @FindBy(css = "#main")
    public WebElement homePage;

    @FindBy(css = ".login.inline-type")
    public WebElement ilkSignIn;

    @FindBy(css = "#username")
    public WebElement emailBox;

    @FindBy(css = "#password")
    public WebElement passwordBox;

    @FindBy(css = ".woocommerce-form-login__submit")
    public WebElement ikinciSignIn;

    @FindBy(css = ".register.inline-type")
    public WebElement registerHomePage;

    @FindBy(xpath = "(//a[.='My Account'])[1]")
    public WebElement myAccountLink;

    @FindBy(css = "div>h2.page-title")
    public WebElement myAccountTitle;

    @FindBy(xpath = "(//*[.='Logout'])[1]")
    public WebElement logOutMyAccount;

    @FindBy(css = ".nav-link.active")
    public WebElement signInPage;

    @FindBy(css = ".icon-box.text-center>a>p")
    public List<WebElement> myAccountPageList;

    @FindBy(css = ".woocommerce-MyAccount-navigation>ul>li")
    public List<WebElement> dashboardList;
    @FindBy(xpath = "(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVendor;
    //.register_as_vendor
    @FindBy(xpath = "(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVendor2;

    @FindBy(css = ".woocommerce-MyAccount-navigation.col-md-3")
    public WebElement dashBoardList;


    //negativelogin
    @FindBy(xpath = "//p[.='Wrong username or password.']")
    public WebElement wrongSignInText;

    //registrationpage
    @FindBy(css = "#user_email")
    public WebElement registerEmailBox;

    @FindBy(css = "#passoword")
    public WebElement registerPasswordBox;

    @FindBy(css = "#confirm_pwd")
    public WebElement registerConfirmPwdBox;

    @FindBy(css = ".wcfm_email_verified_input")
    public WebElement verificationCodeBox;

    @FindBy(css = "#wcfm_membership_register_button")
    public WebElement registerButton;

    @FindBy(css = ".wcfm-message.wcfm-success")
    public WebElement registrationSuccessfully;


    @FindBy(css = "div.wcfm-message.email_verification_message.wcfm-success")
    public WebElement verificationSentToEmail;

    @FindBy(xpath = "//*[.='Not right now']")
    public WebElement notRightNowButton;

    @FindBy(css = ".page-title")
    public WebElement storeManagerTitle;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logOutManager;

    @FindBy(xpath = "//*[text()='Email: This field is required.']")
    public WebElement emailDogrulamaBosText;

    @FindBy(xpath = "//*[text()='Email Verification Code: This field is required.']")
    public WebElement emailKutusuBosText;

    @FindBy(xpath = "//*[.='This Email already exists. Please login to the site and apply as vendor.']")
    public WebElement emailAlreadyExistsText;

    @FindBy(xpath = "//*[.='Password strength should be atleast \"Good\".']")
    public WebElement weakPasswordText;

    @FindBy(xpath = "//*[.='Password and Confirm-password are not same.']")
    public WebElement passwordNotSameText;

    @FindBy(xpath = "//*[@class='page-title']")
    public WebElement storeManager;


    //verification code div.email gecici email sitesi locate
    @FindBy(css = "div.email")
    public WebElement geciciEmail;
    @FindBy(css = "a#renew")
    public WebElement emailBoxRefresh;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement geciciEmailBox;

    @FindBy(xpath = "//tbody//tr[2]")
    public WebElement onayEmail;

    @FindBy(xpath = "//*[@id='body_content_inner']")
    public WebElement verificationCode;
    //tbody>tr>td>div>p>b

    @FindBy(xpath = "//*[.='Visit now ...']")
    public WebElement visitNow;
    //==================================================================================


    //Us22
    @FindBy(xpath = "//h2//a[@href='/product-category/trending/']")
    public WebElement trendingSeeAll;

    @FindBy(xpath = "//h2//a[@href='/product-category/new-arrivals/']")
    public WebElement newArrivalsSeeAll;

    @FindBy(xpath = "//h2//a[@href='/product-category/best-seller/']")
    public WebElement bestSellerSeeAll;

    @FindBy(css = "ul>li.delimiter")
    public WebElement trendingPage;
    @FindBy(css = "ul>li.delimiter")
    public WebElement newArrivalsPage;
    @FindBy(css = "ul>li.delimiter")
    public WebElement bestSellerPage;

    @FindBy(css = "select.orderby.form-control")
    public WebElement trendingDdm;

    @FindBy(css = "select.orderby.form-control")
    public WebElement newArrivalsDdm;

    @FindBy(css = "select.orderby.form-control")
    public WebElement bestSellerDdm;
}