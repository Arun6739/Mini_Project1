package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginSignupPage {
    WebDriver driver;
    WebDriverWait wait;

    // Locators for Sign Up functionality
    @FindBy(id = "signin2") 
    private WebElement signUpButton;

    @FindBy(id = "signInModalLabel") 
    private WebElement signUpModal;
    
    @FindBy(xpath="//*[@id=\"signInModal\"]/div/div/div[3]/button[1]")
    private WebElement closeSignUpModalButton;
    // Locators for Log In functionality
    @FindBy(id = "login2") 
    private WebElement loginButton;

    @FindBy(id= "logout2")
    private WebElement logoutButton;
    @FindBy(id = "loginusername") 
    private WebElement usernameField;

    @FindBy(id = "loginpassword") 
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class, 'btn btn-primary') and text()='Log in']")
    private WebElement loginSubmitButton;

    @FindBy(id = "nameofuser")
    private WebElement welcomeMessage;

    // Constructor
    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10); 
        PageFactory.initElements(driver, this);
    }

    // -------------------- Sign Up Methods --------------------

    public boolean isSignUpButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(signUpButton)); 
        return signUpButton.isDisplayed();
    }

    public void clickSignUpButton() {
        wait.until(ExpectedConditions.elementToBeClickable(signUpButton)).click();
    }

    public boolean isSignUpWindowVisible() {
        wait.until(ExpectedConditions.visibilityOf(signUpModal)); 
        return signUpModal.isDisplayed();
    }

    public void closeSignUpWindow() {
        try {
            wait.until(ExpectedConditions.visibilityOf(closeSignUpModalButton)).click();
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("signUpModal"))); 
        } catch (Exception e) {
            System.out.println("Sign-Up modal is not open or could not be closed: " + e.getMessage());
        }
    }

    public boolean isSignUpWindowClosed() {
        try {
            driver.findElement(By.id("signUpModal")); 
            return false; 
        } catch (Exception e) {
            return true; 
        }
    }

    // -------------------- Log In Methods --------------------

    public boolean isLoginButtonVisible() {
        wait.until(ExpectedConditions.visibilityOf(loginButton)); 
        return loginButton.isDisplayed();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click(); 
    }
    
    public void login(String username, String password) {
        wait.until(ExpectedConditions.visibilityOf(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOf(passwordField)).sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(loginSubmitButton)).click(); 
    }

    
	public boolean isUserdasboardVisible() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton)); 
        return logoutButton.isDisplayed();
	}

	public boolean isUserdasboardVisible1() {
		wait.until(ExpectedConditions.visibilityOf(loginButton)); 
        return loginButton.isDisplayed();
	}
}
