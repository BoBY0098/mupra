package com.example.library.converter.publisher;

import com.example.library.model.publisher.Publisher;
import com.example.library.model.publisher.PublisherReq;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ReqToPublisher implements Converter<PublisherReq , Publisher> {

    private BookRepository bookRepository;

    @Autowired
    public ReqToPublisher(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Publisher convert(PublisherReq req) {

        Publisher publisher = new Publisher();

        publisher.setName(req.getName());
        publisher.setEstablishedYear(req.getEstablishedYear());
        publisher.getBookList().add(bookRepository.findById(req.getBookId()).get());

        return publisher;
    }
}
