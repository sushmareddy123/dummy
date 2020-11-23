package com.Asgri.android;
import java.net.MalformedURLException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.model.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.AndroidDriverutils;

public class Loginfunctionality{
	ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    //ExtentTest test;
    static ExtentTest test;
    static ExtentReports report;
public void LoginwithcrctCredentials() throws MalformedURLException {
	
	//androidCapabilities();
	System.out.println("hello");
	//report = new ExtentReports(System.getProperty("user.dir")+"\\ExtentReportResults.html");
	//test = report.startTest("ExtentDemo");
}
}
