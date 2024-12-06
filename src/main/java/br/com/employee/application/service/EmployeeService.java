package br.com.employee.application.service;

import java.util.List;
import java.util.UUID;

import br.com.employee.application.api.EmployeeDetailsResponse;
import br.com.employee.application.api.EmployeeListResponse;
import br.com.employee.application.api.EmployeeRequest;
import br.com.employee.application.api.EmployeeResponse;
import br.com.employee.application.api.EmployeeUpdateRequest;

public interface EmployeeService {

	EmployeeResponse save(EmployeeRequest employeeRequest);

	List<EmployeeListResponse> list();

	EmployeeDetailsResponse details(UUID idEmployee);

	void update(UUID idEmployee, EmployeeUpdateRequest employeeUpdateRequest);

	void delete(UUID idEmployee);

}
