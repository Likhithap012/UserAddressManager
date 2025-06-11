package com.example.useraddressmanager.repository;

import com.example.useraddressmanager.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
