package com.mybook.mybooklist.data.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Setter
@Getter

public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private Author author;
    @ElementCollection
    private List<String> subjects;
    @ElementCollection
    private List<String> bookShelves;
    @ElementCollection
    private List<String> languages;



}
