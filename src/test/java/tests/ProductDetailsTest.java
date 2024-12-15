package tests;

import utils.TestBase;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductDetailsPage;

public class ProductDetailsTest extends TestBase {

    WebDriverWait wait;

    @Test(priority = 1)
    public void testRedirectionToProductDetailsPage() {
        HomePage homePage = new HomePage(driver);
        homePage.selectSonyVaioI5();

        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        Assert.assertEquals(productDetailsPage.getProductTitle(), "Sony vaio i5",
                            "Redirection to product details page failed.");
    }

    @Test(priority = 2)
    public void testProductDetailsAccuracy() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        String expectedPrice = "$790 *includes tax";
        String expectedDescription = "Sony is so confident that the VAIO S is a superior ultraportable laptop that the company proudly compares the notebook to Apple's 13-inch MacBook Pro. And in a lot of ways this notebook is better, thanks to a lighter weight.";

        Assert.assertEquals(productDetailsPage.getProductPrice(), expectedPrice, "Product price does not match.");

        Assert.assertTrue(productDetailsPage.getProductDescription().contains(expectedDescription),
                          "Product description does not match.");
    }

    @Test(priority = 3)
    public void testAddProductToCartAndVerifyDetails() {
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        productDetailsPage.addToCart();

        productDetailsPage.goToCart();

        String expectedTitle = "Sony vaio i5";
        String expectedPrice = "790";

        Assert.assertTrue(productDetailsPage.isTitleAndPriceCorrect(expectedTitle, expectedPrice),
                          "The title or price in the cart is incorrect.");

    }


    @Test(priority = 4)
    public void testIncrementCartCount() {
        HomePage homePage = new HomePage(driver);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
        
        homePage.clickHomeLink();

        homePage.selectSonyVaioI5();

        productDetailsPage.addToCart();

        productDetailsPage.goToCart();

        Assert.assertTrue(productDetailsPage.isTitleAndPriceCorrect("Sony vaio i5", "790"),
                          "Product count did not increment as expected.");
    }
    
}
