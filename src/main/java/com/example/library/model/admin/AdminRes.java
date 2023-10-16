package com.example.library.model.admin;

import com.example.library.model.audit.AuditModelRes;
import lombok.Data;

@Data
public class AdminRes extends AuditModelRes {

    private String fullName;

    private String username;
}