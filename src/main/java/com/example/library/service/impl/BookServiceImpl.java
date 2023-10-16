package com.example.library.service.impl;

import com.example.library.converter.book.BookToRes;
import com.example.library.converter.book.ReqToBook;
import com.example.library.model.book.Book;
import com.example.library.model.book.BookReq;
import com.example.library.model.book.BookRes;
import com.example.library.repository.BookRepository;
import com.example.library.service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private ReqToBook reqToBook;
    private BookToRes bookToRes;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ReqToBook reqToBook, BookToRes bookToRes) {
        this.bookRepository = bookRepository;
        this.reqToBook = reqToBook;
        this.bookToRes = bookToRes;
    }

    @Override
    public BookRes createBook(BookReq bookReq) {
        Book book = reqToBook.convert(bookReq);
        bookRepository.save(book);

        return bookToRes.convert(book);
    }

    @Override
    public List<BookRes> getAllBooks() {
        List<Book> books = bookRepository.findAll();

        List<BookRes> resList = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            resList.add(bookToRes.convert(books.get(i)));
        }

        return resList;
    }

    @Override
    public BookRes getBook(UUID bookId) {
        Book book = bookRepository.findById(bookId).get();

        return bookToRes.convert(book);
    }

    @Override
    public void deleteBook(UUID bookId) {
        Book book = bookRepository.findById(bookId).get();

        bookRepository.delete(book);
    }

    @Scheduled(cron = "0 0 8 * * *")
    public void resetBookInventory() {
        List<Book> bookList = bookRepository.findAll();

        for (int i = 0; i < bookList.size(); i++) {
            bookList.get(i).setInventory(10);
        }
    }
}
