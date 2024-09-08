package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;

        //Initiate FindBy
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="userEmail")
    WebElement fieldEmail;

    @FindBy(id="userPassword")
    WebElement fieldPassword;

    @FindBy(id="login")
    WebElement btnLogin;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessageContainer;

    public ProductPage login(String email, String password) {
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        btnLogin.click();
        
        return new ProductPage(driver);
    }

    public String getErrorMessage() {
        waitForWebElementVisible(errorMessageContainer);
        return errorMessageContainer.getText();
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
