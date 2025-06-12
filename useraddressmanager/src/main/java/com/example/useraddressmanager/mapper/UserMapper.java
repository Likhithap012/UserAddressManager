package com.example.useraddressmanager.mapper;


import com.example.useraddressmanager.dto.AddressDTO;
import com.example.useraddressmanager.dto.UserDTO;
import com.example.useraddressmanager.entity.Address;
import com.example.useraddressmanager.entity.User;

import java.util.stream.Collectors;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setPhoneNumber(user.getPhoneNumber());
        dto.setAddresses(user.getAddresses().stream().map(UserMapper::toDTO).collect(Collectors.toList()));
        return dto;
    }

    public static AddressDTO toDTO(Address address) {
        return new AddressDTO(
                address.getStreetOne(),
                address.getStreetTwo(),
                address.getCity(),
                address.getState(),
                address.getCountry(),
                address.getPincode()
        );
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setPhoneNumber(dto.getPhoneNumber());
        user.setAddresses(dto.getAddresses().stream().map(a -> toEntity(a, user)).collect(Collectors.toList()));
        return user;
    }

    public static Address toEntity(AddressDTO dto, User user) {
        Address address = new Address();
        address.setStreetOne(dto.getStreetOne());
        address.setStreetTwo(dto.getStreetTwo());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setCountry(dto.getCountry());
        address.setPincode(dto.getPincode());
        address.setUser(user);
        return address;
    }
}