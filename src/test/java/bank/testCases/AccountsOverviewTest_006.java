package bank.testCases;

import java.time.Duration;

import org.testng.annotations.Test;

import bank.pagesObjects.AccountServicesPage;
import bank.pagesObjects.AccountsOverviewPage;
import bank.pagesObjects.HomePage;

public class AccountsOverviewTest_006 extends BaseClass {
	@Test
	public void accountsOverview() throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		AccountServicesPage asp=new AccountServicesPage(driver);
		AccountsOverviewPage aop=new AccountsOverviewPage(driver);
		asp.accountOverview();
		log.info("Clicked on Account Overview");
		aop.accOverviewDetails();
		log.info("Account Details Succesfull completed");
		Thread.sleep(1000);
	}
}
