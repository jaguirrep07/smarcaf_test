package co.edu.uniajc.smartcaf.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniajc.smartcaf.exception.ResourceNotFoundException;
import co.edu.uniajc.smartcaf.model.Client;
import co.edu.uniajc.smartcaf.service.ClientService;
import co.edu.uniajc.smartcaf.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "Client", tags = "Client")
@RestController
@RequestMapping("/api/v1")
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/client")
	public List<Client> getAll() throws NoSuchMethodException, ResourceNotFoundException {
		try {
			return clientService.getAll();
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getById(@PathVariable(value = "id") Integer idClient) throws NoSuchMethodException {
		Client client = new Client();
		try {
			Util util = new Util();
			boolean estado = util.isNumeric(idClient.toString());
			if (estado == true) {
				client = clientService.getById(idClient);
				return ResponseEntity.ok().body(client);
			}

		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
		return ResponseEntity.ok().body(client);
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PostMapping("/client")
	public Client create(@Valid @RequestBody Client client) throws NoSuchMethodException {
		try {
			return clientService.create(client);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PutMapping("/client/{id}")
	public ResponseEntity<Client> edit(@PathVariable(value = "id") Integer idClient,
			@Valid @RequestBody Client clientDetail) throws NoSuchMethodException {
		Client client = new Client();
		try {
			client = clientService.edit(idClient, clientDetail);
			return ResponseEntity.ok(client);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@DeleteMapping("/client/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Integer idClient)
			throws ResourceNotFoundException, NoSuchMethodException {
		try {
			clientService.delete(idClient);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
}
