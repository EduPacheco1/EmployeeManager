package br.com.employee.infra;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import br.com.employee.application.repository.EmployeeRepository;
import br.com.employee.domain.Employee;
import br.com.employee.handler.ApiExceptions;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class EmployeeInfraRepository implements EmployeeRepository {

	private final EmployeeSpringDataJpaRepository employeeSpringDataJpaRepository;

	@Override
	public Employee save(Employee employee) {
		employeeSpringDataJpaRepository.save(employee);
		return employee;
	}

	@Override
	public List<Employee> list() {
		List<Employee> list = employeeSpringDataJpaRepository.findAll();
		return list;
	}

	@Override
	public Employee details(UUID idEmployee) {
		Employee detailsEmployeeId = employeeSpringDataJpaRepository.findById(idEmployee)
				.orElseThrow(() -> ApiExceptions.build(HttpStatus.NOT_FOUND, "Employee not found! Check ID!"));
		return detailsEmployeeId;
	}

	public void delete(Employee employee) {
		employeeSpringDataJpaRepository.delete(employee);	
	}
}
