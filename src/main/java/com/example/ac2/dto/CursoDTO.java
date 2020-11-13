package com.example.ac2.dto;

public class CursoDTO {
    private int codigo;
    private String nome;
    private String descricao;
    private boolean cursoCheio;

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




    
}
