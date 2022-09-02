package com.example.myfirstthing.controller;

import com.example.myfirstthing.dto.UserDTO;
import com.example.myfirstthing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users") //ex)www.google.com -> 172.1987.0.1:8080/users
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("")
    public ResponseEntity insertUser(@Valid @RequestBody UserDTO user, BindingResult bindingResult){
        
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            bindingResult.getAllErrors().forEach(objectError ->{
                FieldError field = (FieldError) objectError;
                String message = objectError.getDefaultMessage();

                System.out.println("field : "+field.getField());
                System.out.println(message);

                sb.append("field : "+field.getField());
                sb.append("message: "+message);

            });

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(sb.toString());
        }
        //return userService.insertUser(user);
        return ResponseEntity.ok(user);

    }

    @GetMapping("")
    public List<UserDTO> getAllUsers(){

        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public UserDTO getUserByUserId(@PathVariable String userId){

        return userService.getUserByUserId(userId);
    }

    @PutMapping("/{userId}")
    public void updateUserPw(@PathVariable String userId,@RequestBody UserDTO user){
        userService.updateUserPw(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId){

        userService.deleteUserPw(userId);
    }
}
