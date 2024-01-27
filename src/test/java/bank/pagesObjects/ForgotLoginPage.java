package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotLoginPage {
	WebDriver driver;
	public ForgotLoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="firstName")
	public WebElement firstname;
	
	@FindBy(id="lastName")
	public WebElement lastname;
	
	@FindBy(id="address.street")
	public WebElement address;
	
	@FindBy(id="address.city")
	public WebElement city;
	
	@FindBy(id="address.state")
	public WebElement state;
	
	@FindBy(id="address.zipCode")
	public WebElement zip;
	
	@FindBy(id="ssn")
	public WebElement ssn;
	
	@FindBy(css="input[value='Find My Login Info']")
	public WebElement findInfo;
	
	public void findFirstName(String f) {
		firstname.sendKeys(f);
	}
	
	public void findLastName(String l) {
		lastname.sendKeys(l);
	}
	
	public void findAdd(String a) {
		address.sendKeys(a);
	}
	
	public void findCity(String c) {
		city.sendKeys(c);
	}
	
	public void findState(String s) {
		state.sendKeys(s);
	}
	
	public void findzip(String z) {
		zip.sendKeys(z);
	}
	public void findSsn(String s) {
		ssn.sendKeys(s);
	}
	
	public void findLoginInfo() {
		findInfo.click();
	}

	
}
