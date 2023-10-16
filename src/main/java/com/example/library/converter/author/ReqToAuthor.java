package com.example.library.converter.author;

import com.example.library.model.author.Author;
import com.example.library.model.author.AuthorReq;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToAuthor implements Converter<AuthorReq , Author> {

    private BookRepository bookRepository;

    @Autowired
    public ReqToAuthor(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Author convert(AuthorReq req) {

        Author author = new Author();

        author.setFullName(req.getFullName());
        author.setAge(req.getAge());
        author.setBirthDate(req.getBirthDate());
        author.getBookList().add(bookRepository.findById(req.getBookId()).get());

        return author;
    }
}
