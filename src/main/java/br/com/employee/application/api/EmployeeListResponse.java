package br.com.employee.application.api;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import br.com.employee.domain.Employee;
import lombok.Value;

@Value
public class EmployeeListResponse {

	private UUID idEmployee;
	private String name;
	private String fuction;
	private Double salary;
	private String tel;
	private String address;;
	
	public static List<EmployeeListResponse> converte(List<Employee> employees){
		return employees.stream().map(EmployeeListResponse::new).collect(Collectors.toList());
	}
	
	public EmployeeListResponse(Employee employee) {
		this.idEmployee = employee.getIdEmployee();
		this.name = employee.getName();
		this.fuction = employee.getFuction();
		this.salary = employee.getSalary();
		this.tel = employee.getTel();
		this.address = employee.getAddress();
	}
}
