package com.example.library.converter.admin;

import com.example.library.model.admin.Admin;
import com.example.library.model.admin.AdminReq;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToAdmin implements Converter<AdminReq , Admin> {

    private BookRepository bookRepository;

    @Autowired
    public ReqToAdmin(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Admin convert(AdminReq req) {
        Admin admin = new Admin();

        admin.setFullName(req.getFullName());
        admin.setUsername(req.getUsername());
        admin.setPassword(req.getPassword());

        return admin;
    }
}
