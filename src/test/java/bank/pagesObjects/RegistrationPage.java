package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="customer.firstName")
	public WebElement firstName;
	
	@FindBy(id="customer.lastName")
	public WebElement lastName;
	
	@FindBy(id="customer.address.street")
	public WebElement address;
	
	@FindBy(id="customer.address.city")
	public WebElement city;
	
	@FindBy(id="customer.address.state")
	public WebElement state;
	
	@FindBy(id="customer.address.zipCode")
	public WebElement zipCode;

	@FindBy(id="customer.phoneNumber")
	public WebElement phone;
	
	@FindBy(id="customer.ssn")
	public WebElement ssn;
	
	@FindBy(id="customer.username")
	public WebElement userName;
	
	@FindBy(id="customer.password")
	public WebElement password;
	
	@FindBy(id="repeatedPassword")
	public WebElement confirmPsw;
	
	@FindBy(xpath="//input[@value='Register']")
	public WebElement register;
	
	public void userFirstName(String f) {
		firstName.sendKeys(f);
	}
	
	public void userLastName(String l) {
		lastName.sendKeys(l);
	}
	
	public void userAddress(String a) {
		address.sendKeys(a);
	}
	
	public void userCity(String c) {
		city.sendKeys(c);
	}
	
	public void userState(String s) {
		state.sendKeys(s);
	}
	
	public void userZip(String z) {
		zipCode.sendKeys(z);
	}
	
	public void userPhone(String p) {
		phone.sendKeys(p);
	}
	
	public void userSsn(String s) {
		ssn.sendKeys(s);
	}
	
	public void userName(String n) {
		userName.sendKeys(n);
	}
	
	public void userpassword(String p) {
		password.sendKeys(p);
	}
	
	public void confirmUserPsw(String cp) {
		confirmPsw.sendKeys(cp);
	}
	
	public void userregister() {
		register.click();
	}
}
