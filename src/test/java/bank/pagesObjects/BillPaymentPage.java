package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BillPaymentPage {
	WebDriver driver;
	public BillPaymentPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input[name='payee.name']")
	public WebElement payname;
	
	@FindBy(css="input[name='payee.address.street']")
	public WebElement payeeAdd;
	
	@FindBy(css="input[name='payee.address.city']")
	public WebElement payeeCity;
	
	@FindBy(css="input[name='payee.address.state']")
	public WebElement payeeState;
	
	@FindBy(css="input[name='payee.address.zipCode']")
	public WebElement payeeZip;
	
	@FindBy(css="input[name='payee.phoneNumber']")
	public WebElement payeeNum;
	
	@FindBy(css="input[name='payee.accountNumber']")
	public WebElement payeeAccNum;
	
	@FindBy(css="input[name='verifyAccount']")
	public WebElement verifyAcc;
	
	@FindBy(css="input[name='amount']")
	public WebElement amt;
	
	@FindBy(css="select[name='fromAccountId']")
	public WebElement fromAcc;
	
	@FindBy(css="input[value='Send Payment']")
	public WebElement sendAmt;
	
	public void payeeName(String str) {
		payname.sendKeys(str);
	}
	public void payeeAddress(String str) {
		payeeAdd.sendKeys(str);
	}
	public void payeeCity(String str) {
		payeeCity.sendKeys(str);
	}
	public void payeestate(String str) {
		payeeState.sendKeys(str);
	}
	public void payeeZipCode(String str) {
		payeeZip.sendKeys(str);
	}
	public void payeeMobile(String str) {
		payeeNum.sendKeys(str);
	}
	public void payeeAcountNumber(String str) {
		payeeAccNum.sendKeys(str);
	}
	public void verifyAcountNumber(String str) {
		verifyAcc.sendKeys(str);
	}
	public void amount(int n) {
		String str=String.valueOf(n);
		amt.sendKeys(str);
	}
	
	public void fromActID() {
		fromAcc.click();
	}
	public void sendAmtButton() {
		sendAmt.click();
	}
	
	
}
