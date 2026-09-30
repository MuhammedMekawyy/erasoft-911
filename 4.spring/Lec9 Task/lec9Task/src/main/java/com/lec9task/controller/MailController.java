package com.lec9task.controller;

import com.lec9task.dto.MailDto;
import com.lec9task.service.MailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//create API to create Email done
//create API to update Email done
//create API to remove Email done
//create API to get all Email done
//create API to get Email by name done
//create API to get Email by List of name done
//create API to get Email by content done

@RestController
@RequestMapping("/emails")
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping
    public ResponseEntity<MailDto> create(@Valid @RequestBody MailDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mailService.createMail(dto));
    }

    @PutMapping
    public ResponseEntity<MailDto> update(@Valid @RequestBody MailDto dto) {
        return ResponseEntity.ok(mailService.updateMail(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        mailService.deleteMail(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<MailDto>> getAll() {
        return ResponseEntity.ok(mailService.getAllMails());
    }

    @GetMapping("/by-name")
    public ResponseEntity<List<MailDto>> getByName(@RequestParam String name) {
        return ResponseEntity.ok(mailService.getMailsByName(name));
    }

    @GetMapping("/by-names")
    public ResponseEntity<List<MailDto>> getByNames(@RequestParam List<String> names) {
        return ResponseEntity.ok(mailService.getMailsByNames(names));
    }

    @GetMapping("/by-content")
    public ResponseEntity<List<MailDto>> getByContent(@RequestParam String content) {
        return ResponseEntity.ok(mailService.getMailsByContent(content));
    }

}
