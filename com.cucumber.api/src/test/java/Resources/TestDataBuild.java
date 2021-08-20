package Resources;

import java.util.ArrayList;

import Pojos.GoogleAPIJson;
import Pojos.Location;

public class TestDataBuild {

	
	public static GoogleAPIJson addPlacePayLoad(String name, String language)
	{
		GoogleAPIJson gp = new GoogleAPIJson();
		  gp.setAccuracy("50");
		  gp.setAddress("test");
		  gp.setLanguage(language);
		  gp.setName(name);
		  gp.setPhone_number("101-200-230");
		  gp.setWebsite("http://test.com");
		  Location lp = new Location();
		  lp.setLat("101");
		  lp.setLng("202");
		  gp.setLocation(lp);
		  ArrayList<String> aList = new ArrayList<String>();
		  aList.add("shoe park");
		  aList.add("shop");
		  gp.setTypes(aList);
		  
		  return gp;
		  
	}
	
	public static String deletePlacePayLoad(String place_id)
	{
		
		    return "{\r\n"
		    		+ "    \"place_id\":\""+place_id+"\"  	\r\n"
		    		+ "} \r\n"
		    		+ "";
}
}

