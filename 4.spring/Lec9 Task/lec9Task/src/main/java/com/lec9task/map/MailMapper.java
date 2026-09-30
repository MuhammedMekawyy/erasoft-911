package com.lec9task.map;

import com.lec9task.dto.MailDto;
import com.lec9task.model.Mail;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MailMapper {

    MailDto toDto(Mail mail);

    Mail toEntity(MailDto mailDto);

    List<MailDto> toDtoList (List<Mail> mails);

    List<Mail> toEntityList ( List<MailDto> mailDtoList);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "employee", ignore = true)
    void updateEntityFromDto(MailDto dto, @MappingTarget Mail mail);
}
