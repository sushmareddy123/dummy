package com.Asgri.android;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import Pages.RegisterLand;
import Utilities.AndroidDriverutils;
import Utilities.Androidutilities;
import Utilities.AsgriReusablefun;


public class Sample extends AndroidDriverutils {
	   @BeforeTest
		public static void extentreports()
		{
		   AndroidDriverutils.extentreports();
		    }
	 
@Test
	    public  void cap() throws Exception  {
		logger = extent.createTest("Registering new land");
		
		AsgriReusablefun.Applicationlogin();
    		RegisterLand RL=new RegisterLand(driver);
    		RL.MyCrops.click();
    		logger.log(Status.INFO," User clicked in my crops");
    		WebDriverWait wait = new WebDriverWait(driver, 30);
       	 wait.until(ExpectedConditions.visibilityOf(RL.MyCropsimage));
	    	RL.MyCropsimage.click();
	    	String landName="Sushma";
	    	logger.log(Status.INFO," User navigated to register new land");
	    	RL.LandName.clear();
	    	RL.LandName.sendKeys(landName);
	    	RL.LandDimension.sendKeys("4 hectors");
	    	RL.LandLocation.sendKeys("hyd");
	    	RL.lastcultivateddate.sendKeys("2020-08-25");
	    	RL.LastCultivatedCrop.sendKeys("redgram");
	    	RL.Irrigationinformation.sendKeys("No water");
	    	 String s="Add Field";
		    	Androidutilities.scrolldown(s);	
		    	 wait.until(ExpectedConditions.visibilityOf(RL.firstculdate));
	    	RL.firstculdate.sendKeys("2020-08-25");
	    	RL.checkbox.click();
	    	RL.AddFieldBtn.click();
	    	logger.log(Status.INFO," User displayed with message has land name already exist please try with another name  "+landName);
	    	 Thread.sleep(2000);
	    	Androidutilities.scrollUp();
	    	wait.until(ExpectedConditions.visibilityOf(RL.LandName));
	    	String autonum=Androidutilities.generatePassword();
	    	RL.LandName.clear();
	    	String NewlandName="Asgri"+autonum;
	    	RL.LandName.sendKeys(NewlandName);
	    	logger.log(Status.INFO," User entered new land name as  "+NewlandName);
	    	Androidutilities.scrolldown(s);
	    	 wait.until(ExpectedConditions.visibilityOf(RL.AddFieldBtn));
	    	RL.AddFieldBtn.click();
	    	logger.log(Status.INFO," User registered land "+NewlandName +"successfully ");
	    	RL.myculLandtab.click();
	    	List<WebElement>li=   RL.fieldtitle;
	    	System.out.println("LI"+li.size());
	     for(int i=0;i<li.size();i++)
	     {
	    	 System.out.println("elementdata"+li.get(i).getText());
	    	Androidutilities.scrolldown(NewlandName);
	 
	    	 if(li.get(i).getText().equals(NewlandName))
	    	 {
	    		 logger.log(Status.INFO," created user is displayed in my cultivation land created user is"+NewlandName);
	    	 }
	        
	     }
	   String s3=  AndroidDriverutils.captureScreen();
    	
    		logger.log(Status.INFO, "Login Screen displayed"+logger.addScreenCaptureFromPath(s3));

}

@AfterTest
public static void endtestcase()
{
	AndroidDriverutils.tearDown();
}









}