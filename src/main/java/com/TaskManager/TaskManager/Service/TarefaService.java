package com.TaskManager.TaskManager.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TaskManager.TaskManager.Repository.TarefaRepository;

@Service
public class TarefaService {
    

    private final TarefaRepository repository;

    @Autowired
    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    public void findByTitulo(String nome) {
        repository.findByTitulo(nome);

        if(repository.findByTitulo(nome) == null) {
            System.out.println("Tarefa nao encontrada!");
        }
    }

    public void findByID(long id) {
        repository.findById(id);

        if(repository.findById(id) == null) {
            System.out.println("Tarefa nao encontrada!");
        }
    }
}
