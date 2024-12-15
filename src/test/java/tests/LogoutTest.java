package tests;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.LoginSignupPage;
import utils.TestBase;

public class LogoutTest extends TestBase {

	@BeforeMethod
	    public void closeAllModalsAfterTest(){
	        CartPage cartPage = new CartPage(driver);

	        cartPage.closeModals();
	        

	    
	}
	@Test(priority=1)
    public void testLogoutButtonVisibility() throws InterruptedException {
		
		Thread.sleep(3000);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver); 

        Assert.assertTrue(loginSignupPage.isUserdasboardVisible(), "Log out button is not visible.");
    }

    @Test(priority=2)
    public void testLogoutFunctionality() {
        HomePage homePage = new HomePage(driver);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver); 

        homePage.clickLogoutButton();

        Assert.assertTrue(loginSignupPage.isSignUpButtonVisible(), "Did not redirect to the home page after logging out.");
    }
    
    @AfterTest
    public void tearDown() {
        if (driver != null) 
    	{
            driver.quit();
        }
    }
}
