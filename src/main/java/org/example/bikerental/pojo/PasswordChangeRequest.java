package org.example.bikerental.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordChangeRequest {
    private String email;
    private String newPassword;
}
