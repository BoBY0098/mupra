package com.example.library.service.impl;

import com.example.library.converter.author.AuthorToRes;
import com.example.library.converter.author.ReqToAuthor;
import com.example.library.model.author.Author;
import com.example.library.model.author.AuthorReq;
import com.example.library.model.author.AuthorRes;
import com.example.library.repository.AuthorRepository;
import com.example.library.service.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorServiceImpl implements AuthorService {

    private AuthorRepository authorRepository;
    private ReqToAuthor reqToAuthor;
    private AuthorToRes authorToRes;

    @Autowired
    public AuthorServiceImpl(AuthorRepository authorRepository, ReqToAuthor reqToAuthor, AuthorToRes authorToRes) {
        this.authorRepository = authorRepository;
        this.reqToAuthor = reqToAuthor;
        this.authorToRes = authorToRes;
    }

    @Override
    public AuthorRes createAuthor(AuthorReq authorReq) {
        Author author = reqToAuthor.convert(authorReq);
        authorRepository.save(author);

        return authorToRes.convert(author);
    }

    @Override
    public List<AuthorRes> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();

        List<AuthorRes> resList = new ArrayList<>();

        for (int i = 0; i < authors.size(); i++) {
            resList.add(authorToRes.convert(authors.get(i)));
        }

        return resList;
    }

    @Override
    public AuthorRes getAuthor(UUID authorId) {
        Author author = authorRepository.findById(authorId).get();

        return authorToRes.convert(author);
    }

    @Override
    public void deleteAuthor(UUID authorId) {
        Author author = authorRepository.findById(authorId).get();

        authorRepository.delete(author);
    }
}
