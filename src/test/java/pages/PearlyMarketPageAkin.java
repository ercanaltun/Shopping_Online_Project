package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageAkin {
    public PearlyMarketPageAkin() {
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
    public WebElement password;

    @FindBy(css = ".woocommerce-form-login__submit")
    public WebElement ikinciSignIn;

    @FindBy(css = ".register.inline-type")
    public WebElement registerHomePage;

    @FindBy(xpath = "(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVendor;
    //.register_as_vendor
    @FindBy(xpath = "(//*[.='Become a Vendor'])[2]")
    public WebElement becomeAVendor2;


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


    @FindBy(xpath = "//*[.='Not right now']")
    public WebElement notRightNowButton;

    @FindBy(css = ".page-title")
    public WebElement storeManagerTitle;

    @FindBy(xpath = "//*[.='Logout']")
    public WebElement logoutManager;

    //verification code div.email
    @FindBy(css = "div.email")
    public WebElement geciciEmail;
    @FindBy(css = "a#renew")
    public WebElement emailBoxRefresh;

    @FindBy(xpath = "//tbody//tr[1]")
    public WebElement geciciEmailBox;

    @FindBy(xpath = "//*[@id='body_content_inner']")
    public WebElement verificationCode;

    @FindBy(xpath = "//nav//ul//li//a[.='Store Manager']")
    public WebElement storeManager;
    @FindBy(css = "a.login.logout.inline-type>i")
    public WebElement signOutButton;

    @FindBy(xpath = "(//*[@class='wcfm_menu_item '])[3]")
    public WebElement products;
    @FindBy(xpath = "//thead//tr/th[5]")
    public WebElement statusBaslik;
    @FindBy(xpath = "//thead//tr/th[6]")
    public WebElement stockBaslik;
    @FindBy(xpath = "//thead//tr/th[7]")
    public WebElement priceBaslik;
    @FindBy(xpath = "//thead//tr/th[11]")
    public WebElement dateBaslik;

    @FindBy(css = "#add_new_product_dashboard")
    public WebElement addNewButton;

    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualClick;

    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadableClick;
    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;
    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement fotoEkleme1;

    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement foto2Ekleme;

    @FindBy(xpath = "//button[@id='menu-item-browse']")
    public WebElement mediaLibrary;

    @FindBy(xpath = "//li[@data-id='14014']")
    public WebElement foto1;
    @FindBy(xpath = "(//*[@class='attachment save-ready'])[9]")
    public WebElement foto2;
    @FindBy(css = ".button.media-button.button-primary.button-large.media-button-select")
    public WebElement fotoSelectButton;
    @FindBy(xpath = "(//div[@class='media-toolbar-primary search-form'])[4]")
    public WebElement fotoAddToGalleryButton;
    @FindBy(xpath = "//img[@id='featured_img_display']")
    public WebElement foto_1Displayed;
    @FindBy(xpath = "//img[@id='gallery_img_gimage_0_display']")
    public WebElement foto_2Displayed;
    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement priceGirisi;

    @FindBy(css = "html>body[data-id=excerpt]>:only-child")
    public WebElement shortDescription;

    @FindBy(css = "html>body[data-id=description]>:only-child")
    public WebElement description;
    @FindBy(xpath = "//ul//li//input[@value='230']")
    public WebElement electronicsKategorisi;
    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit_button']")
    public WebElement submitButton;
    @FindBy(xpath = "//*[contains(text(), 'Product Successfully Published.')]")
    public WebElement submitUyari;
    @FindBy(xpath = "//div[@class='wcfm-message wcfm-success']")
    public WebElement tamamYazisi;
    @FindBy(xpath = "//*[text()='Featured img: This field is required.']")
    public WebElement uyariYazisiNegatifTest;

    @FindBy(xpath = "(//input[@class=\"wcfm-checkbox checklist_type_product_cat \"])[9]")
    public WebElement besinTakviyesi;
    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[10]")
    public WebElement cokSatanlar;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[30]")
    public WebElement elektrikElektronik;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[64]")
    public WebElement EvVeYasam;
    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[66]")
    public WebElement indirimliUrunler;
    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[11]")
    public WebElement KitapMüzikFilm;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[19]")
    public WebElement KozmetikKisisel;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[32]")
    public WebElement ModaGiyim;
    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[94]")
    public WebElement Oyuncak;
    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[1]")
    public WebElement TakiVeAksesuar;

    @FindBy(xpath = "(//*[@class='wcfm-checkbox checklist_type_product_cat '])[81]")
    public WebElement YeniUrünler;


    @FindBy(xpath = "(//*[contains(text(), 'Please insert Product Title before submit.')])[1]")
    public WebElement uyariYazisiProduct;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[10]")
    public WebElement elegantAutoBrand;

    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[14]")
    public WebElement  greenGrass;
    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[34]")
    public WebElement   nodeJS;
    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[36]")
    public WebElement  NS8;
    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[49]")
    public WebElement  RED;
    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[57]")
    public WebElement  SkySuite;
    @FindBy(xpath = "(//input[@class='wcfm-checkbox checklist_type_product_brand '])[59]")
    public WebElement  Sterling;


}
