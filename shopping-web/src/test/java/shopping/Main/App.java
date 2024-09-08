package shopping.Main;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.LoginPage;
import PageObjects.ProductPage;
import PageObjects.SuccessPage;
import Test.BaseTest;

public class App extends BaseTest
{   
    @Test
    public void submitOrder() throws InterruptedException, IOException
    {
        String email = "shoptest@test.com";
        String password = "Tester123#";
        String productNameTxt = "IPHONE 13 PRO";
        String countryNameTxt = "Indonesia";

        // Create objects
        LoginPage loginPage = startApplication();

        // Login
        ProductPage productPage = loginPage.login(email, password);

        // Product Page
        productPage.addToCart(productNameTxt);
        CartPage cartPage = productPage.goToCartPage();

        // Cart Page
        Boolean match = cartPage.verifyProductByName(productNameTxt);
        Assert.assertTrue(match);
        CheckoutPage checkoutPage = cartPage.clickCheckoutBtn();
        
        // Checkout Page
        checkoutPage.inputSelectCountry(countryNameTxt);
        SuccessPage successPage = checkoutPage.clickBtnPlaceOrder();

        // Success Page
        Boolean success = successPage.checkSuccessTxt();
        Assert.assertTrue(success);
    }

}
