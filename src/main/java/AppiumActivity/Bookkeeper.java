package AppiumActivity;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import MyVariable.VariableModule;

public class Bookkeeper {

	public static void browseBookkeeper() throws Exception {
		
		VariableModule.appiumdriver.findElement(By.id("com.android.packageinstaller:id/permission_allow_button")).click();
		//Thread.sleep(2000);
		
		VariableModule.appiumdriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
		VariableModule.appiumdriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']")).click();
		//VariableModule.appiumdriver.findElement(By.className("android.widget.ImageButton")).click();

		VariableModule.appiumdriver.findElement(By.id("action_btn_add_debit")).click();
		/*        
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
        Thread.sleep(2000);*/
	}
}
