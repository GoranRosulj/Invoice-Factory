package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.ExpectedConditions;

public class InvoicesPage extends PageObject {

	public InvoicesPage(WebDriver driver) {
		super(driver);
	}
	
	//Elements
	
	@FindBy(css=".v-toolbar__content div")
	WebElement sortselectClient;
	
	@FindBy(id="filter-from")
	WebElement invoicesFrom;
	
	@FindBy(id="filter-to")
	WebElement invoicesTo;
	
	@FindBy(id="filter-period")
	WebElement filterPeriodDropBtn;
	
	@FindBy(id="filter-reset")
	WebElement filterResetAll;
	
	@FindBy(id="reset-dates")
	WebElement filterResetDates;
	
	@FindBy(id="this-month")
	WebElement filterPeriodThisMonth;
	
	@FindBy(id="last-month")
	WebElement filterPeriodLastMonth;
	
	@FindBy(id="add-new-invoice")
	WebElement addInvoiceBtn;
	
	@FindBy(id="inv-form-back-btn")
	WebElement addBackBtn;

	@FindBy(id="click-to-enter")
	WebElement invoiceFormTitle;
	
	@FindBy(css=".invoice-list-items strong[id*=inv-num]")
	List <WebElement> invoicesNumbers;
	
	@FindBy(css=".menuable__content__active div.v-list__tile__title")
	List <WebElement> selectClientList;

	@FindBy(id="inv-form-back-btn")
	WebElement invoiceFormBack;

	@FindBy(id="inv-form-save-btn")
	WebElement invoiceFormSave;

	@FindBy(css="#inv-form-save-btn div")
	WebElement invoiceFormSaveText;

	@FindBy(xpath="//[@id='inv-form-client']/parent::div/parent::div/parent::div")
	WebElement invoiceFormClientSelectTo;

	@FindBy(css=".v-select__selections")
	List <WebElement> invoiceFormDropdownList;

	@FindBy(css=".menuable__content__active a")
	List <WebElement> invoiceFormClientSelectToList;

	@FindBy(css=".v-messages__message")
	List <WebElement> invoiceFormErrMsgs;

	@FindBy(id="inv-form-business")
	WebElement invoiceFormClientSelectFrom;

	@FindBy(css=".menuable__content__active a")
	List <WebElement> invoiceFormClientSelectFromList;

	@FindBy(xpath="//div[@class='v-card__actions']//button//div[contains(text(), 'Yes')]")
	WebElement invoiceFormConformExit;

	@FindBy(id="inv-form-cancel-btn")
	WebElement invoiceFormCancel;

	@FindBy(id="inv-currency")
	WebElement invoiceFormCurrency;

	@FindBy(css=".menuable__content__active .v-list__tile__title")
	List <WebElement> invoiceFormCurrencyList;

	@FindBy(id="inv-form-select-bank")
	WebElement invoiceFormBusiness;

	@FindBy(css=".menuable__content__active .v-list__tile__title")
	List <WebElement> invoiceFormBusinessList;

	@FindBy(id="inv-form-acc-num-title")
	WebElement invoiceFormAccNum;

	@FindBy(id="inv-form-basis")
	WebElement invoiceFormBasis;

//	@FindBy(xpath="//i[contains(text(), 'error')]/following-sibling::p")
	@FindBy(css=".application--wrap p.body-2")
	WebElement invoiceFormPopupErr;

	@FindBy(id="inv-form-status")
	WebElement invoiceFormStatus;

	@FindBy(css=".invoice-factory-header-title")
	WebElement invoiceList;

	@FindBy(css=".menuable__content__active .v-list__tile__title")
	List <WebElement> invoiceFormStatusList;


	
	//Methods//
	
	public String getURL() {
		return driver.getCurrentUrl();
	}
	
	public WebElement getInvoiceStatusBtn(int x) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoicesNumbers));
//		System.out.println("getInvoiceStatusBtn entry");
		String invNum = invoicesNumbers.get(x).getText();
		
//		System.out.println(invNum);
		
		WebElement invoicesNumber = driver.findElement(By.id("inv-status-btn-" + invNum));
