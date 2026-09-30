package com.lec11task.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserWithPostsDto {
    private Long id;
    private String name;
    private Integer age;
    private List<PostResponseDto> posts;
}
