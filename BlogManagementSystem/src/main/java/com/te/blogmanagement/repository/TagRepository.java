package com.te.blogmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.te.blogmanagement.entity.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {

}
