package MyAction;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;

import javax.mail.internet.AddressException;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.text.AbstractDocument.Content;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFBorderFormatting;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.sun.javafx.geom.transform.GeneralTransform3D;
/*import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeBodyPart;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeMultipart;
import com.sun.xml.internal.ws.wsdl.writer.document.Message;*/


import MyVariable.VariableModule;
import javafx.scene.control.Cell;
/*import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.rmi.transport.Transport;*/
import net.bytebuddy.dynamic.loading.ClassInjector;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
 

public class ActionModule {
	static Logger logActionModule = Logger.getLogger(ActionModule.class.getName());
	static VariableModule variabledo = new VariableModule();
	static int RowCount=1;
	
	
/*	public static void EmailAction() {
		

	}*/
	public static void dialnumberMaker()
	{
		
		String[] dialArray = VariableModule.dialNumber.split("");
		for(int i=0;i<VariableModule.dialNumber.length();i++)
		{
			//System.out.println("Array value "+(i+1)+" : "+dialArray[i]);
			if(dialArray[i].contains("0"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_0")).click();
			}
			else if(dialArray[i].contains("1"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_1")).click();
			}
			else if(dialArray[i].contains("2"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_2")).click();
			}
			else if(dialArray[i].contains("3"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_3")).click();
			}
			else if(dialArray[i].contains("4"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_4")).click();
			}
			else if(dialArray[i].contains("5"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_5")).click();
			}
			else if(dialArray[i].contains("6"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_6")).click();
			}
			else if(dialArray[i].contains("7"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_7")).click();
			}
			else if(dialArray[i].contains("8"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_8")).click();
			}
			else if(dialArray[i].contains("9"))
			{
				VariableModule.appiumdriver.findElement(By.id("button_9")).click();
			}
		}
		
		 
	}
	public static String unicodeMaker(String text)
	{
		String unicode="";
		char[] cArray = text.toCharArray();
		for(int i=0;i<cArray.length;i++)
		{
			unicode=unicode.concat(String.valueOf(Character.toChars(Integer.parseInt(VariableModule.UnicodeArray[Character.getNumericValue(cArray[i])], 16))));
		}
		
		return unicode;
	}
	
	public static String unicodeEngMaker(String text)
	{
		String unicode="";
		char[] cArray = text.toCharArray();
		for(int i=0;i<cArray.length;i++)
		{
			unicode=unicode.concat(String.valueOf(Character.toChars(Integer.parseInt(VariableModule.UnicodeEngArray[Character.getNumericValue(cArray[i])], 16))));
		}
		
		return unicode;
	}
	
    public static String getCurrentHour() {
        Date date = Calendar.getInstance().getTime();
        SimpleDateFormat dateobject = new SimpleDateFormat("HH");
        return dateobject.format(date);
    }
    
	public static WebDriver HtmlUnitDriver()
	{
		WebDriver drive;
		drive = new HtmlUnitDriver();
		return drive;
	}
	
	public static void MysqlFBHInsertData(int suraid, int ayatid, String FBID, int postID, Connection con)
	{
		String sql=null;
	    //Connection conn = null;
	    java.sql.Statement stmt = null;

	    try {
	    	//conn=MysqlConnection();


	        // STEP 5: Excute query
	    	//log.debug("\\nInserting records into table...");
	        System.out.print("\nInserting records into table...");
	        stmt = con.createStatement();

		        sql = "INSERT INTO FacebookHistory (fhSuraID,fhSuraAyatID,fhPostID,fhFBID)" +
			            " VALUES ("+suraid+","+ayatid+","+postID+",'"+FBID+"');";
		        //log.debug("SQL: "+sql);
		        System.out.println("SQL: "+sql);

	        stmt.executeUpdate(sql);
	        //log.debug(" SUCCESS!\\n");
	        System.out.println(" SUCCESS!\n");

	    } catch(SQLException se) {
	        se.printStackTrace();
	        //log.debug("E1: "+se);
	    } catch(Exception e) {
	        e.printStackTrace();
	        //log.debug("E2: "+e);
	    }
	    //log.debug("Thank you for your patronage!");
	    System.out.println("Thank you for your patronage!");
	    
	}
	
	public static void MysqlHadisInsertData(int hdHadisID, int hdChapterID, String hdHadis_ar, String hdHadisNarratedBy, String hdHadis_bl, String hdHadisSonod, Connection con)
	{
		String sql=null;
	    //Connection conn = null;
	    java.sql.Statement stmt = null;

	    try {
	    	//conn=MysqlConnection();


	        //System.out.print("\nInserting records into table...");
	        stmt = con.createStatement();

/*		        sql = "INSERT INTO hadisdetails (hdHadisID,hdChapterID,hdHadis_ar,hdHadisNarratedBy,hdHadis_bl,hdHadisSonod,hdHadisSonod_bl)" +
			            " VALUES ("+hdHadisID+","+hdChapterID+",'"+hdHadis_ar+"','"+hdHadisNarratedBy+"','"+hdHadis_bl+"',"+HadisCollector.Sonod(hdHadisSonod)+",'"+hdHadisSonod+"');";*/
		        //log.debug("SQL: "+sql);
		        //System.out.println("SQL: "+sql);

	        stmt.executeUpdate(sql);
	        //log.debug(" SUCCESS!\\n");
	        System.out.println(" SUCCESS!\n");

	    } catch(SQLException se) {
	        se.printStackTrace();
	        //log.debug("E1: "+se);
	    } catch(Exception e) {
	        e.printStackTrace();
	        //log.debug("E2: "+e);
	    }
	    //log.debug("Thank you for your patronage!");
	    //System.out.println("Thank you for your patronage!");
	    
	}
	
	public static void MysqlChapterInsertData(int hcChapterID, String hcName_bl, int total, int max, Connection con)
	{
		String sql=null;
	    //Connection conn = null;
	    java.sql.Statement stmt = null;

	    try {
	    	//conn=MysqlConnection();


	        //System.out.print("\nInserting records into table...");
	        stmt = con.createStatement();

		        sql = "INSERT INTO hadischapter (hcChapterID,hcName_bl,hcTotalHadis,hcMaxID)" +
			            " VALUES ("+hcChapterID+",'"+hcName_bl+"',"+total+","+max+");";
		        //log.debug("SQL: "+sql);
		        System.out.println("SQL: "+sql);

	        stmt.executeUpdate(sql);
	        //log.debug(" SUCCESS!\\n");
	        System.out.println(" SUCCESS!\n");

	    } catch(SQLException se) {
	        se.printStackTrace();
	        //log.debug("E1: "+se);
	    } catch(Exception e) {
	        e.printStackTrace();
	        //log.debug("E2: "+e);
	    }
	    //log.debug("Thank you for your patronage!");
	    //System.out.println("Thank you for your patronage!");
	    
	}
	
	
	public static void MysqlConnectionActionUpdate(String Myquery)
	{

	    java.sql.Statement stmt = null;
		    
	    try {
	    	//CommonOSModule.conn=MysqlConnection();
	        stmt = VariableModule.Ownconn.createStatement();
	        stmt.executeUpdate(Myquery);
	        //ConsolPrint("User is updated");
		    stmt.close();
		    //connection.close();
	} catch (SQLException e) {
	    throw new IllegalStateException("Cannot connect the database!", e);
	}
	    
	}
	

	public static String MysqlConnectionAction(String Myquery, Connection conn, String character)
	{

		String columnValue1="";
		String columnValue="";
		String[] URL=null;
	    //Connection connection = null;
	    java.sql.Statement stmt = null;
		    
	    try {
	    	//connection=CommonOSModule.MysqlConnection();
	    	stmt = conn.createStatement();
		    ResultSet rs=stmt.executeQuery(Myquery);
		    ResultSetMetaData rsmd = rs.getMetaData();
		    int columnsNumber = rsmd.getColumnCount();
		    int i;
		    while (rs.next()) {

		        for (i = 1; i <= columnsNumber; i++) {
		            //if (i > 1) System.out.print("\n");
		            columnValue = rs.getString(i);
		            if(columnValue==null)
		            {
		            	columnValue="";
		            }
		            if(columnValue.equals("NULL"))
		            {
		            	//System.out.print("NULL found:");
		            	columnValue="";
		            }
		            //DBValues[i]=columnValue;
		            //System.out.print("Test:"+columnValue);
		            //System.out.print(columnValue + " " + rsmd.getColumnName(i));
		            if(i<columnsNumber)
		            {
		            	columnValue1=columnValue1.concat(columnValue+character);
		            }
		            else
		            {

		            	columnValue1=columnValue1.concat(columnValue);

		            }
		        }
		        i=1;
		        if(!columnValue1.equals(""))
		        {
		        	columnValue1=columnValue1.concat("\n");
		        }
		    }
		    //System.out.print("Test:"+columnValue1);
		    stmt.close();
		    //connection.close();
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database!", e);
		}
		return columnValue1;
	}
	
    public static void MysqlConnectOwn(Connection connect)
    {
    	if(connect==null)
    	{
    		VariableModule.Ownconn=MysqlConnectionOwn();
    		ConsolPrint("Mysql Connection is getting: "+VariableModule.Ownconn,"");
    		writing("Mysql Connection is getting: "+VariableModule.Ownconn);
/*	    	if(VariableModule.Ownconn==null)
	    	{
	    		try {
					EmailModule.sendEmailWithAttachments("nafiul@revesoft.com", "MySQL connection is null", "Dear Team,\n\n"+VariableModule.server_IP+" server MySQL connection is getting null.\nPlease fix the MySQL connection issue otherwise Mail thread will be failed to send SQA mail.","5");
				} catch (AddressException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (javax.mail.MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}*/
    	}
    }
    
    
    public static Connection MysqlConnectionOwn()
    {
    	//long startTime = System.currentTimeMillis();
    	Connection connt = null;
	    try {
	        // STEP 2: Register JDBC driver
	        Class.forName("com.mysql.jdbc.Driver");


	        connt = DriverManager.getConnection("jdbc:mysql://"+VariableModule.MySQLIP+"/"+VariableModule.DBName, VariableModule.dbusername, VariableModule.dbpassword);
	        writing(" Own Database Connected!\n");
	    }catch(Exception e) {
	        e.printStackTrace();
	    }

	    
/*	    public void close() throws SQLException {
	        databaseConnection.close();
	    }*/
	    //CommonAction.ExecuteTimeMeasure(startTime,"ProcessParserforCPU");
		return connt;
    }
    

    


	public static WebDriver ChromedriverAction() {
		System.setProperty("webdriver.chrome.driver",VariableModule.chromedriver);
		//Create prefs map to store all preferences 
		Map<String, Object> prefs = new HashMap<String, Object>();

		//Put this into prefs map to switch off browser notification
		prefs.put("profile.default_content_setting_values.notifications", 2);

		//Create chrome options to set this prefs
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", prefs);
		if(VariableModule.isGUI.equals("2"))
		{
			options.addArguments("--headless");
		}
		//Now initialize chrome driver with chrome options which will switch off this browser notification on the chrome browser
		WebDriver driver = new ChromeDriver(options);
		
	    
	    //WebDriver driver = new ChromeDriver();
	    return driver;
	}


	
    public static void writing(String wget) {
        try {
            //Whatever the file path is.
        	File WFile = new File(VariableModule.driverlog+"/Output.txt");
        	//File WFile = new File(file_name);
        	FileWriter fw = new FileWriter(WFile,true);
/*            FileOutputStream is = new FileOutputStream(WFile);
            OutputStreamWriter osw = new OutputStreamWriter(is);    
            Writer w = new BufferedWriter(osw);*/
        	
        	if(wget!=null)
        	{
        	fw.write("\n"+wget+"\n");
        	}
            //fw.write(wget);
            //fw.write("\n");
            fw.close();
        } catch (IOException e) {
            System.err.println("Problem writing to the file Output.txt");
        }
    }
    
    
    
    public static void writinginFile(String replaceWith, String newthreshold) {
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader(VariableModule.driverlog+"/Config.txt"));
            String line;
            StringBuffer inputBuffer = new StringBuffer();
            String matchstr = null;
            while ((line = file.readLine()) != null) {
                if (line.contains(replaceWith)) {
                    matchstr=line;
                    
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            String inputStr = inputBuffer.toString();

            file.close();

            //System.out.println("Replace Threshold: \n"+inputStr); // check that it's inputted right

            // this if structure determines whether or not to replace "0" or "1"
            
            //System.out.printf("%.2f",newthreshold);
            //newthreshold = String.format("%.2f");
            if (inputStr.contains(replaceWith)) {
                inputStr = inputStr.replace(matchstr, replaceWith+newthreshold+";"); 
                ActionModule.ConsolPrint("Date is updated with "+newthreshold,"");
                ActionModule.writing("Date Value is updated with "+newthreshold);
            }

            
            // check if the new input is right
            //System.out.println("----------------------------------\n"  + inputStr);

            // write the new String with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream(VariableModule.driverlog+"/Config.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
    
    public static void ConsolPrint(String wget, String testresult) {

    	if(VariableModule.isWindows.equals("1"))
    	{
    	System.out.println(wget+"\n");
    	}
    }
    
	
	public static String[] TokenizerAction(String splitString) //http://crunchify.com/java-stringtokenizer-and-string-split-example/
	{
		
		String delims = "=|,|:";
		//String delims = "[=+]";
		String[] tokens=splitString.split(delims);
/*	    for (int i=0; i< tokens.length; i++){
	      System.out.println("StringTokenizer Output: " +tokens[i]);
	    }*/
	    //System.out.println("StringTokenizer: " +tokens[3]);
	    return tokens;
	}
	
	


}
