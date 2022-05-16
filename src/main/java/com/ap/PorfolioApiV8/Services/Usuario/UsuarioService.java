package com.ap.PorfolioApiV8.Services.Usuario;

import java.util.List;
import java.util.Optional;

import com.ap.PorfolioApiV8.models.Usuario;
import com.ap.PorfolioApiV8.repository.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    public IUsuarioRepository usuarioRepo;
    
    @Override
    public List<Usuario> verUsuarios() {
        return usuarioRepo.findAll();
    }

    @Override
    public void crearUsuario(Usuario user) {
        usuarioRepo.save(user);
    }

    @Override
    public void borrarUsuario(Long id) {
        usuarioRepo.deleteById(id);
    }

    @Override
    public Usuario buscarUsuario(Long id) {
        return usuarioRepo.findById(id).orElse(null);
    }

    @Override
    public ResponseEntity<Usuario> buscarUsuarioId(Long id) {
       Optional<Usuario> user = usuarioRepo.findById(id);
        
        if(user.isPresent()){
            return ResponseEntity.ok().body(user.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public void editarUsuario(Usuario user) {
        usuarioRepo.save(user);
    }

    @Override
    public Usuario getByUsername(String nombreUsuario) {
       
        return usuarioRepo.findByNombreUsuario(nombreUsuario);
    }
    
}
