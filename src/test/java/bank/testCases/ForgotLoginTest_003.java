package bank.testCases;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mysql.cj.protocol.Resultset;

import bank.pagesObjects.ForgotLoginPage;
import bank.pagesObjects.HomePage;

public class ForgotLoginTest_003 extends BaseClass {
	@Test(dataProvider="forgotLoginData")
	public void forgotLogin(String firstname,String lastname,String address,String city,String state,String zip,String ssn) {
		HomePage hp=new HomePage(driver);
		ForgotLoginPage flp=new ForgotLoginPage(driver);
		hp.forgotPassword();
		flp.findFirstName(firstname);
		flp.findLastName(lastname);
		flp.findAdd(address);
		flp.findState(state);
		flp.findzip(zip);
		flp.findSsn(ssn);
		flp.findLoginInfo();
		try {
			if(driver.findElement(By.xpath("//a[text()='Log Out']")).getText().equals("Log Out")) {
				Assert.assertTrue(true);
				log.info("Registered successfull");
				driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			}	
		}catch(Exception e) {
			ssCapture(driver,"ForgotLoginDetails");
			log.error("Please fill details:"+e.getMessage());
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="forgotLoginData")
	Object[][] getData() throws SQLException{
	    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank","root","root");
	    
	    Statement s=con.createStatement();
	    if(!s.isClosed()) {
	        log.info("Connection Successful");
	    }
	    ResultSet rs=s.executeQuery("select * from forgotcred");
	    List<Object[]> dataList=new ArrayList<>();
	    while(rs.next()) {
	        Object[] data= {
	            rs.getString("firstname"),
	            rs.getString("lastname"),
	            rs.getString("address"),
	            rs.getString("city"),
	            rs.getString("state"),
	            rs.getString("zip"),
	            rs.getString("ssn")
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
