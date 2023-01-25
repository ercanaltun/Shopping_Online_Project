package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageErcan {

    public PearlyMarketPageErcan() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
