package com.example.ac2.model;

public class Curso {
    private int codigo;
    private String nome;
    private String descricao;
    private double valor;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isCursoCheio() {
        return cursoCheio;
    }

    public void setCursoCheio(boolean cursoCheio) {
        this.cursoCheio = cursoCheio;
    }

    @Override
    public String toString() {
        return "Curso [codigo=" + codigo + ", cursoCheio=" + cursoCheio + ", descricao=" + descricao + ", nome=" + nome
                + ", valor=" + valor + "]";
    }

    
}
