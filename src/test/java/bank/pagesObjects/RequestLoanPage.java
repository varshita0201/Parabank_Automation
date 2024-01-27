package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestLoanPage {
	WebDriver driver;
	public RequestLoanPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="amount")
	public WebElement loanamt;
	
	@FindBy(id="downPayment")
	public WebElement downpay;
	
	@FindBy(id="fromAccountId")
	public WebElement fromact;
	
	@FindBy(css="input[class='button']")
	public WebElement apply;
	
	@FindBy(id="newAccountId")
	public WebElement newacc;
	
	public void loanAmt(int n) {
		String str=String.valueOf(n);
		loanamt.sendKeys(str);
	}
	
	public void downPayAmt(int n) {
		String str=String.valueOf(n);
		downpay.sendKeys(str);
	}
	
	public void fromAcc() {
		fromact.click();
	}
	
	public void apply() {
		apply.click();
	}
	
	public void newAccountID() {
		newacc.click();
	}
}
