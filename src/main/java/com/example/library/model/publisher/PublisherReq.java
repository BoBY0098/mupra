package com.example.library.model.publisher;

import lombok.Data;

import java.util.UUID;

@Data
public class PublisherReq {

    private String name;

    private String establishedYear;

    private UUID bookId;
}
