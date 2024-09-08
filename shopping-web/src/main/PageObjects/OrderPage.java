package PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractComponents {

    WebDriver driver;

    public OrderPage(WebDriver driver) {
        
        super(driver);

        this.driver = driver;

        //Initiate FindBy
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath ="//tr/td[2]")
    List<WebElement> productName;

    @FindBy(css=".ngx-spinner-overlay")
    WebElement spinner;

    public Boolean verifyProductName(String productNameExpected) {
        Boolean productNameObj = productName.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productNameExpected));
        return productNameObj;
    }
}
