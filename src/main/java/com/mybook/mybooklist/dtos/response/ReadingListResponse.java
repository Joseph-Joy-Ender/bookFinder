package com.mybook.mybooklist.dtos.response;

import com.mybook.mybooklist.data.model.Author;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ReadingListResponse {
    private String title;
    private List<String> subjects;
    private Author author;
    private List<String> bookShelves;
    private List<String> languages;
}
