package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountServicesPage {
	WebDriver driver;
	public AccountServicesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Open New Account']")
	public WebElement openNewAcc;
	
	@FindBy(xpath="//a[text()='Accounts Overview']")
	public WebElement accOverview;
	
	@FindBy(xpath="//a[text()='Transfer Funds']")
	public WebElement transferFunds;
	
	@FindBy(xpath="//a[text()='Bill Pay']")
	public WebElement billpay;
	
	@FindBy(xpath="//a[text()='Find Transactions']")
	public WebElement findTrans;
	
	@FindBy(xpath="//a[text()='Update Contact Info']")
	public WebElement updateContact;
	
	@FindBy(xpath="//a[text()='Request Loan']")
	public WebElement reqLoan;
	
	@FindBy(xpath="//a[text()='Log Out']")
	public WebElement logout;
	
	
	public void openNewAccount() {
		openNewAcc.click();
	}
	
	public void accountOverview() {
		accOverview.click();
	}
	
	public void transferFundsTo() {
		transferFunds.click();
	}
	
	public void billPay() {
		billpay.click();
	}
	
	public void findTransactions() {
		findTrans.click();
	}
	
	public void updateConInfo() {
		updateContact.click();
	}
	
	public void requestLoan() {
		reqLoan.click();
	}
	
	public void logout() {
		logout.click();
	}
	
}
