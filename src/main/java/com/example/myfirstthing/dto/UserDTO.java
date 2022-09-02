package com.example.myfirstthing.dto;


import com.example.myfirstthing.annotation.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    private String userName;
    private String userId;
    private String userPw;
    private int age;
    private String sex;
    private String job;

    @PhoneNumber
    private String phoneNumber;
}
