package com.te.blogmanagement.entity;



import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Data
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    @Column(nullable=false,length=50)
	private String firstName;
    @Column(nullable=false,length=50)
	private String middleName;
    @Column(nullable=false,length=50)
	private String lastName;
    @Column(nullable=false,length=15)
	private String mobile;
    @Column(nullable=false,length=50)
	private String email;
    @Column(nullable=false,length=32)
	private String password;
    @DateTimeFormat
	private String registeredAt;
    @DateTimeFormat
	private String lastLogin;
    @Column(nullable=false,length=50)
	private String intro;
    @Column(nullable=false,length=50)
	private String profile;
	
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL)
	private Set<Post> posts;

}
