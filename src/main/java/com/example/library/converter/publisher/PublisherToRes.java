package com.example.library.converter.publisher;

import com.example.library.converter.book.BookToRes;
import com.example.library.model.publisher.Publisher;
import com.example.library.model.publisher.PublisherRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PublisherToRes implements Converter<Publisher , PublisherRes> {

    private BookToRes bookToRes;

    @Autowired
    public PublisherToRes(BookToRes bookToRes) {
        this.bookToRes = bookToRes;
    }

    @Override
    public PublisherRes convert(Publisher publisher) {

        PublisherRes res = new PublisherRes();

        res.setId(publisher.getId());

        res.setName(publisher.getName());
        res.setEstablishedYear(publisher.getEstablishedYear());

        for (int i = 0; i < publisher.getBookList().size(); i++) {
            res.getBookList().add(bookToRes.convert(publisher.getBookList().get(i)));
        }

        return res;
    }
}
