package tests;

import utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pages.LoginSignupPage;

public class SignupTest extends TestBase {

    @Test
    public void testSignUpButtonVisibility() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
        Assert.assertTrue(loginSignupPage.isSignUpButtonVisible(), "Sign Up button is not visible.");
    }

    @Test
    public void testSignUpButtonClickability() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
        loginSignupPage.clickSignUpButton();
    }

    @Test
    public void testSignUpPageOpens() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);
        Assert.assertTrue(loginSignupPage.isSignUpWindowVisible(), "Sign Up page/modal did not open.");
        
    }
    
    @AfterClass
    public void closeSignUpModal() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);

        if (loginSignupPage.isSignUpWindowVisible()) {
            loginSignupPage.closeSignUpWindow();
        } else {
            System.out.println("Sign-Up modal is not visible; skipping close.");
        }
    }

}
