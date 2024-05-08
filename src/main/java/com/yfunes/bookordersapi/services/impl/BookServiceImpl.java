package com.yfunes.bookordersapi.services.impl;

import com.yfunes.bookordersapi.entities.BookEntity;
import com.yfunes.bookordersapi.entities.CustomerEntity;
import com.yfunes.bookordersapi.repositories.IBookRepository;
import com.yfunes.bookordersapi.repositories.ICustomerRepository;
import com.yfunes.bookordersapi.repositories.IGenericRepository;
import com.yfunes.bookordersapi.services.IBookService;
import com.yfunes.bookordersapi.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;

@Service
@RequiredArgsConstructor
public class BookServiceImpl extends CRUDImpl<BookEntity, Integer> implements IBookService {

    private final IBookRepository repository;

    @Override
    protected IGenericRepository<BookEntity, Integer> getRepo() {
        return repository;
    }
}
