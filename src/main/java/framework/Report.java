package framework;

import java.io.IOException;
import java.time.LocalDateTime;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Report {

	private static final String DEFAULT_PATH = "./reports/report_%s.html";
	private static ExtentReports extentReport;
	private static ExtentTest test;

	public static void create(String title, String description) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
				String.format(DEFAULT_PATH, LocalDateTime.now().getNano()));
		extentReport = new ExtentReports();
		extentReport.attachReporter(htmlReporter);
	}

	public static void startTest(String testCaseTitle) {
		Report.test = extentReport.createTest(testCaseTitle);
	}

	public static void log(Status status, String message) {
		test.log(status, message);
	}

	public static void log(Status status, String message, String screenShot) {
		try {
			System.out.println(screenShot);
			test.log(status, message, MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
		} catch (IOException ex) {
			System.out.println("Falha ao salvar ScreenShot: " + ex.getMessage());
			test.log(status, message);
		}
	}

	public static void logFail(String message, String screenShot) {
		try {
			test.fail(message, MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
		} catch (IOException ex) {
			System.out.println("Falha ao salvar ScreenShot: " + ex.getMessage());
			test.fail(message);
		}
	}

	public static void logPass(String message, String screenShot) {
		try {
			test.pass(message, MediaEntityBuilder.createScreenCaptureFromPath(screenShot).build());
		} catch (IOException ex) {
			test.pass(message);
		}
	}

	public static void close() {
		if (extentReport != null) {
			extentReport.flush();
		}
	}

}