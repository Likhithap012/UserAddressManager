package com.example.useraddressmanager.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {
    private String streetOne;
    private String streetTwo;
    private String city;
    private String state;
    private String country;
    private String pincode;

}