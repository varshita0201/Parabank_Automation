package bank.pagesObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerCarePage {
	WebDriver driver;
	public  CustomerCarePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="name")
	public WebElement cname;
	
	@FindBy(id="email")
	public WebElement cmail;
	
	@FindBy(id="phone")
	public WebElement cphone;
	
	@FindBy(id="message")
	public WebElement cmsg;
	
	@FindBy(css="input[value='Send to Customer Care']")
	public WebElement sendToCC;
	
	public void custName(String cn) {
		cname.sendKeys(cn);
	}
	public void custEmail(String ce) {
		cmail.sendKeys(ce);
	}
	public void custPhone(String cp) {
		cphone.sendKeys(cp);
	}
	public void custMsg(String cm) {
		cmsg.sendKeys(cm);
	}
	
	public void sendToCustCare() {
		sendToCC.click();
	}
}
