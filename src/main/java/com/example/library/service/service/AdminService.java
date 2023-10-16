package com.example.library.service.service;

import com.example.library.model.admin.AdminReq;
import com.example.library.model.admin.AdminRes;
import com.example.library.model.admin.Login;

import java.util.List;
import java.util.UUID;

public interface AdminService {

    AdminRes createAdmin(AdminReq adminReq);

    List<AdminRes> getAllAdmins();

    AdminRes getAdmin(UUID adminId);

    void deleteAdmin(UUID adminId);

    AdminRes adminLogin(Login login);
}
