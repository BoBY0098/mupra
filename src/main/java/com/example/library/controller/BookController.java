package com.example.library.controller;

import com.example.library.model.book.BookReq;
import com.example.library.model.book.BookRes;
import com.example.library.service.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "books")
@RequestMapping("/books")
public class BookController {

    private BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Books" , notes = "Get List of Books" , response = BookRes.class , responseContainer = "List")
    public List<BookRes> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    @ApiOperation(value = "Get a Book" , notes = "Get Book by ID" , response = BookRes.class)
    public BookRes getBook(@PathVariable UUID bookId){
        return bookService.getBook(bookId);
    }

    @PostMapping
    @ApiOperation(value = "Create Book" , notes = "Create Book" , response = BookRes.class)
    public BookRes createBook(@RequestBody BookReq bookReq){
        return bookService.createBook(bookReq);
    }

    @DeleteMapping("/{bookId}")
    @ApiOperation(value = "Delete Book" , notes = "Delete Book by ID")
    public void deleteBook(@PathVariable UUID bookId){
        bookService.deleteBook(bookId);
    }

}
