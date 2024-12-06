package br.com.employee.application.api;

import java.util.UUID;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EmployeeResponse {

	private UUID idEmployee;

}
