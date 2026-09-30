package com.lec11task.map;

import com.lec11task.dto.PostDto;
import com.lec11task.dto.PostResponseDto;
import com.lec11task.dto.PostWithUserDto;
import com.lec11task.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    Post toEntity(PostDto dto);

    @Mapping(source = "user.id", target = "userId")
    PostResponseDto toDto(Post post);
    List<PostResponseDto> toDtoList(List<Post> posts);

    PostWithUserDto toWithUserDto(Post post);
    List<PostWithUserDto> toWithUserDtoList(List<Post> posts);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "user", ignore = true)
    void updateEntity(PostDto dto, @MappingTarget Post post);
}
