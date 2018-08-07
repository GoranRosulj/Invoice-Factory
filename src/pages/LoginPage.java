package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends PageObject {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(css=".v-toolbar__content div")
	WebElement invoiceFactoryLink;
	
	@FindBy(id="login-form-email")
	WebElement emailField;
	
	@FindBy(id="login-pass")
	WebElement passField;
	
	@FindBy(id="login-form-btn")
	WebElement loginButton;
	
	@FindBy(css=".v-input__append-inner i")
	WebElement visibilityButton;
	
	@FindBy(css="[alt='ITEKAKO']")
	WebElement logo;
	
	@FindBy(css="div.error--text")
	WebElement version;
	
	@FindBy(css="span.title")
	WebElement singinText;
	
	@FindBy(css=".v-messages__message")
	List <WebElement> emailPassErrMsg;
	
	@FindBy(css=".v-counter")
	WebElement charCounter;
	
	@FindBy(css=".v-snack__content p")
	WebElement invalidCredentialsMsg;
	
	
	//Methods
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
	
	public boolean areFieldsDisplayed() {
		
		boolean email = emailField.isDisplayed();
		boolean pass = passField.isDisplayed();
		
		if (email && pass) {
			return true;
		}
		
		return false;
	}
	
	public boolean isLoginBtnDisplayed() {
		return loginButton.isDisplayed();
	}
	
	public boolean isInvoiceFactoryDisplayed() {
		return invoiceFactoryLink.isDisplayed();
	}
	
	public boolean isLogoDisplayed() {
		return logo.isDisplayed();
	}
	
	public boolean isVersionDisplayed() {
		return version.isDisplayed();
	}
	
	public boolean isSinginTextDisplayed() {
		return singinText.isDisplayed();
	}
	
	public boolean isVisibilityBtnDisplayed() {
		return visibilityButton.isDisplayed();
	}
	
	public boolean isCharCounterDisplayed() {
		return charCounter.isDisplayed();
	}
	
	public void login(String email, String pass) {
		wait.until(ExpectedConditions.visibilityOf(emailField));
		emailField.clear();
		emailField.clear();
		emailField.sendKeys(email);
		
		wait.until(ExpectedConditions.visibilityOf(passField));
		passField.clear();
		passField.clear();
		passField.sendKeys(pass);
		
//		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
//		loginButton.click();
	}
	
	public String[] errorMessages() {
		wait.until(ExpectedConditions.visibilityOfAllElements(emailPassErrMsg));
		
		String[] array = new String[2];
		array[0] = emailPassErrMsg.get(0).getText();
		array[1] = emailPassErrMsg.get(1).getText();
		
		return array;
	}
	
	public String errorMessage() {
		wait.until(ExpectedConditions.visibilityOfAllElements(emailPassErrMsg));
		
		return emailPassErrMsg.get(0).getText();
	}
	
	public void editPassField(String character) {
		passField.sendKeys(character);
	}
	
	public boolean isPassVisible() {
		wait.until(ExpectedConditions.visibilityOf(visibilityButton));
		visibilityButton.click();
		
		if(passField.getAttribute("type").equals("text")) {
			return true;
		}
		return false;
	}
	
	public void clickLoginBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));
		loginButton.click();
	}
	
	public String invalidCredentials() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invalidCredentialsMsg));
		return invalidCredentialsMsg.getText();
	}
	
	public String passCharCounterText() {
		wait.until(ExpectedConditions.visibilityOfAllElements(charCounter));
		return charCounter.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}