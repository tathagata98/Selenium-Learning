package seleniumpreparation;

import java.util.Date;
public class DateUtils {
	public static String gettimestamp()
	{
	Date date=new Date();
	return date.toString().replaceAll(":", "_").replaceAll(" ", "_") ; 
	}

}
