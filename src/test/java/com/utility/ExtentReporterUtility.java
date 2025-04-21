package com.utility;

import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterUtility {
	private static ExtentReports extentReports;// it is made class variable/ private static/ because even tho multiple
												// execution will be done, but only one report will be created.
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();// since there will be multiple
																						// threads for multiple test
																						// running in parallel.

	public static void setupSparkReporter(String reportName) {
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//" +  reportName);// local var
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);

	}

	public static void createExtentTest(String testName) {

		ExtentTest test = extentReports.createTest(testName);
		extentTest.set(test);
	}

	public static ExtentTest getTest() {
		return extentTest.get();
	}

	public static void flushReport() {
		extentReports.flush();
	}

}
