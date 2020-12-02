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
import co.edu.uniajc.smartcaf.model.PhysicalEvaluation;
import co.edu.uniajc.smartcaf.service.PhysicalEvalutionService;
import co.edu.uniajc.smartcaf.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "PhysicalEvaluation", tags = "PhysicalEvaluation")
@RestController
@RequestMapping("/api/v1")
public class PhysicalEvaluationController {

	@Autowired
	private PhysicalEvalutionService physicalEvalutionService;
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/physicalEvaluation")
	public List<PhysicalEvaluation> getAll() throws NoSuchMethodException, ResourceNotFoundException {
		try {
			return physicalEvalutionService.getAll();
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/physicalEvaluation/{id}")
	public ResponseEntity<PhysicalEvaluation> getById(@PathVariable(value = "id") Integer idPhysicalEvaluation) throws NoSuchMethodException {
		PhysicalEvaluation asPhysicalEvaluation = new PhysicalEvaluation();
		try {
			Util util = new Util();
			boolean estado = util.isNumeric(idPhysicalEvaluation.toString());
			if (estado == true) {
				asPhysicalEvaluation = physicalEvalutionService.getById(idPhysicalEvaluation);
				return ResponseEntity.ok().body(asPhysicalEvaluation);
			}

		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
		return ResponseEntity.ok().body(asPhysicalEvaluation);
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PostMapping("/physicalEvaluation")
	public PhysicalEvaluation create(@Valid @RequestBody PhysicalEvaluation physicalEvaluation) throws NoSuchMethodException {
		try {
			return physicalEvalutionService.create(physicalEvaluation);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PutMapping("/physicalEvaluation/{id}")
	public ResponseEntity<PhysicalEvaluation> edit(@PathVariable(value = "id") Integer idPhysicalEvaluation,
			@Valid @RequestBody PhysicalEvaluation physicalEvaluationDetail) throws NoSuchMethodException {
		PhysicalEvaluation physicalEvaluation = new PhysicalEvaluation();
		try {
			physicalEvaluation = physicalEvalutionService.edit(idPhysicalEvaluation, physicalEvaluationDetail);
			return ResponseEntity.ok(physicalEvaluation);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@DeleteMapping("/physicalEvaluation/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Integer idPhysicalEvaluation)
			throws ResourceNotFoundException, NoSuchMethodException {
		try {
			physicalEvalutionService.delete(idPhysicalEvaluation);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
}
