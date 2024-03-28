package com.mybook.mybooklist.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class ReadingList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ElementCollection
    private List<String> subjects;
    @OneToOne
    private Author author;
    @ElementCollection
    private List<String> bookShelves;
    @ElementCollection
    private List<String> languages;
}
