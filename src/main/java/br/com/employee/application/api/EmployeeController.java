package br.com.employee.application.api;

import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import br.com.employee.application.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@Tag(name = "Employee Controller", description = "Endpoints for Employee Management")
public class EmployeeController implements EmployeeAPI {

	private final EmployeeService employeeService;

	@Override
	@Operation(summary = "Save a new employee", description = "Creates a new employee")
	public EmployeeResponse save(EmployeeRequest employeeRequest) {
		EmployeeResponse save = employeeService.save(employeeRequest);
		return save;
	}

	@Override
	@Operation(summary = "Retrieve all employees", description = "Fetches a list of all registered employees")
	public List<EmployeeListResponse> getAllEmployees() {
		List<EmployeeListResponse> list = employeeService.list();
		return list;
	}

	@Override
	@Operation(summary = "Get employee details", description = "Retrieves detailed information about a specific employee identified by UUID")
	public EmployeeDetailsResponse detailsEmployee(UUID idEmployee) {
		EmployeeDetailsResponse details = employeeService.details(idEmployee);
		return details;
	}

	@Override
	@Operation(summary = "Update employee details", description = "Update Employee data")
	public void update(UUID idEmployee, EmployeeUpdateRequest employeeUpdateRequest) {
		employeeService.update(idEmployee, employeeUpdateRequest);
		
	}

	@Override
	@Operation(summary = "Delete employee", description = "Delete Employee data")
	public void delete(UUID idEmployee) {
		employeeService.delete(idEmployee);
		
	}

}
