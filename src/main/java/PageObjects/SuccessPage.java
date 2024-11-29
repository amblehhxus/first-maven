package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SuccessPage extends AbstractComponents {

    WebDriver driver;

    public SuccessPage(WebDriver driver) {
        
        super(driver);

        this.driver = driver;

        //Initiate FindBy
        PageFactory.initElements(driver, this);
    }


    @FindBy(tagName = "h1")
    WebElement successTxt;

    public boolean checkSuccessTxt() {
        boolean match = successTxt.getText().equalsIgnoreCase("THANKYOU FOR THE ORDER.");
        return match;
    }
}
