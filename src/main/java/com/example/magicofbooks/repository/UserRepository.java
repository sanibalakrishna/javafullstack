package com.example.magicofbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.magicofbooks.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
