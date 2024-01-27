package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TransferFundsPage {
	
	WebDriver driver;
	public TransferFundsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="amount")
	public WebElement amt;
	
	@FindBy(id="fromAccountId")
	public WebElement fromAcc;
	
	@FindBy(id="toAccountId")
	public WebElement toAcc;
	
	@FindBy(css="input[class='button']")
	public WebElement transfer;
	
	public void amount(int n) {
		String s=String.valueOf(n);
		amt.sendKeys(s);
	}
	
	public void clickTransfer() {
		transfer.click();
	}
	
	public void fromAccount() {
		fromAcc.click();
	}
	
	public void toAccount() {
		toAcc.click();
	}
	
	
}
