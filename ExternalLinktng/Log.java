package ExternalLinktng;

import org.apache.log4j.Logger;

public class Log {

 //Initialize Log4j logs
	static String spce = "";
	 private static Logger Log = Logger.getLogger(Log.class.getName());//

// This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

public static void startTestCase(String sTestCaseName, String sMethodName){

	Log.info("********************************************************************************************************************************************************************************************************************");
	
	Log.info("         "+sTestCaseName+" "+spce+" "+ sMethodName+"  ");

	Log.info("********************************************************************************************************************************************************************************************************************");

	

	}

	//This is to print log for the ending of the test case

public static void endTestCase(String sTestCaseName, String sMethodName){

	Log.info("XXXXXXXXXXXXXXXXXXXXXXX             "+"-E---N---D-"+"             XXXXXXXXXXXXXXXXXXXXXX");

	Log.info("X");

	Log.info("X");

	Log.info("X");

	Log.info("X");

	}


//This print to server response

public static void Server_Response(String serverres){

	Log.info("Server Response =>   "+serverres);

	}

//This print to client response
public static void Client_Response(String clientres){

	Log.info("Client Response =>   "+clientres);

	}
	// Need to create these methods, so that they can be called  

public static void info(String message) {

		Log.info(message);

		}

public static void warn(String message) {

   Log.warn(message);

	}

public static void error(String message) {

   Log.error(message);

	}

public static void fatal(String message) {

   Log.fatal(message);

	}

public static void debug(String message) {

   Log.debug(message);

	}





}