package Starting;

import java.sql.Connection;

import org.apache.log4j.Logger;


import MyAction.ActionModule;
import MyVariable.VariableModule;


public class MyAppium {
	static Logger logAppium = Logger.getLogger(MyAppium.class.getName());
	public static void main(String[] args) {
		logAppium.debug("Appium Module is going to start");

		VariableModule.StartModule();
		
	}

}
