package util;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class ResourceUtil {

	
	public static <X>X retrieveResource(HttpResponse response,Class<X> cl) throws ParseException
		//X can represent any type of object,string,int,X is anonymous,because our pojo has multiple resources
	//pass a class to it..which has methods supporting it,X here is also anonymous because we dont know
	{
		String json;
		try
		{
			json=EntityUtils.toString(response.getEntity());// json is a string of response
			
			ObjectMapper mapper = new ObjectMapper();//calling an object of mapper ..
			
			return mapper.readValue(json, cl);//passing a json string plus a class which is passed from restutil..
			//mapped the json corresponding to the pojo class...set all the variable using the set type.
			
					
		}
		catch(IOException e){
			e.printStackTrace();
		}
	
		return null;
	}

}
