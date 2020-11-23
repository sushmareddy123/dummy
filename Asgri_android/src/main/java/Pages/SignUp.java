package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utilities.AndroidDriverutils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SignUp extends AndroidDriverutils  {
	public SignUp(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
	}

	/*public void pageFactory()
	{
		PageFactory.initElements(driver,this);
	}*/
@AndroidFindBy(id="com.ascentya.Asgri:id/password")
public  WebElement PassWord;
@AndroidFindBy(id="com.ascentya.Asgri:id/username")
public  WebElement Username;
@AndroidFindBy(id="com.ascentya.Asgri:id/confirm_password")
public  WebElement ConfirmPassword;
@AndroidFindBy(id="com.ascentya.Asgri:id/mail")
public  WebElement Email;
@AndroidFindBy(id="com.ascentya.Asgri:id/phone")
public  WebElement PhoneNum;
@AndroidFindBy(id="com.ascentya.Asgri:id/terms")
public  WebElement terms;
@AndroidFindBy(id="com.ascentya.Asgri:id/privacypolicy")
public  WebElement privacypolicy;
@AndroidFindBy(id="com.ascentya.Asgri:id/signup")
public  WebElement SignUpbtn;
@AndroidFindBy(xpath="//*[@text='Sign Up']")
public  WebElement LoginSignUpbtn;









}

