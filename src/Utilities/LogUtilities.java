package Utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class LogUtilities 
{
	    public static void Log (String logTrace)
	    {
	    	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    	Date curTime = new Date();
	    	System.out.print(dateFormat.format(curTime));
            System.out.printf(": %s\n", logTrace);
	    }

		public static void LogMsg(String text)
		{
			System.out.println(text);
			
	    	DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	    	
	    	Date today = new Date();
	    	System.out.println(dateFormat.format(today));	
		}
}
