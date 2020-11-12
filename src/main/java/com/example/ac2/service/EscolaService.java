package com.example.ac2.service;

import java.util.List;
import java.util.Optional;

import com.example.ac2.dto.EscolaDTO;
import com.example.ac2.model.Escola;
import com.example.ac2.repository.EscolaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class EscolaService {
    
    @Autowired
    private EscolaRepository repositorio;

    public Escola fromDTO(EscolaDTO dto){

        Escola escola = new Escola();
        escola.setNome(dto.getNome());
        escola.setEndereco(dto.getEndereco());
        escola.setTelefone(dto.getTelefone());
        return escola;
    }

    public List<Escola> getAllEscolas(){
        return repositorio.getAllEscolas();
    }

    public Escola getEscolaByCodigo(int codigo){
        Optional<Escola> op = repositorio.getEscolaByCodigo(codigo);
        return op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Escola nao cadastrada"));
    }

    public Escola save(Escola escola){
        return repositorio.save(escola);
    }

    public void removeByCodigo(int codigo){
        repositorio.remove(getEscolaByCodigo(codigo));
    }

    public Escola update(Escola escola){
        getEscolaByCodigo(escola.getCodigo());
        return repositorio.update(escola);
    }
}
