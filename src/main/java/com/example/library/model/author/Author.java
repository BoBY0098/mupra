package com.example.library.model.author;

import com.example.library.model.audit.AuditModel;
import com.example.library.model.book.Book;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Data
public class Author extends AuditModel {

    private String fullName;

    private Integer age;

    private String birthDate;

    @OneToMany
    private List<Book> bookList = new ArrayList<>();
}
