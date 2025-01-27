package com.TaskManager.TaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TaskManager.TaskManager.Entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNomeAndSenha(String nome, String senha);
    Usuario findByNome(String nome);
    Object findByEmail(String email);
    Usuario findById(long id);
}
