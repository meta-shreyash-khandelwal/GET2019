package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class EmailConfigurationTest {

	@Autowired
	private MockMvc mvc;

	@Test
	public void testShouldReturnStringWhenSearchedByGet1() throws Exception {
		this.mvc.perform(get("/email")).andExpect(status().isOk()).andExpect(content().string("Writing Mail Contents"));
	}
	@Test
	public void testShouldReturnStringWhenSearchedByGet2() throws Exception {
		this.mvc.perform(get("/email")).andExpect(status().isOk()).andExpect(content().string("Sending SMTP Mail"));
	}
}
