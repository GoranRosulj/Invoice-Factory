package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import tests.InitTest;
import pages.Basis;
import pages.LoginPage;

public class LoginPageTests extends InitTest{
	LoginPage login;
	Basis basis;
	
	public static void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	@Test(priority = 0)
	public void checkURL() {
		login = new LoginPage(driver);
		driver.get("http://app.invoice-factory.source-code.rs/login");
		
		String expected = "http://app.invoice-factory.source-code.rs/login";
		String actual = login.getURL();
		
		assertEquals(actual, expected);
	}
	
//	@Test(priority = 1)
//	public void checkTitle() {
//		login = new LoginPage(driver);
//		
//		String expected = "Invoice factory";
//		String actual = login.getTitle();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 2)
//	public void inputFieldsDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.areFieldsDisplayed());
//	}
//	
//	@Test(priority = 3)
//	public void loginBtnDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isLoginBtnDisplayed());
//	}
//	
//	@Test(priority = 4)
//	public void invoiceFactoryDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isInvoiceFactoryDisplayed());
//	}
//	
//	@Test(priority = 5)
//	public void logoDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isLogoDisplayed());
//	}
//	
//	@Test(priority = 6)
//	public void versionDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isVersionDisplayed());
//	}
//	
//	@Test(priority = 7)
//	public void visibilityBtnDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isVisibilityBtnDisplayed());
//	}
//	
//	@Test(priority = 8)
//	public void signinTextDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isSinginTextDisplayed());
//	}
//	
//	@Test(priority = 9)
//	public void charCounterDisplayed() {
//		login = new LoginPage(driver);
//		
//		assertTrue(login.isCharCounterDisplayed());
//	}
//	
//	@Test(priority = 10)
//	public void loginEmptyFields() {
//		login = new LoginPage(driver);
//		
//		login.login(" ", " ");	
//		
//		sleep(200);
//		
//		boolean messages;
//		
//		String[] array = login.errorMessages();
//		
//		String expectedEmail = "The email field is required.";
//		String actualEmail = array[0];
//		
//		String expectedPass = "The password field is required.";
//		String actualPass = array[1];
//		
//		if (expectedEmail.equals(actualEmail) && expectedPass.equals(actualPass)) {
//			messages = true;
//		} else {
//			messages = false;
//		}
//		
//		assertTrue(messages);
//	}
//	
//	@Test(priority = 11)
//	public void loginEmptyEmail() {
//		login = new LoginPage(driver);
//		
//		login.login(" ", "123qwe");	
//		
//		String expected = "The email field is required.";
//		String actual = login.errorMessage();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 12)
//	public void loginEmptyPass() {
//		login = new LoginPage(driver);
//		
//		login.login("goran.rosulj@gmail.com", " ");	
//		
//		String expected = "The password field is required.";
//		String actual = login.errorMessage();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 13)
//	public void loginInvalidEmail() {
//		login = new LoginPage(driver);
//		
//		login.login("goran.rosulj", "qwe123");
//		
//		String expected = "The email field must be a valid email.";
//		String actual = login.errorMessages()[0];
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 14)
//	public void loginPassLessTBorder() {
//		login = new LoginPage(driver);
//		
//		login.login("goran.rosulj@gmail.com", "qwe12");
//		
//		sleep(100);
//		
//		String expected = "The password field must be at least 6 characters.";
//		String actual = login.errorMessage();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 15)
//	public void loginPassGreaterTBorder() {
//		login = new LoginPage(driver);
//		
//		login.login("goran.rosulj@gmail.com", "123456789012345678901");
//		
//		sleep(200);
//
//		String expected = "The password field may not be greater than 20 characters.";
//		String actual = login.errorMessage();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 16)
//	public void loginAllValidPassLength() {
//		login = new LoginPage(driver);
//		
//		login.login("goran.rosulj@gmail.com", "12345");
//		
//		boolean message;
//		
//		for (int i = 6; i <= 20; i++) {
//			login.editPassField("1");
//			
//			sleep(300);
//			
//			String expected = "At least 6 characters";
//			String actual = login.errorMessage();
//		
//			if(!expected.equals(actual)) {
//				message = false;
//			}
//		}
//		
//		message = true;
//		
//		assertTrue(message);
//	}
//	
//	@Test(priority = 17)
//	public void loginPassVisible() {
//		login = new LoginPage(driver);	
//		
//		assertTrue(login.isPassVisible());
//	}
//	
//	@Test(priority = 18)
//	public void passCharCounter() {
//		login = new LoginPage(driver);	
//		
//		login.login("goran@gmail.com", "12345678");
//		
//		String expected = "8 / 20";
//		String actual = login.passCharCounterText();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 19)
//	public void loginIncorrectEmail() {
//		login = new LoginPage(driver);	
//		
//		login.login("goran@gmail.com", "qwe123");
//		login.clickLoginBtn();
//		
//		String expected = "Invalid credentials.";
//		String actual = login.invalidCredentials();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 20)
//	public void loginIncorrectPass() {
//		login = new LoginPage(driver);	
//		
//		login.login("goran.rosulj@gmail.com", "1234567");
//		login.clickLoginBtn();
//		
//		String expected = "Invalid credentials.";
//		String actual = login.invalidCredentials();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 21)
//	public void loginPassCAPS() {
//		login = new LoginPage(driver);	
//		
//		login.login("goran.rosulj@gmail.com", "QWE123");
//		login.clickLoginBtn();
//		
//		String expected = "Invalid credentials.";
//		String actual = login.invalidCredentials();
//		
//		assertEquals(actual, expected);
//	}
//	
//	@Test(priority = 22)
//	public void loginEmailCAPS() {
//		login = new LoginPage(driver);	
//		basis = new Basis(driver);
//		
//		login.login("GORAN.ROSULJ@GMAIL.COM", "qwe123");
//		login.clickLoginBtn();
//				
//		assertTrue(basis.checkUsername());
//		
//		basis.logout();
//	}
	
	@Test(priority = 22)
	public void loginSuccessful() {
		login = new LoginPage(driver);	
		basis = new Basis(driver);
		
		//When there is only one login method is not clickable, when there are 2 logins, it is clickable
		login.login("goran.rosulj@gmail.com", "qwe123");
		login.login("goran.rosulj@gmail.com", "qwe123");
		sleep(800);

		login.clickLoginBtn();
				
		assertTrue(basis.checkUsername());
	}
	
}