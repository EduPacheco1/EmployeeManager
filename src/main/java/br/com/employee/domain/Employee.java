package br.com.employee.domain;

import java.util.UUID;

import br.com.employee.application.api.EmployeeRequest;
import br.com.employee.application.api.EmployeeUpdateRequest;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
@Entity
public class Employee {

	@Id
	private UUID idEmployee;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String fuction;
	
	@Column(nullable = false)
	private Double salary;
	
	@Column(nullable = false)
	private String tel;
	
	@Column(nullable = false)
	private String address;
	
	public Employee(EmployeeRequest employeeRequest) {
		this();
		this.name = employeeRequest.getName();
		this.fuction = employeeRequest.getFuction();
		this.salary = employeeRequest.getSalary();
		this.tel = employeeRequest.getTel();
		this.address = employeeRequest.getAddress();
	}
	
	{
		this.idEmployee = UUID.randomUUID();
	}

	public void update(EmployeeUpdateRequest employeeUpdateRequest) {
		this.name = employeeUpdateRequest.getName();
		this.fuction = employeeUpdateRequest.getFuction();
		this.salary = employeeUpdateRequest.getSalary();
		this.tel = employeeUpdateRequest.getTel();
		this.address = employeeUpdateRequest.getAddress();
		
	}
}
