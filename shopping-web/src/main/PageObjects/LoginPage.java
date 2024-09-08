package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        
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

    public ProductPage login(String email, String password) {
        fieldEmail.sendKeys(email);
        fieldPassword.sendKeys(password);
        btnLogin.click();
        
        return new ProductPage(driver);
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client");
    }
}
