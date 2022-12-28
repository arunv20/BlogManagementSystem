package com.te.blogmanagement.service.category;

import java.util.Set;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.te.blogmanagement.dto.CategoryDto;
import com.te.blogmanagement.dto.CreateTagDto;
import com.te.blogmanagement.entity.Category;
import com.te.blogmanagement.entity.Post;
import com.te.blogmanagement.entity.Tag;
import com.te.blogmanagement.exception.InvalidInputException;
import com.te.blogmanagement.repository.CategoryRepository;
import com.te.blogmanagement.repository.NewPostRepository;
import com.te.blogmanagement.repository.TagRepository;

import java.util.Collections;

@Service
public class CategoryAndServiceImpl implements CategoryAndTagInterface {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private NewPostRepository newPostRepository;

	@Autowired
	private TagRepository tagRepository;
    
	@Override
	public String addNewCategory(CategoryDto categoryDto) {
		Category category = new Category();
		if (categoryDto != null) {
			BeanUtils.copyProperties(categoryDto, category);
			categoryRepository.save(category);
			return category.getTitle();
		} else {
			return null;
		}
	}
    @Override
	public String addPostCategory(Long id, CategoryDto categoryDto) {
		if (categoryRepository.findById(id).isPresent()) {
			return addNewCategory(categoryDto);
		} else {
			return null;
		}
	}
    
    @Override
	public Set<Category> getPostCategory(Long id) {
		Post findById = newPostRepository.findById(id).orElseThrow(()-> new InvalidInputException("Id not found"));
		if (findById != null) {
			return findById.getCategories();
		} else {
			return Collections.emptySet();
		}

	}
    
    @Override
	public String createTag(CreateTagDto createTagDto) {
		Tag tag = new Tag();
		if (createTagDto != null) {
			BeanUtils.copyProperties(createTagDto, tag);
			tagRepository.save(tag);
			return tag.getTitle();
		} else {
			return null;

		}
	}
    
    @Override
	public Set<Tag> getPostTag(Long id) {
		Post byId = newPostRepository.findById(id).orElseThrow(()->  new InvalidInputException("Enter valid post id"));
		if (byId != null) {
			return byId.getTags();
		} else {
			return Collections.emptySet();
		}

	}

}
