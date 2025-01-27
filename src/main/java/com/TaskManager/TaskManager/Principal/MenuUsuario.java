package com.TaskManager.TaskManager.Principal;
import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TaskManager.TaskManager.Entities.Usuario;
import com.TaskManager.TaskManager.Service.UsuarioService;

@Component
public class MenuUsuario {

    Scanner sc = new Scanner(System.in);

    @Autowired
    private UsuarioService service;

    @Autowired
    private MenuPrincipal menuPrincipal;

    public MenuUsuario() {
    }

    public void menuUser() {
        boolean continuar = true;

        while (continuar) {
            System.out.println("Bem vindo ao Task Manager");
            System.out.println("Deseja realizar Login ou Cadastrar-se?");
            System.out.println("1 - Login");
            System.out.println("2 - Cadastrar-se");
            System.out.println("3 - Sair");
            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    LoginUsuario();
                    break;
                case 2:
                    CadastroUsuario();
                    break;
                case 3:
                    continuar = false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
    }

    private void LoginUsuario() {

        System.out.println("Login:");

        System.out.println("Informe o nome de usuário: ");
        String nome = sc.nextLine();
        System.out.println("Informe a senha: ");
        String senha = sc.nextLine();
        

        if (nome.equals("") || senha.equals("")) {
            System.out.println("Usuário ou senha inválidos!");
            return;
        }
        
        service.authenticateUser(nome, senha);
        menuPrincipal.menuPrincipal(service.authenticateUser(nome, senha));
    }

    private void CadastroUsuario() {
        Usuario user = new Usuario();

        System.out.println("Cadastro:");

        System.out.println("Informe o nome de usuário: ");
        user.setNome(sc.nextLine());
        System.out.println("Informe o email: ");
        user.setEmail(sc.nextLine());
        System.out.println("Informe a senha: ");
        user.setSenha(sc.nextLine());

        if (user.getNome().equals("") || user.getEmail().equals("") || user.getSenha().equals("")) {
            System.out.println("Usuário ou senha inválidos!");
            return;
        }

        if (service.findByNome(user.getNome()) != null) {
            System.out.println("Usuário já cadastrado!");
            return;
        }

        service.saveUser(user.getNome(), user.getEmail(), user.getSenha(), LocalDate.now());
        System.out.println("Usuário cadastrado com sucesso!");
        menuPrincipal.menuPrincipal(user);
    }
}
