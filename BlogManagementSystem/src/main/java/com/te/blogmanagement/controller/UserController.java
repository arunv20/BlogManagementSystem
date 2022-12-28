package com.te.blogmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.te.blogmanagement.dto.NewPostDto;
import com.te.blogmanagement.dto.PostCommentDto;
import com.te.blogmanagement.dto.UpdateDto;
import com.te.blogmanagement.dto.UpdateUserDto;
import com.te.blogmanagement.dto.UserRegistrationDto;


import com.te.blogmanagement.responce.AppResponse;
import com.te.blogmanagement.service.ServiceImpl;

@RequestMapping("/api")
@RestController
public class UserController {
	@Autowired
	private ServiceImpl serviceImpl;
	@Autowired
	private AppResponse response;

	@PostMapping("/registerUser")
	public ResponseEntity<AppResponse> userRegistration(@RequestBody  UserRegistrationDto registrationDto) {
		if (serviceImpl.userRegistration(registrationDto) != null) {
			response.setError(false);
			response.setMsg("User Registered Successfully");
			response.setStatus(200);
			response.setData(registrationDto.getFirstName());
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("Please Enter Valid Crendentials");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<AppResponse> deleteUser(@RequestParam Long id) {
		if (serviceImpl.deletePost(id)) {
			response.setError(false);
			response.setMsg("User deleted Successfully");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("Please Enter Valid Crendentials");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/updateUser/{id}")
	public ResponseEntity<AppResponse> updateUser(@RequestParam Long id,@RequestBody UpdateUserDto updateUserDto) {
		if (serviceImpl.updateUser(id, updateUserDto)!=null) {
			response.setError(false);
			response.setMsg("User deleted Successfully");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("Enter Valid Input");
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("/savePost/{Id}")
	public ResponseEntity<AppResponse> saveNewPost(@RequestParam Long id, @RequestBody NewPostDto newPostDto) {
		if (serviceImpl.saveNewPost(newPostDto) != null) {
			response.setError(false);
			response.setMsg("Blog saved successfully");
			response.setStatus(200);
			response.setData(newPostDto.getTitle());
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("Unsuccessful insertion");
			response.setStatus(400);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PostMapping("/postComment")
	public ResponseEntity<AppResponse> postComment(PostCommentDto commentDto) {
		if (serviceImpl.postComment(commentDto) != null) {
			response.setError(false);
			response.setMsg("Comment Posted successfully");
			response.setStatus(200);
			response.setData(commentDto);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("Unsuccessful insertion");
			response.setStatus(402);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}
	
	@DeleteMapping("/deleteComment/{postId}/{commentId}")
	public ResponseEntity<AppResponse> deleteComment(@RequestParam Long postId,@RequestParam Long commentId) {
		if (serviceImpl.deleteComment(postId, commentId)) {
			response.setError(false);
			response.setMsg("Comment Deleted Successfully");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("id's are incorrect");
			response.setStatus(402);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}
	

	@GetMapping("/getPost")
	public ResponseEntity<AppResponse> getPost() {
		if (serviceImpl.getPost() != null) {
			response.setError(false);
			response.setMsg("here is your blog");
			response.setStatus(200);
			response.setData(serviceImpl.getPost());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("Input Invalid Error");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<AppResponse> updatePost(@PathVariable Long id, @RequestBody UpdateDto updateDto) {
		if (serviceImpl.updatePost(id, updateDto) != null) {
			response.setError(false);
			response.setStatus(200);
			response.setMsg("Post Updated successfully");
			response.setData(updateDto.getTitle());
			return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
		} else {
			response.setError(true);
			response.setMsg("Please give correct data");
			response.setStatus(400);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AppResponse> deletePost(@PathVariable Long id) {
		if (serviceImpl.deletePost(id)) {
			response.setError(false);
			response.setMsg("Data Deleted Successfully");
			response.setStatus(200);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setMsg("Post Not found");
			response.setStatus(400);
			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}
	}
	


	

}
