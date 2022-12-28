package com.te.blogmanagement.dto;



import lombok.Data;

@Data
public class PostCommentDto {

	
	private String title;
	private Integer published;
	private String createdAt;
	private String publishedAt;
	private String content;
}
