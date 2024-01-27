package bank.testCases;

import java.io.*;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.io.Files;

import bank.utilities.ReadConfig;

public class BaseClass {
	ReadConfig rc=new ReadConfig();
	public WebDriver driver;
	public String url=rc.getAppURL();
	public String browser=rc.getBrowser();
	public String userName=rc.getuserName();
	public String psw=rc.getPassword();
	public Logger log;
	
	@BeforeClass
	public void setup() {
		log=LogManager.getLogger("ParaBank");
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
			
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);
		
		log.info("Opened Application URL");
		
	}
	
	@AfterClass
	public void closeApp() throws InterruptedException {
		Thread.sleep(1000);
		log.info("Application closed ");
		driver.quit();
	}
	
	public void ssCapture(WebDriver driver, String testName) {
		try {
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File dest=new File(".\\Screenshots\\"+testName+getTime()+".png");
			Files.copy(src,dest);
			
		}catch(Exception e) {
			log.error("ss not captured:"+e.getMessage());
		}
	}
	
	public String getTime() {
		Date d=new Date();
		return d.toString().replace(" ","_").replace(":", "_");
	}
	
}
