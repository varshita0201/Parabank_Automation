package bank.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import bank.pagesObjects.AccountServicesPage;
import bank.pagesObjects.FindTransactionsPage;
import bank.pagesObjects.HomePage;

public class FindTransactions_009 extends BaseClass {
	
	@BeforeClass
	public void loginDetailss() {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
	}
	
	@Test
	public void transactions() throws InterruptedException {
		AccountServicesPage asp=new AccountServicesPage(driver);
		asp.findTransactions();
		FindTransactionsPage ftp=new FindTransactionsPage(driver);
		ftp.transactionID("14476");
		ftp.clickTransByID();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Transaction Results")) {
			Assert.assertTrue(true);
			log.info("Transactions are displayed");
		}
		else {
			log.error("Error");
			ssCapture(driver,"transactios");
		}
		asp.findTransactions();
		ftp.dateTransaction("01-27-2024");
		ftp.clickTransByDate();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Transaction Results")) {
			Assert.assertTrue(true);
			log.info("Transactions are displayed");
		}else {
			log.error("Error");
			ssCapture(driver,"transactios");
			Assert.assertTrue(false);
		}
		
		asp.findTransactions();
		ftp.fromDate("01-26-2024");
		ftp.toDate("01-27-2024");
		ftp.clickTransByRange();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Transaction Results")) {
			Assert.assertTrue(true);
			log.info("Transactions are displayed");
		}else {
			log.error("Error");
			ssCapture(driver,"transactios");
		}
		
		asp.findTransactions();
		ftp.amount("100");
		ftp.clickTransByAmt();
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//h1")).getText().equalsIgnoreCase("Transaction Results")) {
			Assert.assertTrue(true);
			log.info("Transactions are displayed");
		}else {
			log.error("Error");
			ssCapture(driver,"transactios");
			Assert.assertTrue(false);
		}
		
		
	}
}
