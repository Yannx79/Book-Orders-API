package com.yfunes.bookordersapi.services.impl;

import com.yfunes.bookordersapi.entities.UserEntity;
import com.yfunes.bookordersapi.repositories.IGenericRepository;
import com.yfunes.bookordersapi.repositories.IUserRepository;
import com.yfunes.bookordersapi.services.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends CRUDImpl<UserEntity, Integer> implements IUserService, UserDetailsService {

    private final IUserRepository repository;

    @Override
    protected IGenericRepository<UserEntity, Integer> getRepo() {
        return repository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = repository.findUserEntitiesByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found!"));

        List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

        userEntity.getRoles()
                .forEach(role -> simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_".concat(role.getName().name()))));

        userEntity.getRoles()
                .stream()
                .flatMap(role -> role.getPermissions().stream())
                .forEach(permission -> simpleGrantedAuthorities.add(new SimpleGrantedAuthority(permission.getName())));

        return new User(
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.isEnabled(),
                userEntity.isAccountNoExpired(),
                userEntity.isCredentialNoExpired(),
                userEntity.isAccountNoLocked(),
                simpleGrantedAuthorities
        );
    }
}
