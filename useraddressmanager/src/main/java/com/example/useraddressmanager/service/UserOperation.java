package com.example.useraddressmanager.service;

import com.example.useraddressmanager.dto.UserDTO;

import java.util.List;

public interface UserOperation {
    List<UserDTO> getAllUsers();

    UserDTO getUserById(int id);

    UserDTO createUser(UserDTO dto);

    UserDTO updateUser(int id, UserDTO dto);

    void deleteUser(int id);
}
