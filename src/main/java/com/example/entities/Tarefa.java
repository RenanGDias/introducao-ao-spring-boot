package com.example.entities;

public class Tarefa {
    private int id;
    private String descricao;
    private boolean concluida;


    // Construtores, getters e setters (você pode gerar isso na sua IDE)

    public Tarefa() {}

    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluida = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isConcluida() {
        return concluida;
    }

    public void setConcluida(boolean concluida) {
        this.concluida = concluida;
    }
}
