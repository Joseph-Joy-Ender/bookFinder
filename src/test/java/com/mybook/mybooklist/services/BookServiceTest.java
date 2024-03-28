package com.mybook.mybooklist.services;

import com.mybook.mybooklist.data.model.Book;
import com.mybook.mybooklist.data.repositories.BookRepository;
import com.mybook.mybooklist.exceptions.BookNotFound;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
@Slf4j
public class BookServiceTest {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookRepository repository;
//
//    @AfterEach
//    public void deleteAfterEach(){
//        repository.deleteAll();
//    }

    @Test
    public void testThatBookCanBeSearchedFor() throws BookNotFound {
        String title = "Great Expectations";
        Book book = bookService.search(title);
        log.info("book searched :: {}", book);
        assertThat(book).isNotNull();
    }

    @Test
    public void testThatBookCanBeSearchedForAgain() throws BookNotFound {
        String title = "Frankenstein; Or, The Modern Prometheus";
        Book book = bookService.search(title);
        log.info("book searched :: {}", book);
        assertThat(book).isNotNull();
    }

    @Test
    public void testThatExceptionIsThrownWhenABookIsNotFound() {
        String title = "Morning comes softly";
        assertThatExceptionOfType(BookNotFound.class).isThrownBy(()-> bookService.search(title));

    }

    @Test
    public void testThatUserReadingListCanBeShown(){
        List<Book> responses = bookService.readingList();
        log.info("Reading list :: {}", responses);
        assertThat(responses).isNotNull();

    }
}

