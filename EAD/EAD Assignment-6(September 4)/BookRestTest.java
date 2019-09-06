package com.metacuberest.restdemo;
import static io.restassured.RestAssured.get;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;


import io.restassured.response.Response;


import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

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