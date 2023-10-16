package com.example.library.service.service;

import com.example.library.model.book.BookReq;
import com.example.library.model.book.BookRes;

import java.util.List;
import java.util.UUID;

public interface BookService {

    BookRes createBook(BookReq bookReq);

    List<BookRes> getAllBooks();

    BookRes getBook(UUID bookId);

    void deleteBook(UUID bookId);
}
