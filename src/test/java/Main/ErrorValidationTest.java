package Main;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestComponent.BaseTest;

public class ErrorValidationTest extends BaseTest
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
