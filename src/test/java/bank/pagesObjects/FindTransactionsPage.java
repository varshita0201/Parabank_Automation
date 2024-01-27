package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTransactionsPage {
	WebDriver driver;
	public FindTransactionsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="criteria.transactionId")
	public WebElement transID;
	
	@FindBy(xpath="//button[@ng-click=\"criteria.searchType = 'ID'\"]")
	public WebElement findTransID;
	
	@FindBy(id="criteria.onDate")
	public WebElement dateTransactions;
	
	@FindBy(xpath="//button[@ng-click=\"criteria.searchType = 'DATE'\"]")
	public WebElement findTransDate;
	
	@FindBy(id="criteria.fromDate")
	public WebElement from;
	
	@FindBy(id="criteria.toDate")
	public WebElement to;
	
	@FindBy(xpath="//button[@ng-click=\"criteria.searchType = 'DATE_RANGE'\"]")
	public WebElement findTransRange;
	
	@FindBy(id="criteria.amount")
	public WebElement amt;
	
	@FindBy(xpath="//button[@ng-click=\"criteria.searchType = 'AMOUNT'\"]")
	public WebElement findTransAmt;
	
	public void transactionID(String str) {
		transID.sendKeys(str);
	}
	
	public void clickTransByID() {
		findTransID.click();
	}
	
	public void dateTransaction(String str) {
		dateTransactions.sendKeys(str);
	}
	
	public void clickTransByDate() {
		findTransDate.click();
	}
	
	public void fromDate(String str) {
		from.sendKeys(str);
	}
	
	public void toDate(String str) {
		to.sendKeys(str);
	}
	
	public void clickTransByRange() {
		findTransRange.click();
	}
	
	public void amount(String n) {
		amt.sendKeys(n);
	}
	
	public void clickTransByAmt() {
		findTransAmt.click();
	}
	
}
