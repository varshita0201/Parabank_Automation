package bank.pagesObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccPage {
	WebDriver driver;
	public OpenNewAccPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Open New Account']")
	public WebElement openNewAcc;
	
	@FindBy(id="type")
	public WebElement accType;
	
	@FindBy(id="fromAccountId")
	public WebElement toTransferAcc;
	
	@FindBy(xpath="//input[@class='button']")
	public WebElement clickOpenNewAcc;
	
	@FindBy(id="newAccountId")
	public WebElement accNumber;
	
	@FindBy(id="month")
	public WebElement month;
	
	@FindBy(id="transactionType")
	public WebElement transcationType;
	
	@FindBy(css="input[value='Go']")
	public WebElement go;
	
	public void newAcc() {
		openNewAcc.click();
	}
	
	public void accountType(String s) {
		List<WebElement> type=accType.findElements(By.xpath("//option"));
		for(WebElement t:type) {
			if(t.getText().equals(s)) {
				t.click();
			}
		}
	}
	
	public void transferAcc() {
		toTransferAcc.click();
	}
	
	public void clickOnNewAcc() {
		clickOpenNewAcc.click();
	}
	
	public void clickAccNum() {
		accNumber.click();
	}
	public void accActivity() throws InterruptedException {
	    List<WebElement> months = month.findElements(By.tagName("option"));
	    List<WebElement> types = transcationType.findElements(By.tagName("option"));

	    for (WebElement m : months) {
	        m.click();

	        for (WebElement t : types) {
	            t.click();
	            go.click();
	            Thread.sleep(1000);
	        }
	    }
	}

}
