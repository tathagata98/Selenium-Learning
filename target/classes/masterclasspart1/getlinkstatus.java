package masterclasspart1;

import java.net.HttpURLConnection;
import java.net.URL;

public class getlinkstatus
{
	static int invalidlink;
   
	public static void verifyLink(String linkstring)
	{
		try {
			URL url=new URL(linkstring);
			//Open HTTP connection
			HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
			
			//Define Timeout
			urlConnect.setConnectTimeout(5000);
			//Hit URL
			urlConnect.connect();
			if(urlConnect.getResponseCode()==200)
			{
				
			}
			else
			{
				System.out.println(linkstring + " : " + urlConnect.getResponseMessage() + " : " + urlConnect.HTTP_NOT_FOUND);
				invalidlink++;
			}
			
		}
		catch (Exception e) 
		{
		
			//e.printStackTrace();
		}
		
	}
	public static void getInvalidLink()
	{
		System.out.println("total no of broken links are : " +invalidlink);
	}
}

		
