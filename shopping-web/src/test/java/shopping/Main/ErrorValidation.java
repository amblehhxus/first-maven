package shopping.Main;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Test.BaseTest;

public class ErrorValidation extends BaseTest
{   
    @Test
    public void errorValidation() throws InterruptedException, IOException
    {
        String email = "shoptestasdas@test.com";
        String password = "Tester12s3#";

        // Login
        loginPage.login(email, password);
        Assert.assertEquals("Incorrect email or password.", loginPage.getErrorMessage());
    }

}
