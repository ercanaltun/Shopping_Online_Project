package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PearlyMarketPageZeliha {

    public PearlyMarketPageZeliha() {

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

    @FindBy(xpath = "(//*[text()='My Account'])[2]")
    public WebElement myAcount;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManager;

    //@FindBy(xpath = "(//*[@class='text'])[6]")
    //public WebElement couponsButton;

    @FindBy(xpath = "//*[@href=\"https://pearlymarket.com/store-manager/coupons/\"]")
    public WebElement couponsButton;

    @FindBy(xpath = "//*[@id='add_new_coupon_dashboard']")
    public WebElement addNewButton;

    @FindBy(xpath = "//*[text()='Add Coupon']")
    public WebElement addCoupon;

    @FindBy(xpath = "//*[@class='wcfm-container wcfm-top-element-container']")
    public WebElement addCouponSayfaDogrulama;

    @FindBy(xpath = "//*[@id='title']")
    public WebElement codeBox;

    @FindBy(xpath = "//*[@id='description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//*[@id='discount_type']")
    public WebElement discountTypeBox;

    @FindBy(xpath = "//*[@id='coupon_amount']")
    public WebElement couponAmountBox;

    @FindBy(xpath = "//*[@id='expiry_date']")
    public WebElement couponExpiryDate;

    @FindBy(xpath = "//*[@class='ui-datepicker-month']")
    public WebElement couponMonth;

    @FindBy(xpath = "//*[@class='ui-datepicker-year']")
    public WebElement couponYear;

    @FindBy(xpath = "//*[@id='ui-datepicker-div']")
    public WebElement couponDateBox;

    @FindBy(xpath = "//a[text()='23']")
    public List<WebElement> couponDay;



    @FindBy(xpath = "//*[text()='Coupon expiry date']")
    public WebElement getCouponExpiryDate;

    @FindBy(xpath = "//input[@id='free_shipping']")
    public WebElement allowFreeShipping;

    @FindBy(xpath = "//input[@id='show_on_store']")
    public WebElement showOnStore;

    @FindBy(xpath = "//*[@id='coupons_manage_general_expander']")
    public WebElement couponVerification;

    @FindBy(xpath = "//*[@id='minimum_amount']")
    public WebElement minimumAmountBox;

    @FindBy(xpath = "//*[@id='maximum_amount']")
    public WebElement maximumAmountBox;

    @FindBy(xpath = "//*[@id='individual_use']")
    public WebElement individualUseOnlyBox;

    @FindBy(xpath = "//*[@id='exclude_sale_items']")
    public WebElement excludeSaleItemsBox;

    /*
    @FindBy(xpath = "(//*[@class='select2-search__field'])[4]")
    public WebElement excludeCategories;

    @FindBy(xpath = "//*[@id='select2-exclude_product_categories-result-yd3l-229']")
    public WebElement excludeCategories2;

     */



    @FindBy(css = ".select2-results__options>li")
    public WebElement excludeCategories;


    @FindBy(xpath = "//*[@id='coupons_manage_limit']")
    public WebElement limitButton;

    @FindBy(xpath = "//*[@id='usage_limit']")
    public WebElement useLimitPerCouponBox;

    @FindBy(xpath = "//*[@id='limit_usage_to_x_items']")
    public WebElement limitUsageToXItemsBox;

    @FindBy(xpath = "//*[@id='usage_limit_per_user']")
    public WebElement usageLimitPerUserBox;

    @FindBy(xpath = "//*[@id='wcfm_coupon_manager_submit_button']")
    public WebElement submitButton;

    @FindBy(xpath = "//*[@class='collapse wcfm-collapse']")
    public WebElement couponSuccessfullyPublished;

    @FindBy(xpath = "//*[contains(text(), 'Coupon Successfully Published')]")
    public WebElement couponSuccessfullyPublish;

    @FindBy(xpath = "//*[contains(text(), 'Coupon Successfully Saved.')]")
    public WebElement couponSuccessfullySaved;


    @FindBy(xpath = "//*[contains(text(), 'Coupon code already exists - customers will use the latest coupon with this code.')]")
    public WebElement couponCodeAlreadyExists;



    //

    //     Product Successfully Published.

    //*[contains(text(), 'Product Successfully Published.')]


    @FindBy(xpath = "(//span[@class='select2-selection select2-selection--multiple'])[4]")
    public WebElement excludeCategoriess;


    @FindBy(xpath = "//ul[@class='select2-results__options']//li[text()='Accessories']")
    public WebElement accessories;

    //@FindBy(xpath = "//ul[@class='select2-results__options']//li[@class='select2-results__option']")
    //public List<WebElement> excludeCategoriesList;

    @FindBy(xpath = "//*[@class='wcfm-tabWrap']")
    public WebElement restrictionVerification;


    @FindBy(xpath = "//*[@id='wcfm_coupon_manager_submit']")
    public WebElement pleaseInsertAtleastCouponTitle;


    @FindBy(xpath = "//*[@name='draft-data']")
    public WebElement draftButton;




}
