package tests;

import utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginSignupPage;

public class LoginTest extends TestBase {


    @Test(priority=1)
    public void testLoginButtonVisibility() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);

        Assert.assertTrue(loginSignupPage.isLoginButtonVisible(), "Log In button is not visible.");
    }

    @Test(priority=2)
    public void testLoginButtonClickability() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);

        loginSignupPage.clickLoginButton();
        loginSignupPage.login("Arunexample315@gmail.com", "Arun@2000");
    }
    
    @Test(priority=3)
    public void testUserDashboardOpens() {
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver); 
        
        Assert.assertTrue(loginSignupPage.isUserdasboardVisible1(),"UserDashboard is not opend");
}
    
}
