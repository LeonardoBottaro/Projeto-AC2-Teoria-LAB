package com.example.ac2.controller;

import java.util.List;

import com.example.ac2.model.Curso;
import com.example.ac2.service.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
    private CursoService service;

    @GetMapping()
    public List<Curso> getCursos(){
        return service.getAllCursos();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Curso> getCursoByCodigo(@PathVariable int codigo){
        Curso curso = service.getCursoByCodigo(codigo);
        return ResponseEntity.ok(curso);
    }
}
