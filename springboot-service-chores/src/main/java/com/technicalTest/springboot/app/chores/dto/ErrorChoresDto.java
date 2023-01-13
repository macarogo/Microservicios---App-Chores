package com.technicalTest.springboot.app.chores.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorChoresDto {
	
	private String code;
	private String message;
}
