package tests;

import utils.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTest extends TestBase {

    @Test(priority = 1)
    public void testWelcomeMessageDisplayed() {

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isWelcomeMessageDisplayed(), "Welcome message is not displayed on the homepage.");
    }

    @Test(priority = 2)
    public void testMenuItemsDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.areMenuItemsDisplayed(), "Not all menu items are displayed on the homepage.");
    }

    @Test(priority = 3)
    public void testProductCategoriesDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.areProductCategoriesDisplayed(), "Product categories are not displayed on the homepage.");
    }

    @Test(priority = 4)
    public void testApplicationLogoDisplayed() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isApplicationLogoDisplayed(), "Application logo is not displayed on the homepage.");
    }
}
