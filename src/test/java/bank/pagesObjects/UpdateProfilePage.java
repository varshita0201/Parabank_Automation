package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProfilePage {
	WebDriver driver;
	public UpdateProfilePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="customer.firstName")
	public WebElement firstname;
	
	@FindBy(id="customer.lastName")
	public WebElement lastname;
	
	@FindBy(id="customer.address.street")
	public WebElement adrs;
	
	@FindBy(id="customer.address.city")
	public WebElement city;
	
	@FindBy(id="customer.address.state")
	public WebElement state;
	
	@FindBy(id="customer.address.zipCode")
	public WebElement zip;
	
	@FindBy(id="customer.phoneNumber")
	public WebElement phone;
	
	@FindBy(css="input[class='button']")
	public WebElement update;
	
	
	public void firstName(String str) {
		firstname.sendKeys(str);
	}
	
	public void lastName(String str) {
		lastname.sendKeys(str);
	}
	public void address(String str) {
		adrs.sendKeys(str);
	}
	public void cCity(String str) {
		city.sendKeys(str);
	}
	public void cstate(String str) {
		state.sendKeys(str);
	}
	public void postalCode(String str) {
		zip.sendKeys(str);
	}
	public void phone(String str) {
		phone.sendKeys(str);
	}
	public void updateProfile() {
		update.click();
	}
	
}
