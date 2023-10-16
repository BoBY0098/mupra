package com.example.library.controller;

import com.example.library.model.admin.AdminReq;
import com.example.library.model.admin.AdminRes;
import com.example.library.model.admin.Login;
import com.example.library.service.service.AdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "admins")
@RequestMapping("/admins")
public class AdminController {

    private AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Admins" , notes = "Get List of Admins" , response = AdminRes.class , responseContainer = "List")
    public List<AdminRes> getAllAdmins(){
        return adminService.getAllAdmins();
    }

    @GetMapping("/{adminId}")
    @ApiOperation(value = "Get a Admin" , notes = "Get Admin by ID" , response = AdminRes.class)
    public AdminRes getAdmin(@PathVariable UUID adminId){
        return adminService.getAdmin(adminId);
    }

    @PostMapping
    @ApiOperation(value = "Create Admin" , notes = "Create Admin" , response = AdminRes.class)
    public AdminRes createAdmin(@RequestBody AdminReq adminReq){
        return adminService.createAdmin(adminReq);
    }

    @DeleteMapping("/{adminId}")
    @ApiOperation(value = "Delete Admin" , notes = "Delete admin by ID")
    public void deleteAdmin(@PathVariable UUID adminId){
        adminService.deleteAdmin(adminId);
    }

    @PostMapping("/login")
    @ApiOperation(value = "by Username and Password" , notes = "by Username and Password" , response = AdminRes.class)
    public AdminRes adminLogin(@RequestBody Login login){
        return adminService.adminLogin(login);
    }
}
