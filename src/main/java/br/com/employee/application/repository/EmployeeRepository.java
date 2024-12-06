package br.com.employee.application.repository;

import java.util.List;
import java.util.UUID;

import br.com.employee.domain.Employee;

public interface EmployeeRepository  {

	Employee save(Employee employee);

	List<Employee> list();

	Employee details(UUID idEmployee);

}
