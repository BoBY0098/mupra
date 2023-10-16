package com.example.library.model.book;

import com.example.library.model.author.Author;
import com.example.library.model.publisher.Publisher;
import lombok.Data;

import java.util.UUID;

@Data
public class BookReq {

    private String name;

    private String printYear;

    private Integer inventory;

    private Long price;

    public UUID publisherId;

    public UUID authorId;
}
