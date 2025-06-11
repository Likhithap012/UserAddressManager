package com.example.useraddressmanager.controller;
import com.example.useraddressmanager.dto.AddressDTO;
import com.example.useraddressmanager.entity.Address;
import com.example.useraddressmanager.mapper.UserMapper;
import com.example.useraddressmanager.repository.AddressRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressRepository addressRepository;

    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    // Get all addresses sorted by city and state, as DTOs
    @GetMapping("/sorted")
    public ResponseEntity<List<AddressDTO>> getSortedAddresses() {
        List<AddressDTO> dtoList = addressRepository.findAllSortedByCityAndState()
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
        return ResponseEntity.ok(dtoList);
    }

    // Get addresses filtered by city or state, as DTOs
    @GetMapping("/search")
    public ResponseEntity<List<AddressDTO>> getAddressesByCityOrState(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String state) {

        List<Address> addressList = addressRepository.findByCityOrState(city, state);
        List<AddressDTO> dtoList = addressList
                .stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(dtoList);
    }
}
