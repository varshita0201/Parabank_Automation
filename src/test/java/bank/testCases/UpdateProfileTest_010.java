package bank.testCases;

import java.sql.*;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import bank.pagesObjects.AccountServicesPage;
import bank.pagesObjects.HomePage;
import bank.pagesObjects.UpdateProfilePage;

public class UpdateProfileTest_010 extends BaseClass {
	@BeforeClass
	public void loginDetailss() {
		HomePage hp=new HomePage(driver);
		hp.username("naruto");
		hp.userpassword("naruto");
		hp.userLogin();
	}
	
	@Test(dataProvider="update")
	public void updateProfileTest(String fname,String lname, String adrs, String city, String state,String zip, String phone) throws InterruptedException {
		AccountServicesPage asp=new AccountServicesPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		asp.updateConInfo();
		UpdateProfilePage upp=new UpdateProfilePage(driver);
		upp.firstName(fname);
		upp.lastName(lname);
		upp.address(adrs);
		upp.cCity(city);
		upp.cstate(state);
		upp.postalCode(zip);
		upp.phone(phone);
		upp.updateProfile();
		Thread.sleep(1000);
		log.info("Clicked on UpdateProfile button");
		try {
		
			if(driver.findElement(By.cssSelector("h1[class='title']")).getText().equals("Profile Updated")) {
				Assert.assertTrue(true);
				log.info("Successfully Updated");
			}
			else {
				log.error("Fill the details");
				ssCapture(driver,"Profile Update");
				Assert.assertTrue(false);
			}
		}catch(Exception e) {
			log.error("Fill the details");
			ssCapture(driver,"Profile Update");
			Assert.assertTrue(false);
		}
	}
	
	@DataProvider(name="update")
	Object[][] getData() throws SQLException{
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/parabank", "root", "root");
		if(!c.isClosed()) {
			log.info("Connection is Successful");
		}
		Statement s=c.createStatement();
		ResultSet rs=s.executeQuery("select * from updateprofile");
		List<Object[]> dataList=new ArrayList<>();
		while(rs.next()) {
			Object[] data= {
					rs.getString("firstname"),
					rs.getString("lastname"),
		            rs.getString("address"),
		            rs.getString("city"),
		            rs.getString("state"),
		            rs.getString("zip"),
		            rs.getString("phone")
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
