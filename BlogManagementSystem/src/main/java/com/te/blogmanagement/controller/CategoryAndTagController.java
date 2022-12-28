package com.te.blogmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.te.blogmanagement.dto.CategoryDto;
import com.te.blogmanagement.dto.CreateTagDto;
import com.te.blogmanagement.entity.Category;
import com.te.blogmanagement.responce.AppResponseCategoryTag;
import com.te.blogmanagement.service.category.CategoryAndServiceImpl;

@RestController
@RequestMapping("/category")
public class CategoryAndTagController {

	@Autowired
	private AppResponseCategoryTag appResponseCategoryTag;

	@Autowired
	private CategoryAndServiceImpl categoryAndServiceImpl;

	@PostMapping("/addNewCategory")
	public ResponseEntity<AppResponseCategoryTag> addNewCategory(@RequestBody CategoryDto categoryDto) {
		if (categoryAndServiceImpl.addNewCategory(categoryDto) != null) {
			appResponseCategoryTag.setError(false);
			appResponseCategoryTag.setMessage("New Category Added");
			appResponseCategoryTag.setStatus(200);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.ACCEPTED);
		} else {
			appResponseCategoryTag.setError(true);
			appResponseCategoryTag.setMessage("Cant process the output");
			appResponseCategoryTag.setStatus(403);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/addPostCategory/{id}")
	public ResponseEntity<AppResponseCategoryTag> addPostCategory(@PathVariable Long id,
			@RequestBody CategoryDto categoryDto) {
		if (categoryAndServiceImpl.addPostCategory(id, categoryDto) != null) {
			appResponseCategoryTag.setError(false);
			appResponseCategoryTag.setMessage("New Category Added");
			appResponseCategoryTag.setStatus(200);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.ACCEPTED);
		} else {
			appResponseCategoryTag.setError(true);
			appResponseCategoryTag.setMessage("Enter Valid id");
			appResponseCategoryTag.setStatus(404);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.BAD_REQUEST);

		}
	}

	@GetMapping("/getCategoryforPost/{id}")
	public ResponseEntity<AppResponseCategoryTag> getPostCategory(@PathVariable Long id) {
		if (categoryAndServiceImpl.getPostCategory(id) != null) {
			appResponseCategoryTag.setError(false);
			appResponseCategoryTag.setMessage("Here is your Post Category");
			appResponseCategoryTag.setStatus(202);
			appResponseCategoryTag.setData(categoryAndServiceImpl.getPostCategory(id));
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.ACCEPTED);
		} else {
			appResponseCategoryTag.setError(true);
			appResponseCategoryTag.setMessage("Post Catergory should be added to ID");
			appResponseCategoryTag.setStatus(404);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.BAD_REQUEST);

		}
	}
	
	@PostMapping("/createTag")
	public ResponseEntity<AppResponseCategoryTag> createTag(CreateTagDto createTagDto) {
		if (categoryAndServiceImpl.createTag(createTagDto) != null) {
			appResponseCategoryTag.setError(false);
			appResponseCategoryTag.setMessage("Tag created successfully");
			appResponseCategoryTag.setStatus(200);
			appResponseCategoryTag.setData(categoryAndServiceImpl.createTag(createTagDto));
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.ACCEPTED);
		} else {
			appResponseCategoryTag.setError(true);
			appResponseCategoryTag.setMessage("Please Enter valid input");
			appResponseCategoryTag.setStatus(404);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.BAD_REQUEST);

		}
	}
	@GetMapping("/getPostTag/{id}")
	public ResponseEntity<AppResponseCategoryTag> getPostTag(@PathVariable Long id) {
		if (categoryAndServiceImpl.getPostTag(id) != null) {
			appResponseCategoryTag.setError(false);
			appResponseCategoryTag.setMessage("Here is your Post tag");
			appResponseCategoryTag.setStatus(202);
			appResponseCategoryTag.setData(categoryAndServiceImpl.getPostTag(id));
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.ACCEPTED);
		} else {
			appResponseCategoryTag.setError(true);
			appResponseCategoryTag.setMessage("please Enter valid post id ");
			appResponseCategoryTag.setStatus(404);
			return new ResponseEntity<>(appResponseCategoryTag, HttpStatus.BAD_REQUEST);

		}
	}
	

}
