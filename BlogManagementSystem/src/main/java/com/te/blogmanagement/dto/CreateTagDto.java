package com.te.blogmanagement.dto;


import lombok.Data;

@Data
public class CreateTagDto {
	private String title;
	private String metaData;
	private String slug;
	private String content;

}
