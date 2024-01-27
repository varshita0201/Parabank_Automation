package bank.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import bank.pagesObjects.HomePage;
import bank.pagesObjects.OpenNewAccPage;

public class OpenNewAcc_005 extends BaseClass {
	
	@Test
	public void openNewAccount() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		OpenNewAccPage onap=new OpenNewAccPage(driver);
		onap.newAcc();
		onap.accountType("CHECKING");
		//onap.transferAcc();
		Thread.sleep(2000);
		onap.clickOnNewAcc();
		log.info("Clicked on OpenNewAcc button");
		Thread.sleep(5000);
		try {
			log.info("In try block");
			if(driver.findElement(By.cssSelector("h1[class='title']")).getText().equals("Account Opened!")) {
				Thread.sleep(1000);
				Assert.assertTrue(true);
				log.info("Congratulations, your account is now open.");
				Thread.sleep(1000);
				onap.clickAccNum();
				log.info("Clicked on clickAccNum");
				Thread.sleep(5000);
				if(driver.findElement(By.xpath("//h1")).getText().equals("Account Details")) {
					log.info("Account Opened");
					Assert.assertTrue(true);
					onap.accActivity();
					log.info("Checked All Transactions");
					Assert.assertTrue(true);
				}else {
					log.error("Not Opened");
					Assert.assertTrue(false);
				}
				
				
			}
		}catch(Exception e) {
			log.error("New Account not created:"+e.getMessage());
			Assert.assertTrue(false);
		}
		
		
	}
}
