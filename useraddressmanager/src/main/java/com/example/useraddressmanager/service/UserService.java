package com.example.useraddressmanager.service;

import com.example.useraddressmanager.dto.UserDTO;
import com.example.useraddressmanager.entity.User;
import com.example.useraddressmanager.mapper.UserMapper;
import com.example.useraddressmanager.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDTO).collect(Collectors.toList());
    }

    public UserDTO getUserById(int id) {
        return UserMapper.toDTO(userRepository.findById(id).orElseThrow());
    }

    public UserDTO createUser(UserDTO dto) {
        return UserMapper.toDTO(userRepository.save(UserMapper.toEntity(dto)));
    }

    public UserDTO updateUser(int id, UserDTO dto) {
        User existing = userRepository.findById(id).orElseThrow();
        User updated = UserMapper.toEntity(dto);
        updated.setId(id);
        return UserMapper.toDTO(userRepository.save(updated));
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }
}