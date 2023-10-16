package com.example.library.model.publisher;

import com.example.library.model.audit.AuditModel;
import com.example.library.model.book.Book;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@Data
public class Publisher extends AuditModel {

    private String name;

    private String establishedYear;

    @OneToMany
    private List<Book> bookList = new ArrayList<>();
}
