package com.lec11task.controller;

import com.lec11task.dto.PostResponseDto;
import com.lec11task.dto.UserDto;
import com.lec11task.dto.UserResponseDto;
import com.lec11task.dto.UserWithPostsDto;
import com.lec11task.service.PostService;
import com.lec11task.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PostService postService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.createUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> update(@PathVariable Long id, @RequestBody @Valid UserDto dto) {
        return ResponseEntity.ok(userService.updateUser(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostResponseDto>> getPostsOfUser(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPostsByUserId(id));
    }

    @GetMapping("/usersWithPost")
    public ResponseEntity<List<UserWithPostsDto>> getAllWithPosts() {
        return ResponseEntity.ok(userService.getAllUsersWithPosts());
    }

    @GetMapping("/userWithPost/{id}")
    public ResponseEntity<UserWithPostsDto> getWithPosts(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUserWithPosts(id));
    }
}
