package Utilities;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import io.appium.java_client.AppiumDriver;

public class Androidutilities extends AndroidDriverutils {
	
	
	public static int  screenWidth;
	public static int screenheight;
	public static int startx;
	public static int endx;
	public static int starty;
	public static int endy;
	
	public static void isWebElementPresent(WebElement s)  {
		try {
		//driver.context(name);
				System.out.println("Element Present");
			//return true;
				//flag=true;
				//break;
		}
			catch(Exception e)
			{
				System.out.println("Element is not Present");
				//return false;
			}
			//executionDelay(2000);
		//	timeOut=timeOut+2;
			
		//}

		//return flag;

	}
	
	
	
	public static boolean click(WebElement element) throws InterruptedException  {
		Thread.sleep(1500);

		//WebElement element = (explicitWaitForElement(path, type));
	
		element.click();
		return true;
	}
	
	public boolean verifyDropdownSelectedValue(WebElement s, String data) {

		Boolean flag = false;
		

		Select sel = new Select(s);
		String defSelectedVal = sel.getFirstSelectedOption().getText();

		if (defSelectedVal.trim().equals(data.trim())) {
			flag = true;

			return flag;
		} else {
			return flag;
		}
	}
	
	public static void scrollUp() {
	
		screenWidth=driver.manage().window().getSize().getWidth();
 screenheight=driver.manage().window().getSize().getHeight();
 startx=screenWidth/2;
	 endx=screenWidth/2;
starty=screenheight/6;
endy=screenheight*5/6;
	
((AppiumDriver) driver).swipe(startx, starty, startx, endy, 3000);
	}
	
	
	public static void scroll() {
	    Dimension dimensions = driver.manage().window().getSize();
	    int Startpoint = (int) (dimensions.getHeight() * 0.5);
	    int scrollEnd = (int) (dimensions.getHeight() * 0.5);
	    ((AppiumDriver) driver).swipe(200, Startpoint,200,scrollEnd,2000); 
	}
	
	 public static String generatePassword() {
		 int randomPin   =(int) (Math.random()*9000)+1000; 
	        String randomNum  = String.valueOf(randomPin);
	      return randomNum;
	   }
	 
	public static void scrolldown(String text)
	{driver
	        .findElementByAndroidUIAutomator("new UiScrollable("
	            + "new UiSelector().scrollable(true)).scrollIntoView("                      
	            + "new UiSelector().textContains(\""+text+"\"));");
		
	}
	}	
	

