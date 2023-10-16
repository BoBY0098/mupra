package com.example.library.model.book;

import com.example.library.model.audit.AuditModelRes;
import com.example.library.model.author.Author;
import com.example.library.model.publisher.Publisher;
import lombok.Data;

@Data
public class BookRes extends AuditModelRes {

    private String name;

    private String printYear;

    private Integer inventory;

    private Long price;

    public Publisher publisher;

    public Author author;
}
