package com.lec9task.service;

import com.lec9task.dto.MailDto;

import java.util.List;

public interface MailService {
    MailDto createMail(MailDto mailDto);
    MailDto updateMail(MailDto mailDto);
    void deleteMail(Long id);
    List<MailDto> getAllMails();
    List<MailDto> getMailsByName(String name);
    List<MailDto> getMailsByNames(List<String> names);
    List<MailDto> getMailsByContent(String content);
}
