package com.lec9task.vm;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class MailVm {
    @NotBlank
    private String name;

    @Email
    private String content;

}
