package Utilities;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Pages.LoginPage;

public class AsgriReusablefun extends AndroidDriverutils {
	@Test
    public static void Applicationlogin() throws Exception  {
		capablities();

Thread.sleep(4000);
    	
    	LoginPage LP=new LoginPage(driver);
    	 WebDriverWait wait = new WebDriverWait(driver, 30);
    	 wait.until(ExpectedConditions.visibilityOf(LP.NextButn));
    	LP.NextButn.click();
    	LP.getstarted.click();
    	
    	if(LP.Email.isDisplayed()) {
    	logger.log(Status.INFO,"Login screen appears");
    	String s=AndroidDriverutils.captureScreen();
    	logger.log(Status.INFO, "Login Screen"+logger.addScreenCaptureFromPath(s));
    	}
    	String userName=ExcelData.getCellData("TC_LoginValidation","UserName",1);
    	//Lp.Email.sendKeys("madhini.sushma@gmail.com");
    	LP.Email.sendKeys(userName);
    	logger.log(Status.INFO,"User entered the email ID sucessfully");
    	String Password=ExcelData.getCellData("TC_LoginValidation","Password",1);
    	LP.Password.sendKeys(Password);
    	logger.log(Status.INFO,"User entered the password Sucessfully ");
    	LP.Agriterms.click();
    	LP.Agripolicy.click();
    	logger.log(Status.INFO," User selected term and Policy");
    	LP.login.click();
    	
    	logger.log(Status.INFO," User clicked on login");
    	 wait.until(ExpectedConditions.visibilityOf(LP.Dashbord));
    	if(LP.Dashbord.isDisplayed()) {
    		logger.log(Status.INFO, "User is navigated to dashboard successfully");
    		String s1=captureScreen();
    		logger.log(Status.INFO, "Login Screen displayed"+logger.addScreenCaptureFromPath(s1));
    	}
}
}
