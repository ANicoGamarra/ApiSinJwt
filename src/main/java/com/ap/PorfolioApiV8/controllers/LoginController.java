package com.ap.PorfolioApiV8.controllers;

import com.ap.PorfolioApiV8.Services.Usuario.IUsuarioService;
import com.ap.PorfolioApiV8.models.Usuario;
import com.ap.PorfolioApiV8.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    
    @Autowired
    private IUsuarioService usuarioServ;
    @Autowired
    private JwtProvider jwtProvider;
    

    @PostMapping
    public ResponseEntity<Usuario> login(@Validated @RequestBody Usuario user) {

        Usuario usuarioLogueado = usuarioServ.getByUsername(user.getNombreUsuario());
        if (usuarioLogueado.getPassword().equals(user.getPassword())) {
            String token = jwtProvider.getJWTToken(user.getNombreUsuario());
            usuarioLogueado.setToken(token);
            usuarioLogueado.setPassword(null);
            return ResponseEntity.ok().body(usuarioLogueado);
        } else {
            return ResponseEntity.badRequest().build();
        }

    }


}
