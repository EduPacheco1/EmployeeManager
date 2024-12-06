package br.com.employee.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.employee.domain.Employee;

public interface EmployeeSpringDataJpaRepository extends JpaRepository<Employee, UUID> {

}
