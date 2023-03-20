package com.example.magicofbooks.service;

import com.example.magicofbooks.model.AdminUser;

public interface AdminUserService {
    void addUser(AdminUser user);
    void updateUser(AdminUser user);
    AdminUser getUserByUsername(String username);
}