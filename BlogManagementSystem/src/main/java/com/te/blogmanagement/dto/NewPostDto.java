package com.te.blogmanagement.dto;

import lombok.Data;

@Data
public class NewPostDto {

	private String title;
	private String metaTitle;
	private String slug;// short name given in article during production
	private String summary;
	private String published;
	private String createdAt;
	private String updatedAt;
	private String publishedAt;
	private String content;
	private byte[] data;

}
