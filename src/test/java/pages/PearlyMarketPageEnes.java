package pages;

import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PearlyMarketPageEnes {

    public PearlyMarketPageEnes() {

        PageFactory.initElements(Driver.getDriver(), this);
    }
}
