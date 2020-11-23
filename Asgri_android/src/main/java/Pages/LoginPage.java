package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.AndroidDriverutils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class  LoginPage  extends AndroidDriverutils {	
	public LoginPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	
@AndroidFindBy(xpath="//*[@text='Email']")
public  WebElement Email;
@AndroidFindBy(xpath="//*[@text='Password']")
public  WebElement Password;

@AndroidFindBy(xpath="//*[@text='Login']")
public  WebElement login;

@AndroidFindBy(xpath="//*[@resource-id='com.ascentya.Asgri:id/terms']")
public WebElement Agriterms;

@AndroidFindBy(xpath="//*[@resource-id='com.ascentya.Asgri:id/privacypolicy']")
public WebElement Agripolicy;

xpath="//*[@resource-id='com.ascentya.Asgri:id/privacypolicy']")
public WebElement Agripolicy;

@AndroidFindBy(xpath="//*[@text='NEXT']")
public WebElement NextButn ;

@AndroidFindBy(xpath="//*[@text='GET STARTED']")
public WebElement getstarted ;


@AndroidFindBy(xpath="//*[@text='AGRIPEDIA']")
public WebElement Dashbord ;
@AndroidFindBy(xpath="//*[@text='Cultivable Land Name (For short reference)']")
public  WebElement LandName;
}
