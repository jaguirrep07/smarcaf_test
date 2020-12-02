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
import co.edu.uniajc.smartcaf.model.Employee;
import co.edu.uniajc.smartcaf.service.EmployeeService;
import co.edu.uniajc.smartcaf.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@Api(value = "Employee", tags = "Employee")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/employee")
	public List<Employee> getAll() throws NoSuchMethodException, ResourceNotFoundException {
		try {
			return employeeService.getAll();
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getById(@PathVariable(value = "id") Integer idEmployee) throws NoSuchMethodException {
		Employee employee = new Employee();
		try {
			Util util = new Util();
			boolean estado = util.isNumeric(idEmployee.toString());
			if (estado == true) {
				employee = employeeService.getById(idEmployee);
				return ResponseEntity.ok().body(employee);
			}

		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
		return ResponseEntity.ok().body(employee);
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PostMapping("/employee")
	public Employee create(@Valid @RequestBody Employee employee) throws NoSuchMethodException {
		try {
			return employeeService.create(employee);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> edit(@PathVariable(value = "id") Integer idEmployee,
			@Valid @RequestBody Employee employeeDetail) throws NoSuchMethodException {
		Employee employee = new Employee();
		try {
			employee = employeeService.edit(idEmployee, employeeDetail);
			return ResponseEntity.ok(employee);
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
	
	@ApiResponses(value = {
	        @ApiResponse(code = 200, message = "OK"),
	        @ApiResponse(code = 404, message = "404 error"),
	        @ApiResponse(code = 500, message = "service error")
	    })
	@DeleteMapping("/employee/{id}")
	public Map<String, Boolean> delete(@PathVariable(value = "id") Integer idEmployee)
			throws ResourceNotFoundException, NoSuchMethodException {
		try {
			employeeService.delete(idEmployee);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		} catch (IndexOutOfBoundsException exp) {
			throw new NoSuchMethodException();
		}
	}
}
