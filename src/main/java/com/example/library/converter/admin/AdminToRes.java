package com.example.library.converter.admin;

import com.example.library.model.admin.Admin;
import com.example.library.model.admin.AdminRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AdminToRes implements Converter<Admin , AdminRes> {

    @Override
    public AdminRes convert(Admin admin) {
        AdminRes res = new AdminRes();

        res.setId(admin.getId());

        res.setFullName(admin.getFullName());
        res.setUsername(admin.getUsername());

        return res;
    }
}
