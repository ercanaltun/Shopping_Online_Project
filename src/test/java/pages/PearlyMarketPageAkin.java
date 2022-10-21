package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageAkin {

    public PearlyMarketPageAkin() {

        PageFactory.initElements(Driver.getDriver(),this);
    }
}
