package GenericUtility;

import java.util.Date;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReportConfig implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}
	
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS,result.getMethod().getMethodName());
		System.out.println("TestScript is Pass");
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		test.log(Status.FAIL,testname+"==>Failed==<");
		test.log(Status.FAIL,result.getMethod().getMethodName());
		test.log(Status.FAIL,result.getThrowable());
		String screenshot = null;
		try {
			screenshot = WebDriverUtility.takeScreenShot1(TestNG_BaseClass.sDriver,result.getMethod().getMethodName());
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		test.addScreenCaptureFromPath(screenshot);
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP,result.getMethod().getMethodName());
		test.log(Status.SKIP,result.getThrowable());
		System.out.println("TestScript is Skipped");
	}

	public void onStart(ITestContext context) {
		String dateTime = new Date().toString().replace(" ","_").replace(":","_");
		ExtentSparkReporter spark = new ExtentSparkReporter("ExtentReports/Report.html"+dateTime);
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("VtigeReports");
		spark.config().setReportName("Shruti");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("PlatFrom", "Windows");
		report.setSystemInfo("Executed By", "Shruti");
		report.setSystemInfo("Reviwed By", "Shobha");
	}

	public void onFinish(ITestContext context) {
		report.flush();
	}
}
