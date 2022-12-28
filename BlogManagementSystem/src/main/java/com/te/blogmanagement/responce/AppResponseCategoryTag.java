package com.te.blogmanagement.responce;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AppResponseCategoryTag {
	private boolean error;
	private String message;
	private Integer status;
	private Object data;
	

}
