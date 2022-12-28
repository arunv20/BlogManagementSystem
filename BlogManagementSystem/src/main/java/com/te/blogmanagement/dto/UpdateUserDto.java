package com.te.blogmanagement.dto;

import lombok.Data;

@Data
public class UpdateUserDto {
	private String firstName;
	private String middleName;
	private String lastName;
	private String mobile;
	private String lastLogin;
	private String intro;
	private String profile;

}
