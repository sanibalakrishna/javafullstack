package com.example.magicofbooks.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.magicofbooks.model.AdminUser;



public interface AdminRepository extends JpaRepository<AdminUser, Long> {

	AdminUser findByEmail(String email);
}
