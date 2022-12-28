package com.te.blogmanagement.dto;

import java.util.Date;

import lombok.Data;

@Data
public class UpdateDto {
	private String title;
	private String metaTitle;
	private String slug;//short name given in article during production
	private String summary;
	private String published;
	private Date createdAt;
	private Date updatedAt;
	private Date publishedAt;
	private String content;

}
