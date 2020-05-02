package AppiumActivity;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CalculatorTest {
	public static AppiumDriver<MobileElement> driver;
	
	@Test
	public static void LaunchCalculator() throws MalformedURLException
	{
		DesiredCapabilities cap = new DesiredCapabilities();
		
		//Device Configuration
		cap.setCapability("deviceName", "Galaxy J7 (2016)");
		cap.setCapability("udid", "3100d13d72c4237b");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "6.0.1");
		
		//App Information
		cap.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		cap.setCapability("appActiviry", "com.sec.android.app.popupcalculator.Calculator");
		
		driver= new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
		
	}
	
/*	public static void main(String[] args) {
		//logBismillah.debug("Bismillah Module is going to start");
		try {
			LaunchCalculator();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//VariableModule.StartModule();
		//FirebugModule.FacebookLogin("");
	}*/
}
