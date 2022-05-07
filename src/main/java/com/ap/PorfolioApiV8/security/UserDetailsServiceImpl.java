package com.ap.PorfolioApiV8.security;

import java.util.ArrayList;

import com.ap.PorfolioApiV8.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
	private IUsuarioRepository usuarioRepo;


    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
               

        return new User("nicgamarra2010@gmail.com","123",new ArrayList<>());
    }
    
}
