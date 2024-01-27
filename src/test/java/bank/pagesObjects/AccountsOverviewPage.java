package bank.pagesObjects;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import jdk.internal.org.jline.utils.Log;

public class AccountsOverviewPage {
	WebDriver driver;
	public AccountsOverviewPage(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//td/a")
	public List<WebElement> accNumbers;
	
	public void accOverviewDetails() throws InterruptedException {
		for(WebElement acc:accNumbers) {
			acc.click();
			try {
				if(driver.findElement(By.xpath("//h1[text()='Account Details']")).getText().equals("Account Details")) {
					Assert.assertTrue(true);
					System.out.println("Open the Account Details");
				}
				
			}catch(Exception e) {
				System.out.println("Error");
				Assert.assertTrue(false);
			}
			Thread.sleep(1000);
			driver.navigate().back();
			Thread.sleep(1000);
		}
	}
	
}
