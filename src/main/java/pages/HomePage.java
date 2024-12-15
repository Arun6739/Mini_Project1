package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); 
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='nameofuser']")
    private WebElement welcomeMessage;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    private WebElement homeMenuItem;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[2]/a")
    private WebElement contactMenuItem;

    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[3]/a")
    private WebElement aboutUsMenuItem;

    @FindBy(xpath = "//*[@id=\"cartur\"]")
    private WebElement cartMenuItem;

    @FindBy(xpath = "//*[@id=\"logout2\"]")
    private WebElement logoutMenuItem;

    @FindBy(xpath = "//a[contains(text(),'Phones')]")
    private WebElement phonesCategory;

    @FindBy(xpath = "//a[contains(text(),'Laptops')]")
    private WebElement laptopsCategory;

    @FindBy(xpath = "//a[contains(text(),'Monitors')]")
    private WebElement monitorsCategory;

    @FindBy(xpath = "//*[@id=\"nava\"]/img")
    private WebElement applicationLogo;

    public boolean isWelcomeMessageDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.isDisplayed();
    }

    public boolean areMenuItemsDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(homeMenuItem));
        wait.until(ExpectedConditions.visibilityOf(contactMenuItem));
        wait.until(ExpectedConditions.visibilityOf(aboutUsMenuItem));
        wait.until(ExpectedConditions.visibilityOf(cartMenuItem));
        wait.until(ExpectedConditions.visibilityOf(logoutMenuItem));
        return homeMenuItem.isDisplayed() && contactMenuItem.isDisplayed() &&
               aboutUsMenuItem.isDisplayed() && cartMenuItem.isDisplayed() &&
               logoutMenuItem.isDisplayed();
    }
    public WebElement clickHomeButton() {
    	wait.until(ExpectedConditions.visibilityOf(homeMenuItem));
    	return wait.until(ExpectedConditions.elementToBeClickable(homeMenuItem));
    	
    }

    public boolean areProductCategoriesDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(phonesCategory));
        wait.until(ExpectedConditions.visibilityOf(laptopsCategory));
        wait.until(ExpectedConditions.visibilityOf(monitorsCategory));
        return phonesCategory.isDisplayed() && laptopsCategory.isDisplayed() &&
               monitorsCategory.isDisplayed();
    }

    public boolean isApplicationLogoDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(applicationLogo));
        return applicationLogo.isDisplayed();
    }
    
    @FindBy(xpath = "//a[contains(text(),'Sony vaio i5')]")
    private WebElement sonyVaioI5Product;

    public void selectSonyVaioI5() {
        wait.until(ExpectedConditions.elementToBeClickable(sonyVaioI5Product)).click();
    }
    @FindBy(xpath = "//*[@id=\"navbarExample\"]/ul/li[1]/a")
    private WebElement homeLink;

    public void clickHomeLink() {
        wait.until(ExpectedConditions.elementToBeClickable(homeLink)).click();
    }
   

    @FindBy(id = "signin2")
    private WebElement signUpButton;

    public boolean isLogoutButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(logoutMenuItem));
        return logoutMenuItem.isDisplayed();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutMenuItem)).click();
    }

    public boolean isRedirectedToHomePage() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton));
        return signUpButton.isDisplayed();
    }
}
