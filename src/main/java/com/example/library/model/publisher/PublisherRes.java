package com.example.library.model.publisher;

import com.example.library.model.audit.AuditModelRes;
import com.example.library.model.book.BookRes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PublisherRes extends AuditModelRes {

    private String name;

    private String establishedYear;

    private List<BookRes> bookList = new ArrayList<>();
}
