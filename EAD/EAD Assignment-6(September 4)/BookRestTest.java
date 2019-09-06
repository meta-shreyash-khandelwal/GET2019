package com.metacuberest.restdemo;
package com.metacuberest.restdemo;
import java.io.IOException;
import static com.jayway.restassured.RestAssured.given;
import org.junit.Test;
import junit.framework.*;
import static com.jayway.restassured.RestAssured.expect;
import org.junit.Before;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import org.junit.*;
import org.apache.catalina.HttpResponse;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Before;
import org.junit.runner.RunWith;
import static org.hamcrest.Matchers.equalTo;
import com.sun.grizzly.util.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.junit.Ignore;

import static org.junit.Assert.assertEquals;

public class BookRestTest {
	  @BeforeClass
	    public void init() {
	        RestAssured.baseURI = "http://localhost";
	        RestAssured.port = 8081;
	    }

	   
	    @Test
	    public void testUserFetchesSuccess() {
	        get("/restdemo/webresources/books/displaytitle/Concepts")
	        .then()
	        .body("publisher", equalTo("TataMcHill"))
	        .body("writer", equalTo("H.k. Agam"))
	        .body("publishedYear", equalTo("1976"));
	    }
	    @Test
	    public void testUserFetchesSuccess1() {
	        get("/restdemo/webresources/books/displaytitle/Dit")
	        .then()
	        .body("publisher", equalTo("SChand"))
	        .body("writer", equalTo("Maria"))
	        .body("publishedYear", equalTo("2000"));
	    }
	}
