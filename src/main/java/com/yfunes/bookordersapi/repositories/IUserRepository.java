package com.yfunes.bookordersapi.repositories;

import com.yfunes.bookordersapi.entities.UserEntity;

import java.util.Optional;

public interface IUserRepository extends IGenericRepository<UserEntity, Integer> {

    Optional<UserEntity> findUserEntitiesByUsername(String username);

}
