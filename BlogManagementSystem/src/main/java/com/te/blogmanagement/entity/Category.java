package com.te.blogmanagement.entity;


import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	
	@Column(nullable=false,length=75)
	private String title;
	@Column(nullable=false,length=100)
	private String metaTitle;
	@Column(nullable=false,length=100)
	private String slug;
	private String content;

	@ManyToMany(mappedBy = "categories")
	private Set<Post> postCat;
}