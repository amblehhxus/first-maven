package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractComponents {

    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css=".cartSection h3")
    List<WebElement> cartProductCard;

    @FindBy(xpath="//button[text()='Checkout']")
    WebElement checkoutBtn;

    public boolean verifyProductByName(String productNameTxt) {
        boolean match = cartProductCard.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productNameTxt));
        return match;
    }

    public CheckoutPage clickCheckoutBtn() {
        checkoutBtn.click();
        return new CheckoutPage(driver);
    }
}
