package com.yfunes.bookordersapi.services;

import com.yfunes.bookordersapi.entities.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


public interface IUserService extends ICRUD<UserEntity, Integer> {
}
