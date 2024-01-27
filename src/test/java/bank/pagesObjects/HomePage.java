package bank.pagesObjects;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import jdk.internal.org.jline.terminal.TerminalBuilder.SystemOutput;
import jdk.internal.org.jline.utils.Log;

public class HomePage {
	public Logger log;
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(tagName="a")
	public List<WebElement> links;
	
	@FindBy(css="input[name='username']")
	public WebElement userName;

	@FindBy(css="input[name='password']")
	public WebElement userPsw;
	
	@FindBy(css="input[class='button']")
	public WebElement login;
	
	@FindBy(xpath="//a[text()='Forgot login info?']")
	public WebElement forgotpsw;
	
	@FindBy(xpath="//a[text()='Register']")
	public WebElement register;
	
	@FindBy(xpath="//a[text()='contact']")
	public WebElement customerCare;
	
	public boolean allLinks() {
		int cnt=0;
		for(WebElement link:links) {
			String url=link.getAttribute("href");
			System.out.println(url);
			if(url==null || url.isEmpty()) {
				continue;
			}
			try {
				HttpURLConnection huc=(HttpURLConnection)(new URL(url).openConnection());
				huc.connect();
				System.out.println("HttpURL Connection Successful");
				if(huc.getResponseCode()>=400) {
					log.info("Link Broken:"+url);
					System.out.println("Link Broken");
					
				}else {
					cnt++;
					System.out.println(huc.getResponseCode());
					link.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
				}
			}catch(Exception e) {
				System.out.println("In Catch Box");
				e.printStackTrace();
			}
		}
		if(cnt==links.size()) {
			return true;
		}
		return false;
	}
	public void username(String u) {
		userName.sendKeys(u);
	}
	
	public void userpassword(String p) {
		userPsw.sendKeys(p);
	}
	
	public void userLogin() {
		login.click();
	}
	
	public void forgotPassword() {
		forgotpsw.click();
	}
	
	public void registration() {
		register.click();
	}
	
	public void custCare() {
		customerCare.click();
	}
}
