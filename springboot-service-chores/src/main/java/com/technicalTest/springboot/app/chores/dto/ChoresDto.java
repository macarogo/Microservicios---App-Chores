package com.technicalTest.springboot.app.chores.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChoresDto {
	
	@NotNull(message = "title cannot be null")
    @NotBlank(message = "thetitle field is required")
	private String title;
	
	@NotNull(message = "content cannot be null")
    @NotBlank(message = "the content field is required")
	private String content;
	
}
