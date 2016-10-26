package test;

import static org.testng.AssertJUnit.assertEquals;
import org.apache.http.HttpStatus;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import util.RestUtil;


public abstract class GitHubTest extends BaseTest{
	//abstract so multiple classes can extend it..anything that the child class can reuse or redirect

RestUtil util;
 
@BeforeClass
public void beforeClass()
{
	util = new RestUtil();
	util.getRequest("users/whiteboxhub");//for every api should call its own request how it should 
	
}
@Test
public void testStatusCode()
{
	
	assertEquals(HttpStatus.SC_OK,util.validateStatusCode());
}

@Test
public void testLogin(){
	assertEquals(HttpStatus.SC_OK,util.validateLogin());
	
}
@Test
public void testId(){
	assertEquals(HttpStatus.SC_OK,util.validateLogin());
}
}

