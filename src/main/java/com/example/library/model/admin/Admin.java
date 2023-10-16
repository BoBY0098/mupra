package com.example.library.model.admin;

import com.example.library.model.audit.AuditModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "admins")
@Data
public class Admin extends AuditModel {

    private String fullName;

    private String username;

    private String password;
}
