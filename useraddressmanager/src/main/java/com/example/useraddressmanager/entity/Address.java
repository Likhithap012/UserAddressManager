package com.example.useraddressmanager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String streetOne;
    private String streetTwo;
    private String city;
    private String state;
    private String country;
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}