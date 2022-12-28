package com.te.blogmanagement.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.Post;

@Repository
public interface NewPostRepository extends JpaRepository<Post, Long> {
	


  	

}
