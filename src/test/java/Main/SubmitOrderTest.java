package Main;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.CartPage;
import PageObjects.CheckoutPage;
import PageObjects.OrderPage;
import PageObjects.ProductPage;
import PageObjects.SuccessPage;
import TestComponent.BaseTest;
import java.util.HashMap;

public class SubmitOrderTest extends BaseTest
{   
    String email = "shoptest@test.com";
    String password = "Tester123#";
    String productNameTxt = "IPHONE 13 PRO";

    @Test(dataProvider="getData")
    public void submitOrder(HashMap<String, String> input) throws InterruptedException, IOException
    {
        String email = "shoptest@test.com";
        String password = "Tester123#";
        String productNameTxt = "IPHONE 13 PRO";
        String countryNameTxt = "Indonesia";

        // Login
        ProductPage productPage = loginPage.login(input.get("email"), input.get("password"));

        // Product Page
        productPage.addToCart(input.get("productName"));
        CartPage cartPage = productPage.goToCartPage();

        // Cart Page
        Boolean match = cartPage.verifyProductByName(input.get("productName"));
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

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "shoptest@test.com");
        map.put("password", "Tester123#");
        map.put("productName", "IPHONE 13 PRO");

        HashMap<String, String> map1 = new HashMap<String, String>();
        map1.put("email", "shoptest@test.com");
        map1.put("password", "Tester123#");
        map1.put("productName", "ADIDAS ORIGINAL");

        return new Object[][] {{map},{map1}};
    }
}
