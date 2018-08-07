package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import tests.InitTest;

import pages.Basis;
import pages.InvoicesPage;

public class InvoicesPageTests extends InitTest{
	InvoicesPage invoices;
	Basis basis;
	
	public static void sleep(int msec) {
		try {
			Thread.sleep(msec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(priority = 23)
	public void verifySelectClientDisplayed() {
		invoices = new InvoicesPage(driver);
		
		assertTrue(invoices.isDisplayedSortselectClient());
		;
	}
	
	@Test(priority = 24)
	public void verifyInvoicesFromDisplayed() {
		invoices = new InvoicesPage(driver);
		
		assertTrue(invoices.isDisplayedInvoicesFrom());
	}
	
	@Test(priority = 25)
	public void verifyInvoicesToDisplayed() {
		invoices = new InvoicesPage(driver);
		
		assertTrue(invoices.isDisplayedInvoicesTo());		
	}
	
	@Test(priority = 26)
	public void verifyFilterPeriodDropBtnDisplayed() {
		invoices = new InvoicesPage(driver);
		
		assertTrue(invoices.isDisplayedFilterPeriodDropBtn());
	}
	
	@Test(priority = 27)
	public void verifyFilterResetAll() {
		invoices = new InvoicesPage(driver);
		
		assertTrue(invoices.isDisplayedFilterResetAll());
	}
	
	@Test(priority = 28)
	public void verifyAddInvoiceBtn() {
		invoices = new InvoicesPage(driver);
		
		assertTrue(invoices.isDisplayedAddInvoiceBtn());
	}
	
	@Test(priority = 29)
	public void checkAddInvoiceBtn() {
		invoices = new InvoicesPage(driver);
		
		invoices.clickAddInvoiceBtn();
		
		String expected = "SAVE";
		String actual = invoices.getSaveInvoiceBtnText();
		
		assertEquals(actual, expected);
	}
	
	@Test(priority = 30)
	public void checkInvoiceBackBtn() {
		invoices = new InvoicesPage(driver);
		
		invoices.clickInvoiceFormBack();
		
		String expected = "Invoices List";
		String actual = invoices.getInvoiceListText();
		
		assertEquals(actual, expected);
	}
	
	@Test(priority = 31)
	public void checkSaveInvoiceEmpty() {
		invoices = new InvoicesPage(driver);
		
		invoices.clickAddInvoiceBtn();
		
		invoices.clickInvoiceFormSave();
		
		int expected = 6;
		int actual = invoices.numberOfInvoiceFormErrMsgs();
		
		assertEquals(actual, expected);
	}
	
	@Test(priority = 32)
	public void fillInInvoiceToFld() {
		invoices = new InvoicesPage(driver);
		
		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");
		invoices.clickInvoiceFormClientSelectDropdwn(1);
		
		invoices.clickInvoiceFormClientSelectToList(1);
		
		String expected = "Djordje Djordjević";
		String actual = invoices.getInvoiceFormClientSelectToListText(1);
		
		assertEquals(actual, expected);
	}
	
	@Test(priority = 33)
	public void backFromFilledInoiceForm() {
		invoices = new InvoicesPage(driver);
		
		invoices.clickInvoiceFormBack();
		
		invoices.clickInvoiceFormConformExit();
		
		String expected = "Invoices List";
		String actual = invoices.getInvoiceListText();
		
		assertEquals(actual, expected);
	}
	
	@Test(priority = 34)
	public void fillInInvoiceFromFld() {
		invoices = new InvoicesPage(driver);
		
		driver.get("http://app.invoice-factory.source-code.rs/invoices/form");
		invoices.clickInvoiceFormClientSelectDropdwn(2);
		
		invoices.clickInvoiceFormClientSelectFromList(0);
		
		String expected = "Fijuma & Co.";
		String actual = invoices.getInvoiceFormClientSelectFromListText(0);
		
		assertEquals(actual, expected);
	}
	
	
	
	
	
	
	//Dynamic locator test
//	@Test(priority = 23)
//	public void loginSuccessful() {
//		invoices = new InvoicesPage(driver);
//		
//		invoices.clickInvoiceStatusBtn(0);
//
//		
//		sleep(5000);
//
//	}
	
//	@Test(priority = 23)
//	public void loginSuccessful() {
//		invoices = new InvoicesPage(driver);
//		
//		sleep(200);
//		
//		invoices.clickAddInvoiceBtn();
//		
//		sleep(200);
//		
//		invoices.fillInvoiceFormTitle("Test");
//		
//		sleep(5000);
//
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}