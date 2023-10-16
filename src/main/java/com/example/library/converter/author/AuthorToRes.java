package com.example.library.converter.author;

import com.example.library.converter.book.BookToRes;
import com.example.library.model.author.Author;
import com.example.library.model.author.AuthorRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AuthorToRes implements Converter<Author , AuthorRes> {

    private BookToRes bookToRes;

    @Autowired
    public AuthorToRes(BookToRes bookToRes) {
        this.bookToRes = bookToRes;
    }

    @Override
    public AuthorRes convert(Author author) {

        AuthorRes res = new AuthorRes();

        res.setId(author.getId());

        res.setFullName(author.getFullName());
        res.setAge(author.getAge());
        res.setBirthDate(author.getBirthDate());

        for (int i = 0; i < author.getBookList().size(); i++) {
            res.getBookList().add(bookToRes.convert(author.getBookList().get(i)));
        }

        return res;
    }
}
