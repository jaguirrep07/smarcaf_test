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
import co.edu.uniajc.smartcaf.model.Assistance;
import co.edu.uniajc.smartcaf.service.AssistanceService;
import co.edu.uniajc.smartcaf.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "Assistance", tags = "Assistance")
@RestController
@RequestMapping("/api/v1")
public class AssistanceController {

	@Autowired
	private AssistanceService assistanceService;
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/assistance")
	public List<Assistance> getAll() throws NoSuchMethodException, ResourceNotFoundException {
		try {
			return assistanceService.getAll();
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/assistance/{id}")
	public ResponseEntity<Assistance> getById(@PathVariable(value = "id") Integer idAssistance) throws NoSuchMethodException {
		Assistance assistance = new Assistance();
		try {
			Util util = new Util();
			boolean estado = util.isNumeric(idAssistance.toString());
			if (estado == true) {
				assistance = assistanceService.getById(idAssistance);
				return ResponseEntity.ok().body(assistance);
			}

		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
		return ResponseEntity.ok().body(assistance);
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PostMapping("/assistance")
	public Assistance create(@Valid @RequestBody Assistance assistance) throws NoSuchMethodException {
		try {
			return assistanceService.create(assistance);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PutMapping("/assistance/{id}")
	public ResponseEntity<Assistance> edit(@PathVariable(value = "id") Integer idAssistance,
			@Valid @RequestBody Assistance assistanceDetail) throws NoSuchMethodException {
		Assistance usuario = new Assistance();
		try {
			usuario = assistanceService.edit(idAssistance, assistanceDetail);
			return ResponseEntity.ok(usuario);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@DeleteMapping("/assistance/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Integer idAssistance)
			throws ResourceNotFoundException, NoSuchMethodException {
		try {
			assistanceService.delete(idAssistance);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
}
