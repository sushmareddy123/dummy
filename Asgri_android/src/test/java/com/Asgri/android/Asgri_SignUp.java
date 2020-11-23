package com.Asgri.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.LoginPage;
import Pages.RegisterLand;
import Pages.SignUp;
import Utilities.AndroidDriverutils;
import Utilities.Androidutilities;
import Utilities.AsgriReusablefun;
import Utilities.ExcelData;

public class Asgri_SignUp extends AndroidDriverutils {
	   @BeforeTest
			public static void extentreports()
			{
			   AndroidDriverutils.extentreports();
			    }
		 
	@Test
		    public  void cap() throws Exception  {
			logger = extent.createTest("Asgri_SignUp");
			capablities();
			logger.log(Status.INFO,"Launch the application");
			LoginPage LP=new LoginPage(driver);
			 WebDriverWait wait = new WebDriverWait(driver, 30);
	    	 wait.until(ExpectedConditions.visibilityOf(LP.NextButn));
		 	LP.NextButn.click();
	    	LP.getstarted.click();
			SignUp SP=new SignUp(driver);
			
	       	 wait.until(ExpectedConditions.visibilityOf(SP.LoginSignUpbtn));
			SP.LoginSignUpbtn.click();
			logger.log(Status.INFO," User clicked on Sign Up button");
			logger.log(Status.INFO," User navigated to registration page");
			Thread.sleep(2000);
			wait.until(ExpectedConditions.visibilityOf(SP.Username));
			String userName=ExcelData.getCellData("SignUp","UserName",1);
	    	SP.Username.sendKeys(userName);
	    	logger.log(Status.INFO,"User entered the UserName Successfully");
	    	String Password=ExcelData.getCellData("SignUp","Password",1);
	    	Thread.sleep(2000);
	    	SP.PassWord.sendKeys(Password);
	    	logger.log(Status.INFO," User entered the password Successfully");
	    	Thread.sleep(2000);
	    	String ConfirmPassword=ExcelData.getCellData("SignUp","confirmPassword",1);
	    	Thread.sleep(2000);
	    	SP.ConfirmPassword.sendKeys(ConfirmPassword);
		    logger.log(Status.INFO," User entered the confirm password");
		    String EmailID=ExcelData.getCellData("SignUp","EmailID",1);
		    Thread.sleep(2000);
		    SP.Email.sendKeys(EmailID);
		    logger.log(Status.INFO," User entered the email ID");
		    String autoGenaratePhoneNum=Androidutilities.generatePassword();
		  //  String PhoneNum=ExcelData.getCellData("SignUp","P,1);
		    Thread.sleep(2000);
		    SP.PhoneNum.sendKeys(autoGenaratePhoneNum);
		    logger.log(Status.INFO," User entered the PhoneNumber");
		    Thread.sleep(2000);
		    SP.terms.click();
		    SP.privacypolicy.click();
			logger.log(Status.INFO," User selected term and Policy");
		    Thread.sleep(2000);
		    SP.SignUpbtn.click();
		    logger.log(Status.INFO," User clicked on Sign Up");
		    wait.until(ExpectedConditions.visibilityOf(LP.Dashbord));
		    if(LP.Dashbord.isDisplayed()) {
	    		logger.log(Status.INFO, "User is navigated to dashboard successfully");
	    		String s1=captureScreen();
	    		logger.log(Status.INFO, "Login Screen displayed"+logger.addScreenCaptureFromPath(s1));
		    }
		    	
	}

	@AfterTest
	public static void endtestcase()
	{
		AndroidDriverutils.tearDown();
	}
}

