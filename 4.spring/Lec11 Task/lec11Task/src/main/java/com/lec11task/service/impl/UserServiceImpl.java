package com.lec11task.service.impl;

import com.lec11task.dto.UserDto;
import com.lec11task.dto.UserResponseDto;
import com.lec11task.dto.UserWithPostsDto;
import com.lec11task.map.UserMapper;
import com.lec11task.model.User;
import com.lec11task.repo.UserRepo;
import com.lec11task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponseDto createUser(UserDto dto) {
        return userMapper.toDto(userRepository.save(userMapper.toEntity(dto)));
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponseDto getUserById(Long id) {
        return userMapper.toDto(findUser(id));
    }

    @Override
    public List<UserResponseDto> getAllUsers() {
        return userMapper.toDtoList(userRepository.findAll());
    }

    @Override
    @Transactional
    public UserResponseDto updateUser(Long id, UserDto dto) {
        User user = findUser(id);
        userMapper.updateEntity(dto, user);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new NoSuchElementException("User not found with id " + id);
        }
        userRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserWithPostsDto> getAllUsersWithPosts() {
        return userMapper.toWithPostsDtoList(userRepository.findAll());
    }

    @Override
    @Transactional(readOnly = true)
    public UserWithPostsDto getUserWithPosts(Long id) {
        return userMapper.toWithPostsDto(findUser(id));
    }

    private User findUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("User not found with id " + id));
    }
}
