package bank.utilities;

import java.io.*;
import java.util.*;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		File src= new File("./Configuration/config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getAppURL() {
		return pro.getProperty("url");
	}
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	public String getuserName() {
		return pro.getProperty("username");
	}
	public String getPassword() {
		return pro.getProperty("password");
	}
}
