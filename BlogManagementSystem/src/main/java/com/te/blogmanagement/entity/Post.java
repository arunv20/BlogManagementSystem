package com.te.blogmanagement.entity;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor 
@Getter
@Setter
@ToString
@Entity
public class Post {

	@Id
	@SequenceGenerator( name = "id" ,  allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(nullable=false,length=75)
	private String title;
	@Column(length=100)
	private String metaTitle;
	@Column(nullable=false,length=100)
	private String slug;
	private String summary;
	private String published; 
	@Lob
	@Column(name = "data", columnDefinition = "BLOB")
	private byte[] data;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date createdAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedAt;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date publishedAt;
	private String content;
	
	
	@ManyToOne
	@JoinColumn(name ="author_id")
	private User user;
	

	@OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "post_id")
	private List<PostComment> list;

	@OneToMany(targetEntity = PostMeta.class, cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name ="postMeta_fk")
	private List<PostMeta> postMetas= new ArrayList<>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(   
			joinColumns = @JoinColumn(name ="postId") ,
	inverseJoinColumns  = @JoinColumn(name ="tagId")
	)
	private Set<Tag> tags;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			joinColumns =  @JoinColumn(name ="post_id") ,
	inverseJoinColumns  = @JoinColumn(name ="category_id")
	)
	private Set<Category> categories;

}
