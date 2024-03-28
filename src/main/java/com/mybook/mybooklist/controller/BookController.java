package com.mybook.mybooklist.controller;

import com.mybook.mybooklist.data.model.Book;
import com.mybook.mybooklist.exceptions.BookNotFound;
import com.mybook.mybooklist.services.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/book")
@CrossOrigin("*")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/{title}")
    public ResponseEntity<Book> search(@PathVariable String title) throws BookNotFound {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.search(title));
    }
    @GetMapping("/readingList")
    public ResponseEntity<List<Book>> displayReadingList() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(bookService.readingList());
    }
}
