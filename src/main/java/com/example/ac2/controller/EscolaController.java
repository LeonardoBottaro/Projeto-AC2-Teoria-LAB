package com.example.ac2.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.example.ac2.dto.EscolaDTO;
import com.example.ac2.model.Curso;
import com.example.ac2.model.Escola;
import com.example.ac2.service.CursoService;
import com.example.ac2.service.EscolaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

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

    @PostMapping()
    public ResponseEntity<Void> salvar(@RequestBody EscolaDTO escoladDto, HttpServletRequest request, UriComponentsBuilder builder){

        Escola escola = escolaService.fromDTO(escoladDto);

        escola = escolaService.save(escola);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + escola.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> remover(@PathVariable int codigo){
        escolaService.removeByCodigo(codigo);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<Escola> atualizar(@PathVariable int codigo, @RequestBody EscolaDTO escolaDTO){
        
        Escola escola = escolaService.fromDTO(escolaDTO);
        escola.setCodigo(codigo);
        escola = escolaService.update(escola);
        return ResponseEntity.ok(escola);
    }

    @PostMapping("{codigo}/cursos")
    public ResponseEntity<Void> salvar(@PathVariable int codigo, @RequestBody Curso curso, HttpServletRequest request, UriComponentsBuilder builder){
        curso = cursoService.salvar(curso, codigo);
        UriComponents uriComponents = builder.path(request.getRequestURI() + "/" + curso.getCodigo()).build();
        return ResponseEntity.created(uriComponents.toUri()).build();
    }


    
}
