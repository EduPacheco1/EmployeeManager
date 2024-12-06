package br.com.employee.application.api;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmployeeRequest {
	
	private String name;
	private String fuction;
	private Double salary;
	private String tel;
	private String address;
}
