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

import co.edu.uniajc.smartcaf.model.Client;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClientControllerTest {

	@LocalServerPort
	int randomServerPort;
	
	String url = "http://localhost:";

	@Test
	public void testGetClients() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/client";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testGetClientById() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/client/"+ "1";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.GET,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}

	@Test
	public void testPostClient() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/client";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		Client client = new Client();
		client.setTipoIdentificacion("sample");
		client.setNombres("sample");
		client.setApellidos("sample");
		client.setTelefono("sample");
		client.setCorreo("sample");
		client.setEstado("sample");
		client.setMatricula("sample");
		HttpEntity<Client> request = new HttpEntity<>(client,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.POST,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testPutClient() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/client/" + "5";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		Client client = new Client();
		client.setTipoIdentificacion("sample");
		client.setNombres("sample");
		client.setApellidos("sample");
		client.setTelefono("sample");
		client.setCorreo("sample");
		client.setEstado("sample");
		client.setMatricula("sample");
		HttpEntity<Client> request = new HttpEntity<>(client,headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.PUT,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}
	
	@Test
	public void testDeleteClient() throws URISyntaxException {
		RestTemplate restTemplate = new RestTemplate();
		final String baseUrl = url + randomServerPort + "/smartcaf/api/v1/client/" + "6";
		URI uri = new URI(baseUrl);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("Authorization","Bearer " +"04e449a1-3d7e-45e2-beaf-5654d73bb052");
		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(uri,HttpMethod.DELETE,request,String.class);
	    assertEquals(200, result.getStatusCodeValue());
	}

}
