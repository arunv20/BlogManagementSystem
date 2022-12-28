package com.te.blogmanagement.dto;

import org.springframework.format.annotation.DateTimeFormat;


import lombok.Data;
@Data
public class UserRegistrationDto {

	private String firstName;

	private String middleName;

	private String lastName;

	private String mobile;

	private String email;

	private String password;
	@DateTimeFormat
	private String registeredAt;
	@DateTimeFormat
	private String lastLogin;

	private String intro;

	private String profile;

}
