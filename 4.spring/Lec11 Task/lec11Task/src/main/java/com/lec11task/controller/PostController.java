package com.lec11task.controller;

import com.lec11task.dto.PostDto;
import com.lec11task.dto.PostResponseDto;
import com.lec11task.dto.PostWithUserDto;
import com.lec11task.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping
    public ResponseEntity<PostResponseDto> create(@RequestBody @Valid PostDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(postService.createPost(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostById(id));
    }

    @GetMapping
    public ResponseEntity<List<PostResponseDto>> getAll() {
        return ResponseEntity.ok(postService.getAllPosts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponseDto> update(@PathVariable Long id, @RequestBody @Valid PostDto dto) {
        return ResponseEntity.ok(postService.updatePost(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/postsWithUsers")
    public ResponseEntity<List<PostWithUserDto>> getAllWithUsers() {
        return ResponseEntity.ok(postService.getAllPostsWithUsers());
    }

    @GetMapping("/postWithUsers/{id}")
    public ResponseEntity<PostWithUserDto> getWithUser(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostWithUser(id));
    }
}
