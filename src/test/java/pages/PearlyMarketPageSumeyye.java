package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class PearlyMarketPageSumeyye {


    public PearlyMarketPageSumeyye() {

        PageFactory.initElements(Driver.getDriver(), this);

    }


    @FindBy(xpath = "//*[text()='Sign In']")
    public WebElement ilkSignInButton;

    @FindBy(xpath = "//input[@name='username']")
    public WebElement emailBox;

    @FindBy(xpath = "//input[@type='password']")
    public WebElement passwordBox;
    @FindBy(xpath = "//button[@name='login']")
    public WebElement ikinciSignInButton;

    //@FindBy(xpath = "(//*[@href='https://pearlymarket.com/my-account-2/'])[1]")
    @FindBy(xpath = "//a[contains(text(),'My Account')]")
    public WebElement myAccountButton;

    @FindBy(xpath = "//*[text()='Store Manager']")
    public WebElement storeManagerButton;

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-followers']")
    public WebElement followersButton;

    @FindBy(xpath = "//div[@class='wcfm-container wcfm-top-element-container']")
    public WebElement followersTransactions;

    @FindBy(xpath = "//*[text()='No data in the table']")
    public List<WebElement> followersInformations;

    @FindBy(xpath = "//th[@class='sorting_asc']")
    public List<WebElement> nameHeader;

    @FindBy(xpath = "//th[@class='sorting_disabled'][1]")
    public List<WebElement> emailHeader;

    @FindBy(xpath = "//th[@class='sorting_disabled'][2]")
    public List<WebElement> actionsHeader;

    @FindBy(xpath = "//*[@class='wcfm_menu_items wcfm_menu_wcfm-reviews']")
    public WebElement reviewsButton;

    @FindBy(xpath = "//*[@id='add_new_product_dashboard']")
    public WebElement productReviewsButton;

    @FindBy(xpath = "//table[@id='wcfm-reviews']//thead//th[text()='Author']")
    public WebElement authorHeader;

    @FindBy(xpath = "//tbody//tr//td//div[@class='wcfmmp-author-meta']")
    public List<WebElement> authorInformations;


    @FindBy(xpath = "//tbody//tr//td//div[@class='wcfmmp-comments-content']")
    public List<WebElement> commentsInformations;

    @FindBy(xpath = "//tbody//tr//td//div[@class='star-rating']")
    public List<WebElement> starRatings;


    @FindBy(xpath = "//tbody//tr//td[6]")
    public List<WebElement> dates;

    @FindBy(xpath = "//div[@class='wcfm_menu_items wcfm_menu_wcfm-reports']")
    public WebElement reportsButton;

    @FindBy(xpath = "//canvas[@id='chart-placeholder-canvas']")
    public WebElement reports;


    @FindBy(xpath = "//*[text()='Year']")
    public WebElement yearButton;


    @FindBy(xpath = "//*[text()='Last Month']")
    public WebElement lastMonthButton;


    @FindBy(xpath = "//*[text()='This Month']")
    public WebElement thisMonthButton;


    @FindBy(xpath = "//*[text()='Last 7 Days']")
    public WebElement last7DaysButton;


    @FindBy(xpath = "//li[@class='custom ']")
    public WebElement customButton;


    @FindBy (xpath = "//*[@class='wcfm-date-range']")
    public WebElement DateRange;

    @FindBy (css = ".wcfm-date-range")
    public  WebElement DayMonth;

    @FindBy (xpath = "(//div[@class='month-wrapper']//tbody//tr//td)[15]")
    public  WebElement day1;

    @FindBy (xpath = "(//div[@class='month-wrapper']//tbody//tr//td)[20]")
    public WebElement day2;

}

