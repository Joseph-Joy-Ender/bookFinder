package com.mybook.mybooklist.services;

import com.mybook.mybooklist.dtos.response.BookListResponse;
import com.mybook.mybooklist.dtos.response.ReadingListResponse;
import com.mybook.mybooklist.exceptions.BookNotFound;
import com.mybook.mybooklist.data.model.Book;

import java.util.List;

public interface BookService {
    Book search(String title) throws BookNotFound;
    List<Book> readingList();


}
