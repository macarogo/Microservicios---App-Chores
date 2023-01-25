package com.technicalTest.springboot.app.users.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
	
	@NotNull(message = "firstName cannot be null")
    @NotBlank(message = "the firstName field is required")
	private String firstName;
	
	@NotNull(message = "lastName cannot be null")
    @NotBlank(message = "the lastName field is required")
	private String lastName;
	
	@NotNull(message = "email cannot be null")
    @NotBlank(message = "the email field is required")
    @Email
	private String email;
	
	@NotNull(message = "password cannot be null")
    @NotBlank(message = "the password field is required")
    @Size(min = 4, message = "password must be at least 4 characters")
	private String password;

	@JsonFormat(shape = Shape.NUMBER, pattern = "yyyy-MM-dd")
	private Date createAt;

}
