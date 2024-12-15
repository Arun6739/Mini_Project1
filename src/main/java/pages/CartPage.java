package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); 
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="totalp")
    private WebElement totalPriceElement;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[2]/td[4]/a")
    private WebElement deleteButton;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]/tr[2]/td[2]")
    private WebElement deletedItemTitle;

    @FindBy(xpath = "//button[@class='btn btn-success' and @data-target='#orderModal']")
    private WebElement placeOrderButton;

    @FindBy(xpath = "//h5[@id='orderModalLabel' and text()='Place order']")
	public WebElement placeOrderModalTitle;

    @FindBy(id = "name")
    private WebElement nameField;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement creditCardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[@class='btn btn-primary' and text()='Purchase']")
    private WebElement purchaseButton;
    
    
    public boolean isPlaceOrderModalDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(placeOrderModalTitle));
        return placeOrderModalTitle.isDisplayed();
    }

    public int getTotalPrice() {
        wait.until(ExpectedConditions.visibilityOf(totalPriceElement));
        return Integer.parseInt(totalPriceElement.getText());
    }

    public void deleteSecondItemFromCart() {
        wait.until(ExpectedConditions.elementToBeClickable(deleteButton)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@id=\"tbodyid\"]/tr[2]/td[2]")));
    }

    public void clickPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton)).click();
        wait.until(ExpectedConditions.visibilityOf(placeOrderModalTitle));
    }

    public boolean areAllFieldsPresent() {
        return nameField.isDisplayed() && countryField.isDisplayed() &&
               cityField.isDisplayed() && creditCardField.isDisplayed() &&
               monthField.isDisplayed() && yearField.isDisplayed();
    }

    public void fillPlaceOrderForm(String name, String country, String city, String card, String month, String year) {
        nameField.sendKeys(name);
        countryField.sendKeys(country);
        cityField.sendKeys(city);
        creditCardField.sendKeys(card);
        monthField.sendKeys(month);
        yearField.sendKeys(year);
    }

    public void submitOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(purchaseButton)).click();
    }
    
    private By modalCloseButton1 = By.xpath("/html/body/div[10]/div[7]/div/button");

    private By modalCloseButton2 = By.xpath("//*[@id='orderModal']/div/div/div[3]/button[1]");

    public boolean isModal1Visible() {
        try {
            WebElement button = driver.findElement(modalCloseButton1);
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isModal2Visible() {
        try {
            WebElement button = driver.findElement(modalCloseButton2);
            return button.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void closeModals() {
        try {
            if (isModal1Visible()) {
                WebElement closeButton1 = wait.until(ExpectedConditions.elementToBeClickable(modalCloseButton1));
                closeButton1.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(modalCloseButton1));
                System.out.println("First modal closed.");
            }

            if (isModal2Visible()) {
                WebElement closeButton2 = wait.until(ExpectedConditions.elementToBeClickable(modalCloseButton2));
                closeButton2.click();
                wait.until(ExpectedConditions.invisibilityOfElementLocated(modalCloseButton2));
                System.out.println("Second modal closed.");
            }
        } catch (Exception e) {
            System.out.println("Error while closing modals: " + e.getMessage());
        }
    }
}

