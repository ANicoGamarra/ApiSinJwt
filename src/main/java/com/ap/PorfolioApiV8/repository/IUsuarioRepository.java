package com.ap.PorfolioApiV8.repository;
import com.ap.PorfolioApiV8.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    public abstract Usuario findByNombreUsuario(String nombreUsuario);

}
    

