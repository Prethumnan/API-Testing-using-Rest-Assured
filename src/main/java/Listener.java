import Utilities.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {


    ExtentReports extentReports;
    ExtentTest extentTest;

    @Override
    public void onStart(ITestContext context) {

        extentReports = utilities.generateExtentReport();
    }
    @Override
    public void onTestStart(ITestResult result) {

        extentTest = extentReports.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        extentTest.log(Status.PASS, result.getName() + " Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.log(Status.FAIL, result.getName() + " Test Failed");
        extentTest.log(Status.INFO,result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest.log(Status.SKIP, result.getName() + " Test Skipped");
        extentTest.log(Status.INFO,result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }
}