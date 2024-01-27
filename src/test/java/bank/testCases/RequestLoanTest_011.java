package bank.testCases;

import java.sql.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bank.pagesObjects.AccountServicesPage;
import bank.pagesObjects.HomePage;
import bank.pagesObjects.RequestLoanPage;

public class RequestLoanTest_011 extends BaseClass{
	@BeforeClass
	public void loginDetailss() {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
	}
	
	@Test(priority=1,dataProvider="loandetails")
	public void requestLoan(int loanamt,int downpay) throws InterruptedException {
		AccountServicesPage asp=new AccountServicesPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		asp.requestLoan();
		RequestLoanPage rlp=new RequestLoanPage(driver);
		rlp.loanAmt(loanamt);
		rlp.downPayAmt(downpay);
		rlp.fromAcc();
		rlp.apply();
		Thread.sleep(1000);
		try {
			if(driver.findElement(By.id("loanStatus")).getText().equalsIgnoreCase("Approved")){
				Assert.assertTrue(true);
				log.info("Loan Request Approved");
				rlp.newAccountID();
				Thread.sleep(1000);
				if(driver.findElement(By.xpath("//h1[text()='Account Details']")).getText().equalsIgnoreCase("Account Details")) {
					Assert.assertTrue(true);
					log.info("Opened the new Account details");
				}
			}
			else {
				ssCapture(driver,"LoanRequest");
				log.error("Loan Request Denied");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			log.error("Exception"+e.getMessage());
			
		}
	}
	
	@DataProvider(name="loandetails")
	Object[][] getData() throws SQLException{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank", "root", "root");
		if(!c.isClosed()) {
			log.info("Connection is Successful");
		}
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select * from reqloan");
		List<Object[]> dataList=new ArrayList<>();
		while(rs.next()) {
			Object[] data= {
					rs.getInt("loanamt"),
					rs.getInt("downpay")
		           
			};
			dataList.add(data);
		}
		
		Object[][] d=new Object[dataList.size()][];
		for(int i=0;i<dataList.size();i++) {
			d[i]=dataList.get(i);
		}
		return d;
	}
	
	@Test(priority=2)
	public void logout() {
		AccountServicesPage asp=new AccountServicesPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		asp.logout();
		log.info("Account Logged Out");
	}
}
