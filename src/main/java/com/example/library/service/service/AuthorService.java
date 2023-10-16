package com.example.library.service.service;

import com.example.library.model.author.AuthorReq;
import com.example.library.model.author.AuthorRes;

import java.util.List;
import java.util.UUID;

public interface AuthorService {

    AuthorRes createAuthor(AuthorReq authorReq);

    List<AuthorRes> getAllAuthors();

    AuthorRes getAuthor(UUID authorId);

    void deleteAuthor(UUID authorId);
}
