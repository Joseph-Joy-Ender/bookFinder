package com.mybook.mybooklist.data.repositories;

import com.mybook.mybooklist.data.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
