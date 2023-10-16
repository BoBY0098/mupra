package com.example.library.model.book;

import com.example.library.model.audit.AuditModel;
import com.example.library.model.author.Author;
import com.example.library.model.publisher.Publisher;
import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "books")
@Data
public class Book extends AuditModel {

    private String name;

    private String printYear;

    private Integer inventory;

    private Long price;

    @ManyToOne
    public Publisher publisher;

    @ManyToOne
    public Author author;
}
