package co.edu.uniajc.smartcaf.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import co.edu.uniajc.smartcaf.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserControllerTest {

	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";

	@Test
	public void testGetUsers() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/user";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	    //assertEquals(true, result.getBody().contains("employeeList"));
	}
	
	@Test
	public void testGetUserById() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/user/"+ "1";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	    //assertEquals(true, result.getBody().contains("employeeList"));
	}

	@Test
	public void testPostUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/user";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		User user = new User();
		user.setNickname("sample");
		user.setPassword("sample");
		user.setToken("1");
		HttpEntity<User> request = new HttpEntity<>(user,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.POST,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	    //assertEquals(true, result.getBody().contains("employeeList"));
	}
	
	@Test
	public void testPutUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/user/" + "5";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		User user = new User();
		user.setNickname("sample-edit");
		user.setPassword("sample-edit");
		user.setToken("2");
		HttpEntity<User> request = new HttpEntity<>(user,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.PUT,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	    //assertEquals(true, result.getBody().contains("employeeList"));
	}
	
	@Test
	public void testDeleteUser() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/user/" + "6";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	    //assertEquals(true, result.getBody().contains("employeeList"));
	}

}
