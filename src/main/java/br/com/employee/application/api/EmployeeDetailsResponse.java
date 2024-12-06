package br.com.employee.application.api;

import java.util.UUID;

import br.com.employee.domain.Employee;
import lombok.Value;

@Value
public class EmployeeDetailsResponse {
	
	
	private UUID idEmployee;
	private String name;
	private String fuction;
	private Double salary;
	private String tel;
	private String address;
	
	public EmployeeDetailsResponse(Employee detailsEmployee) {
		this.idEmployee = detailsEmployee.getIdEmployee();
		this.name = detailsEmployee.getName();
		this.fuction = detailsEmployee.getFuction();
		this.salary = detailsEmployee.getSalary();
		this.tel = detailsEmployee.getTel();
		this.address = detailsEmployee.getAddress();
	}
}
