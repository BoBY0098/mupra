package com.example.library.controller;

import com.example.library.model.author.AuthorReq;
import com.example.library.model.author.AuthorRes;
import com.example.library.service.service.AuthorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Api(tags = "authors")
@RequestMapping("/authors")
public class AuthorController {

    private AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    @ApiOperation(value = "Get all Authors" , notes = "Get List of Authors" , response = AuthorRes.class , responseContainer = "List")
    public List<AuthorRes> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/{authorId}")
    @ApiOperation(value = "Get a Author" , notes = "Get Author by ID" , response = AuthorRes.class)
    public AuthorRes getAuthor(@PathVariable UUID authorId){
        return authorService.getAuthor(authorId);
    }

    @PostMapping
    @ApiOperation(value = "Create Author" , notes = "Create Author" , response = AuthorRes.class)
    public AuthorRes createAuthor(@RequestBody AuthorReq authorReq){
        return authorService.createAuthor(authorReq);
    }

    @DeleteMapping("/{authorId}")
    @ApiOperation(value = "Delete Author" , notes = "Delete author by ID")
    public void deleteAuthor(@PathVariable UUID authorId){
        authorService.deleteAuthor(authorId);
    }

}
