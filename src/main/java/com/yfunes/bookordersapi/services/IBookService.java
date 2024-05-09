package com.yfunes.bookordersapi.services;

import com.yfunes.bookordersapi.entities.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService extends ICRUD<BookEntity, Integer> {

    Page<BookEntity> findByPage(Pageable pageable);

}
