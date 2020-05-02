package AppiumActivity;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import MyVariable.VariableModule;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class InstaTest {
	
	
	
	@BeforeClass
	public static void launchApp() throws MalformedURLException, InterruptedException {
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		// Please change the device name according to your device name
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, VariableModule.DEVICE_NAME);

		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		
		// Please change the Android version according to your device's Android version
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, VariableModule.PLATFORM_VERSION);
		
		capabilities.setCapability("appPackage", VariableModule.appPackage);
		capabilities.setCapability("appActivity", VariableModule.appActivity);
		
		URL url = new URL(VariableModule.Url);
        
        VariableModule.appiumdriver = new AndroidDriver<WebElement>(url, capabilities);
        
        Thread.sleep(2000);
        try {
			//browseInstagram();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public static void browseInstagram() throws Exception {
		
		WebElement proceedToLogin = VariableModule.appiumdriver.findElement(By.id("log_in_button"));
        
        proceedToLogin.click();
        
        WebElement username = VariableModule.appiumdriver.findElement(By.id("login_username"));
        
        // Provides username, you can change this to your username
        username.sendKeys("haque_kazi_rashedul");
        Thread.sleep(2000);
        
        WebElement password = VariableModule.appiumdriver.findElement(By.id("password"));
        
        // Provides password, you can change this to your password
        password.sendKeys("reve#2019");
        Thread.sleep(2000);
        
        // Clicking on login button
        WebElement login_button = VariableModule.appiumdriver.findElement(By.id("button_text"));
        login_button.click();
        Thread.sleep(6000);
        
        // Clicking on search button at the bottom
        WebElement search_button = VariableModule.appiumdriver.findElement(By.id("tab_icon"));
        search_button.click();
        Thread.sleep(2000);
        
        // Clicking on heart button at the bottom
        WebElement activity = VariableModule.appiumdriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Activity\"]/android.widget.ImageView[@index='0']"));
        activity.click();
        Thread.sleep(2000);
        
        // Clicking on profile button at the bottom-right corner
        WebElement profile = VariableModule.appiumdriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Profile\"]/android.widget.ImageView[@index='0']"));
        profile.click();
        Thread.sleep(2000);
        
        // Clicking on options button at the top-right corner
        WebElement options = VariableModule.appiumdriver.findElement(By.xpath("//android.widget.FrameLayout[@content-desc=\"Options\"]/android.widget.ImageView[@index='0']"));
        options.click();
        Thread.sleep(2000);
        
        // Clicking on settings button at the bottom
        WebElement settings = VariableModule.appiumdriver.findElement(By.id("menu_settings_row"));
        settings.click();
        Thread.sleep(2000);
        
        // Clicking on logout button at the bottom
        WebElement log_out = VariableModule.appiumdriver.findElement(By.id("row_simple_link_textview"));
        log_out.click();
        Thread.sleep(2000);
	}
	
	@AfterClass
	public void closeInstagran() throws Exception {
		VariableModule.appiumdriver.quit();
	}
	
	

}