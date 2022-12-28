 package com.te.blogmanagement.service.category;

import java.util.Set;

import com.te.blogmanagement.dto.CategoryDto;
import com.te.blogmanagement.dto.CreateTagDto;
import com.te.blogmanagement.entity.Category;
import com.te.blogmanagement.entity.Tag;


public interface CategoryAndTagInterface {

	public String addNewCategory(CategoryDto categoryDto);
	public String addPostCategory(Long id, CategoryDto categoryDto);
	public Set<Category> getPostCategory(Long id);
	public String createTag(CreateTagDto createTagDto);
	public Set<Tag> getPostTag(Long id);

} 
