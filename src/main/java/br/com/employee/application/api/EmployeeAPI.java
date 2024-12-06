package br.com.employee.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.employee.util.MediaType;

@RestController
@RequestMapping("v1/employee")
public interface EmployeeAPI {

	@PostMapping(consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
			     produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@ResponseStatus(code = HttpStatus.CREATED)
	EmployeeResponse save(@RequestBody EmployeeRequest employeeRequest);

	@GetMapping(produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@ResponseStatus(code = HttpStatus.OK)
	List<EmployeeListResponse> getAllEmployees();

	@GetMapping(value = "/{idEmployee}", 
				produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@ResponseStatus(code = HttpStatus.OK)
	EmployeeDetailsResponse detailsEmployee(@PathVariable UUID idEmployee);

	@PatchMapping(value = "/{idEmployee}", 
				 consumes = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML }, 
				 produces = { MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.APPLICATION_YML })
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void update(@PathVariable UUID idEmployee, @RequestBody EmployeeUpdateRequest employeeUpdateRequest);
	
	@DeleteMapping(value = "/{idEmployee}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	void delete(@PathVariable UUID idEmployee);
}
