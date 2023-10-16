package com.example.library.model.author;

import com.example.library.model.book.Book;
import lombok.Data;

import java.util.UUID;

@Data
public class AuthorReq {

    private String fullName;

    private Integer age;

    private String birthDate;

    private UUID bookId;
}
