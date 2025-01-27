package com.TaskManager.TaskManager.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.TaskManager.TaskManager.Entities.Tarefas;

public interface TarefaRepository extends JpaRepository<Tarefas, Long> {

    Tarefas findByTitulo(String nome);

    Tarefas findById(long id);
    
}
