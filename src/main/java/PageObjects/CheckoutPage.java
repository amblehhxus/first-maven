package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractComponents {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@placeholder='Select Country']")
    WebElement fieldSelectCountry;

    @FindBy(css = "span.ng-star-inserted")
    List<WebElement> optionSelectCountry;

    @FindBy(css = ".action__submit")
    WebElement btnPlaceOrder;

    By dropdownObj = By.cssSelector(".ta-results");

    public void inputSelectCountry(String countryTxt) {
        fieldSelectCountry.sendKeys(countryTxt);
        waitForElementVisible(dropdownObj);
        WebElement country = optionSelectCountry.stream().filter(s -> s.getText().equalsIgnoreCase(countryTxt))
            .findFirst().orElse(null);
        
        country.click();
    }

    public SuccessPage clickBtnPlaceOrder() {
        btnPlaceOrder.click();
        return new SuccessPage(driver);
    }
}
