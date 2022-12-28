package com.te.blogmanagement.service;

import java.util.List;

import com.te.blogmanagement.dto.NewPostDto;
import com.te.blogmanagement.dto.PostCommentDto;
import com.te.blogmanagement.dto.UpdateDto;
import com.te.blogmanagement.dto.UpdateUserDto;
import com.te.blogmanagement.dto.UserRegistrationDto;
import com.te.blogmanagement.entity.Post;

public interface ServiceInterface {
	public String userRegistration(UserRegistrationDto registrationDto);
	public boolean deleteUser(Long id);
	public String updateUser(Long id, UpdateUserDto updateUserDto);
	public String saveNewPost(NewPostDto newPostDto);
	public String postComment(PostCommentDto postCommentDto);
	public boolean deleteComment(Long postId, Long commentId);
	public List<Post> getPost();
	public Post updatePost(Long id, UpdateDto updateDto);
	public boolean deletePost(Long id);
	
}
