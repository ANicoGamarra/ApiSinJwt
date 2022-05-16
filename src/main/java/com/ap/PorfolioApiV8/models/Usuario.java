package com.ap.PorfolioApiV8.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;




@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;    
    @Column(name = "usuario") 
    private String nombreUsuario;
    private String email;
    private String password; 
    private Long id_persona;
    
    private String foto_perfil;    
    private String foto_portada;
    @Transient
    private String token;    

    public Usuario() {
    }

    public Usuario( String nombreUsuario, String password, String email,  Long id_persona, String foto_perfil, String foto_portada) {
       
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.email = email;
        this.id_persona = id_persona;
        
        this.foto_perfil = foto_perfil;
        this.foto_portada = foto_portada;
    }

    public Long getId_usuario() {
        return id_usuario;
    }
    
    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId_persona() {
        return id_persona;
    }

    public void setId_persona(Long id_persona) {
        this.id_persona = id_persona;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    public String getFoto_portada() {
        return foto_portada;
    }

    public void setFoto_portada(String foto_portada) {
        this.foto_portada = foto_portada;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
