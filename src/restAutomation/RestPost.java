package restAutomation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

@SuppressWarnings("deprecation")
public class RestPost {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		
			    @SuppressWarnings("resource")
				HttpClient client = new DefaultHttpClient();
			    HttpPost post = new HttpPost("http://gmail.com");
			    try {
			      List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
			      nameValuePairs.add(new BasicNameValuePair("loginid",
			          "123456789"));
			      post.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			 
			      HttpResponse response = client.execute(post);
			      BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			      String line = "";
			      while ((line = rd.readLine()) != null) {
			        System.out.println(line);
			      }

			    } catch (IOException e) {
			      e.printStackTrace();
			    }
			  }
			} 
			
		