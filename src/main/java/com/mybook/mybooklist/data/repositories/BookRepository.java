package com.mybook.mybooklist.model.repositories;

import com.mybook.mybooklist.model.data.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
