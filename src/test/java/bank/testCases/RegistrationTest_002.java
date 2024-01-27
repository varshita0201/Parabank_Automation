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

import bank.pagesObjects.HomePage;
import bank.pagesObjects.RegistrationPage;

public class RegistrationTest_002 extends BaseClass{

	@Test(dataProvider="registrationData")
	public void registrationTest(String firstName,String lastName,String address, String city, String state,String zip, String phone, String ssn, String username,String psw,String confirmpsw) throws InterruptedException {
		HomePage hp=new HomePage(driver);
		RegistrationPage rp=new RegistrationPage(driver);
		hp.registration();
		rp.userFirstName(firstName);
		rp.userLastName(lastName);
		rp.userAddress(address);
		rp.userCity(city);
		rp.userState(state);
		rp.userZip(zip);
		rp.userPhone(phone);
		rp.userSsn(ssn);
		rp.userName(username);
		rp.userpassword(psw);
		rp.confirmUserPsw(confirmpsw);
		rp.userregister();
		try {
			if(driver.findElement(By.xpath("//a[text()='Log Out']")).getText().equals("Log Out")) {
				Assert.assertTrue(true);
				log.info("Registered successfull");
				driver.findElement(By.xpath("//a[text()='Log Out']")).click();
			
				
			}
		}catch(Exception e) {
			ssCapture(driver,"Registration Test");
			log.info("Please fill the details");
			Thread.sleep(1000);
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="registrationData")
	Object[][] getData() throws SQLException {
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/paraBank","root","root");
		Statement s=con.createStatement();
		if(!s.isClosed()) {
			log.info("Connection is Succesfull");
		}
		ResultSet rs=s.executeQuery("select * from register");
		List<Object[]> dataList=new ArrayList<>();
		while(rs.next()) {
			Object[] rowData = {
		            rs.getString("firstname"),
		            rs.getString("lastname"),
		            rs.getString("address"),
		            rs.getString("city"),
		            rs.getString("state"),
		            rs.getString("zipcode"),
		            rs.getString("phone"),
		            rs.getString("ssn"),
		            rs.getString("username"),
		            rs.getString("password"),
		            rs.getString("confirmpassword")
		        };
		        dataList.add(rowData);
		}
		Object[][] data=new Object[dataList.size()][];
		for(int i=0;i<dataList.size();i++) {
			data[i]=dataList.get(i);
		}
		return data;
		
	}
}
