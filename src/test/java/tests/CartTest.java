package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import utils.TestBase;

public class CartTest extends TestBase {

	   @Test(priority = 1)
	    public void testDeleteItemFromCart() {
	        
	        CartPage cartPage = new CartPage(driver);        
	        // Get the total price before deletion
	        int totalPriceBeforeDelete = cartPage.getTotalPrice();

	        // Delete the second item from the cart
	        cartPage.deleteSecondItemFromCart();

	        // Verify the item is deleted
	        Assert.assertTrue(cartPage.getTotalPrice() < totalPriceBeforeDelete, "Item was not deleted from the cart.");
	    }

	    @Test(priority = 2)
	    public void testTotalPriceAfterDeletion() {
	        CartPage cartPage = new CartPage(driver);

	        // Get the total price after deletion
	        int totalPriceAfterDelete = cartPage.getTotalPrice();

	        // Verify the total price is updated correctly
	        Assert.assertEquals(totalPriceAfterDelete, 790, "Total price is incorrect after deletion.");
	    }

    @Test(priority = 3)
    public void testPlaceOrderButtonRedirection() {
        CartPage cartPage = new CartPage(driver);

        // Click the "Place Order" button
        cartPage.clickPlaceOrder();

        // Verify the "Place Order" modal is displayed
        Assert.assertTrue(cartPage.isPlaceOrderModalDisplayed(), "Failed to redirect to 'Place Order' page.");
    }


    @Test(priority = 4)
    public void testUserDetailsFieldsPresence() {
        CartPage cartPage = new CartPage(driver);

        Assert.assertTrue(cartPage.areAllFieldsPresent(), "All user details fields are not present in the 'Place Order' modal.");
    }

    @Test(priority = 5)
    public void testSubmitOrder() {
        CartPage cartPage = new CartPage(driver);

        cartPage.fillPlaceOrderForm("John Doe", "USA", "New York", "1234567890123456", "12", "2025");

        cartPage.submitOrder();
    }
    
}
