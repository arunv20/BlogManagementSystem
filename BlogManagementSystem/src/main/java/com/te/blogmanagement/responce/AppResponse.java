package com.te.blogmanagement.responce;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class AppResponse {
	private boolean error;
	private int status;
	private String msg;
	private Object data;

}
