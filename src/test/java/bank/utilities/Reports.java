package bank.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Reports implements ITestListener {
	public ExtentReports extent;
	public ExtentSparkReporter rep;
	public ExtentTest etest;
	
	
	@Override
	public void onStart(ITestContext context) {
		String time=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repName="TestReports"+time+".html";
		String repPath=System.getProperty("user.dir")+"./reports/"+repName;
		rep=new ExtentSparkReporter(repPath);
		rep.config().setReportName("ParaBank Results");
		rep.config().setDocumentTitle("ParaBank");
		extent=new ExtentReports();
		extent.attachReporter(rep);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("tested By", "Varshita");
		etest=extent.createTest("ParaBank Test");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		etest.pass("Test passed:"+result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		etest.fail("Test Failed:"+result.getName());
		WebDriver driver=null;
//		try {
//			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		etest.skip("Test Skipped:"+result.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
