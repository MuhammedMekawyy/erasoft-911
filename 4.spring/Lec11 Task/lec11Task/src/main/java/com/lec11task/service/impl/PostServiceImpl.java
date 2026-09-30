package com.lec11task.service.impl;

import com.lec11task.dto.PostDto;
import com.lec11task.dto.PostResponseDto;
import com.lec11task.dto.PostWithUserDto;
import com.lec11task.map.PostMapper;
import com.lec11task.model.Post;
import com.lec11task.model.User;
import com.lec11task.repo.PostRepo;
import com.lec11task.repo.UserRepo;
import com.lec11task.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postRepository;
    private final UserRepo userRepository;
    private final PostMapper postMapper;

    @Override
    @Transactional
    public PostResponseDto createPost(PostDto dto) {
        Post post = postMapper.toEntity(dto);
        if (dto.getUserId() != null) {
            post.setUser(findUser(dto.getUserId()));
        }
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    @Transactional(readOnly = true)
    public PostResponseDto getPostById(Long id) {
        return postMapper.toDto(findPost(id));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponseDto> getAllPosts() {
        return postMapper.toDtoList(postRepository.findAll());
    }

    @Override
    @Transactional
    public PostResponseDto updatePost(Long id, PostDto dto) {
        Post post = findPost(id);
        postMapper.updateEntity(dto, post);
        if (dto.getUserId() != null) {
            post.setUser(findUser(dto.getUserId()));
        }
        return postMapper.toDto(postRepository.save(post));
    }

    @Override
    public void deletePost(Long id) {
        if (!postRepository.existsById(id)) {
            throw new NoSuchElementException("Post not found with id " + id);
        }
        postRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostResponseDto> getPostsByUserId(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new NoSuchElementException("User not found with id " + userId);
        }
        return postMapper.toDtoList(postRepository.findByUserId(userId));
    }

    @Override
    @Transactional(readOnly = true)
    public List<PostWithUserDto> getAllPostsWithUsers() {
        return postMapper.toWithUserDtoList(postRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public PostWithUserDto getPostWithUser(Long id) {
        return postMapper.toWithUserDto(findPost(id));
    }

    private Post findPost(Long id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Post not found with id " + id));
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id " + id));
    }
}
