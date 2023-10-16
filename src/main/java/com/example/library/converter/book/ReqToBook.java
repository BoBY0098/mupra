package com.example.library.converter.book;

import com.example.library.model.book.Book;
import com.example.library.model.book.BookReq;
import com.example.library.repository.AuthorRepository;
import com.example.library.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToBook implements Converter<BookReq , Book> {

    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;

    @Autowired
    public ReqToBook(AuthorRepository authorRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public Book convert(BookReq req) {

        Book book = new Book();

        book.setName(req.getName());
        book.setPrintYear(req.getPrintYear());
        book.setInventory(req.getInventory());
        book.setPrice(req.getPrice());
        book.setAuthor(authorRepository.findById(req.getAuthorId()).get());
        book.setPublisher(publisherRepository.findById(req.getPublisherId()).get());

        return book;
    }
}
