package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); 
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath="//*[@id=\\\"navbarExample\\\"]/ul/li[1]/a")
    private WebElement Homepage;
    
    @FindBy(xpath = "//h2[@class='name']") 
    private WebElement productTitle;

    @FindBy(xpath = "//h3[@class='price-container']") 
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='more-information']/p") 
    private WebElement productDescription;

    @FindBy(xpath = "//a[contains(@onclick, 'addToCart')]") 
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[@id='cartur']") 
    private WebElement cartLink;

    @FindBy(xpath = "//*[@id=\"tbodyid\"]") 
    private WebElement cartTableBody;

    public String getProductTitle() {
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        return productTitle.getText();
    }

    public String getProductPrice() {
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        return productPrice.getText();
    }

    public String getProductDescription() {
        wait.until(ExpectedConditions.visibilityOf(productDescription));
        return productDescription.getText();
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton)).click();
    }

    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
    }

    public boolean isTitleAndPriceCorrect(String expectedTitle, String expectedPrice) {
        wait.until(ExpectedConditions.visibilityOf(cartTableBody));

        List<WebElement> rows = cartTableBody.findElements(By.xpath("//*[@id=\"tbodyid\"]"));

        for (WebElement row : rows) {
            String actualTitle = row.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]")).getText(); 
            String actualPrice = row.findElement(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]")).getText(); 

            if (actualTitle.equals(expectedTitle) && actualPrice.equals(expectedPrice)) {
                return true; 
            }
           
            wait.until(ExpectedConditions.elementToBeClickable(Homepage)).click();

        }
        return false; 
    }

}
