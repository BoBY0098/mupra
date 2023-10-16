package com.example.library.converter.book;

import com.example.library.model.book.Book;
import com.example.library.model.book.BookRes;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookToRes implements Converter<Book , BookRes> {

    @Override
    public BookRes convert(Book book) {

        BookRes res = new BookRes();

        res.setId(book.getId());

        res.setName(book.getName());
        res.setPrintYear(book.getPrintYear());
        res.setInventory(book.getInventory());
        res.setPrice(book.getPrice());
        res.setAuthor(book.getAuthor());
        res.setPublisher(book.getPublisher());

        return res;
    }
}
