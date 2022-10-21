package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageNur {

    public PearlyMarketPageNur() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
