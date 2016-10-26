package util;

import java.io.IOException;
import java.text.ParseException;

import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.pojo.GitHubUser;

public class RestUtil {

	HttpUriRequest request;// creating a global variable so that it can be
							// easily accessed

	HttpResponse response;
	private GitHubUser user;// reference variable
	
	
	public GitHubUser getUser() {
		return user;
	}

	public void setUser(GitHubUser user) {
		this.user = user;
	}

	String URI = Configuration.URI;//common uri request

	public void getRequest(String resourceUrn) {

		request = new HttpGet(URI + resourceUrn);
		request.addHeader(HttpHeaders.CONTENT_TYPE, "application/json");

		try {
			this.response = HttpClientBuilder.create().build().execute(request);// passing  the parameter of request to execute method
			// this returns a response..to this.response..referring to the
			// instance variable
			setUser(ResourceUtil.retrieveResource(response,GitHubUser.class));
			
			if (response != null) {
			} else {
				System.out.println("Something went wrong" + response);
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int validateStatusCode() {
		return response.getStatusLine().getStatusCode();
	}
	
	public String validateLogin(){
		return getUser().getLogin();
		
	}
}
