package com.TaskManager.TaskManager.Principal;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.TaskManager.TaskManager.Entities.Tarefas;
import com.TaskManager.TaskManager.Entities.Usuario;
import com.TaskManager.TaskManager.Enum.Status;
import com.TaskManager.TaskManager.Repository.TarefaRepository;
import com.TaskManager.TaskManager.Repository.UsuarioRepository;

@Component
public class MenuPrincipal {

    Scanner sc = new Scanner(System.in);

    @Autowired
    TarefaRepository repository;

    @Autowired
    UsuarioRepository repositoryUser;

    public void menuPrincipal(Usuario user) {

        System.out.println("Bem vindo ao Task Manager");
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Cadastrar tarefa");
        System.out.println("2 - Deletar tarefa");
        System.out.println("3 - Atualizar tarefa");
        System.out.println("4 - Listar tarefas");
        System.out.println("5 - Sair");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                CadastrarTarefa(user);
                break;
            case 2:
                DeletarTarefa(user);
                break;
            case 3:
                AtualizarTarefa(user);
                break;
            case 4:
                ListarTarefas(user);
                break;
            case 5:
                System.exit(0);
                break;
            default:
                break;
        }
    }

    private void CadastrarTarefa(Usuario user) {

        Tarefas tarefa = new Tarefas();
        System.out.println("Digite o título da tarefa: ");
        tarefa.setTitulo(sc.nextLine());
        System.out.println("Digite a descrição da tarefa: ");
        tarefa.setDescricao(sc.nextLine());
        tarefa.setStatus(Status.PENDENTE);
        System.out.println("Digite o prazo da tarefa: ");
        tarefa.setDataVencimento(LocalDate.parse(sc.nextLine()));
        tarefa.setDataCriacao(LocalDate.now());
        tarefa.setUltimaAtualizacao(LocalDate.now());
        tarefa.setUsuario(user);

        repository.save(tarefa);
        menuPrincipal(user);
    }

    private void DeletarTarefa(Usuario user) {

        System.out.println("Você deseja procurar a tarefa por qual campo?");
        System.out.println("1 - Título \n" +
                "2 - ID ");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:

                System.out.println("Digite o título da tarefa: ");
                String titulo = sc.nextLine();

                Optional<Tarefas> optionalTarefaTitulo = Optional.ofNullable(repository.findByTitulo(titulo));

                if (optionalTarefaTitulo.isPresent()) {
                    Tarefas tarefa = optionalTarefaTitulo.get();

                    if (tarefa.getUsuario().getId() == user.getId()) {
                        tarefa.setUsuario(user);
                        repository.delete(tarefa);
                        System.out.println("Tarefa deletada com sucesso!");
                        menuPrincipal(user);

                    }
                } else {
                    System.out.println("Tarefa nao encontrada!");
                    DeletarTarefa(user);
                }
                break;
            case 2:

                System.out.println("Digite o ID da tarefa: ");
                long id = sc.nextLong();

                Optional<Tarefas> optionalTarefaId = Optional.ofNullable(repository.findById(id));

                if (optionalTarefaId.isPresent()) {
                    Tarefas tarefa = optionalTarefaId.get();

                    if (tarefa.getUsuario().getId() == user.getId()) {
                        tarefa.setUsuario(user);
                        repository.delete(tarefa);
                        System.out.println("Tarefa deletada com sucesso!");
                        menuPrincipal(user);
                    } else {
                        System.out.println("Tarefa nao encontrada!");
                    }
                    break;
                }
            default:
                break;
        }

    }

    private void AtualizarTarefa(Usuario user) {

        System.out.println("Você deseja procurar a tarefa por qual campo?");
        System.out.println("1 - Título \n" +
                "2 - ID ");

        int opcao = sc.nextInt();
        sc.nextLine();

        switch (opcao) {
            case 1:
                System.out.println("Informe o titulo da tarefa: ");
                String titulo = sc.nextLine();

                Optional<Tarefas> optionalTarefaTitulo = Optional.ofNullable(repository.findByTitulo(titulo));

                if (optionalTarefaTitulo.isPresent()) {
                    Tarefas tarefa = optionalTarefaTitulo.get();

                    if (tarefa.getUsuario().getId() == user.getId()) {

                        System.out.println("Quais dados deseja atualizar?");
                        System.out.println("1 - Titulo \n" +
                                "2 - Descricao \n" +
                                "3 - Status \n" +
                                "4 - Data de Vencimento ");
                        int opcao2 = sc.nextInt();

                        switch (opcao2) {
                            case 1:
                                System.out.println("Informe o novo titulo da tarefa: ");
                                tarefa.setTitulo(sc.nextLine());
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            case 2:
                                System.out.println("Informe a nova descricao da tarefa: ");
                                tarefa.setDescricao(sc.nextLine());
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            case 3:
                                System.out.println("Informe o novo status da tarefa: ");
                                String status = sc.nextLine().toLowerCase();

                                if (status.equals("pendente")) {
                                    tarefa.setStatus(Status.PENDENTE);
                                } else if (status.equals("em andamento")) {
                                    tarefa.setStatus(Status.EM_ANDAMENTO);
                                } else if (status.equals("concluida")) {
                                    tarefa.setStatus(Status.CONCLUIDA);
                                }
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            case 4:
                                System.out.println("Informe a nova data de vencimento da tarefa: ");
                                tarefa.setDataVencimento(LocalDate.parse(sc.nextLine()));
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }
                        tarefa.setUltimaAtualizacao(LocalDate.now());
                        tarefa.setUsuario(user);
                        repository.save(tarefa);
                        menuPrincipal(user);
                    } else {
                        System.out.println("Tarefa nao encontrada!");
                        menuPrincipal(user);
                    }
                }
                break;
            case 2:

                System.out.println("Informe o ID da tarefa: ");
                long id = sc.nextLong();

                Optional<Tarefas> optionalTarefaId = Optional.ofNullable(repository.findById(id));

                if (optionalTarefaId.isPresent()) {
                    Tarefas tarefa = optionalTarefaId.get();

                    if (tarefa.getUsuario().getId() == user.getId()) {
                        System.out.println("Quais dados deseja atualizar?");
                        System.out.println("1 - Titulo \n" +
                                "2 - Descricao \n" +
                                "3 - Status \n" +
                                "4 - Data de Vencimento ");
                        int opcao2 = sc.nextInt();
                        sc.nextLine();

                        switch (opcao2) {
                            case 1:
                                System.out.println("Informe o novo titulo da tarefa: ");
                                tarefa.setTitulo(sc.nextLine());
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            case 2:
                                System.out.println("Informe a nova descricao da tarefa: ");
                                tarefa.setDescricao(sc.nextLine());
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            case 3:
                                System.out.println("Informe o novo status da tarefa: ");
                                sc.nextLine();
                                System.out.println("1 - Pendente \n" +
                                        "2 - Em andamento \n" +
                                        "3 - Concluida ");

                                int status = sc.nextInt();

                                if (status == 1) {
                                    tarefa.setStatus(Status.PENDENTE);
                                } else if (status == 2) {
                                    tarefa.setStatus(Status.EM_ANDAMENTO);
                                } else if (status == 3) {
                                    tarefa.setStatus(Status.CONCLUIDA);
                                }

                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            case 4:
                                System.out.println("Informe a nova data de vencimento da tarefa: ");
                                tarefa.setDataVencimento(LocalDate.parse(sc.nextLine()));
                                System.out.println("Tarefa atualizada com sucesso!");
                                break;
                            default:
                                System.out.println("Opção inválida!");
                                break;
                        }

                        System.out.println("Deseja realizar outras atualizacoes? \n" +
                                "1 - Sim \n" +
                                "2 - Não ");
                        int opcao3 = sc.nextInt();

                        if (opcao3 == 1) {
                            tarefa.setUltimaAtualizacao(LocalDate.now());
                            tarefa.setUsuario(user);
                            repository.save(tarefa);
                            AtualizarTarefa(user);
                        } else {
                            tarefa.setUltimaAtualizacao(LocalDate.now());
                            tarefa.setUsuario(user);
                            repository.save(tarefa);
                            menuPrincipal(user);
                        }
                    } else {
                        System.out.println("Tarefa nao encontrada!");
                        menuPrincipal(user);
                    }
                }
                break;
            default:
                break;
        }
    }

    private void ListarTarefas(Usuario user) {
        System.out.println("Listando tarefas:");

        Optional <Usuario> OptionalUserId = Optional.ofNullable(repositoryUser.findById(user.getId()));
        if (OptionalUserId.isPresent()) {
            Usuario usuario = OptionalUserId.get();
            if (usuario.getId() == user.getId()) {
                Iterable<Tarefas> tarefas = repository.findAllByUsuarioId(user.getId());
                for (Tarefas tarefa : tarefas) {
                    System.out.println(tarefa.toString());
                }
            }
        }
        menuPrincipal(user);
    }
}
