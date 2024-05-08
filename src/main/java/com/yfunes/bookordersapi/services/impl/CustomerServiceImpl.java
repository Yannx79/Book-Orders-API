package com.yfunes.bookordersapi.services.impl;

import com.yfunes.bookordersapi.entities.CustomerEntity;
import com.yfunes.bookordersapi.repositories.ICustomerRepository;
import com.yfunes.bookordersapi.repositories.IGenericRepository;
import com.yfunes.bookordersapi.services.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl extends CRUDImpl<CustomerEntity, Integer> implements ICustomerService {

    private final ICustomerRepository repository;

    @Override
    protected IGenericRepository<CustomerEntity, Integer> getRepo() {
        return repository;
    }
}
