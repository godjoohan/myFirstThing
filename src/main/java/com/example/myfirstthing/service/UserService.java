package com.example.myfirstthing.service;

import com.example.myfirstthing.dto.UserDTO;
import com.example.myfirstthing.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired //
    UserRepository userRepository;

    public UserDTO insertUser(UserDTO user){
        return userRepository.insertUser(user);
    }

    public List<UserDTO> getAllUsers(){
        return userRepository.getAllUsers();
    }

    public UserDTO getUserByUserId(String userId){
        return userRepository.getUserByUserId(userId);
    }

    public void updateUserPw(String userId, UserDTO user){
        userRepository.updateUserPw(userId, user);
    }

    public void deleteUserPw(String userId){
        userRepository.deleteUser(userId);
    }
}
