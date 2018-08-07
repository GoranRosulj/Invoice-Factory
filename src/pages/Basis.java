package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Basis extends PageObject {

	public Basis(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(css=".v-toolbar__content div")
	WebElement username;
	
	@FindBy(id="navbar-logout")
	WebElement navLogout;
	
	@FindBy(id="navbar-logout-btn")
	WebElement logout;
	
	@FindBy(id="logut-yes")
	WebElement logoutYes;
	
	//Methods
	public boolean checkUsername() {
		wait.until(ExpectedConditions.visibilityOf(username));
		return username.isDisplayed();
	}

	public void logout() {
		wait.until(ExpectedConditions.visibilityOf(navLogout));
		navLogout.click();
		
		wait.until(ExpectedConditions.visibilityOf(logout));
		logout.click();
		
		wait.until(ExpectedConditions.visibilityOf(logoutYes));
		logoutYes.click();
	}
}