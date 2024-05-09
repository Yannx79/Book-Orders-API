package com.yfunes.bookordersapi.services.impl;

import com.yfunes.bookordersapi.entities.BookEntity;
import com.yfunes.bookordersapi.repositories.IBookRepository;
import com.yfunes.bookordersapi.repositories.IGenericRepository;
import com.yfunes.bookordersapi.services.IBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends CRUDImpl<BookEntity, Integer> implements IBookService {

    private final IBookRepository repository;

    @Override
    protected IGenericRepository<BookEntity, Integer> getRepo() {
        return repository;
    }

    @Override
    public Page<BookEntity> findByPage(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
