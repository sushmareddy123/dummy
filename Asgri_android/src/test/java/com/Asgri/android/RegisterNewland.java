package com.Asgri.android;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.LoginPage;
import Pages.RegisterLand;
import Utilities.AndroidDriverutils;

public class RegisterNewland extends AndroidDriverutils{
	static ExtentHtmlReporter htmlReporter;
	 static   ExtentReports extent;
	   static ExtentTest logger;
	   @BeforeTest
		public void config()
		{
		    
		   String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		    	String path=System.getProperty("user.dir") +"\\ExecutionReports\\HtmlReports\\"+dateName+"MyOwnReport.html";
		       
		    	htmlReporter = new ExtentHtmlReporter(path);
		    	htmlReporter.config().setReportName("AsgriTestReport");
		    	htmlReporter.config().setDocumentTitle("Test Result");
		    //	htmlReporter.getRunDuration();
		        extent = new ExtentReports();
		        extent.attachReporter(htmlReporter);
		        extent.setSystemInfo("Tester", "Sushma");
		     
		        
		    }
	   @Test
	    public  void RegisterLandnewland() throws Exception  {
		   capablities();
			Thread.sleep(4000);
			    	logger = extent.createTest("Register new Land ");
			    	RegisterLand RL=new RegisterLand(driver);
			    	LoginPage LP=new LoginPage(driver);
			    	RL.MyCrops.click();
			    	//Thread.sleep(4000);
			    	RL.MyCropsimage.click();
			    	//Thread.sleep(4000);
			    	//RL.LandName.click();
			    	
			    	LP.LandName.sendKeys("Sushma");
			    	RL.LandDimension.sendKeys("4 hectors");
			    	RL.LandLocation.sendKeys("2020-08-25");
			    	RL.LastCultivatedCrop.sendKeys("redgram");
	   }
	   
	   
	   
	   
}
