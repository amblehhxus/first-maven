package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends AbstractComponents {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        
        super(driver);

        this.driver = driver;

        //Initiate FindBy
        PageFactory.initElements(driver, this);
    }


    @FindBy(css=".mb-3")
    List<WebElement> productCard;

    @FindBy(css="[routerlink*='cart']")
    WebElement cartPageBtn;

    @FindBy(css=".ngx-spinner-overlay")
    WebElement spinner;

    By productCardBy = By.cssSelector(".mb-3");
    By productNameBy = By.cssSelector("b");
    By addToCartBtnBy = By.cssSelector(".card-body button:last-of-type");
    By toastMessageBy = By.id("toast-container");

    // public List<WebElement> getProductList() {
    //     waitForElementVisible(productCardBy);
    //     return productCard; 
    // }

    public WebElement getProductByName(String productNameExpected) {
        waitForElementVisible(productCardBy);
        WebElement productNameObj = productCard.stream().filter(s -> s.findElement(productNameBy)
            .getText().equalsIgnoreCase(productNameExpected)).findFirst().orElse(null);
        return productNameObj;
    }

    public void addToCart(String productNameExpected) throws InterruptedException {
        WebElement productNameObj = getProductByName(productNameExpected);
        productNameObj.findElement(addToCartBtnBy).click();
        waitForElementVisible(toastMessageBy);
        waitForInvisibility(spinner);
        Thread.sleep(3000);
    }
}
