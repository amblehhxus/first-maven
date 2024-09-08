package Main;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.OrderPage;
import PageObjects.ProductPage;
import PageObjects.SuccessPage;
import TestComponent.BaseTest;

public class SubmitOrderTest extends BaseTest
{   
    String email = "shoptest@test.com";
    String password = "Tester123#";
    String productNameTxt = "IPHONE 13 PRO";

    @Test
    public void submitOrder() throws InterruptedException, IOException
    {
        String email = "shoptest@test.com";
        String password = "Tester123#";
        String productNameTxt = "IPHONE 13 PRO";
        String countryNameTxt = "Indonesia";

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

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistory() {
        ProductPage productPage = loginPage.login(email, password);
        OrderPage orderPage = productPage.goToOrderPage();
        Assert.assertTrue(orderPage.verifyProductName(productNameTxt));
    }
}
