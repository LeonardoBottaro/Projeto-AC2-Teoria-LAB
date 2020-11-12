package com.example.ac2.model;

public class Curso {
    private int codigo;
    private String nome;
    private String descricao;
    private Escola escola;
    private boolean cursoCheio;

    public Curso(){

    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isCursoCheio() {
        return cursoCheio;
    }

    public void setCursoCheio(boolean cursoCheio) {
        this.cursoCheio = cursoCheio;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", cursoCheio=" + cursoCheio + ", descricao=" + descricao + ", escola="
                + escola + ", nome=" + nome + "]";
    }


    
}
