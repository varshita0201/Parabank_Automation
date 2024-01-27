package bank.testCases;

import java.sql.*;
import java.util.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bank.pagesObjects.HomePage;

public class CustomerLoginTest_004 extends BaseClass {
	
	@Test(dataProvider="loginData")
	public void cutomerLogin(String username,String psw) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		hp.username(username);
		hp.userpassword(psw);
		hp.userLogin();
		try {
			if(driver.findElement(By.xpath("//a[text()='Log Out']")).getText().equals("Log Out")) {
				Assert.assertTrue(true);
				log.info("Registered successfull");
				driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			
				
			}
		}catch(Exception e) {
			ssCapture(driver,"CustomerLogin");
			log.error("Please fill details:"+e.getMessage());
			Assert.assertTrue(false);
		}
		
	}
	
	@DataProvider(name="loginData")
	Object[][] getData() throws SQLException{
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank", "root", "root");
		Statement s=con.createStatement();
		if(!s.isClosed()) {
			log.info("Connection is successful");
		}
		List<Object[]> dataList=new ArrayList<>();
		ResultSet rs=s.executeQuery("select * from loginInfo");
		while(rs.next()) {
			Object[] data= {
					rs.getString("username"),
					rs.getString("psw")
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
