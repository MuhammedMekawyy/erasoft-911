package com.lec11task.map;

import com.lec11task.dto.UserDto;
import com.lec11task.dto.UserResponseDto;
import com.lec11task.dto.UserWithPostsDto;
import com.lec11task.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = PostMapper.class)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    User toEntity(UserDto dto);

    UserResponseDto toDto(User user);
    List<UserResponseDto> toDtoList(List<User> users);

    UserWithPostsDto toWithPostsDto(User user);
    List<UserWithPostsDto> toWithPostsDtoList(List<User> users);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "posts", ignore = true)
    void updateEntity(UserDto dto, @MappingTarget User user);
}
