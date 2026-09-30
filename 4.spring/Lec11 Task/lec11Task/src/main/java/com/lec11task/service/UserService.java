package com.lec11task.service;

import com.lec11task.dto.UserDto;
import com.lec11task.dto.UserResponseDto;
import com.lec11task.dto.UserWithPostsDto;

import java.util.List;

public interface UserService {
    UserResponseDto createUser(UserDto dto);
    UserResponseDto getUserById(Long id);
    List<UserResponseDto> getAllUsers();
    UserResponseDto updateUser(Long id, UserDto dto);
    void deleteUser(Long id);
    List<UserWithPostsDto> getAllUsersWithPosts();
    UserWithPostsDto getUserWithPosts(Long id);
}
