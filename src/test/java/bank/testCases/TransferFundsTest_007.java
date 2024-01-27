package bank.testCases;

import java.sql.*;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bank.pagesObjects.AccountServicesPage;
import bank.pagesObjects.HomePage;
import bank.pagesObjects.TransferFundsPage;

public class TransferFundsTest_007 extends BaseClass {
	@BeforeClass
	public void loginDetailss() {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
	}
	
	
	@Test(dataProvider="transferAmt")
	public void transferFunds(int n) throws InterruptedException {
		AccountServicesPage asp=new AccountServicesPage(driver);
		asp.transferFundsTo();
		Thread.sleep(1000);
		TransferFundsPage tfp=new TransferFundsPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		try {
			
			if(n>0) {
				Assert.assertTrue(true);
				tfp.amount(n);
				tfp.fromAccount();
				tfp.toAccount();
				Thread.sleep(1000);
				tfp.clickTransfer();
				Thread.sleep(3000);
				if(driver.findElement(By.xpath("//h1")).getText().equals("Transfer Complete!")) {
					
					log.info("Successful Transaction");
				}
			}else {
	           
	            log.info("Invalid amount: " + n);
	            ssCapture(driver,"TransferFunds");
	            Assert.assertTrue(false);
			}
	        
			
		}catch(Exception e) {
			log.error("Exception:"+e.getMessage());
		}
		
	}
	
	@DataProvider(name="transferAmt")
	Object[][] getData() throws SQLException {
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank", "root","root");
		if(!c.isClosed()) {
			log.info("Connection is Successful");
		}
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select * from transferfunds");
		List<Object[]> data = new ArrayList<>();

        while (rs.next()) {
            int num = rs.getInt("amt");
            data.add(new Object[]{num});
        }
        Object[][] dataArray = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            dataArray[i][0] = data.get(i)[0];
        }

        return dataArray;
	}
}
