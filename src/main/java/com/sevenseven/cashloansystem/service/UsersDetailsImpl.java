package com.sevenseven.cashloansystem.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.sevenseven.cashloansystem.model.Users;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class UsersDetailsImpl implements UserDetails{
    private static final long serialVersionUID = 1L;

    private String username;
    private String password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

    public UsersDetailsImpl(Users users) {
        this.username = users.getUserName();
        this.password = users.getPassword();
        this.isActive = users.getActive();
        this.authorities = Arrays.stream(users.getRoles().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public UsersDetailsImpl() {}

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {

        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }

}
