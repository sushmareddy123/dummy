package com.Asgri.android;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;


import Utilities.AndroidDriverutils;
import Utilities.Utility;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
@SuppressWarnings("rawtypes")
public class Login extends Data{
	public static AndroidDriver<AndroidElement>  driver;
	@Test
	public static void f()   throws MalformedURLException
	{
		logger.log(LogStatus.PASS, "Test Case (failTest) Status is passed");
		
}
}
