package com.te.blogmanagement.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.te.blogmanagement.dto.NewPostDto;
import com.te.blogmanagement.dto.PostCommentDto;
import com.te.blogmanagement.dto.UpdateDto;
import com.te.blogmanagement.dto.UpdateUserDto;
import com.te.blogmanagement.dto.UserRegistrationDto;
import com.te.blogmanagement.entity.Post;
import com.te.blogmanagement.entity.PostComment;
import com.te.blogmanagement.entity.User;
import com.te.blogmanagement.exception.InvalidInputException;
import com.te.blogmanagement.repository.NewPostRepository;
import com.te.blogmanagement.repository.PostCommentRepository;
import com.te.blogmanagement.repository.UserRegistrationRepository;

@Service
public class ServiceImpl implements ServiceInterface {

	@Autowired
	private NewPostRepository newPostRepository;
	@Autowired
	private PostCommentRepository commentRepository;
	@Autowired
	private UserRegistrationRepository registrationRepository;
	  

//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public String userRegistration(UserRegistrationDto registrationDto) {
		if (registrationDto != null) {
//			registrationDto.setPassword(bCryptPasswordEncoder.encode(registrationDto.getPassword()));
			User user = new User();
	
			BeanUtils.copyProperties(registrationDto, user);
			registrationRepository.save(user);
			return user.getFirstName();
		} else {
			return null;
		}
	}
	

	@Override
	public boolean deleteUser(Long id) {
		Optional<User> findById = registrationRepository.findById(id);
		if (findById.isPresent()) {
			registrationRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public String updateUser(Long id, UpdateUserDto updateUserDto) {
		User user = registrationRepository.findById(id).orElse(null);
		if (user != null) {
			BeanUtils.copyProperties(updateUserDto, user);
			registrationRepository.save(user);
			return user.getFirstName();
		} else {
			throw new InvalidInputException("Please Enter Correct ID");
		}
	}

	@Override
	public String saveNewPost(NewPostDto newPostDto) {
		if (newPostDto != null) {
			Post post = new Post();
			BeanUtils.copyProperties(newPostDto, post);
			newPostRepository.save(post);
			return post.getTitle();
		} else
			throw new InvalidInputException("Something went wrong");

	}

	@Override
	public String postComment(PostCommentDto postCommentDto) {
		if (postCommentDto != null) {
			PostComment comment = new PostComment();
			BeanUtils.copyProperties(postCommentDto, comment);
			commentRepository.save(comment);
			return comment.getTitle();
		} else {
			throw new InvalidInputException("Post comment Dto is null");
		}
	}

	@Override
	public boolean deleteComment(Long postId, Long commentId) {
		Optional<Post> existingPost = newPostRepository.findById(postId);
		if (existingPost.isPresent()) {
			PostComment commentToDelete = null;
			for (PostComment comment : existingPost.get().getList()) {
				if (comment.getId().equals(commentId)) {
					commentToDelete = comment;
					break;
				}
			}
			if (commentToDelete != null) {
				existingPost.get().getList().remove(commentToDelete);
			}
			newPostRepository.save(existingPost.get());
			return true;
		} else {
			throw new InvalidInputException("Comment id or post id is not available");
		}

	}

	@Override
	public List<Post> getPost() {
		return newPostRepository.findAll();
	}

	@Override
	public Post updatePost(Long postId, UpdateDto updateDto) {
		Post postUpdate = newPostRepository.findById(postId)
				.orElseThrow(() -> new InvalidInputException("Id not found"));
		if (postUpdate != null) {
			BeanUtils.copyProperties(updateDto, postUpdate);
			return newPostRepository.save(postUpdate);
		}
		throw new InvalidInputException("Invalid id ");
	}

	@Override
	public boolean deletePost(Long id) {
		if (newPostRepository.findById(id).isPresent()) {
			newPostRepository.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	

}
