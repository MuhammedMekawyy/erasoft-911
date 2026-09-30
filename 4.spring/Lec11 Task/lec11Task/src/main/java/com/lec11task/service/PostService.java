package com.lec11task.service;

import com.lec11task.dto.PostDto;
import com.lec11task.dto.PostResponseDto;
import com.lec11task.dto.PostWithUserDto;

import java.util.List;

public interface PostService {
    PostResponseDto createPost(PostDto dto);
    PostResponseDto getPostById(Long id);
    List<PostResponseDto> getAllPosts();
    PostResponseDto updatePost(Long id, PostDto dto);
    void deletePost(Long id);
    List<PostResponseDto> getPostsByUserId(Long userId);
    List<PostWithUserDto> getAllPostsWithUsers();
    PostWithUserDto getPostWithUser(Long id);
}
