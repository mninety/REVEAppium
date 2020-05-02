package Starting;

import org.apache.log4j.Logger;


import MyAction.ActionModule;
import MyVariable.VariableModule;

public class MySQLPINGModule extends Thread {
	static Logger logMySQLPINGModule = Logger.getLogger(MySQLPINGModule.class.getName());
	 //int sum=0;
	@SuppressWarnings("null")
	@Override
    public void run() {
    	while(true) {
			try {
				VariableModule.Post = VariableModule.readVariable("Post",1);
				VariableModule.PostID = VariableModule.readVariable("PostID",1);
				if(!VariableModule.Post.equals(""))
				{
					String hourTime=ActionModule.getCurrentHour();
					System.out.println("Current Hour: "+hourTime);
					logMySQLPINGModule.debug("Current Hour: "+hourTime);
					if(VariableModule.isSchedule.equals("0"))
					{
						System.out.println("Instant Posting");
						PostAction();
					}
					else
					{
						System.out.println("Schedule Posting");
						if(VariableModule.ScheduleDate.equals(hourTime))
						{
							PostAction();
						}
						else
						{
							try {
								Thread.sleep(10000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						
					}
					

				}

				//Thread.sleep(300000);

			} catch (Exception e1) {
				// TODO Auto-generated catch block
				logMySQLPINGModule.debug("MySQL Connection Exception3: "+e1);
			}

			try {
				Thread.sleep(300000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	}
    }
    
	public static void PostAction()
	{
		System.out.println("Post: "+VariableModule.Post);
		String postID="";
		

		
		if(VariableModule.PostID.equals(""))
		{
			postID=Integer.toString(1);
		}
		else
		{
			postID=Integer.toString((Integer.parseInt(VariableModule.PostID)+1));
		}
		
		@SuppressWarnings("unused")
		boolean flag;
		String[] postArray = VariableModule.Post.split(":");
		
		System.out.println("Sura: "+postArray[0]);
		System.out.println("Ayat: "+postArray[1]);
		String[] ayatArray = null;
		if(postArray[1].indexOf("-") != -1)
		{
			flag=true;
			ayatArray = postArray[1].split("-");
		}
		else
		{
			flag=false;
			//ayatArray=postArray[1];
		}
		System.out.println("Flag: "+flag);
		if(flag)
		{
			
			String checkHistory="select * from facebookhistory where fhSuraID="+postArray[0]+" and fhSuraAyatID between "+ayatArray[0]+" and "+ayatArray[1];
			System.out.println("Select SQL: "+checkHistory);
			String hisData=ActionModule.MysqlConnectionAction(checkHistory, VariableModule.Ownconn, ",");
			if(hisData.equals(""))
			{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID between "+ayatArray[0]+" and "+ayatArray[1];
				System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, VariableModule.Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], VariableModule.Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				
				
				
				for(int i=Integer.parseInt(ayatArray[0]);i<=Integer.parseInt(ayatArray[1]);i++)
				{
					ActionModule.MysqlFBHInsertData(Integer.parseInt(postArray[0]),i,VariableModule.FBuserName,Integer.parseInt(postID),VariableModule.Ownconn);
				}
				ActionModule.writinginFile("Post=","");
				ActionModule.writinginFile("Tracking=",VariableModule.Post);
				ActionModule.writinginFile("PostID=",postID);
			}
			else
			{
				System.out.println("Already Posted");
			}
		}
		else
		{
			
			String checkHistory="select * from facebookhistory where fhSuraID="+postArray[0]+" and fhSuraAyatID="+postArray[1];
			System.out.println("Select SQL: "+checkHistory);
			String hisData=ActionModule.MysqlConnectionAction(checkHistory, VariableModule.Ownconn, ",");
			if(hisData.equals(""))
			{
			
				String Myquery="select atAyatMeaning_bl from ayat where atSuraID="+postArray[0]+" and atSuraAyatID="+postArray[1];
				System.out.println("Select SQL: "+Myquery);
				String dbData=ActionModule.MysqlConnectionAction(Myquery, VariableModule.Ownconn, ",");
				dbData=dbData.substring(0, dbData.length()-1);
				System.out.println("Data: "+dbData);
				String SuraName=ActionModule.MysqlConnectionAction("select snName_bl from suraname where snSuraID="+postArray[0], VariableModule.Ownconn, ",");
				SuraName=SuraName.substring(0, SuraName.length()-1);
				
				
				ActionModule.MysqlFBHInsertData(Integer.parseInt(postArray[0]),Integer.parseInt(postArray[1]),VariableModule.FBuserName,Integer.parseInt(postID),VariableModule.Ownconn);
				ActionModule.writinginFile("Post=","");
				ActionModule.writinginFile("Tracking=",VariableModule.Post);
				ActionModule.writinginFile("PostID=",postID);
			}
			else
			{
				System.out.println("Already Posted");
			}
		}
	}
}