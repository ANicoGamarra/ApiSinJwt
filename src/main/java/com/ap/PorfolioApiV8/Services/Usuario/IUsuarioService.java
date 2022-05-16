package com.ap.PorfolioApiV8.Services.Usuario;

import java.util.List;
import java.util.Optional;

import com.ap.PorfolioApiV8.models.Usuario;

import org.springframework.http.ResponseEntity;

public interface IUsuarioService {

    public List<Usuario> verUsuarios();
    
    public void crearUsuario (Usuario user);
    
    public void borrarUsuario (Long id);
    
    public Usuario buscarUsuario (Long id);   
    
    public ResponseEntity<Usuario> buscarUsuarioId (Long id);
    
    public void editarUsuario (Usuario user);

    public Usuario getByUsername(String nombreUsuario);
    
}
