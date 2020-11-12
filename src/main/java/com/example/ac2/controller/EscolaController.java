package com.example.ac2.controller;

import java.util.List;

import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;
import com.example.ac2.service.CursoService;
import com.example.ac2.service.EscolaService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/escolas")
public class EscolaController {

    @Autowired
    private EscolaService escolaService;

    @Autowired
    private CursoService cursoService;

    @GetMapping()
    public List<Escola> getEscolas(){
        return escolaService.getAllEscolas();
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<Escola> getEscolas(@PathVariable int codigo){
        Escola escola = escolaService.getEscolaByCodigo(codigo);
        return ResponseEntity.ok(escola);
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        escolaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Escola> atualizar(@PathVariable int codigo){
        escola.setCodigo(codigo);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);
    }


    
}
