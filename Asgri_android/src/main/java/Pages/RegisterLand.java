package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.AndroidDriverutils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RegisterLand extends AndroidDriverutils{
	public RegisterLand(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver),this);
}
	
	@AndroidFindBy(xpath="//*[@text='MY CROPS']")
	public  WebElement MyCrops;
	@AndroidFindBy(id="com.ascentya.Asgri:id/mycrops")
	public  WebElement MyCropsimage;
	@AndroidFindBy(id="com.ascentya.Asgri:id/landname")
	public  WebElement LandName;
	@AndroidFindBy(id="com.ascentya.Asgri:id/landdime")
	public  WebElement LandDimension;
	@AndroidFindBy(id="com.ascentya.Asgri:id/landloc")
	public  WebElement LandLocation;
	@AndroidFindBy(id="com.ascentya.Asgri:id/lastcultivated")
	public  WebElement lastcultivateddate;
	@AndroidFindBy(id="com.ascentya.Asgri:id/lastcultivatedcrop")
	public  WebElement LastCultivatedCrop;
	@AndroidFindBy(id="com.ascentya.Asgri:id/irrigationinfo")
	public  WebElement Irrigationinformation;
	@AndroidFindBy(id="com.ascentya.Asgri:id/firstdone")
	public  WebElement firstculdate;
	@AndroidFindBy(id="com.ascentya.Asgri:id/land_condition")
	public  WebElement checkbox;
	@AndroidFindBy(xpath="//*[@text='Add Field']")
	public  WebElement AddFieldBtn;
	@AndroidFindBy(xpath="//android.widget.Toast[1]")
	public  WebElement tostmesge;
	@AndroidFindBy(id="com.ascentya.Asgri:id/field_title")
	public List<WebElement> fieldtitle;
	@AndroidFindBy(xpath="//*[@text='My Cultivation Land']")
	public  WebElement myculLandtab;
	@FindBy(xpath= "//*[@class='android.widget.LinearLayout[0]']")    
	public List<WebElement> allElementsfieldtitle;
	
}

