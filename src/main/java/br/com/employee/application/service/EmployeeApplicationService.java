package br.com.employee.application.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.employee.application.api.EmployeeDetailsResponse;
import br.com.employee.application.api.EmployeeListResponse;
import br.com.employee.application.api.EmployeeRequest;
import br.com.employee.application.api.EmployeeResponse;
import br.com.employee.application.api.EmployeeUpdateRequest;
import br.com.employee.domain.Employee;
import br.com.employee.infra.EmployeeInfraRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class EmployeeApplicationService implements EmployeeService {

	private final EmployeeInfraRepository employeeRepository;

	@Override
	public EmployeeResponse save(EmployeeRequest employeeRequest) {
		Employee employee = employeeRepository.save(new Employee(employeeRequest));
		return EmployeeResponse.builder().idEmployee(employee.getIdEmployee()).build();
	}

	@Override
	public List<EmployeeListResponse> list() {
		List<Employee> list = employeeRepository.list();
		return EmployeeListResponse.converte(list);
	}

	@Override
	public EmployeeDetailsResponse details(UUID idEmployee) {
		Employee details = employeeRepository.details(idEmployee);
		return new EmployeeDetailsResponse(details);
	}

	@Override
	public void update(UUID idEmployee, EmployeeUpdateRequest employeeUpdateRequest) {
		Employee employee = employeeRepository.details(idEmployee);
		employee.update(employeeUpdateRequest);
		employeeRepository.save(employee);
	}

	@Override
	public void delete(UUID idEmployee) {
		Employee employee = employeeRepository.details(idEmployee);
		employeeRepository.delete(employee);
	}

}
