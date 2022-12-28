package com.te.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.blogmanagement.entity.PostComment;

@Repository
public interface PostCommentRepository extends JpaRepository<PostComment, Long> {

}
