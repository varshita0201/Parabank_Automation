package bank.testCases;

import java.sql.*;
import java.util.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bank.pagesObjects.AccountServicesPage;
import bank.pagesObjects.BillPaymentPage;
import bank.pagesObjects.HomePage;

public class BillPaymentTest_008 extends BaseClass {
	@BeforeClass
	public void loginDetailss() {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
	}
	
	
	@Test(dataProvider="billData")
	public void billTest(String name,String address, String city, String state,String zip,String phone, String accNum,String verifyacc,int amt) throws InterruptedException {
		AccountServicesPage asp=new AccountServicesPage(driver);
		asp.billPay();
		BillPaymentPage bpp=new BillPaymentPage(driver);
		bpp.payeeName(name);
		bpp.payeeAddress(address);
		bpp.payeeCity(city);
		bpp.payeestate(state);
		bpp.payeeZipCode(zip);
		bpp.payeeMobile(phone);
		bpp.payeeAcountNumber(accNum);
		bpp.verifyAcountNumber(verifyacc);
		bpp.amount(amt);
		bpp.fromActID();
		Thread.sleep(1000);
		bpp.sendAmtButton();
		Thread.sleep(2000);
		try {
			if(amt>0) {
				if(driver.findElement(By.xpath("//h1[text()='Bill Payment Complete']")).getText().equals("Bill Payment Complete")) {
					log.info("Payment Successful");
					Assert.assertTrue(true);
				}
				else {
					ssCapture(driver,"BillPayment");
					log.error("Enter the details");
					Assert.assertTrue(false);
				}
			}else {
				ssCapture(driver,"BillPayment");
				log.error("Amount is less than 0");
				Assert.assertTrue(false);
			}
			
		}catch(Exception e) {
			
			log.error("Enter the details"+e.getMessage());
			
		}
	}
	
	@DataProvider(name="billData")
	Object[][] getData() throws SQLException{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank","root","root");
		if(!c.isClosed()) {
			log.info("Connection Successful");
		}
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select * from billpayment");
		List<Object[]> dataList=new ArrayList<>();
		while(rs.next()) {
			Object[] data= {
					rs.getString("pname"),
		            rs.getString("address"),
		            rs.getString("city"),
		            rs.getString("state"),
		            rs.getString("zip"),
		            rs.getString("phone"),
		            rs.getString("accNuum"),
		            rs.getString("verifyacc"),
		            rs.getInt("amt")    
			};
			dataList.add(data);
			
		}
		
		Object[][] d=new Object[dataList.size()][];
		for(int i=0;i<dataList.size();i++) {
			d[i]=dataList.get(i);
		}
		return d;
	}
}
