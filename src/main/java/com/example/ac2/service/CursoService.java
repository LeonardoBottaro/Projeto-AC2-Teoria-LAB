package com.example.ac2.service;

import java.util.List;
import java.util.Optional;

import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;
import com.example.ac2.repository.CursoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CursoService {
    
    @Autowired
    private CursoRepository repositorio;

    @Autowired
    private EscolaService escolaService;

    public List<Curso> getAllCursos(){
        return repositorio.getAllCursos();
    }

    public Curso getCursoByCodigo(int codigo){
        Optional <Curso> op = repositorio.getCursoByCodigo(codigo);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso nao cadastrado"));
    }

    public Curso salvar(Curso curso, int codigo){
        Escola escola = escolaService.getEscolaByCodigo(codigo);
        curso.setEscola(escola);
        escola.addCurso(curso);

        return repositorio.save(curso);
    }
}