//		System.out.println(invoicesNumber.getText());
		return invoicesNumber;
	}
	
	public boolean isDisplayedSortselectClient() {
		wait.until(ExpectedConditions.elementToBeClickable(sortselectClient));
		return sortselectClient.isDisplayed();
	}
	
	public boolean isDisplayedInvoicesFrom() {
		wait.until(ExpectedConditions.elementToBeClickable(invoicesFrom));
		return invoicesFrom.isDisplayed();
	}
	
	public boolean isDisplayedInvoicesTo() {
		wait.until(ExpectedConditions.elementToBeClickable(invoicesTo));
		return invoicesTo.isDisplayed();
	}
	
	public boolean isDisplayedFilterPeriodDropBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(filterPeriodDropBtn));
		return filterPeriodDropBtn.isDisplayed();
	}
	
	public boolean isDisplayedFilterResetAll() {
		wait.until(ExpectedConditions.elementToBeClickable(filterResetAll));
		return filterResetAll.isDisplayed();
	}
	
	public boolean isDisplayedAddInvoiceBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addInvoiceBtn));
		return addInvoiceBtn.isDisplayed();
	}
	
	public void clickAddInvoiceBtn() {
		wait.until(ExpectedConditions.elementToBeClickable(addInvoiceBtn));
		addInvoiceBtn.click();
	}
	
	public String getSaveInvoiceBtnText() {
		wait.until(ExpectedConditions.elementToBeClickable(invoiceFormSaveText));
		return invoiceFormSaveText.getText();
		}
	
	public String getInvoiceListText() {
		wait.until(ExpectedConditions.elementToBeClickable(invoiceList));
		return invoiceList.getText();
		}
	
	public void clickInvoiceStatusBtn(int x) {
		getInvoiceStatusBtn(x).click();
	}
	
	public void clickInvoiceFormBack() {
		wait.until(ExpectedConditions.visibilityOf(invoiceFormBack));
		invoiceFormBack.click();
	}
	
	public void clickInvoiceFormSave() {
		wait.until(ExpectedConditions.visibilityOf(invoiceFormSave));
		invoiceFormSave.click();
	}
	
	public int numberOfInvoiceFormErrMsgs() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormErrMsgs));
		return invoiceFormErrMsgs.size();
	}
	
	public void clickInvoiceFormClientSelectDropdwn(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormDropdownList));
		
		invoiceFormDropdownList.get(index).click();
//		invoiceFormClientSelectTo.click();
//		invoiceFormClientSelectTo.click();
	}
	
	public void clickInvoiceFormClientSelectToList(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormClientSelectToList));
		invoiceFormClientSelectToList.get(index).click();
	}
	
	public String getInvoiceFormClientSelectToListText(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormDropdownList));
		return invoiceFormDropdownList.get(index).getText();
	}
	
	public String[] clickInvoiceFormNumOfErrMsgs() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormErrMsgs));
			
		String[] array = new String[invoiceFormErrMsgs.size()];
		
		for (int i = 0; i < invoiceFormErrMsgs.size(); i++) {
			array[i] = invoiceFormErrMsgs.get(i).getText();
		}

		return array;
	}
	
	public void clickInvoiceFormConformExit() {
		wait.until(ExpectedConditions.visibilityOf(invoiceFormConformExit));
		invoiceFormConformExit.click();
	}
	
	public void clickInvoiceFormClientSelectFrom() {
		wait.until(ExpectedConditions.visibilityOf(invoiceFormClientSelectFrom));
		invoiceFormClientSelectFrom.click();
	}
	
	public void clickInvoiceFormClientSelectFromList(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormClientSelectFromList));
		invoiceFormClientSelectFromList.get(index).click();
	}
	
	public String getInvoiceFormClientSelectFromListText(int index) {
		System.out.println("1");
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormClientSelectFromList));
		System.out.println("2");
		return invoiceFormClientSelectFromList.get(index).getText();
	}
	
	public void clickInvoiceFormInvoiceFormCancel() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormCancel));
		invoiceFormCancel.click();
	}
	
	public void clickInvoiceFormInvoiceFormCurrency() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormCurrency));
		invoiceFormCurrency.click();
	}
	
	public String getInvoiceFormInvoiceFormCurrencyText() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormCurrencyList));
		return invoiceFormCurrencyList.get(0).getText();
	}
	
	public void clickInvoiceFormBusiness() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormBusiness));
		invoiceFormBusiness.click();
	}
	
	public String getInvoiceFormInvoiceFormBusinessText() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormBusinessList));
		return invoiceFormBusinessList.get(0).getText();
	}
	
	public String getInvoiceFormAccNumText() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormAccNum));
		return invoiceFormAccNum.getText();
	}
	
	public void fillInInvoiceFormBasis(String text) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormBasis));
		invoiceFormBasis.sendKeys(text);
	}
	
	public void clickInvoiceFormTitle() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormTitle));
		invoiceFormTitle.click();
	}
	
	public WebElement getInvoiceFormTitle() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormTitle));
		return invoiceFormTitle;
	}

	Actions builder = new Actions(driver);
	public void fillInvoiceFormTitle(String text) {
		wait.until(ExpectedConditions.visibilityOf(invoiceFormTitle));
		Action fillTitle = builder.moveToElement(invoiceFormTitle).click().sendKeys(text).build();
		fillTitle.perform();
	}
//	
//	public void fillInInvoiceFormTitle(String text) {
//		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormTitle));
//		invoiceFormTitle.sendKeys(text);
//	}
	
	public void clickInvoiceFormStatus() {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormStatus));
		invoiceFormStatus.click();
	}
	
	public void clickinvoiceFormStatusList(int index) {
		wait.until(ExpectedConditions.visibilityOfAllElements(invoiceFormStatusList));
		invoiceFormStatusList.get(index).click();
	}
	
	
	
	
}
