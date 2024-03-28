package com.mybook.mybooklist.dtos.response;

import com.mybook.mybooklist.data.model.Book;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookListResponse {
    private int count;
    private String next;
    private String previous;
    private List<Book> results;

}
