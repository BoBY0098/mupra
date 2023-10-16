package com.example.library.model.author;

import com.example.library.model.audit.AuditModelRes;
import com.example.library.model.book.Book;
import com.example.library.model.book.BookRes;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorRes extends AuditModelRes {

    private String fullName;

    private Integer age;

    private String birthDate;

    private List<BookRes> bookList = new ArrayList<>();
}
