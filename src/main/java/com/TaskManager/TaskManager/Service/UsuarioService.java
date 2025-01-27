package com.TaskManager.TaskManager.Service;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.TaskManager.Entities.Usuario;
import com.TaskManager.TaskManager.Repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    private final UsuarioRepository userRepository;

    @Autowired
    public UsuarioService(UsuarioRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(String nome, String email, String senha, LocalDate dataCriacao) {
        if(userRepository.findByNome(nome) != null) {
            System.out.println("Usuário já cadastrado!");
            return;
        }

        if(userRepository.findByEmail(email) != null) {
            System.out.println("Email já cadastrado!");
            return;
        }

        Usuario user = new Usuario(nome, email, senha, dataCriacao);
        userRepository.save(user);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public Usuario authenticateUser(String nome, String senha) {
        Usuario authenticateUser = userRepository.findByNomeAndSenha(nome,senha);
            if (authenticateUser == null) {
                throw new RuntimeException("Usuário ou senha inválidos!");
            }
            
            System.out.println("Usuário autenticado com sucesso!");
            return authenticateUser;
    }

    public Usuario findByNome(String nomeUsuario) {
        return userRepository.findByNome(nomeUsuario);
    }

    public Optional<Usuario> findById(Long id){
        return userRepository.findById(id);
    }
}
