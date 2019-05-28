package com.example.a26142070.projetoloja;

public class Parafuzo {
    private  String descricao;
    private String tamanho;
    private String nome;

    public Parafuzo() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome + "\n" +
                "descricao: " + descricao  +
                "\n tamanho: " + tamanho;
    }
}
