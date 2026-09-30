package com.lec9task.service.impl;

import com.lec9task.dto.MailDto;
import com.lec9task.model.Mail;
import com.lec9task.map.MailMapper;
import com.lec9task.repo.EmployeeRepo;
import com.lec9task.repo.MailRepo;
import com.lec9task.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final MailRepo mailRepo;
    private final EmployeeRepo employeeRepo;
    private final MailMapper mailMapper;

    @Override
    public MailDto createMail(MailDto mailDto) {
        Mail mail = mailMapper.toEntity(mailDto);
        mail.setEmployee(employeeRepo.findById(mailDto.getEmployee().getId()).orElseThrow());
        return mailMapper.toDto(mailRepo.save(mail));
    }

    @Override
    @Transactional
    public MailDto updateMail(MailDto mailDto) {
        if (mailDto.getId() == null) {
            throw new IllegalArgumentException("ID must be provided when updating an Email");
        }
        Mail mail = mailRepo.findById(mailDto.getId()).orElseThrow();
        mailMapper.updateEntityFromDto(mailDto, mail);
        mail.setEmployee(employeeRepo.findById(mailDto.getEmployee().getId()).orElseThrow());
        return mailMapper.toDto(mailRepo.save(mail));
    }

    @Override
    public void deleteMail(Long id) {
        mailRepo.deleteById(id);
    }

    @Override
    public List<MailDto> getAllMails() {
        return mailMapper.toDtoList(mailRepo.findAll());
    }

    @Override
    public List<MailDto> getMailsByName(String name) {
        return mailMapper.toDtoList(mailRepo.findByName(name));
    }

    @Override
    public List<MailDto> getMailsByNames(List<String> names) {
        return mailMapper.toDtoList(mailRepo.findByNameIn(names));
    }

    @Override
    public List<MailDto> getMailsByContent(String content) {
        return mailMapper.toDtoList(mailRepo.findByContent(content));
    }



}
