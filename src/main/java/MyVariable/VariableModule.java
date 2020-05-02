package MyVariable;

import MyAction.ActionModule;
import Starting.MySQLPINGModule;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.apache.log4j.Logger;
import java.awt.TrayIcon;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import AppiumActivity.Bookkeeper;
import AppiumActivity.InstaTest;
import AppiumActivity.iTelDialer;



//import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil.ToStringAdapter;



public class VariableModule {
	//ActionModule actiondo = new ActionModule();
	static Logger logVariableModule = Logger.getLogger(VariableModule.class.getName());
	
	//log.info("Error in: " + this.getClass.getName() + "at line #"+ this.getClass.getActualLine());
	
	static MySQLPINGModule ThreadMysqlPingdo = new MySQLPINGModule();

	//public Static String file_name="E:/Automation/Logs/Output.txt";
	public static String driverlog="G:/WorkStation/AppiumProject"; // linux=/home/dailyqur/DreamProject // Windows=G:/WorkStation/DreamProject
	public static String isWindows=readVariable("isWindows",1); //1 for windows, 2 for linux
	public static String isGUI=readVariable("isGUI",1); // 1 for GUI, 2 for non GUI

	
	public static String Url = readVariable("Url",1);
	public static String FBuserName = readVariable("FBuserName",1);
	public static String FBpwd = readVariable("FBpwd",1);
	
	public static Connection Ownconn = null;
	public static Connection Remoteconn = null;
	
	public static String mysqlurl = readVariable("mysqlurl",1);
	public static String MySQLIP = readVariable("MySQLIP",1);
	public static String DBName = readVariable("DBName",1);
	public static String dbusername = readVariable("dbusername",1);
	public static String dbpassword = readVariable("dbpassword",1);
	
	public static String chromedriver = "";
	
	public static String isSchedule = readVariable("isSchedule",1);
	public static String ScheduleDate = readVariable("ScheduleDate",1);
	
	public static String Post = "";
	public static String Tracking = "";
    public static String PostID = "";
    
    public static int totalcases=0;
    public static int totalfailedcases=0;
    public static String[] UnicodeArray= {"09E6","09E7","09E8","09E9","09EA","09EB","09EC","09ED","09EE","09EF"};
    public static String[] UnicodeEngArray= {"0030","0031","0032","0033","0034","0035","0036","0037","0038","0039"};

	public static String DEVICE_NAME = readVariable("DEVICE_NAME",1);
	public static String PLATFORM_VERSION = readVariable("PLATFORM_VERSION",1);
	public static String appPackage = readVariable("appPackage",1);
	public static String appActivity = readVariable("appActivity",1);
	public static String dialNumber = readVariable("dialNumber",1);
	
	public static AndroidDriver<WebElement> appiumdriver;
	
    public static void StartModule()
    {
        	
    	//ActionModule.MysqlConnectOwn(Ownconn);
    	
    	try {
			launchApp();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

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
        	iTelDialer.iTelDialerStart();
			//Bookkeeper.browseBookkeeper();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
	public static String readVariable(String var, int configflag)
	{
		int flag=0;
		int gotvar=0;
		Character ch = new Character('a');
		StringBuilder Test = new StringBuilder("");
		StringBuilder tempvar = new StringBuilder("");
		String path = null;
		int data;
		try {
			if(configflag==1)
			{
				path=driverlog+"/Appium.txt";
			}
			Reader fileReader = new FileReader(path);
			data = fileReader.read();
			while(data != -1) {
				ch=(char)data;
				//System.out.println("String: "+ch+flag+gotvar);
				if(flag==0 && ch!='=') {
					Test.append(ch);
				}
				else if(flag==1 && gotvar==1) {
					if(ch!='=' && ch!=';') {
						tempvar.append(ch);
						
					}
				}
				if(ch=='\n') {
					flag=0;
					Test = new StringBuilder("");
				}
				else if(ch=='='){
					flag=1;
					String Test1=Test.toString();
					//System.out.println("Flag:"+Test1);
					//System.out.println("Actual:"+var);
					if(Test1.equals(var))
					{
						//System.out.println("Match Equal"+Test);
						gotvar=1;
					}
				}
				else if(ch==';' && gotvar==1) {
					//System.out.println("Variable Found:"+tempvar);
					break;
				}

				data = fileReader.read();
			  //System.out.println((char)data);
			}
			//String tempvar1=tempvar.toString();
			
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tempvar.toString();
	}
	
	public static WebDriver HtmlUnitDriver()
	{
		WebDriver drive;
		drive = new HtmlUnitDriver();
		return drive;
	}


	
}
