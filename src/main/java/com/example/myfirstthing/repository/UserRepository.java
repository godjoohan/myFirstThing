package com.example.myfirstthing.repository;

import com.example.myfirstthing.dto.UserDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    static public ArrayList<UserDTO> users;

    static{
        users = new ArrayList<>();
        users.add(new UserDTO("joohan", "joorgasm", "1207", 37, "male"));
        users.add(new UserDTO("tk", "dolgot2", "0827",37, "female"));
        users.add(new UserDTO("kyungjin", "meat", "0814", 37, "shemale"));
    }

    public UserDTO insertUser(UserDTO user){
        users.add(user);
        return user;
    }

    public List<UserDTO> getAllUsers(){
        return users;
    }

    public UserDTO getUserByUserId(String userId){
        return users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO(" ", " ", " ",0,""));
    }

    public void updateUserPw(String userId, UserDTO user){
        users.stream()
                .filter(userDTO -> userDTO.getUserId().equals(userId))
                .findAny()
                .orElse(new UserDTO(" "," "," ",0," "))
                .setUserPw(user.getUserPw());
    }

    public void deleteUser(String userId){
        users.removeIf(userDTO -> userDTO.getUserId().equals(userId));
    }
}
