package bank.testCases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bank.pagesObjects.CustomerCarePage;
import bank.pagesObjects.HomePage;

public class HomeTest_001 extends BaseClass {
	@Test(priority=1)
	public void homeTest() {
		HomePage hp=new HomePage(driver);
		boolean b=hp.allLinks();
		if(b==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertTrue(false);
		}
		log.info("all the urls are verified");
		hp.username("hinata");
		hp.userpassword("hinata");
		hp.userLogin();
		
		if(driver.findElement(By.xpath("//a[text()='Log Out']")).getText().equals("Log Out")) {
			Assert.assertTrue(true);
			log.info("User logged In");
		}else {
			Assert.assertTrue(false);
		}
	}
	
	
	@Test(priority=2,dataProvider="customerData")
	public void customerService(String name,String mail,String phone,String msg) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		CustomerCarePage ccp=new CustomerCarePage(driver);
		hp.custCare();
		ccp.custName(name);
		ccp.custEmail(mail);
		ccp.custPhone(phone);
		ccp.custMsg(msg);
		ccp.sendToCustCare();
		try {
			if(driver.findElement(By.xpath("//p[text()='A Customer Care Representative will be contacting you.']")).getText().equals("A Customer Care Representative will be contacting you.")) {
				Assert.assertTrue(true);
				log.info("Message sent successfully");
				
			
				
			}
		}catch(Exception e) {
			ssCapture(driver,"CustomerCareService");
			log.error("Please fill the details"+e.getMessage());
			Thread.sleep(1000);
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="customerData")
	Object[][] getData() throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank", "root", "root");
		Statement s=con.createStatement();
		if(!s.isClosed()) {
			log.info("Connection successful");
		}
		List<Object[]> dataList=new ArrayList<>();
		ResultSet rs=s.executeQuery("select * from custCareData");
		while(rs.next()) {
			Object data[]= {
					rs.getString("cname"),
					rs.getString("email"),
					rs.getString("phone"),
					rs.getString("message")
					
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
