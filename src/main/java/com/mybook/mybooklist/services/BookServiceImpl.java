package com.mybook.mybooklist.services;

import com.mybook.mybooklist.data.repositories.ReadingListRepository;
import com.mybook.mybooklist.dtos.response.BookListResponse;
import com.mybook.mybooklist.dtos.response.ReadingListResponse;
import com.mybook.mybooklist.exceptions.BookNotFound;
import com.mybook.mybooklist.data.model.Book;
import com.mybook.mybooklist.data.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookServiceImpl implements BookService{

    private final RestTemplate restTemplate;

    private final BookRepository bookRepository;

    private static final String URL = "https://gutendex.com/books?search=";
    private final StringBuilder stringBuilder = new StringBuilder(URL);

    @Override
    public Book search(String title) throws BookNotFound {
        String result = stringBuilder.append(title).toString().toLowerCase();
        BookListResponse bookListResponse = restTemplate.getForObject(result, BookListResponse.class);

        assert bookListResponse != null;
        if (bookListResponse.getResults().isEmpty()) throw new BookNotFound("Book not found");
        Book book = bookListResponse.getResults().getFirst();

        bookRepository.save(book);
        return book;
    }

    @Override
    public List<Book> readingList() {
        return bookRepository.findAll();

    }
}
