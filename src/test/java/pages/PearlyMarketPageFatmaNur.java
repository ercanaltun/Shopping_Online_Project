package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageFatmaNur {

    public PearlyMarketPageFatmaNur() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement signIn;

    @FindBy(id = "username")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//*[@name='login']")
    public WebElement login;

    @FindBy(xpath = "//*[@href='/my-account-2/orders/']")
    public WebElement myAccount;

    @FindBy(xpath = "//*[@href='https://pearlymarket.com/store-manager/']")
    public WebElement storeManager;

    @FindBy(xpath = "(//*[@class='wcfmfa fa-cube'])[1]")
    public WebElement product;


    @FindBy(xpath = "//span[text()='Add New']")
    public WebElement addNew;

    @FindBy(xpath = "//*[@class='wcfmfa fa-edit text_tip']")
    public WebElement edit;

    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manage_stock;

    @FindBy(id = "stock_qty")
    public WebElement stock_qty;

    @FindBy(xpath = "//input[@class='wcfm-checkbox bulk_action_checkbox_single']")
    public WebElement firstProduct;

    @FindBy(xpath = "//input[@id='wcfm_products_simple_submit_button']")
    public WebElement submitProductButton;

    @FindBy(xpath = "//*[contains(text(), 'Product Successfully Published.')]")
    public WebElement submitProductStockSuccess;

    @FindBy(xpath = "//*[@class='product-status product-status-publish']")
    public WebElement published;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[1]")
    public WebElement inventory;

    @FindBy(xpath = "//*[@id='backorders']")
    public WebElement backorders;

    @FindBy(xpath = "//*[@id='sold_individually']")
    public WebElement soldIndividually;

    @FindBy(xpath = "//*[@class='wcfm-message wcfm-success']")
    public WebElement successfullyPublished;

    @FindBy(xpath = "(//div[@class='page_collapsible_content_holder'])[4]")
    public WebElement shipping;

    @FindBy(xpath = "//input[@id='weight']")
    public WebElement weight;

    @FindBy(xpath = "//input[@id='length']")
    public WebElement length;

    @FindBy(xpath = "//input[@id='width']")
    public WebElement width;

    @FindBy(xpath = "//input[@id='height']")
    public WebElement height;

    @FindBy(xpath = "//*[@id='_wcfmmp_processing_time']")
    public WebElement processingTime;

    @FindBy(xpath = "(//*[@class='page_collapsible_content_holder'])[5]")
    public WebElement attributes;

    @FindBy(xpath = "//input[@id='attributes_is_active_1']")
    public WebElement color;

    @FindBy(xpath = "(//span[@class='fields_collapser attributes_collapser wcfmfa fa-arrow-circle-down'])[2]")
    public WebElement colorSelect;

    @FindBy(xpath = "//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes']")
    public WebElement selectAllColor;

    @FindBy(xpath = "//*[@id='attributes_is_active_2']")
    public WebElement size;

    @FindBy(xpath = "//*[@class='button wcfm_add_attribute_term wcfm_select_all_attributes']")
    public WebElement selectAllSize;


    @FindBy(xpath = "//input[@id='pro_title']")
    public WebElement productTitle;

    @FindBy(xpath = "//*[@id='featured_img_display']")
    public WebElement image;

    @FindBy(xpath = "(//*[@id='menu-item-browse'])[1]")
    public WebElement mediaLibrary;
    @FindBy(xpath = "(//*[@class='thumbnail'])[3]")
    public WebElement firstfoto;

    @FindBy(xpath = "//*[@class='button media-button button-primary button-large media-button-select']")
    public WebElement firstfotoSelect;

    @FindBy(xpath = "//*[@id='gallery_img_gimage_0_display']")
    public WebElement secondimage;


    @FindBy(xpath = "(//*[@src=\"http://pearlymarket.com/wp-content/uploads/2022/10/unisex-hoodie-300x300.webp\"])[2]")
    public WebElement secondfoto;


    @FindBy(xpath = "//div[@id='__wp-uploader-id-3']//div[@class='media-frame-toolbar']//button[@type='button'][normalize-space()='Add to Gallery']")
    public WebElement secondfotoSelect;

    @FindBy(xpath = "(//span[@title='Toggle Block'])[3]")
    public WebElement sizeButton;
}
