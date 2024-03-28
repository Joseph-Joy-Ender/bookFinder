package com.mybook.mybooklist.data.repositories;

import com.mybook.mybooklist.data.model.ReadingList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReadingListRepository extends JpaRepository<ReadingList, Long> {
}
