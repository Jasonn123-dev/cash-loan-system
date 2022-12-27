package com.sevenseven.cashloansystem.service;

import com.sevenseven.cashloansystem.model.Users;
import com.sevenseven.cashloansystem.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsersDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> user = usersRepo.findByUserName(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));
        return user.map(UsersDetailsImpl::new).get();
    }

}