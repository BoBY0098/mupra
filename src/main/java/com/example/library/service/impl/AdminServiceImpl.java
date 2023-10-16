package com.example.library.service.impl;

import com.example.library.converter.admin.AdminToRes;
import com.example.library.converter.admin.ReqToAdmin;
import com.example.library.exception.BadRequestException;
import com.example.library.model.admin.Admin;
import com.example.library.model.admin.AdminReq;
import com.example.library.model.admin.AdminRes;
import com.example.library.model.admin.Login;
import com.example.library.repository.AdminRepository;
import com.example.library.service.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {

    private AdminToRes adminToRes;
    private ReqToAdmin reqToAdmin;
    private AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminToRes adminToRes, ReqToAdmin reqToAdmin, AdminRepository adminRepository) {
        this.adminToRes = adminToRes;
        this.reqToAdmin = reqToAdmin;
        this.adminRepository = adminRepository;
    }

    @Override
    public AdminRes createAdmin(AdminReq adminReq) {
        Admin admin = reqToAdmin.convert(adminReq);
        adminRepository.save(admin);

        return adminToRes.convert(admin);
    }

    @Override
    public List<AdminRes> getAllAdmins() {
        List<Admin> admins = adminRepository.findAll();

        List<AdminRes> resList = new ArrayList<>();

        for (int i = 0; i < admins.size(); i++) {
            resList.add(adminToRes.convert(admins.get(i)));
        }

        return resList;
    }

    @Override
    public AdminRes getAdmin(UUID adminId) {
        Optional<Admin> admin = adminRepository.findById(adminId);

        return adminToRes.convert(admin.get());
    }

    @Override
    public void deleteAdmin(UUID adminId) {
        Optional<Admin> admin = adminRepository.findById(adminId);
        adminRepository.delete(admin.get());
    }

    @Override
    public AdminRes adminLogin(Login login) {

        Admin admin = adminRepository.findAllByUsernameIsContaining(login.getUsername());
        if(admin == null){
            throw  new BadRequestException("Admin not Found");
        }
        if (!admin.getPassword().equals(login.getPassword())){
            throw new BadRequestException("Password is Incorrect");
        }
        return adminToRes.convert(admin);
    }
}