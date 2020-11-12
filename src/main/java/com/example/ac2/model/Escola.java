package com.example.ac2.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Escola {
    private int codigo;
    private String nome;
    private String endereco;
    private String telefone;

    @JsonIgnore
    private ArrayList<Curso> cursos = new ArrayList<Curso>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public boolean addCurso(Curso curso){
        return cursos.add(curso);
    }

    public boolean removeCurso(Curso curso){
        return cursos.remove(curso);
    }

    @Override
    public String toString() {
        return "Escola [endereco=" + endereco + ", nome=" + nome + ", telefone=" + telefone + "]";
    }

    

    
}
