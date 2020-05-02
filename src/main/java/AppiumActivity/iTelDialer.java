package AppiumActivity;

import org.openqa.selenium.By;

import MyAction.ActionModule;
import MyVariable.VariableModule;

public class iTelDialer {

	public static void iTelDialerStart() throws Exception {
		
		VariableModule.appiumdriver.findElement(By.id("operator_code")).sendKeys("90520");
		VariableModule.appiumdriver.findElement(By.id("button_ok")).click();
		//Thread.sleep(2000);
		
		VariableModule.appiumdriver.findElement(By.id("username")).sendKeys("1234521");
		VariableModule.appiumdriver.findElement(By.id("password")).sendKeys("1");
		VariableModule.appiumdriver.findElement(By.id("save_button")).click();
		
		Thread.sleep(5000);
		
		String status= VariableModule.appiumdriver.findElement(By.id("status")).getText();
		System.out.println("Status: "+status);
		
		if(status.contains("Registered"))
		{
			System.out.println("Signin successful and dialer is registered");
		}
		else
		{
			System.out.println("Signin unsuccessful and dialer is not registered");
		}
		

		ActionModule.dialnumberMaker();
		
		
		VariableModule.appiumdriver.findElement(By.id("call")).click();
		
		String statustview= VariableModule.appiumdriver.findElement(By.id("statustview")).getText();
		System.out.println("StatusTView: "+statustview);
		
		if(status.contains("Connected"))
		{
			System.out.println("Call is connected");
		}
		else
		{
			System.out.println("Call is not connected");
		}
		
/*		VariableModule.appiumdriver.findElement(By.xpath("//android.widget.ImageView[@index='1']")).click();
		VariableModule.appiumdriver.findElement(By.xpath("//android.widget.LinearLayout[@index='2']")).click();
		//VariableModule.appiumdriver.findElement(By.className("android.widget.ImageButton")).click();

		VariableModule.appiumdriver.findElement(By.id("action_btn_add_debit")).click();
*/
	}

	
}
