package com.TaskManager.TaskManager.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.Objects;

import com.TaskManager.TaskManager.Enum.Status;

@Entity
@Table(name = "tarefas")
public class Tarefas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private String descricao;
    
    @Enumerated(EnumType.STRING)
    private Status status;
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario_id;
    private LocalDate dataCriacao;
    private LocalDate ultumaAtualizacao;
    
    public Tarefas(){}

    public Tarefas(long id, String titulo, String descricao, Status status, LocalDate dataVencimento, Usuario usuario_id, LocalDate dataCriacao, LocalDate ultumaAtualizacao) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.status = status;
        this.dataVencimento = dataVencimento;
        this.usuario_id = usuario_id;
        this.dataCriacao = dataCriacao;
        this.ultumaAtualizacao = ultumaAtualizacao;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public LocalDate getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDate dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public LocalDate getUltumaAtualizacao() {
        return ultumaAtualizacao;
    }

    public void setUltumaAtualizacao(LocalDate ultumaAtualizacao) {
        this.ultumaAtualizacao = ultumaAtualizacao;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefas other = (Tarefas) obj;
        if (id != other.id)
            return false;
        return true;
    }

    
}
